package com.zhoutengteng.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.UnmarshallerHandler;

import com.zhoutengteng.control.registerControl;

public class UserModel implements Serializable{
	private int id = 0;
	private String name = "";
	private int sex = 0;
	private String password = "";
	private String mail = "";
	private String phone = "";
	private String headImageAdd = "";
	private String addr = "";
	private List<UserModel> contactPeopleList;
	private int rate = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHeadImageAdd() {
		return headImageAdd;
	}
	public void setHeadImageAdd(String headImageAdd) {
		this.headImageAdd = headImageAdd;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	/**
	 * 注意那个好友列表，存的是id，用逗号隔开，  id1，id2，id3
	 * @return 
	 */
	public List<UserModel> getContactPeopleList() {
		return contactPeopleList;
	}
	public void setContactPeopleList(List<UserModel> contactPeopleList) {
		this.contactPeopleList = contactPeopleList;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getId() {
		return id;
	}
	public void setId(int userId) {
		this.id = userId;
	}
	public boolean saveOneUser(UserModel user) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "insert into users values " + "(" +user.toString()+ ")";
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteOneUser(int id) {
		DBForConnection dBforUser = new DBForConnection();
		CommentModel commentModel = new CommentModel();
		RecordModel recordModel = new RecordModel();
		commentModel.deleteOneCommentByPeopleId(id);
		recordModel.deleteOneRecordByPeopleId(id);
		List<UserModel> list = lookOneUser(id).getContactPeopleList();
		for (int i = 0; i < list.size(); i++) {
			UserModel peopleIn = lookOneUser(list.get(i).getId());
			peopleIn.deleteOneUserFromPeopleList(id);
			updateOneUser(peopleIn);
		}
		String sql = "delete from users where id = " + id;
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean updateOneUser(UserModel user) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "update users set id = " + user.getId() + ", name = "+'"'+user.getName()+'"'+ ", sex = " + user.getSex() + ", password = " + '"'+user.getPassword()+'"' + ", mail = " +'"'+user.getMail()+'"' + ", phone = " + '"'+user.getPhone()+'"' + ", headImageAdd = " + '"'+user.getHeadImageAdd()+'"' + ", addr = " + '"'+user.getAddr()+'"' + ", contactPeopleList = " + '"'+getListString(user.getContactPeopleList())+'"' + ", rate =" + user.getRate() + " where id = "+user.getId();
		try {
			dBforUser.getStatement().executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return false;
		}
	}
	
	public UserModel lookOneUser(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from users where id = " + id;
		try {
			UserModel userModel = new UserModel();
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			userModel.setId(rs.getInt("id"));
			userModel.setName(rs.getString("name"));
			userModel.setSex(rs.getInt("sex"));
			userModel.setPassword(rs.getString("password"));
			userModel.setMail(rs.getString("mail"));
			userModel.setPhone(rs.getString("phone"));
			userModel.setHeadImageAdd(rs.getString("headImageAdd"));
			userModel.setAddr(rs.getString("addr"));
			userModel.setContactPeopleList(userModel.strToList(rs.getString("contactPeopleList")));
			userModel.setRate(rs.getInt("rate"));
			rs.close();
			dBforUser.close();
			return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int lookOneUserId(String name1) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from users where name = " + "'" +  name1.toString() + "'";
		try {
			int id = 0;
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			id = rs.getInt("id");
			rs.close();
			dBforUser.close();
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return -1;
		}
	}
	
	
	public UserModel lookOneUserIgnoreList(int id) {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from users where id = " + id;
		try {
			UserModel userModel = new UserModel();
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			rs.next();
			userModel.setId(rs.getInt("id"));
			userModel.setName(rs.getString("name"));
			userModel.setSex(rs.getInt("sex"));
			userModel.setPassword(rs.getString("password"));
			userModel.setMail(rs.getString("mail"));
			userModel.setPhone(rs.getString("phone"));
			userModel.setHeadImageAdd(rs.getString("headImageAdd"));
			userModel.setAddr(rs.getString("addr"));
			userModel.setRate(rs.getInt("rate"));
			rs.close();
			dBforUser.close();
			return userModel;
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean addOneUserToPeopleList(int id) {
		UserModel uModel = lookOneUser(id);
		this.contactPeopleList.add(uModel);
		if (updateOneUser(this)) {
		return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteOneUserFromPeopleList(int id) {
		Iterator<UserModel> it = this.contactPeopleList.iterator();
		while(it.hasNext()) {
			UserModel uModel = it.next();
			if (uModel.getId() == id) {
				it.remove();
				if (updateOneUser(this)) {
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
		str += ","+'"'+this.getName()+'"';
		str += ","+this.getSex();
		str += ","+'"'+this.getPassword()+'"';
		str += ","+'"'+this.getMail()+'"';
		str += ","+'"'+this.getPhone()+'"';
		str += ","+'"'+this.getHeadImageAdd()+'"';
		str += ","+'"'+this.getAddr()+'"';
		str += ","+'"'+getListString(this.getContactPeopleList())+'"';
		str += ","+this.getRate();
		return str;
	}
	
	/**
	 * 对toString的反解析
	 * @param str
	 * @return 
	 */
	public UserModel strToUser(String str) {
		UserModel uModel = new UserModel();
		String[] columnSet = str.split(",");
		uModel.setId(Integer.parseInt(columnSet[0]));
		uModel.setSex(Integer.parseInt(columnSet[1]));
		uModel.setPassword(columnSet[2]);
		uModel.setMail(columnSet[3]);
		uModel.setPhone(columnSet[4]);
		uModel.setHeadImageAdd(columnSet[5]);
		uModel.setAddr(columnSet[6]);
		uModel.setContactPeopleList(strToList(columnSet[7]));
		uModel.setRate(Integer.parseInt(columnSet[8]));
		return uModel;
	}
	
	public List<UserModel> getAllUsers() {
		DBForConnection dBforUser = new DBForConnection();
		String sql = "select * from users";
		List<UserModel> list = new ArrayList<UserModel>();	
		try {
			ResultSet rs = dBforUser.getStatement().executeQuery(sql);
			while(rs.next()) {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getInt("id"));
			userModel.setName(rs.getString("name"));
			userModel.setSex(rs.getInt("sex"));
			userModel.setPassword(rs.getString("password"));
			userModel.setMail(rs.getString("mail"));
			userModel.setPhone(rs.getString("phone"));
			userModel.setHeadImageAdd(rs.getString("headImageAdd"));
			userModel.setAddr(rs.getString("addr"));
			userModel.setContactPeopleList(userModel.strToList(rs.getString("contactPeopleList")));
			userModel.setRate(rs.getInt("rate"));
			list.add(userModel);
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
	
	/**
	 * @param cpl
	 * @return contactPeopleList的字符串形式
	 */
	public String getListString(List<UserModel> cpl) {
		String str = "";
		if (cpl != null && cpl.size() != 0) {
		str += cpl.get(0).getId();
		for (int i = 1; i < cpl.size(); i++) {
			str += "," + cpl.get(i).getId();
		}
		}
		return str;
	}
	
	/**
	 * @param str
	 * @return contactPeopleList
	 */
	public List<UserModel> strToList(String str) {
		List<UserModel> list = new ArrayList<UserModel>();
		if (!str.equals("")) {
		String[] columnSet = str.split(",");
		for (int i = 0; i < columnSet.length; i++) {
			list.add(lookOneUserIgnoreList(Integer.parseInt(columnSet[i])));
		}
		}
		return list;
	}

}
