package com.a.dao;

import java.util.ArrayList;

import com.a.bean.Classes;



public interface ClassesDao {
	public ArrayList<Classes> findAllClasses();
	 public   void add(Classes classes);
	public void delete(Classes classes);
	public void update(Classes classes);
	public  Classes  SearchById(int id); 
	public  Classes  SearchById(String id); 

}
