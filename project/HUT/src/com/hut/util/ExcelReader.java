package com.hut.util;

import java.io.File;
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
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public final class ExcelReader {

	private static HSSFWorkbook readFileFor03(Object filename, boolean flag) throws IOException {
		if(flag == true)
			return new HSSFWorkbook(new FileInputStream((String)filename));
		else
			return new HSSFWorkbook(new FileInputStream((File)filename));
	}
	
	private static XSSFWorkbook readFileFor07(Object filename, boolean flag) throws IOException {
		if(flag == true)
			return new XSSFWorkbook(new FileInputStream((String)filename));
		else
			return new XSSFWorkbook(new FileInputStream((File)filename));
		
	}

	
	public List<ArrayList<String>> readFor03(Object fileName, boolean flag) {
		try {
			List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
			HSSFWorkbook wb = ExcelReader.readFileFor03(fileName, flag);

			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				HSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();
				for (int r = 0; r < rows; r++) {
					HSSFRow row = sheet.getRow(r);
					if (row == null) {
						continue;
					}

					int cells = row.getPhysicalNumberOfCells();
					ArrayList<String> rowList = new ArrayList<String>();
					for (int c = 0; c < cells; c++) {
						HSSFCell cell = row.getCell(c);
						String value = null;

						switch (cell.getCellType()) {

							case HSSFCell.CELL_TYPE_FORMULA:
								value =  cell.getCellFormula();
								break;

							case HSSFCell.CELL_TYPE_NUMERIC:
								value =  "" + cell.getNumericCellValue();
								break;

							case HSSFCell.CELL_TYPE_STRING:
								value = "" + cell.getStringCellValue();
								break;
							default:
						}
						rowList.add(value);
					}
					dataList.add(rowList);
				}
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public List<ArrayList<String>> readFor07(Object fileName, boolean flag) {
		try {
			List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
			XSSFWorkbook wb = ExcelReader.readFileFor07(fileName, flag);


			for (int k = 0; k < wb.getNumberOfSheets(); k++) {
				XSSFSheet sheet = wb.getSheetAt(k);
				int rows = sheet.getPhysicalNumberOfRows();
				for (int r = 0; r < rows; r++) {
					XSSFRow row = sheet.getRow(r);
					if (row == null) {
						continue;
					}

					int cells = row.getPhysicalNumberOfCells();
					ArrayList<String> rowList = new ArrayList<String>();
					for (int c = 0; c < cells; c++) {
						XSSFCell cell = row.getCell(c);
						String value = null;

						switch (cell.getCellType()) {

							case HSSFCell.CELL_TYPE_FORMULA:
								value =  cell.getCellFormula();
								break;

							case HSSFCell.CELL_TYPE_NUMERIC:
								value =  "" + cell.getNumericCellValue();
								break;

							case HSSFCell.CELL_TYPE_STRING:
								value = "" + cell.getStringCellValue();
								break;
							default:
						}
						rowList.add(value);
					}
					dataList.add(rowList);
				}
			}
			return dataList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<ArrayList<String>> read(String filePath) {
		List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
        if (filePath == null || !filePath.matches("^.+\\.(?i)((xls)|(xlsx))$"))
        {
            return dataList;
        }
        
        boolean isExcel2003 = true;
        if (filePath.matches("^.+\\.(?i)(xlsx)$"))
        {
            isExcel2003 = false;
        }
        if (isExcel2003) {
        	dataList = this.readFor03(filePath, true);
        } else {
        	dataList = this.readFor07(filePath, true);
        }
        return dataList;
	}
	
	public List<ArrayList<String>> read(File file, String fileName) {
		List<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$"))
        {
            return dataList;
        }
        
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$"))
        {
            isExcel2003 = false;
        }
        if (isExcel2003) {
        	dataList = this.readFor03(file, false);
        } else {
        	dataList = this.readFor07(file, false);
        }
        return dataList;
	}
	
	public static void main(String[] args) {
		String filePath = "C:\\Users\\Michael\\Desktop\\2012拟录取数据（423人）.xls";
		ExcelReader excelReader = new ExcelReader();
		List<ArrayList<String>> data = excelReader.read(filePath);
		if (data.isEmpty()) {
			System.out.println("表格有问题！");
		} else {
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				ArrayList<String> arrayList = (ArrayList<String>) iterator.next();
				for (Iterator iterator2 = arrayList.iterator(); iterator2
						.hasNext();) {
					String string = (String) iterator2.next();
					System.out.print(string+"\t");
				}
				System.out.println();
			}
		}
	}
}