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
import com.a.bean.Comparable2;
import com.a.bean.News;
import com.a.dao.NewsDao;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;

public class releaseNewsListServletdel extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();
		List<News> newslist = new ArrayList<News>();
		List<News> newslistx = new ArrayList<News>();

		NewsDao newsDao = new NewsDaoImpl();
		newslist = newsDao.findAllNews();
		for (int i = 0; i < newslist.size(); i++) {
			if (newslist.get(i).getState().equals("ÒÑÉóºË")) {

				newslistx.add(newslist.get(i));
			}

		}
		Comparable2 comparable2=new Comparable2();
		CompareUtil.sort(newslistx, comparable2.comparator);
		session.setAttribute("newslistx", newslistx);
		
		resp.sendRedirect("releaseNewsList.jsp");
	}

}
