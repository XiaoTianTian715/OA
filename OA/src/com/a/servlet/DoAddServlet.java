package com.a.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Classes;
import com.a.bean.Comparable1;
import com.a.bean.News;
import com.a.dao.ClassesDao;
import com.a.dao.NewsDao;
import com.a.dao.impl.ClassesDaoImpl;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;

public class DoAddServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		this.doreg(req,resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		this.doreg(req, resp);
	}
	protected void doreg(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			Date dt=new Date(0);//如果不需要格式,可直接用dt,dt就是当前系统时间
			String title = req.getParameter("title");
			title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
           
			String Pbperson = req.getParameter("pbperson");
			Pbperson=new String(Pbperson.getBytes("ISO-8859-1"), "UTF-8");
			String content= req.getParameter("content");
			content=new String(content.getBytes("ISO-8859-1"), "UTF-8");
			
			String cla= req.getParameter("classid");
			cla=new String(cla.getBytes("ISO-8859-1"), "UTF-8");
			ClassesDao Dao=new ClassesDaoImpl();
			 Classes clas =Dao.SearchById(cla);
		
			
			int classId = clas.getClassId();
			String newsstate=req.getParameter("newsstate");
			newsstate=new String(newsstate.getBytes("ISO-8859-1"), "UTF-8");
			//dao->实现类
			NewsDao dao = new NewsDaoImpl();
			
			//创建实体 
			News  news=new  News(title,0, Pbperson, dt, content, classId, newsstate);
			
			//dao->实现类
			dao.add(news);
			
			List<News> newslist=new ArrayList<News>();
			newslist=dao.findAllNews();		
			Comparable1 comparable1=new Comparable1();
			CompareUtil.sort(newslist, comparable1.comparator);
			HttpSession session = req.getSession();
			session.setAttribute("newslist", newslist);		
			resp.sendRedirect("allnewslist.jsp");
			
			
			
			//req.getRequestDispatcher("success.jsp").forward(req, resp);

			

}
}
