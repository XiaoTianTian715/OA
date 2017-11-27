package com.a.servlet;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import com.a.bean.News;
import com.a.dao.NewsDao;
import com.a.dao.impl.NewsDaoImpl;
import com.a.util.StudentExportService;

public class StudentExportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			exportExcel(req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	public void exportExcel(HttpServletRequest request, HttpServletResponse response)     
		    throws Exception {    
	  StudentExportService studentExportService=new StudentExportService();
	  List<News> newslist = new ArrayList<News>();
	List<News> newslistx = new ArrayList<News>();

		NewsDao newsDao = new NewsDaoImpl();
		newslist = newsDao.findAllNews();
		
		for (int i = 0; i < newslist.size(); i++) {
			if (newslist.get(i).getState().equals("ÒÑÉóºË")) {
                  newslistx.add(newslist.get(i));
			}

		}
	        

	        HSSFWorkbook wb = studentExportService.export(newslistx);  
	        response.setContentType("application/vnd.ms-excel");  
	        response.setHeader("Content-disposition", "attachment;filename=News.xls");  
	        OutputStream ouputStream = response.getOutputStream();  
	        wb.write(ouputStream);  
	        ouputStream.flush();  
	        ouputStream.close();  
		   }    
	

}
