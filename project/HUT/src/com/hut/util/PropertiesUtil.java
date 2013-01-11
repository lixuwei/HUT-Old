package com.hut.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getValue(String filePath, String name) {
		Properties props = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filePath);
		try {
		props.load(in);
		} catch (IOException e) {
		e.printStackTrace();
		}
		return props.getProperty(name);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesUtil.getValue("filePath.properties", "downloadExcel"));
	}

}
