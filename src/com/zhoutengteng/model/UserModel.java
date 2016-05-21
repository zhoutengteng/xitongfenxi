package com.zhoutengteng.model;

import java.util.List;

public class UserModel {
	private int id;
	private String name;
	private int sex;
	private String password;
	private String mail;
	private String phone;
	private String headImageAdd;
	private String addr;
	private List<UserModel> contactPeopleList;
	private int rate;
	
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
	
	public boolean saveOneUser(UserModel user) {
		
		return true;
	}
	
	public boolean deleteOneUser(int id) {
		
		return true;
	}
	
	public boolean updateOneUser(UserModel user) {
		return true;
	}
	
	public UserModel lookOneUser(int id) {
		
		return null;
	}
	
	public boolean addOneUserToPeopleList(int id) {
		
		return true;
	}
	
	public boolean deleteOneUserFromPeopleList(int id) {
		
		return true;
	}
	
	@Override
	public String toString() {
		
		return null;
	}
	
	/**
	 * 对toString的反解析
	 * @param str
	 * @return 
	 */
	public UserModel strToUser(String str) {
		
		return null;
	}
	
	public List<UserModel> getAllUsers() {
		
		return null;
	}

}
