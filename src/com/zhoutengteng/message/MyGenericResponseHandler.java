package com.zhoutengteng.message;

import com.zhoutengteng.control.*;
import com.zhoutengteng.model.*;

import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.Option;

public class MyGenericResponseHandler<T> implements MyResponseHandler<T> {
	private String Option = "default";
	
	public MyGenericResponseHandler() {

	}
	
	public MyGenericResponseHandler(String option) {
		Option = option;
	}
	




	@Override
	public T handle(MyResponse response) {
		System.out.println("//////////" + response + "///");
		if (Option.equals("catRecordControl_getAllRecordsByPeopleId") || Option.equals("catRecordControl_getBeingTimeRecords")
				|| Option.equals("catRecordControl_getBeforeTimeRecords")
				|| Option.equals("catRecordControl_getBeingTimeRecords")) {
			List<RecordModel> ll = (List<RecordModel>)response.getResult();
			String[] li = new String[ll.size() * 2];
			for (int i = 0, j = 0;  i < ll.size(); i++, j = j+2) {
				li[j] = ll.get(i).getTitle();
				li[j+1] = "" + ll.get(i).getId();
			}
			return (T)li;
//			String[] va = new String[] {"activityTitle2", "author2", "activityTitle1", "author1", "activityTitle1", "author1" };
//			return (T)va;
		} if (Option.equals("default")) {
			return (T) response.getResult();
		} if (Option.equals("loginControl_login")) {
			return (T)(response.getResult());
		} if (Option.equals("UserModel_lookOneUserId")) {
			return (T)(response.getResult());
		} if (Option.equals("catRecordControl_getHotRecords")) {
			List<RecordModel> ll = (List<RecordModel>)response.getResult();
			String[] li = new String[ll.size() * 2];
			for (int i = 0, j = 0;  i < ll.size(); i++, j = j+2) {
				li[i] = ll.get(i).getTitle();
			}
			return (T)li;
			
		}
		return (T)response.getResult();
	}
}
