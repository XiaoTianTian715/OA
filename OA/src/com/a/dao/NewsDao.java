package com.a.dao;

import java.util.ArrayList;

import com.a.bean.News;



public interface NewsDao {
	public ArrayList<News> findAllNews();
	public  News  SearchById(int id);  
	 public   void add(News news);
	public void delete(News news);
	public void update(News news);
	
 
}
