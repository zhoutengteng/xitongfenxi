package com.zhoutengteng.model;

import java.util.Date;
import java.util.List;


public class RecordModel {
	private int id;
	private String title;
	private List<String> label;
	private String content;
	private Date startTime;
	private Date endTime;
	private int peopleId;
	private List<UserModel> joinPeopleList;
	
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
	
	public boolean saveOneRecord(RecordModel recordModel) {
		
		return true;
	}
	
	public boolean deleteOneRecord(int id) {
		return true;
	}
	
	public boolean updateOneRecord(RecordModel recordModel) {
		return true;
	}
	
	public RecordModel  lookOneRecord(int id) {
		
		return null;
	}

	public boolean addOneUserToProject(int id) {
		
		return true;
	}
	
	public boolean deleteOneUserFromProject(int id) {
		
		return true;
	}

	@Override
	public String toString() {

		return null;
	}
	
	public RecordModel strToRecode(String str) {
		
		return null;
	}
	
	public List<RecordModel> getAllRecords() {
		
		return null;
	}
}
