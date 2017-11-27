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
	
public class DoDelServlet extends HttpServlet {
		

		
public void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			doPost(req,resp);
		}

		
public void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
	//通过request来得到提交的表单中的值
        	int NewsId = Integer.parseInt(req.getParameter("Id"));;

	//dao->实现类
            	NewsDao dao = new NewsDaoImpl();
	//创建实体
            News news2=dao.SearchById(NewsId);
            dao.delete(news2);
            
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
	

