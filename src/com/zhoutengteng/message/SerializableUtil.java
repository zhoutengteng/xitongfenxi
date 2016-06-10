package com.zhoutengteng.message;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import javax.xml.crypto.Data;

public class SerializableUtil {
	
	public static byte[] toBytes(Object object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			byte[] bytes = baos.toByteArray();
			return bytes;
		} catch(IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			try {
				oos.close();
			} catch (Exception e) {}
		}
	}
	
	public static Object toObject(byte[] bytes) {
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bais);
			Object object = ois.readObject();
			return object;
		} catch(IOException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} catch(ClassNotFoundException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		} finally {
			try {
				ois.close();
			} catch (Exception e) {}
		}
	}
	
//	static public void main(String argvs[]) {
//		Date date = new Date();
//		List<Date> list = new LinkedList<Date>();
//		list.add(date);
//		System.out.println(date.toString());
//		byte[] bytes = SerializableUtil.toBytes(list);
//		System.out.println(bytes.length);
//		System.out.println(SerializableUtil.toObject(bytes));
//		List<Date> list2 = (List<Date>)(SerializableUtil.toObject(bytes));
//		System.out.println(list2.get(0));
//	}
}
