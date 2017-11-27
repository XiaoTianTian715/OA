package com.a.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.a.bean.Classes;
import com.a.dao.ClassesDao;
import com.a.util.ConnUtil;

public class ClassesDaoImpl implements ClassesDao {

	@Override
	public ArrayList<Classes> findAllClasses() {
		ArrayList<Classes> cla = new ArrayList<Classes>();

		try {

			Connection con = ConnUtil.getConn("url", "username", "password");
			String sql = "select ClassId,ClassName from classes";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int classid = rs.getInt("ClassId");
				String classname = rs.getString("ClassName");
				Classes clas = new Classes(classname, classid);
				cla.add(clas);
			}
		} catch (Exception e) {
			System.out.println("查询数据失败");
			e.printStackTrace();
		}
		return cla;
	}

	@Override
	public void add(Classes classes) {
		try {
			PreparedStatement ps;
			Connection con = ConnUtil.getConn("url", "username", "password");
			String sql = "insert into classes(ClassName) values(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, classes.getClassName());
			System.out.println(sql);
			ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("添加数据失败");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Classes classes) {
		try {
		    
		
			PreparedStatement ps;
			Connection con = ConnUtil.getConn("url", "username", "password");
			String sql = "delete  from classes where ClassId='"+ classes.getClassId() + "'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			ps.execute(sql);
		} catch (Exception e) {
			System.out.println("删除数据失败");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Classes classes) {
		try {
			
			PreparedStatement ps;
			Connection con = ConnUtil.getConn("url", "username", "password");
			String sql = "update  classes Set ClassName='"
					+ classes.getClassName() + "' where ClassId='"
					+ classes.getClassId() + "'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
			ps.execute(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();

		}

	}

	@Override
	public Classes SearchById(int id) {
		Classes cla = null;
	try { 
		 Connection con=ConnUtil.getConn("url","username","password");
			String sql = "select ClassName,ClassId from classes";
			PreparedStatement	ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				
				int newsid=rs.getInt("ClassId");		
				String claname=rs.getString("ClassName");
				if(id==newsid)
				{cla =new Classes(claname, newsid);}
			 
			}
		} catch (Exception e) {
			System.out.println("查询数据失败");
			e.printStackTrace();
		}
		return cla;

	}

	@Override
	public Classes SearchById(String id) {
		Classes cla = null;
		try { 
			 Connection con=ConnUtil.getConn("url","username","password");
				String sql = "select ClassName,ClassId from classes";
				PreparedStatement	ps =con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					
					
					int newsid=rs.getInt("ClassId");		
					String claname=rs.getString("ClassName");
					if(id.equals(claname))
					{cla =new Classes(claname, newsid);}
				 
				}
			} catch (Exception e) {
				System.out.println("查询数据失败");
				e.printStackTrace();
			}
			return cla;

	}

}
