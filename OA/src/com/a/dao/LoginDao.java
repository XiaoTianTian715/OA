package com.a.dao;

import java.util.ArrayList;

import com.a.bean.User;

public interface LoginDao {
	public ArrayList<User> findAllUser();
	 public   void add(User user);
	public void delete(User user);
	public void update(User user);
	public void updateinfo(User user);

}
