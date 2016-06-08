package com.zhoutengteng.control;

import java.text.ParseException;
import java.util.List;

import com.zhoutengteng.model.RecordModel;
import com.zhoutengteng.model.UserModel;

public class contactPeopleControl {
	
	
	public List<RecordModel> getRecordByPeople(int id) throws ParseException {
		RecordModel recordModel = new RecordModel();
		return recordModel.getAllRecordsByPeopleId(id);
	}
	
	
	/**
	 * @param sourceId
	 * @param targetId 待删除的ID
	 * @return
	 */
	public boolean deleteOnePeople(int sourceId, int targetId) {
		UserModel userModel = new UserModel();
		userModel = userModel.lookOneUser(sourceId);
		if (userModel.deleteOneUserFromPeopleList(targetId)) {
		return true;
		} else {
			return false;
		}
	}
	
	/**
	 * @param sourceDd 
	 * @param targetId 待删除的ID
	 * @return
	 */
	public boolean addOnePeople(int sourceId, int targetId) {
		UserModel userModel = new UserModel();
		userModel = userModel.lookOneUser(sourceId);
		if (userModel.addOneUserToPeopleList(targetId)) {
		return true;
		} else {
			return false;
		}
	}
}
