package com.zhoutengteng.control;
import java.text.ParseException;
import java.util.*;
import com.zhoutengteng.model.RecordModel;
import com.zhoutengteng.model.UserModel;
import java.io.Serializable;

public class adminControl implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param userModel 寰呮坊鍔犵殑鐢ㄦ埛
	 * @return
	 */
	public boolean addPeople(UserModel userModel) {
		UserModel userManage = new UserModel();
		userManage.addOneUserToPeopleList(userModel.getId());
		return true;
	}
	
	public boolean updatePeople(UserModel userModel) {
		UserModel userManage = new UserModel();
		return userManage.updateOneUser(userModel);
		
	}
	
	public boolean deletePeople(int id) {
		UserModel userManage = new UserModel();
		return userManage.deleteOneUser(id);
	}
	
	public boolean addRecord(int parentId, RecordModel recordModel) throws ParseException {
		RecordModel recordManage = new RecordModel();
		List<RecordModel> allRecordModel = recordManage.getAllRecords();
		for (int i =0; i< allRecordModel.size(); i++) {
			
		}
		return true;
	}
	
	public boolean updateRecord(int id, RecordModel recordModel) {
		
		
		return true;
	}
	
	public boolean deleteRecord(int id) {
		
		return true;
	}
}
