package com.a.bean;

import java.util.Comparator;
public class Comparable4 {
	public Comparator<News> comparator = new Comparator<News>() {
		@Override
		public int compare(News n1, News n2) 
		{
			return (n1.getTitle().compareTo(n2.getTitle()));
		}
	};
	
}
