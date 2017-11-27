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

public class LoginServlet extends HttpServlet{


		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			LoginDao loginDao=new LoginDaoImpl(){};
			ArrayList<User> user=loginDao.findAllUser();
			HttpSession session = req.getSession();
			String userName = req.getParameter("loginName");
			String passWord = req.getParameter("loginPwd");
			
			
			userName=new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			passWord=new String(passWord.getBytes("ISO-8859-1"), "UTF-8");
			
			ClassesDao cladao=new  ClassesDaoImpl();
			ArrayList<Classes> cla=cladao.findAllClasses();

			
	
			
			
		
			for(int i=0;i<user.size();i++)
			{
				
				System.out.println(user.get(i).getName());
				if(user.get(i).getName().equals(userName)&&user.get(i).getPwd().equals(passWord))
				{
				    User	user2=user.get(i);
					session.setAttribute("myuser", user2);
					session.setAttribute("cla",cla );
					session.setAttribute("cladao",cladao );
					resp.sendRedirect("oa.jsp");
					return;
					
					
					
				}
			}
			resp.sendRedirect("login.jsp");
			
			}
		
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			super.doGet(req, resp);
		}
		
	}