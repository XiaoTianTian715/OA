package com.a.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.News;
import com.a.dao.NewsDao;
import com.a.dao.impl.NewsDaoImpl;

public class ReviewSearchById extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReviewSearchById() {
		super();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


		//ͨ��request���õ��ύ�ı��е�ֵ
		int NewsId = Integer.parseInt(req.getParameter("newsId"));

		//dao->ʵ����
	   	NewsDao dao = new NewsDaoImpl();
		//����ʵ��
		 HttpSession session=req.getSession();
			
			
		 News news1=dao.SearchById(NewsId);
		 session.setAttribute("news1", news1);
		
		req.getRequestDispatcher("CheckNews.jsp").forward(req, resp);
	}
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	

	public void init() throws ServletException {
		// Put your code here
	}

}
