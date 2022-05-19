package org.excelsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateExcelSheet {

	public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://omrbranch.com/");
	driver.manage().window().maximize();
     WebElement btnSign = driver.findElement(By.id("pr_register"));
     btnSign.click();
         //select  botton locator
     WebElement dDnMonth = driver.findElement(By.name("month"));
             //select options 
     Select select = new Select(dDnMonth);
      select.selectByIndex(12);     //reference name of select class is consider

    	  //Excel path is taken 
    	   File file = new File("C:\\Users\\Ch Dharma\\eclipse-workspace\\MavenExcelSheet\\Excel\\ExcelCreate1.xlsx");
            Workbook workbook = new XSSFWorkbook();
           Sheet sheet = workbook.createSheet("Sheet1");
         
          //rows
         
            //cell index
            //Cell cell = row.getCell(1);
            //get all options
            List<WebElement> options = select.getOptions();
            //iterate all options
            for(int i=0; i<options.size();i++) {
            	
          	  //get each option
          	  WebElement element = options.get(i);
          	   Row row = sheet.createRow(i);
          	  //get text
          	  String text = element.getText();
          	  System.out.println(text);
          	  //create cell
          	       Cell cell2 = row.createCell(0);
          	       cell2.setCellValue(text);
          
          	       //object to file covertion
          FileOutputStream out = new FileOutputStream(file);
              //write in workbook
           workbook.write(out);   
      }

	}

}
