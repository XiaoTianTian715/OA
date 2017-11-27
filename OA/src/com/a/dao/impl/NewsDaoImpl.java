package com.a.dao.impl;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
  
import com.a.bean.News;

import com.a.dao.NewsDao;
import com.a.util.ConnUtil;

public class NewsDaoImpl implements  NewsDao{

	public ArrayList<News> findAllNews() {
		ArrayList<News> news=new ArrayList<News>();
	try { 
			
		    Connection con=ConnUtil.getConn("url","username","password");
			String sql = "select Title,NewsId,PbTime,Content,Pbperson,ClassId,NewsState from newsinfo";
			PreparedStatement	ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				String title=rs.getString("Title");
				int newsid=rs.getInt("NewsId");
				Date dept=rs.getDate("PbTime");
				String content=rs.getString("Content");
				String Pbperson=rs.getString("Pbperson");
				int classId=rs.getInt("ClassId");
				String newsstate=rs.getString("NewsState");
				
			    News news1 =new News(title,newsid,Pbperson, dept,content,classId,newsstate);
			    news.add(news1);
			}
		} catch (Exception e) {
			System.out.println("查询数据失败");
			e.printStackTrace();
		}
             return news;
	}

	public void add(News news) {
		try {  
		
			Date dt = new Date(System.currentTimeMillis());//如果不需要格式,可直接用dt,dt就是当前系统时间
	       
	        
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "insert into newsinfo(Title,PbTime,Content,Pbperson,ClassId,NewsState) values(?,?,?,?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, news.getTitle());
			ps.setDate(2, dt);
			ps.setString(3, news.getContent());
			ps.setString(4, news.getPbperson());
			ps.setInt(5, news.getClassid());
			ps.setString(6, news.getState());
			System.out.println(sql);
		    ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("添加数据失败");
			e.printStackTrace();
		}
		
	}

	public void delete(News news) {
		try {    
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "delete  from newsinfo where NewsId='"+news.getNewsid()+"'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
		    ps.execute(sql);
		} catch (Exception e) {
			System.out.println("删除数据失败");
			e.printStackTrace();
		}
		
	}

	public void update(News news) {
		try {    
			PreparedStatement ps;
		    Connection con=ConnUtil.getConn("url","username","password");
		    String sql = "update  newsinfo Set Title='"+news.getTitle()+"',PbPerson='"+news.getPbperson()+"'  ,Content='"+news.getContent()+"'  ,ClassID='"+news.getClassid()+"'    ,NewsState='"+news.getState()+"'    where NewsId='"+news.getNewsid()+"'";
			ps = con.prepareStatement(sql);
			System.out.println(sql);
		    ps.execute(sql);
		} catch (Exception e) {
			System.out.println("更新数据失败");
			e.printStackTrace();
		}
		
	}
	

	public News SearchById(int id) {
		News news1 = null;
		try { 
		 Connection con=ConnUtil.getConn("url","username","password");
			String sql = "select Title,NewsId,PbTime,Pbperson,Content,ClassId,NewsState from newsinfo";
			PreparedStatement	ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				String title=rs.getString("Title");
				int newsid=rs.getInt("NewsId");
				Date dept=rs.getDate("PbTime");
				String pbperson=rs.getString("Pbperson");
				String content=rs.getString("Content");
				int classId=rs.getInt("ClassId");
				String newsstate=rs.getString("NewsState");
				if(id==newsid)
				{news1 =new News(title,newsid,pbperson, dept,content,classId,newsstate);}
			 
			}
		} catch (Exception e) {
			System.out.println("查询数据失败");
			e.printStackTrace();
		}
		return news1;
	}
}
