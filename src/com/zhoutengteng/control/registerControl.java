package com.zhoutengteng.control;

import com.zhoutengteng.model.UserModel;
import java.io.Serializable;
import java.util.*;

public class registerControl {
	
	public boolean saveUser(UserModel userModel) {
		UserModel userManager = new UserModel();
		if (userManager.saveOneUser(userModel)) 
			return true;
		else
			return false;
	}
	
	public String[] retAllSuggest(UserModel userModel) {
		
		//name 
		return null;
	}
	public boolean register(UserModel userModel) {
		return false;
//		boolean noRegistered = true;
//		UserModel userManager = new UserModel(); //这里如何和数据库交互，没搞懂
//		
//		List<UserModel> allregUserList = userManager.getAllUsers();
//		int UserNum = allregUserList.size();
//		UserModel temp = new UserModel();
//		for (int i = 0; i< UserNum; i++) 
//		{
//			temp = allregUserList.get(i);
//			if (temp.getName() == userModel.getName())
//			{
//				noRegistered = false;
//				break;
//			} 
//			if (temp.getMail() == userModel.getMail())
//			{
//				noRegistered = false;
//				break;
//			}
//			if (temp.getPhone() == userModel.getPhone())
//			{
//				noRegistered = false;
//				break;
//			}
//		}
//		if (noRegistered) return userManager.saveOneUser(userModel);
//		return noRegistered;
	}
	
	public UserModel strToUserModel(String str) {
		UserModel userModel = new UserModel();
		
		String ch = ";";
		String s1[] =str.split(ch);
		//get the address from s[0];
		userModel.setAddr(s1[0]);
		//get the contactPeopleList from s[1]
		
		return null;
	}
	
	
}
