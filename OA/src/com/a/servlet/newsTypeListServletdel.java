package com.a.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.a.bean.Classes;
import com.a.bean.Comparable2;
import com.a.bean.Comparable3;
import com.a.dao.ClassesDao;
import com.a.dao.impl.ClassesDaoImpl;
import com.a.util.CompareUtil;
import com.mysql.jdbc.Connection;



public class newsTypeListServletdel extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		List<Classes> Cla=new ArrayList<Classes>();
		ClassesDao Dao=new ClassesDaoImpl();
		Cla=Dao.findAllClasses();
		
		Comparable3 comparable3=new Comparable3();
		CompareUtil.sort(Cla, comparable3.comparator);
		Collections.reverse(Cla);
		
		session.setAttribute("claslist", Cla);
		resp.sendRedirect("newsType.jsp");
	}

}
