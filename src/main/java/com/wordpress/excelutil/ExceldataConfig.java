package com.wordpress.excelutil;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExceldataConfig {	
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExceldataConfig(String excelpath) throws Exception 
	
	{			
		File src=new File(excelpath);
		
		FileInputStream fis=new FileInputStream(src);
		
		wb=new XSSFWorkbook(fis);			
				
		}
			
	public String getData(int sheetNumber,int row,int cell) {
		
		sheet1=wb.getSheetAt(sheetNumber);
		
		String data=sheet1.getRow(row).getCell(cell).getStringCellValue();
		return data;		
		
	}
		
	public int getRowCount(int sheetIndex) {
		
		int row=wb.getSheetAt(sheetIndex).getLastRowNum();
		row=row+1;
		
		
		return row;
		
		
	}
		
		
		
	}


