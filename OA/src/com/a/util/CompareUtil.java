package com.a.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;


public class CompareUtil {
	//? super T  将泛型类型限制为所有T的超类（包括T自身），只能用于参数
	public static <T> void sort(List<T> list,Comparator<? super T> c){    
		Object[] a = list.toArray();
		Arrays.sort(a, (Comparator)c);   //实现接口，并进行排序组装
		ListIterator i = list.listIterator();   
		for (int j = 0; j < a.length; j++) {   
			i.next();
			i.set(a[j]);
		}
	}
}
