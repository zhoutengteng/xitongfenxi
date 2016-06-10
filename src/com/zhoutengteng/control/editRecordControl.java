package com.zhoutengteng.control;

import com.zhoutengteng.model.RecordModel;
import java.io.Serializable;

public class editRecordControl implements Serializable {

	//这里是写入数据库
	public boolean saveOneRecord(RecordModel recordModel) {
		RecordModel record1 = new RecordModel();
		if (record1.saveOneRecord(recordModel)) {
		return true;
		} else {
			return false;
		}
	}

	
	
	private boolean checkValid(RecordModel recordModel) {
		RecordModel record1 = new RecordModel();
		return true;
	}
}
