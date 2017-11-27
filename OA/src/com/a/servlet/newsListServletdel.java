package com.a.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.resource.cci.ConnectionSpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Comparable1;
import com.a.bean.Comparable2;
import com.a.bean.Comparable4;
import com.a.bean.Comparable5;
import com.a.bean.Comparable6;
import com.a.bean.News;
import com.a.dao.NewsDao;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;
import com.mysql.jdbc.Connection;

public class newsListServletdel extends HttpServlet {
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = req.getSession();
		List<News> newslist=new ArrayList<News>();
		
		
		
		NewsDao newsDao=new NewsDaoImpl();
		newslist=newsDao.findAllNews();
		int addID = Integer.parseInt(req.getParameter("addID"));
		if(addID==1)
		{			
			Comparable1 comparable1=new Comparable1();
			CompareUtil.sort(newslist, comparable1.comparator);
		}		
		else if(addID==2)
		{		
		Comparable2 comparable2=new Comparable2();
		CompareUtil.sort(newslist, comparable2.comparator);
		}
		else if(addID==3)
		{
			Comparable4 comparable4=new Comparable4();
			CompareUtil.sort(newslist, comparable4.comparator);
		}
		else if(addID==4)
		{
			Comparable4 comparable4=new Comparable4();
			CompareUtil.sort(newslist, comparable4.comparator);
			Collections.reverse(newslist);
		}
		else if(addID==5)
		{
			Comparable5 comparable5=new Comparable5();
			CompareUtil.sort(newslist, comparable5.comparator);
		}
		else if(addID==6)
		{
			Comparable5 comparable5=new Comparable5();
			CompareUtil.sort(newslist, comparable5.comparator);
			Collections.reverse(newslist);
		}
		else if(addID==7)
		{
			Comparable6 comparable6=new Comparable6();
			CompareUtil.sort(newslist, comparable6.comparator);
		}
		else if(addID==8)
		{
			Comparable6 comparable6=new Comparable6();
			CompareUtil.sort(newslist, comparable6.comparator);
			Collections.reverse(newslist);
		}
		
		
		
		session.setAttribute("newslist", newslist);		
		resp.sendRedirect("allnewslist.jsp");
	}

}
