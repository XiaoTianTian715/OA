package com.a.servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Classes;
import com.a.bean.News;
import com.a.bean.User;
import com.a.dao.LoginDao;
import com.a.dao.impl.LoginDaoImpl;

public class AddUserServlet extends HttpServlet {
	
	

		
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
				String username = req.getParameter("username");
				username=new String(username.getBytes("ISO-8859-1"), "UTF-8");
				
				String pwd = req.getParameter("pwd");
				pwd=new String(pwd.getBytes("ISO-8859-1"), "UTF-8");
	           
				String dept = req.getParameter("dept");
				dept=new String(dept.getBytes("ISO-8859-1"), "UTF-8");
				String per= req.getParameter("per");
				per=new String(per.getBytes("ISO-8859-1"), "UTF-8");
				String tele= req.getParameter("tele");
				tele=new String(tele.getBytes("ISO-8859-1"), "UTF-8");
				
				
				
				
				
				
				//dao->实现类
				LoginDao dao = new LoginDaoImpl();
				
				//创建实体 
				User user=new  User(username, pwd, dept, per, tele);
				
				//dao->实现类
				dao.add(user);
				
				ArrayList<User> userlist=dao.findAllUser();
				
				HttpSession session=req.getSession();
				session.setAttribute("userlist", userlist);
				
				
				req.getRequestDispatcher("userlist.jsp").forward(req, resp);

				

	}
	}

	
	
	


