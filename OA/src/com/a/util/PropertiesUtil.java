package com.a.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String readValue(String key){
		Properties props = new Properties();  
		try {
			InputStream in = new BufferedInputStream(new FileInputStream("E:/07101558/web1/src/com/a/util/config.properties"));
			props.load(in);  //properties���ض�ȡ���ļ�
			String value = props.getProperty(key);
			return value;
			
		} catch (Exception e) {
			e.printStackTrace();
			return "��ȡ�쳣";
		}
		
	}
	
	
	

}
