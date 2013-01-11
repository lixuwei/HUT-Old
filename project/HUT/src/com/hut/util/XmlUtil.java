package com.hut.util;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 *处理xml的工具类
 * @author Droid
 * 
 */


public class XmlUtil {
	private XmlUtil(){};
	public static Document getDocFromXml(String path) throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File(path));
		return document;
	}
	
}
