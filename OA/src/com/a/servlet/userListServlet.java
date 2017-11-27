package com.a.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import com.a.bean.User;
import com.a.dao.LoginDao;
import com.a.dao.impl.LoginDaoImpl;

public class userListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		List<User> userlist=new ArrayList<User>();
		LoginDao loginDao=new LoginDaoImpl();
		userlist=loginDao.findAllUser();
		session.setAttribute("userlist", userlist);
		resp.sendRedirect("userlist.jsp");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		
		
	}
}
