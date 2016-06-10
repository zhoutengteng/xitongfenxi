package com.zhoutengteng.control;
import java.util.*;
import java.io.Serializable;
import com.zhoutengteng.model.UserModel;

public class loginControl implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Boolean login(String account, String password) {
		System.out.println("ddd=========");
		int digitalNumber = 0, charNumber = 0;
		boolean withMailChar = false;
		for (int i = 0; i <account.length();i++)
		{
			if (account.charAt(i)>= '0' && account.charAt(i) <='9')
				digitalNumber++;
			else if (account.charAt(i) == '@') 
				withMailChar = true;
			else 
				charNumber++;
		}
		if (withMailChar){
			return new Boolean(loginByMail(account,password));
		} else{
			if (digitalNumber == 11 && charNumber == 0)
				return new Boolean(loginByTel(account,password));
			else 
				return new Boolean(loginByPassword(account,password));
		}
		
	}
	
//	public static void main(String[] args) {
//		
//		System.out.println(new loginControl().login("dd", "ddd"));
//	}
	
	public boolean loginByPassword(String name, String password) {
		UserModel usermodel = new UserModel();
		List<UserModel> allUserlist = usermodel.getAllUsers();

		if (allUserlist == null) return false;//if list has no user, return false
		
		//Iterator<UserModel> it = allUserlist.iterator();
		//while (it.hasNext()) 
		//{
		//}
		
 		int UserNum = allUserlist.size();
 		UserModel temp = new UserModel();
 		for (int i =0; i< UserNum;i++)
 		{
 			temp = allUserlist.get(i);
 			System.out.println("password from db" +  temp.getPassword());
 			if (temp.getName().equals(name) && temp.getPassword().equals(password))
 				return true;
 		}
		
		return false;
	}
	
	public boolean loginByMail(String mail, String password) {
		UserModel usermodel = new UserModel();
		List<UserModel> allUserlist = usermodel.getAllUsers();
		//if list has no user, return false
		

		if (allUserlist == null) return false;
		
		//Iterator<UserModel> it = allUserlist.iterator();
		//while (it.hasNext()) 
		//{
		//}
		
 		int UserNum = allUserlist.size();
 		UserModel temp = new UserModel();
 		for (int i =0; i< UserNum;i++)
 		{
 			temp = allUserlist.get(i);

 			if (temp.getMail().equals(mail) && temp.getPassword().equals(password))
 				return true;
 		}
		
		return false;
	}
	
	public boolean loginByTel(String tel, String password) {
		UserModel usermodel = new UserModel();
		List<UserModel> allUserlist = usermodel.getAllUsers();
		//if list has no user, return false
		if (allUserlist == null) return false;
		
		//Iterator<UserModel> it = allUserlist.iterator();
		//while (it.hasNext()) 
		//{
		//}
		
 		int UserNum = allUserlist.size();
 		UserModel temp = new UserModel();
 		for (int i =0; i< UserNum;i++)
 		{
 			temp = allUserlist.get(i);
 			if (temp.getPhone().equals(tel) && temp.getPassword().equals(password))
 				return true;
 		}
		
		return false;
	}
	
	public boolean isAdmin(String account, String password) {
		
		return true;
	}
}
