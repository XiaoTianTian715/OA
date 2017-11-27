package com.a.bean;

import java.sql.Date;

public class News {
	private  String title;
	private   int   newsid;
	private   String  pbperson;
	private  Date  pbTime;
	private   String content;
	private    int classid;
	  private   String state;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNewsid() {
		return newsid;
	}
	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}
	public String getPbperson() {
		return pbperson;
	}
	public void setPbperson(String pbperson) {
		this.pbperson = pbperson;
	}
	public Date getPbTime() {
		return pbTime;
	}
	public void setPbTime(Date pbTime) {
		this.pbTime = pbTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getClassid() {
		return classid;
	}
	public void setClassid(int classid) {
		this.classid = classid;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public News(String title, int newsid, String pbperson, Date pbTime,
			String content, int classid, String state) {
		super();
		this.title = title;
		this.newsid = newsid;
		this.pbperson = pbperson;
		this.pbTime = pbTime;
		this.content = content;
		this.classid = classid;
		this.state = state;
	}
	
	
	

}
