package com.a.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Comparable1;
import com.a.bean.News;
import com.a.bean.User;
import com.a.dao.LoginDao;
import com.a.dao.NewsDao;
import com.a.dao.impl.LoginDaoImpl;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;

public class newsListServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = req.getSession();
		List<News> newslist=new ArrayList<News>();
		
		
		
		NewsDao newsDao=new NewsDaoImpl();
		
		newslist=newsDao.findAllNews();		
		Comparable1 comparable1=new Comparable1();
		CompareUtil.sort(newslist, comparable1.comparator);
		
		session.setAttribute("newslist", newslist);		
		resp.sendRedirect("allnewslist.jsp");
	}
	

}
