package com.a.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.a.bean.User;

import com.a.dao.LoginDao;
import com.a.util.ConnUtil;

public  class LoginDaoImpl implements LoginDao {
	

	public ArrayList<User> findAllUser() {
		ArrayList<User> user=new ArrayList<User>();
		
		try { 
			
		    Connection con=ConnUtil.getConn("url","username","password");
			String sql = "select UserName,UserPwd,UserDept,UserPer,UserTele from User";
			PreparedStatement	ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String name=rs.getString("UserName");
				String pwd=rs.getString("UserPwd");
				String dept=rs.getString("UserDept");
				String per=rs.getString("UserPer");
				String tele=rs.getString("UserTele");
				
			    User user1=new User(name, pwd,dept,per,tele);
			    user.add(user1);
			}
		} catch (Exception e) {
			System.out.println("查询数据失败");
			e.printStackTrace();
		}
             return user;
	}


	public void add(User user) {
	
		try {  
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "insert into User(UserName,UserPwd,UserDept,UserPer,UserTele) values(?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPwd());
			ps.setString(3, user.getDept());
			ps.setString(4, user.getPer());
			ps.setString(5, user.getTele());
			System.out.println(sql);
		    ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("添加数据失败");
			e.printStackTrace();
		}
}

	
	public void delete(User user) {
		// TODO Auto-generated method stub
		try {    
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "delete  from User where UserName='"+user.getName()+"'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
		    ps.execute(sql);
		} catch (Exception e) {
			System.out.println("删除数据失败");
			e.printStackTrace();
		}
		

	}


	public void update(User user) {
		// TODO Auto-generated method stub
		try {    
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "update  User Set UserPwd='"+user.getPwd()+"' where UserName='"+user.getName()+"'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
		    ps.execute(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
}


	@Override
	public void updateinfo(User user) {
		try {    
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "update  User Set UserDept='"+user.getDept()+"',UserTele='"+user.getTele()+"' where UserName='"+user.getName()+"'";
			
		    ps = con.prepareStatement(sql);
		    ps.execute(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
		
	}


	

}
