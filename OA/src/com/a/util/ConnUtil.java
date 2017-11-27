package com.a.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnUtil {
	
	
	public static Connection getConn(String url,String username,String password ){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(PropertiesUtil.readValue(url), PropertiesUtil.readValue(username), PropertiesUtil.readValue(password));
			}catch (Exception e) {  
            System.out.println("数据库连接失败" + e.getMessage());  
        }  
        return con; 
		
	}
	}
	



