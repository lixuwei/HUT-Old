package com.hut.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;


public final class ExcelWriter {
	
	private List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
	
	public boolean writeTo03(String fileName) {
		try {
			HSSFWorkbook wb = new HSSFWorkbook();
			HSSFSheet s = wb.createSheet();
			
			for (int rownum = 0; rownum < dataList.size(); rownum++) {
				HSSFRow r = s.createRow(rownum);
				ArrayList<String> arrayList = dataList.get(rownum);
				for (int cellnum = 0; cellnum < arrayList.size(); cellnum++) {
					HSSFCell c = r.createCell(cellnum);
					String Value = arrayList.get(cellnum);
					c.setCellValue(Value);
				}
			}

			FileOutputStream out = new FileOutputStream(fileName);
			wb.write(out);
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
			
	}
	
	public boolean writeTo07(String fileName) {
		try {
			Workbook wb = new SXSSFWorkbook();
			Sheet s = wb.createSheet();
			
			for (int rownum = 0; rownum < dataList.size(); rownum++) {
				Row r = s.createRow(rownum);
				r.setHeightInPoints(15);
				ArrayList<String> arrayList = dataList.get(rownum);
				for (int cellnum = 0; cellnum < arrayList.size(); cellnum++) {
					Cell c = r.createCell(cellnum);
					String Value = arrayList.get(cellnum);
					System.out.println(Value);
					c.setCellValue(Value);
				}
			}

			FileOutputStream out = new FileOutputStream(fileName);
			wb.write(out);
			out.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
			
			
	}
	
	public void initData(List<ArrayList<String>> dataList) {
		this.dataList = dataList;
	}
	
	public void addData(ArrayList<String> rowList) {
		this.dataList.add(rowList);
	}
	
	public boolean write(String fileName) {
		boolean flag = false;
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$"))
        {
            return false;
        }
        
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$"))
        {
            isExcel2003 = false;
        }
        if (isExcel2003) {
        	flag = this.writeTo03(fileName);
        } else {
        	flag = this.writeTo07(fileName);
        }
        return flag;
	}
	
	public static void main(String[] args) {
		String fileName = "C:\\Users\\Michael\\Desktop\\1.xlsx";
		ExcelWriter excelWriter = new ExcelWriter();
		ArrayList<String> dataList = new ArrayList<String>();
		dataList.add("1");
		dataList.add("张艺辰");
		dataList.add("Michael");
		ArrayList<String> dataList2 = new ArrayList<String>();
		dataList2.add("11");
		dataList2.add("张艺辰1");
		dataList2.add("Michael1");
		excelWriter.addData(dataList);
		excelWriter.addData(dataList2);
		boolean flag = excelWriter.write(fileName);
		System.out.println(flag);
	}
}