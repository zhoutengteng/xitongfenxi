package com.zhoutengteng.control;

import java.util.List;

import com.zhoutengteng.model.CommentModel;
import com.zhoutengteng.model.RecordModel;
import com.zhoutengteng.model.UserModel;

public class catRecordControl {
	public List<RecordModel> getAllRecordsByPeopleId(int id) {
		
		return null;
	}
	
	public List<CommentModel> getAllCommentsByRecordId(int id) {
		
		return null;
	}
	
	public boolean addOneUserToPeopleList(int sourceId, int targetId) {
		
		return true;
	}
	
	public boolean deleteOneUserFromPeopleList(int sourceId, int targetId) {
		
		return true;
	}
	
	
	
	/**
	 * 得到三条时间最新的活动
	 * @return
	 */
	public List<RecordModel> getHotRecords() {
		
		return null;
	}
	
	public List<RecordModel> getBeforeTimeRecords(int year, int month, int day) {
		
		return null;
	}
	
	public List<RecordModel> getBeingTimeRecords(int year, int month, int day) {
		
		return null;
	}
	
	public List<RecordModel> getAfterTimeRecords(int year, int month, int day) {
		
		return null;
	}
	
	public RecordModel getRecordByRecordId(int id) {
		return null;
	}
	
	public List<UserModel> getAllPeoplesByRecordId(int id) {
		
		return null;
	}
	
	public boolean deleteOneRecord(int id) {
		return true;
	}
	
	public boolean deleteOneCommentByRecordIdAndPeopleId(int recordId, int propleId) {
		
		return true;
	}
	
	public catRecordControl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean updateRecord(int id) {
		
		return true;
	}
	
}
