package com.a.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;


public class CompareUtil {
	//? super T  ��������������Ϊ����T�ĳ��ࣨ����T������ֻ�����ڲ���
	public static <T> void sort(List<T> list,Comparator<? super T> c){    
		Object[] a = list.toArray();
		Arrays.sort(a, (Comparator)c);   //ʵ�ֽӿڣ�������������װ
		ListIterator i = list.listIterator();   
		for (int j = 0; j < a.length; j++) {   
			i.next();
			i.set(a[j]);
		}
	}
}
