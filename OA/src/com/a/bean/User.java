package com.a.bean;

public class User {
	private String name;
	private String pwd;
	private String dept;
	private String per;
	private String tele;

	public void setTele(String tele) {
		this.tele = tele;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPer() {
		return per;
	}

	public void setPer(String per) {
		this.per = per;
	}

	public String getName() {
		return name;
	}

	public User(String name, String pwd, String dept, String per, String tele) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.dept = dept;
		this.per = per;
		this.tele = tele;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public String getTele() {
		return tele;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
