package com.zhoutengteng.model;
import java.security.KeyStore.Entry;
import java.sql.*;
import java.util.Map;
public class DBforUser {
	//连接到数据库的URL
    private final String DBURL = "jdbc:mysql://localhost:3306/xitongfenxi?useUnicode=true&characterEncoding=utf-8";
    private final String DBUSER = "root";
    private final String DBPWD = "3315556";
    private Connection con;
    private Statement stmt;
    
    public DBforUser() {
        try {
            //加载驱动器, 下面的代码为加载MySQL驱动器
        	try {
      	      Class.forName("com.mysql.jdbc.Driver");  
      	    }
      	    catch (Exception e) {
      	      System.out.print("Error loading Mysql Driver!");
      	      e.printStackTrace();
      	    }
            //注册MySQL驱动器
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //建立数据库连接
            con = java.sql.DriverManager.getConnection(DBURL, DBUSER, DBPWD);
            //创建一个Statement 对象
            stmt = con.createStatement();
        } catch (Exception e) {
        	System.out.println("Failed!");
        	e.printStackTrace();
        }
    }
    public Connection getConnection() {
    	return con;
    }
    
    public Statement getStatement() {
    	return stmt;
    }
    
    public void close() throws SQLException {
    	stmt.close();
    	con.close();
    }
	/*public void  insert(String name, int age, String password, String address) {
        try {
            con = java.sql.DriverManager.getConnection(DBURL, DBUSER, DBPWD);
            stmt = con.createStatement();
            stmt.executeUpdate("insert into tbl_user(name, age, password, address) values(" + "'" + name + "'," +  age + ","  + "'" +  password + "'," + "'" + address + "')");
            stmt.close();
            con.close();
        } catch (Exception e) {
        
        }
    }
	
	public ResultSet queryRecordByID(String TableName, Pair<String, Integer>... pair) {
		String sql = "select * from " + TableName;
		for (int i = 0; i < id.length; i++) {
			sql += " where id = " + id[i];
		}
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block	
			e.printStackTrace();
			return null;
		}
	}*/
	
	
}
