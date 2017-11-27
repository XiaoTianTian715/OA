package com.a.bean;

import java.util.Comparator;
public class Comparable2 {
	public Comparator<News> comparator = new Comparator<News>() {
		@Override
		public int compare(News n1, News n2) 
		{
			return (n2.getNewsid()-n1.getNewsid());
		}
	};
	
}
