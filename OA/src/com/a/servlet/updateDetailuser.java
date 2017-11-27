package com.a.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.User;
import com.a.dao.LoginDao;
import com.a.dao.impl.LoginDaoImpl;


public class updateDetailuser extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mynameString=req.getParameter("username");
		String deptString=req.getParameter("dept");
		String teleString=req.getParameter("tele");
		String perString=req.getParameter("per");
		
		mynameString=new String(mynameString.getBytes("ISO-8859-1"), "UTF-8");
		deptString=new String(deptString.getBytes("ISO-8859-1"), "UTF-8");
		teleString=new String(teleString.getBytes("ISO-8859-1"), "UTF-8");
		perString=new String(perString.getBytes("ISO-8859-1"), "UTF-8");
		
		
		User myuser=new User(mynameString, null, deptString, perString, teleString);		
		LoginDao loginDao=new LoginDaoImpl();
		loginDao.updateinfo(myuser);
		
		HttpSession session=req.getSession();
		ArrayList<User> user=loginDao.findAllUser();
    	for(int i=0;i<user.size();i++)
		{
			
			if(user.get(i).getName().equals(mynameString))
			{
				user.get(i).setDept(deptString);
				user.get(i).setTele(teleString);
				session.setAttribute("myuser",user.get(i));
			}
		
		} 
		
		resp.sendRedirect("userDetail.jsp");
		


		
	}
}