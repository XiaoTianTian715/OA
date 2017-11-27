package com.a.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Classes;
import com.a.bean.Comparable3;
import com.a.bean.News;
import com.a.dao.ClassesDao;
import com.a.dao.NewsDao;
import com.a.dao.impl.ClassesDaoImpl;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.CompareUtil;

public class DelTypeServlet extends HttpServlet {
	
			
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {

				doPost(req,resp);
			}

			
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		//ͨ��request���õ��ύ�ı��е�ֵ
	        	int TypeId = Integer.parseInt(req.getParameter("Id"));;

		//dao->ʵ����
	            	ClassesDao dao = new ClassesDaoImpl();
		//����ʵ��
	            Classes type=dao.SearchById(TypeId);
	         dao.delete(type);
	         
	         	ArrayList<Classes> classeslist=dao.findAllClasses();
				HttpSession session=req.getSession();
				
				Comparable3 comparable3=new Comparable3();
				CompareUtil.sort(classeslist, comparable3.comparator);
				
				session.setAttribute("claslist", classeslist);
				resp.sendRedirect("newsType.jsp");
	         
	         
	         
	           // req.getRequestDispatcher("success.jsp").forward(req, resp);
			
				
		}

		public void init() throws ServletException {
			// Put your code here
		}

	}
		

