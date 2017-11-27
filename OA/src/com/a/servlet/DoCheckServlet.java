package com.a.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.a.bean.Comparable1;
import com.a.bean.News;
import com.a.dao.NewsDao;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;
public class DoCheckServlet extends HttpServlet {
		

		public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			doPost(req,resp);
		}
		
		public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			//ͨ��request���õ��ύ�ı��е�ֵ
			Date dt=new Date(0);//�������Ҫ��ʽ,��ֱ����dt,dt���ǵ�ǰϵͳʱ��
			int newsid1=Integer.parseInt(req.getParameter("newsid"));
			
			String title = req.getParameter("title");
			title=new String(title.getBytes("ISO-8859-1"), "UTF-8");
           
			String Pbperson = req.getParameter("Pbperson");
			Pbperson=new String(Pbperson.getBytes("ISO-8859-1"), "UTF-8");
			String content= req.getParameter("content");
			content=new String(content.getBytes("ISO-8859-1"), "UTF-8");
			int classId = Integer.parseInt(req.getParameter("classId"));
			String newsstate="�����";

			//dao->ʵ����
			NewsDao dao = new NewsDaoImpl();
			
			//����ʵ�� 
			News  news=new  News(title,newsid1, Pbperson, dt, content, classId, newsstate);
		    dao.update(news);
		    
		    
		    List<News> newslist=new ArrayList<News>();
			newslist=dao.findAllNews();		
			Comparable1 comparable1=new Comparable1();
			CompareUtil.sort(newslist, comparable1.comparator);
			HttpSession session = req.getSession();
			session.setAttribute("newslist", newslist);		
			resp.sendRedirect("allnewslist.jsp");
			
			
		
			//req.getRequestDispatcher("success.jsp").forward(req, resp);
			
			

		}


	public void init() throws ServletException {
		// Put your code here
	}

}
