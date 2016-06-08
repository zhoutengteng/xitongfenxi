package com.zhoutengteng.control;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.DeflaterInputStream;

import com.zhoutengteng.model.CommentModel;
import com.zhoutengteng.model.RecordModel;
import com.zhoutengteng.model.UserModel;

public class catRecordControl {
	public List<RecordModel> getAllRecordsByPeopleId(int id) throws ParseException {
		RecordModel recordModel = new RecordModel();
		return recordModel.getAllRecordsByPeopleId(id);
	}
	
	public List<CommentModel> getAllCommentsByRecordId(int id) {
		CommentModel commentModel = new CommentModel();
		return commentModel.getAllCommentsByRecordId(id);
	}
	
	public boolean addOneUserToPeopleList(int sourceId, int targetId) throws ParseException {
		RecordModel recordModel = new RecordModel();
		recordModel.lookOneRecord(sourceId).addOneUserToProject(targetId);
		return true;
	}
	
	public boolean deleteOneUserFromPeopleList(int sourceId, int targetId) throws ParseException {
		RecordModel recordModel = new RecordModel();
		recordModel.lookOneRecord(sourceId).deleteOneRecord(targetId);
		return true;
	}
	
	
	
	/**
	 * 得到三条时间最新的活动
	 * @return
	 * @throws ParseException 
	 */
	public List<RecordModel> getHotRecords() throws ParseException {
		Date dateNow = new Date();
		List<RecordModel> list = getBeforeTimeRecords(dateNow.getYear(), dateNow.getMonth(), dateNow.getDay());
		if (list.size() < 10) {
			return list;
		} else {
			List<RecordModel> list2 = new ArrayList<RecordModel>();
			for (int i = 0; i < 10; i++) {
				list2.add(list.get(i));
			}
			return list2;
		}
	}
	
	public List<RecordModel> getBeforeTimeRecords(int year, int month, int day) throws ParseException {
		RecordModel recordModel = new RecordModel();
		List<RecordModel> list = recordModel.getAllRecords();
		List<RecordModel> list2 = new ArrayList<RecordModel>();
		@SuppressWarnings("deprecation")
		Date strDate = new Date(year, month, day);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getEndTime().compareTo(strDate) < 0) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	
	public List<RecordModel> getBeingTimeRecords(int year, int month, int day) throws ParseException {
		RecordModel recordModel = new RecordModel();
		List<RecordModel> list = recordModel.getAllRecords();
		List<RecordModel> list2 = new ArrayList<RecordModel>();
		@SuppressWarnings("deprecation")
		Date strDate = new Date(year, month, day);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStartTime().compareTo(strDate) <= 0 && list.get(i).getEndTime().compareTo(strDate) >= 0) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	
	public List<RecordModel> getAfterTimeRecords(int year, int month, int day) throws ParseException {
		RecordModel recordModel = new RecordModel();
		List<RecordModel> list = recordModel.getAllRecords();
		List<RecordModel> list2 = new ArrayList<RecordModel>();
		@SuppressWarnings("deprecation")
		Date strDate = new Date(year, month, day);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getStartTime().compareTo(strDate) > 0) {
				list2.add(list.get(i));
			}
		}
		return list2;
	}
	
	public RecordModel getRecordByRecordId(int id) throws ParseException {
		RecordModel recordModel = new RecordModel();
		return recordModel.lookOneRecord(id);
	}
	
	public List<UserModel> getAllPeoplesByRecordId(int id) throws ParseException {
		RecordModel recordModel = new RecordModel();
		recordModel = recordModel.lookOneRecord(id);
		return recordModel.getJoinPeopleList();
	}
	
	public boolean deleteOneRecord(int id) {
		RecordModel recordModel = new RecordModel();
		if (recordModel.deleteOneRecord(id)) {
		return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOneCommentByRecordIdAndPeopleId(int recordId, int peopleId) {
		CommentModel commentModel = new CommentModel();
		if (commentModel.deleteOneCommentByRecordIdAndPeopleId(recordId, peopleId)) {
		return true;
		} else {
			return false;
		}
	}
	
	public catRecordControl() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean updateRecord(int id) throws ParseException {
		RecordModel recordModel = new RecordModel();
		recordModel = recordModel.lookOneRecord(id);
		recordModel.updateOneRecord(recordModel);
		return true;
	}
}
