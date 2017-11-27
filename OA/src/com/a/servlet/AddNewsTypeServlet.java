package com.a.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.*;

import com.a.dao.*;
import com.a.dao.impl.*;
import com.a.util.CompareUtil;

public class AddNewsTypeServlet extends HttpServlet {
	
	

		
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
				String typename = req.getParameter("typename");
				typename=new String(typename.getBytes("ISO-8859-1"), "UTF-8");
	
				
				//dao->实现类
			ClassesDao classesDao=new ClassesDaoImpl();
				
				//创建实体 
			Classes classes=new Classes(typename, 0);
				
				//dao->实现类
			classesDao.add(classes);
			
			ArrayList<Classes> classeslist=classesDao.findAllClasses();
			HttpSession session=req.getSession();
			
			Comparable3 comparable3=new Comparable3();
			CompareUtil.sort(classeslist, comparable3.comparator);
			
			session.setAttribute("claslist", classeslist);
			resp.sendRedirect("newsType.jsp");
			
			
			
			//req.getRequestDispatcher("../success.jsp").forward(req, resp);

				

	}
	}

	
	
	


