package com.zhoutengteng.model;

import java.util.List;

public class CommentModel {
	private int id;
	private int peopleId;
	private int recordId;
	private String content;
	private int goodsCount;
	private int badsCount;
	public int getPeopleId() {
		return peopleId;
	}
	public void setPeopleId(int peopleId) {
		this.peopleId = peopleId;
	}
	public int getRecordId() {
		return recordId;
	}
	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getGoodsCount() {
		return goodsCount;
	}
	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}
	public int getBadsCount() {
		return badsCount;
	}
	public void setBadsCount(int badsCount) {
		this.badsCount = badsCount;
	}
	public int getId() {
		return id;
	}
	
	public CommentModel lookOneComment(int commentId) {
		
		return null;
	}
	
	public CommentModel lookOneComment(int peopleId, int recordId) {
		
		return null;
	}
	
	public List<CommentModel> getAllCommentsByRecordId(int recordId) {
		return null;
	}
	
	public List<CommentModel> getAllCommentsByPeopleId(int peopleId) {
		return null;
	}
	
	public boolean saveOneComment(CommentModel commentModel) {
		
		return true;
	}
	
	public boolean deleteOneComment(int id) {
		return true;
	}
	
	public boolean updateOneComment(CommentModel commentModel) {
		
		return true;
	}
	
	@Override
	public String toString() {
		return null;
	}
	
	public CommentModel strToComment(String str) {
		return null;
	}
	
	public List<CommentModel> getAllComments() {
		return null;
	}
}
