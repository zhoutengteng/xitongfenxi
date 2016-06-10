package com.zhoutengteng.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.omg.CORBA.INTERNAL;


public class RecordModel  implements Serializable{
	private int id = 0;
	private String title = "";
	private List<String> label;
	private String content = "";
	private Date startTime;
	private Date endTime;
	private int peopleId = 0;
	private List<UserModel> joinPeopleList = new ArrayList<UserModel>();
	private UserModel uModel = new UserModel();
	public List<UserModel> getJoinPeopleList() {
		return joinPeopleList;
	}
	
	/**
	 * 数据库存的id1，id2，id3逗号隔开的字符串
	 * @param joinPeopleList
	 */
	public void setJoinPeopleList(List<UserModel> joinPeopleList) {
		this.joinPeopleList = joinPeopleList;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getLabel() {
		return label;
	}
	public void setLabel(List<String> label) {
		this.label = label;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int recordId) {
		this.id = recordId;
	}
	
	public boolean saveOneRecord(RecordModel recordModel) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "insert into records values " + "(" +recordModel.toString()+ ")";
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOneRecord(int id) {
		DBForConnection dBforUser = new DBForConnection();
		CommentModel commentModel = new CommentModel();
		commentModel.deleteOneCommentByrecordId(id);
		String sql = "delete from records where id = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOneRecordByPeopleId(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "delete from records where peopleId = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean updateOneRecord(RecordModel recordModel) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "update records set id = " + recordModel.getId() + ", title = "+'"'+recordModel.getTitle()+'"' + ", label = " + '"'+LabelListToString(recordModel.getLabel())+'"' + ", content = " + '"'+recordModel.getContent()+'"' + ", startTime = " +'"'+DateToString(recordModel.getStartTime())+'"' + ", endTime = " + '"'+DateToString(recordModel.getEndTime())+'"' + ", peopleId = " + recordModel.getPeopleId() + ", joinPeopleList = " + '"'+uModel.getListString(recordModel.getJoinPeopleList())+'"' + " where id = "+recordModel.getId();
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public RecordModel  lookOneRecord(int id) throws ParseException {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from records where id = " + id;
		try {
			RecordModel recordModel = new RecordModel();
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			recordModel.setId(rs.getInt("id"));
			recordModel.setTitle(rs.getString("title"));
			recordModel.setLabel(strToLabelList(rs.getString("label")));
			recordModel.setContent(rs.getString("content"));
			recordModel.setStartTime(StringToDate(rs.getString("startTime")));
			recordModel.setEndTime(StringToDate(rs.getString("startTime")));
			recordModel.setPeopleId(rs.getInt("peopleId"));
			recordModel.setJoinPeopleList(uModel.strToList(rs.getString("joinPeopleList")));
			rs.close();
			dBforUser.close();
			return recordModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}

	public boolean addOneUserToProject(int id) {
		UserModel userModel = new UserModel();
		userModel = uModel.lookOneUser(id);
		for (int i = 0; i < this.joinPeopleList.size(); i++) {
			if (this.joinPeopleList.get(i).getId() == userModel.getId()) {
				return false;
			}
		}
		this.joinPeopleList.add(userModel);
		if (updateOneRecord(this)) {
		return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOneUserFromProject(int id) {
		Iterator<UserModel> it = this.joinPeopleList.iterator();
		while(it.hasNext()) {
			UserModel uModel = it.next();
			if (uModel.getId() == id) {
				it.remove();
				if (updateOneRecord(this)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		str += this.getId();
		str += ","+'"'+this.getTitle()+'"';
		str += ","+'"'+LabelListToString(this.getLabel())+'"';
		str += ","+'"'+this.getContent()+'"';
		str += ","+'"'+DateToString(this.getStartTime())+'"';
		str += ","+'"'+DateToString(this.getEndTime())+'"';
		str += ","+this.getPeopleId();
		str += ","+'"'+uModel.getListString(this.getJoinPeopleList())+'"';
		return str;
	}
	
	public RecordModel strToRecode(String str) throws ParseException {
		RecordModel recordModel = new RecordModel();
		String[] columnSet = str.split(",");
		recordModel.setId(Integer.parseInt(columnSet[0]));
		recordModel.setTitle(columnSet[1]);
		recordModel.setLabel(strToLabelList(columnSet[2]));
		recordModel.setContent(columnSet[3]);
		recordModel.setStartTime(StringToDate(columnSet[4]));
		recordModel.setEndTime(StringToDate(columnSet[5]));
		recordModel.setPeopleId(Integer.parseInt(columnSet[6]));
		recordModel.setJoinPeopleList(uModel.strToList(columnSet[7]));
		return recordModel;
	}
	
	public List<RecordModel> getAllRecords() throws ParseException {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from records";
		List<RecordModel> list = new ArrayList<RecordModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			RecordModel recordModel = new RecordModel();
			recordModel.setId(rs.getInt("id"));
			recordModel.setTitle(rs.getString("title"));
			recordModel.setLabel(strToLabelList(rs.getString("label")));
			recordModel.setContent(rs.getString("content"));
			recordModel.setStartTime(StringToDate(rs.getString("startTime")));
			recordModel.setEndTime(StringToDate(rs.getString("startTime")));
			recordModel.setPeopleId(rs.getInt("peopleId"));
			recordModel.setJoinPeopleList(uModel.strToList(rs.getString("joinPeopleList")));
			list.add(recordModel);
			}
			rs.close();
			dBforUser.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	public List<RecordModel> getAllRecordsByPeopleId(int id) throws ParseException {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from records where peopleId = " + id;
		List<RecordModel> list = new ArrayList<RecordModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			RecordModel recordModel = new RecordModel();
			recordModel.setId(rs.getInt("id"));
			recordModel.setTitle(rs.getString("title"));
			recordModel.setLabel(strToLabelList(rs.getString("label")));
			recordModel.setContent(rs.getString("content"));
			recordModel.setStartTime(StringToDate(rs.getString("startTime")));
			recordModel.setEndTime(StringToDate(rs.getString("startTime")));
			recordModel.setPeopleId(rs.getInt("peopleId"));
			recordModel.setJoinPeopleList(uModel.strToList(rs.getString("joinPeopleList")));
			list.add(recordModel);
			}
			rs.close();
			dBforUser.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	public String LabelListToString(List<String> label) {
		String str = "";
		if (label != null && label.size() != 0) {
		str += label.get(0);
		for (int i = 1; i < label.size(); i++) {
			str += "," + label.get(i);
		}
		}
		return str;
	}
	
	public List<String> strToLabelList(String str) {
		List<String> list = new ArrayList<String>();
		if (!str.equals("")) {
		String[] columnSet = str.split(",");
		for (int i = 0; i < columnSet.length; i++) {
			list.add(columnSet[i]);
		}
		}
		return list;
	}
	public String DateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateStr = sdf.format(date);
		return dateStr;
	}
	public Date StringToDate(String dateStr) throws ParseException {
		if (dateStr.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(dateStr);
		return date;
	}
}
