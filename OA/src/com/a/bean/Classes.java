package com.a.bean;

public class Classes {
	private String className;
	private int  classId;
		
	

	public Classes(String className, int classId) {
		super();
		this.className = className;
		this.classId = classId;
	}
	

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	
}
