package com.a.bean;

import java.util.Comparator;
public class Comparable3 {
	public Comparator<Classes> comparator = new Comparator<Classes>() {
		@Override
		public int compare(Classes c1,Classes c2) 
		{
			return (c1.getClassId()-c2.getClassId());
		}
	};
	
}
