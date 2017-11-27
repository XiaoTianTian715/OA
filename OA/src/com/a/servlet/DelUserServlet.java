package com.a.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.User;
import com.a.dao.LoginDao;
import com.a.dao.impl.LoginDaoImpl;

import java.sql.Date;
import java.util.ArrayList;



public class DelUserServlet extends HttpServlet {
			

			
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {

				doPost(req,resp);
			}

			
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
					throws ServletException, IOException {
		//通过request来得到提交的表单中的值
		String username = req.getParameter("Name");
		username=new String(username.getBytes("ISO-8859-1"), "UTF-8");

		//dao->实现类
		LoginDao dao = new LoginDaoImpl();
		
		//创建实体 
		User user=new  User(username, null, null, null, null);
		
	        	dao.delete(user);
	        	
	    
	    ArrayList<User> userlist=dao.findAllUser();
				
		HttpSession session=req.getSession();
		session.setAttribute("userlist", userlist);    	
	        	
	        	
	    req.getRequestDispatcher("userlist.jsp").forward(req, resp);
			
				
		}

		public void init() throws ServletException {
			// Put your code here
		}

	}
		




