package com.zhoutengteng.message;

import com.zhoutengteng.view.*;
import com.zhoutengteng.control.*;
import java.util.ArrayList;
import java.util.List;

public class RunClient {

	private  int port = Config.port;
	private  String host = Config.host;

	public static void main(String[] args) throws Exception {
		entry();
	}

	

	public static void entry() throws Exception {
		new LoginView().go();
//		new MaimView().go();
//		MyClient myClient = new MyClientNIOImpl(host, port);
//		MyRequest request = new MyGenericRequest(MyUserServiceImpl.class, "list", new Class<?>[]{int.class}, new Object[]{2});
//		MyResponse response = myClient.execute(request);
//		System.out.println(((ArrayList<User>)response.getResult()).get(0).getName());
//		List<User> users = myClient.execute(request, new MyGenericResponseHandler<List<User>>());
//		System.out.println(users.get(0).getName());
//		request = new MyGenericRequest(MyUserServiceImpl.class, "findByName", new Class<?>[]{String.class}, new Object[]{"kongxx"});
//		response = myClient.execute(request);
//		System.out.println(((User)response.getResult()).getName());
//		User user = myClient.execute(request, new MyGenericResponseHandler<User>());
//		System.out.println(user.getName());
//		response = myClient.execute(new MyGenericRequest(MyUserServiceImpl.class, "test", new Class<?>[]{}, new Object[]{}));
//		System.out.println(response.getResult());
	}
}
