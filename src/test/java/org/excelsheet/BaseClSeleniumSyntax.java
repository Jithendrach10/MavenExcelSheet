package org.excelsheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClSeleniumSyntax {
   //instance variable 
	
	WebDriver driver;
	TakesScreenshot screenshot;
	Alert al;
	File dest;
	Select select;
	Actions actions;
	JavascriptExecutor executor;
	TakesScreenshot screenShot;
	
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
	

		
		 
	
	
	public void configChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	public void enterUrl(String url) {
		driver.get(url);
	}
	
	public void manageWin() {
		driver.manage().window().maximize();
 
	}
	
	public void textSend(WebElement element, String data) {
		element.sendKeys(data);

	}
		
	public void click(WebElement element) {
	  element.click();

	}	
	
	public WebElement locatedId(String attributeValue) {
	  WebElement element = driver.findElement(By.id(attributeValue));
	return element;

	}
  
	public WebElement locatedByName(String attributeValue) {
	   WebElement element = driver.findElement(By.name(attributeValue));
	return element;

	}
	public WebElement locatedByClassName(String attributeValue) {
		   WebElement element = driver.findElement(By.className(attributeValue));
		return element;

	}
	
         public WebElement xpathLocator(String data) {
		
           WebElement element = driver.findElement(By.xpath(data));
		return element;
		}
     
  public String getText(WebElement element) {
	 String text = element.getText();
	return text;

}
  
  public String getTitle() {
	 String title = driver.getTitle();
	return title;

}
  public void navagateByUrl(String url) {
	driver.navigate().to(url);

}
  public void navagateBack() {
    driver.navigate().back();

}
  
  public void navagateForward() {
	    driver.navigate().forward();

	}
  
  public void navagateRefresh() {
	    driver.navigate().refresh();

	}
  
  public void moveToElement(WebElement target) {
  actions.moveToElement(target);

}
  
  public void actionsDragAndDrop(WebElement s, WebElement d) {
	
	Actions dragandDrop = actions.dragAndDrop(s,d);
}
  
	  
  public void selectByIndex(WebElement element, int index) {
   Select select = new Select(element);
    select.selectByIndex(index);
}
         
  public void selectByValue(WebElement element, String value) {
   Select select = new Select(element);
   select.selectByValue(value);
}     
         
  public void selectByVisible(WebElement element, String text) {
	  Select select = new Select(element);
      select.selectByVisibleText(text);
     
}       
  public List<WebElement> getOptions(String str, int index, WebElement element ){
	  Select select = new Select(element);

	  List<WebElement> options =  select.getOptions();
      return options;
  
  }
         
    public List<WebElement>  getAllOptions() {
		List<WebElement> selectedOpitions = select.getAllSelectedOptions();
		return selectedOpitions;

	}
    
  public WebElement GetFirstSelectOptions() {
	WebElement firstSelectedOption = select.getFirstSelectedOption();
	return firstSelectedOption;

}  
  
  public Select deselectIndex(int index) {
 select.deselectByIndex(index);
 return select;

}
  
  public Select deselectByValue( String value) {
 select.deselectByValue(value);
return select;


}
  public Select deselectByVisisbleText(String text) {
	  select.deselectByVisibleText(text);
	return select;
	}
    
  public void deselectAll() {
	select.deselectAll();

}
   public void equalsOption(Object bj) {
     boolean equals = select.equals(bj);

} 
   public void isMultiple() {
	boolean multiple = select.isMultiple();

}
   public Actions actionClick(WebElement target) {
    actions = new Actions(driver);
    Actions click = actions.click(target);
	return click;

}
   public  Actions actionKeyUp(CharSequence key) {
	   actions = new Actions(driver);
	    Actions keyUp = actions.keyUp(key);
		return keyUp;

}
   public void actionKeyUps(WebElement target, CharSequence key) {
	Actions keyDown = actions.keyDown(target, key);
     
}
   public Actions  actionKeyDown(CharSequence key) {
	   actions = new Actions(driver);
        Actions keyDown = actions.keyDown(key);
		return keyDown;
}
  public void actionKeyDowns(WebElement target, CharSequence key) {
     Actions keyDown = actions.keyDown(target, key);

}
   public void doubleClick() {
	   actions = new Actions(driver);
      actions.doubleClick();
}
    public void actionsRightClick() {
	   Actions contextClick = actions.contextClick();

	}
    
    public void alertAccept() {
    al = driver.switchTo().alert();
	al.accept();

	}
    
    public void alertCancel() {
	  al = driver.switchTo().alert();
      al.dismiss();
	}
   
    public String alertGetText() {
		String text = al.getText();
		return text;
            
	}
    
    public TakesScreenshot takesScreenShot(OutputType<File> target) {
    	
	 screenShot = (TakesScreenshot)driver;
	  File s = screenShot.getScreenshotAs(target);
	 return screenShot;

	}
    
    //file 
    
    public void fileSource(String path) {
      File path1 = new File(path);

	}
    
    public void fileUtilis(File srcFile, File destFile) throws IOException {
		FileUtils.copyFile(srcFile, destFile);
	}
    
   // JavaScript Executor 
    
    public void javaScriptExecutorType(Object element, String text) {
	 executor = (JavascriptExecutor)driver;
	 executor.executeScript( "argument[0]setAttribute('value','"+ text +"')",element);
	 
	}
    
    public JavascriptExecutor javaScriptExecutorGet(WebElement element, String text) {
    	 executor = (JavascriptExecutor)driver;
          executor.executeScript("return arguments[0].getAttribute('value','"+ text +"')", element);
		return executor;
	}
    
    public void jsExecutorScrollUp(WebElement element) {
    	 executor = (JavascriptExecutor)driver;
    	 executor.executeScript("argument[0].scrollIntoView(true)", element);

	}
    
    public void jsExecutorScrollDown(WebElement element) {
    	executor = (JavascriptExecutor)driver;
    	executor.executeScript(" arguments[0].scrollIntoView(true)", element);

	}
    
    public void frameIdSam(String nameOrId) {
		WebDriver frame = driver.switchTo().frame(nameOrId);
	}
    public void frameElement(String frameElement) {
		driver.switchTo().frame(frameElement);

	}
    public void frameIndex(String index) {
	driver.switchTo().frame(index);

	}
    
    public List<WebElement> frameTagName(String tagName) {

           List<WebElement> findElements = driver.findElements(By.tagName(tagName));
		    return findElements;
	}
    
    public void frameDefaultContent() {
		WebDriver content = driver.switchTo().defaultContent();

	}
    
    //windowHandle
    
    public void windowHandle(String nameOrHandle) {
	    WebDriver window = driver.switchTo().window(nameOrHandle);

	}
    
    public Set<String> getWindowHandles() {
      Set<String> windowHandles = driver.getWindowHandles();
	return windowHandles;

	}
    public String getWindow() {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;

	}
    
    public void getAttribute(WebElement element, String name) {
		  element.getAttribute("name");
	

	}
    
	}


