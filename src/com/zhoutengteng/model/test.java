package com.zhoutengteng.model;

import java.awt.print.Printable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class test {
	private static UserModel uModel = new UserModel();
	private static CommentModel commentModel = new CommentModel();
	private static RecordModel recordModel = new RecordModel();
	public static void main(String[] args) throws ParseException {
		//recordTest
		RecordModel recordModel1 = new RecordModel();
		recordModel1 = recordModel.lookOneRecord(1);
		recordModel1.addOneUserToProject(2);
		recordModel1.addOneUserToProject(3);
		recordModel1.deleteOneUserFromProject(2);
		show();
	}
	public static void show() throws ParseException {
		List<UserModel> list = uModel.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		List<CommentModel> list1 = commentModel.getAllComments();
		for (int i = 0; i < list1.size(); i++) {
			System.out.println(list1.get(i).toString());
		}
		List<RecordModel> list2 = recordModel.getAllRecords();
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).toString());
		}
	}
}
