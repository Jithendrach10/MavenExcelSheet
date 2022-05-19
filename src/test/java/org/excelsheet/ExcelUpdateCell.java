package org.excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUpdateCell {
	 String data;
	 

		public String getData(String sheetName,int rowNum ,int cellNum ) throws IOException {
			
			File file = new File("C:\\Users\\Ch Dharma\\eclipse-workspace\\MavenExcelSheet\\Excel\\ExcelCreate3.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
		      CellType type = cell.getCellType();
		      
		   switch(type) {
		   
		   case STRING :
			   data = cell.getStringCellValue();
			   break;
			   
		   case NUMERIC :
			   if(DateUtil.isCellDateFormatted(cell)) {
				   Date dateCellValue = cell.getDateCellValue();
				   SimpleDateFormat dateFormate = new SimpleDateFormat("dd-MMM-yy");
				   data = dateFormate.format(dateCellValue);
				   System.out.println(data);
			   }
			   
			   else {
	  
				   double d = cell.getNumericCellValue();
				   BigDecimal b = BigDecimal.valueOf(d);
				   data = b.toString();
				    System.out.println(data);
	      		 
			   }
			   break;
			   
			   default:
				   break;
		   }
		return data;
		   
			}
 
	public void updateData(String sheetName,int rowNum ,int cellNum,String data) throws IOException {
		
		File file = new File("C:\\Users\\Ch Dharma\\eclipse-workspace\\MavenExcelSheet\\Excel\\ExcelCreate3.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		if(value.equals("Febe")) {
			cell.setCellValue("Java");
			
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		
	}
	

		public void WriteData(String sheetName,int rowNum ,int cellNum,String data) throws IOException {
			
			File file = new File("C:\\Users\\Ch Dharma\\eclipse-workspace\\MavenExcelSheet\\Excel\\ExcelCreate3.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook workbook = new XSSFWorkbook(stream);
			Sheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(rowNum);
			Cell cell = row.getCell(cellNum);
			cell.setCellValue(data);
			FileOutputStream out = new FileOutputStream(file);
			workbook.write(out);
		}
	
		 
	
  
	}

