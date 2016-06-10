package com.zhoutengteng.message;




import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyClientNIOImpl implements MyClient {
	private final static Logger logger = Logger.getLogger(MyClientNIOImpl.class.getName());
	private String host;
	private int port;

	public MyClientNIOImpl(String host, int port) {
		this.host = host;
		this.port = port;
	}

	@Override
	public <T> T execute(MyRequest request, MyResponseHandler<T> handler) {
		MyResponse response = execute(request);
		System.out.println("handle =>" + response);
		return handler.handle(response);
	}

	@Override
	public MyResponse execute(MyRequest request) {
		MyResponse response = null;
		SocketChannel socketChannel = null;
		try {
			socketChannel = SocketChannel.open();
			SocketAddress socketAddress = new InetSocketAddress(host, port);
			socketChannel.connect(socketAddress);
			sendData(socketChannel, request);
			response = receiveData(socketChannel);
		} catch (Exception ex) {
			logger.log(Level.SEVERE, null, ex);
		} finally {
			try {
				socketChannel.close();
			} catch(Exception ex) {}
		}
		return response;
	}

	private void sendData(SocketChannel socketChannel, MyRequest myRequest) throws IOException {
		byte[] bytes = SerializableUtil.toBytes(myRequest);
		ByteBuffer buffer = ByteBuffer.wrap(bytes);
		socketChannel.write(buffer);
		socketChannel.socket().shutdownOutput();
	}

	private MyResponse receiveData(SocketChannel socketChannel) throws IOException {
		MyResponse myResponse = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		try {
			ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
			byte[] bytes;
			int count = 0;
			while ((count = socketChannel.read(buffer)) >= 0) {
				buffer.flip();
				bytes = new byte[count];
				buffer.get(bytes);
				baos.write(bytes);
				buffer.clear();
			}
			bytes = baos.toByteArray();
			Object obj = SerializableUtil.toObject(bytes);
			myResponse = (MyResponse) obj;
			socketChannel.close();
		} finally {
			try {
				baos.close();
			} catch(Exception ex) {}
		}
		return myResponse;
	}
}

