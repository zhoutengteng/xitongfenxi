package com.zhoutengteng.model;

import java.security.spec.RSAPublicKeySpec;
import java.awt.*;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.xml.stream.events.Comment;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;

public class CommentModel implements Serializable {
	private int id = 0;
	private int peopleId = 0;
	private int recordId = 0;
	private String content = "";
	private int goodsCount = 0;
	private int badsCount = 0;
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
	public void setId(int commentId) {
		this.id = commentId;
	}
	
	public CommentModel lookOneComment(int commentId) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from comments where id = " + commentId;
		try {
			CommentModel commentModel = new CommentModel();
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			commentModel.setId(rs.getInt("id"));
			commentModel.setPeopleId(rs.getInt("peopleId"));
			commentModel.setRecordId(rs.getInt("recordId"));
			commentModel.setContent(rs.getString("content"));
			commentModel.setGoodsCount(rs.getInt("goodsCount"));
			commentModel.setBadsCount(rs.getInt("badsCount"));
			rs.close();
			return commentModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	public CommentModel lookOneComment(int peopleId, int recordId) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from comments where peopleId = " + peopleId + " and recordId = " + recordId;
		System.out.println(sql);
		try {
			CommentModel commentModel = new CommentModel();
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			commentModel.setId(rs.getInt("id"));
			commentModel.setPeopleId(rs.getInt("peopleId"));
			commentModel.setRecordId(rs.getInt("recordId"));
			commentModel.setContent(rs.getString("content"));
			commentModel.setGoodsCount(rs.getInt("goodsCount"));
			commentModel.setBadsCount(rs.getInt("badsCount"));
			rs.close();
			return commentModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	public List<CommentModel> getAllCommentsByRecordId(int recordId) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from comments where recordId = " + recordId;
		List<CommentModel> list = new ArrayList<CommentModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			CommentModel commentModel = new CommentModel();
			commentModel.setId(rs.getInt("id"));
			commentModel.setPeopleId(rs.getInt("peopleId"));
			commentModel.setRecordId(rs.getInt("recordId"));
			commentModel.setContent(rs.getString("content"));
			commentModel.setGoodsCount(rs.getInt("goodsCount"));
			commentModel.setBadsCount(rs.getInt("badsCount"));
			list.add(commentModel);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	public List<CommentModel> getAllCommentsByPeopleId(int peopleId) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from comments where peopleId = " + peopleId;
		List<CommentModel> list = new ArrayList<CommentModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			CommentModel commentModel = new CommentModel();
			commentModel.setId(rs.getInt("id"));
			commentModel.setPeopleId(rs.getInt("peopleId"));
			commentModel.setRecordId(rs.getInt("recordId"));
			commentModel.setContent(rs.getString("content"));
			commentModel.setGoodsCount(rs.getInt("goodsCount"));
			commentModel.setBadsCount(rs.getInt("badsCount"));
			list.add(commentModel);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean saveOneComment(CommentModel commentModel) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "insert into comments values " + "(" +commentModel.toString()+ ")";
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOneComment(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "delete from comments where id = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteOneCommentByPeopleId(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "delete from comments where peopleId = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteOneCommentByrecordId(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "delete from comments where recordId = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteOneCommentByRecordIdAndPeopleId(int recordId, int peopleId) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "delete from comments where recordId = " + recordId + " and peopleId = " + peopleId;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateOneComment(CommentModel commentModel) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "update comments set id = " + commentModel.getId() + ",peopleId = "+commentModel.getPeopleId() + ",recordId = " + commentModel.getRecordId() + ",content = " + '"'+commentModel.getContent()+'"' + ",goodsCount = " +commentModel.getGoodsCount() + ",badsCount = " + commentModel.getBadsCount() + " where id = "+commentModel.getId();
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String toString() {
		String str = "";
		str += this.getId();
		str += ","+this.getPeopleId();
		str += ","+this.getRecordId();
		str += ","+'"'+this.getContent()+'"';
		str += ","+this.getGoodsCount();
		str += ","+this.getBadsCount();
		return str;
	}
	
	public CommentModel strToComment(String str) {
		CommentModel cModel = new CommentModel();
		String[] columnSet = str.split(",");
		cModel.setId(Integer.parseInt(columnSet[0]));
		cModel.setPeopleId(Integer.parseInt(columnSet[1]));
		cModel.setRecordId(Integer.parseInt(columnSet[2]));
		cModel.setContent(columnSet[3]);
		cModel.setGoodsCount(Integer.parseInt(columnSet[4]));
		cModel.setBadsCount(Integer.parseInt(columnSet[5]));
		return cModel;
		
	}
	
	public List<CommentModel> getAllComments() {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from comments";
		List<CommentModel> list = new ArrayList<CommentModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			CommentModel commentModel = new CommentModel();
			commentModel.setId(rs.getInt("id"));
			commentModel.setPeopleId(rs.getInt("peopleId"));
			commentModel.setRecordId(rs.getInt("recordId"));
			commentModel.setContent(rs.getString("content"));
			commentModel.setGoodsCount(rs.getInt("goodsCount"));
			commentModel.setBadsCount(rs.getInt("badsCount"));
			list.add(commentModel);
			}
			rs.close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
}
