package bassclass.test.excelSheet;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	TakesScreenshot screenshot;
	Alert al;
	File dest;
	Select select;
	Actions actions;
	JavascriptExecutor executor;
	TakesScreenshot screenShot;

	public void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();                             //1 chrome browser
	}

	public void enterUrl(String url) {
		driver.get(url);                                         //2  get url
	}

	public void type(WebElement element, String data) {            //3.send data to website and sending excel to website
		element.sendKeys(data);
	}

	public void click(WebElement element) {
		element.click();                                        //4. click button
	}

	public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));        //5. id value or attribute value and return
		return element;
	}

	public WebElement findElementByName(String attributeValue) {            
		WebElement element = driver.findElement(By.name(attributeValue));    //6. name value or attribute value and return
		return element;

	}

	public WebElement findElementByClassName(String attributeValue) {
		WebElement element = driver.findElement(By.className(attributeValue));  //7.class value or attribute value
		return element;
	}

	public WebElement findElementByXpth(String attributeValue) {
		WebElement element = driver.findElement(By.xpath(attributeValue));    //8. xpath id value  returns
		return element;
	}

	public String getText(WebElement element) {               //9.get text
		String text = element.getText();
		return text;
	}

	public String getTitle(WebElement element) {
		String title = element.getText();                    //10.get title
		return title;
	}

	public String getUrl(WebElement element) {               //11.get current url
		String url = driver.getCurrentUrl();
		return url;
	}

	public String getAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);                //12.get attribute name ie, id,class,name
		return attribute;

	}

	public void selectOptionText(WebElement element, String text) {            //13.select visible text
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public void selectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);                                             //14 select index
		;
	}

	public void deSelectOptionText(WebElement element, String text) {
		Select select = new Select(element);                                      //15 deselect visible text
		select.deselectByVisibleText(text);
	}

	public void deSelectOptionValue(WebElement element, String value) {
		Select select = new Select(element);                                       //16 deselect visible value
		select.deselectByVisibleText(value);
	}

	public void deSelectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);                                       //17.deselect index
		select.deselectByIndex(index);
	}

	public void deSelectAll(WebElement element, int index) {                       
		Select select = new Select(element);                                         //18. deselectall
		select.deselectAll();
	}

	public void clickJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;                  //19. js click
		executor.executeScript("arguments[0].click()", element);

	}

	public void typeJs(WebElement element, String text) {                           //20.  js set value
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute ('value','" + text + "')", element);

	}

	public String getJs(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;                    //21.js get and return
		Object executeScript = executor.executeScript("arguments[0].getAttribute ('value')", element);
		String s = (String) executeScript;
		return s;
	}

	public void jsScrollup() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;               //22. js scroll up
		executor.executeScript("arguments[0].scrollIntoView(false)");
	}

	public void jsScrollDown() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;              //23. js Scrolldown
		executor.executeScript("arguments[0].scrollIntoView(true)");
	}

	public void alertAccept() {                                                //24. alertAccept(pomp for ok click)
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void alertDissmiss() {
		Alert alert = driver.switchTo().alert();                              //25. alertDismiss (pomp cancel)
		alert.dismiss();
	}

	public void btnPrompt(WebElement element, String button) {               //26. alert accept(for pompt)
		Alert alert = driver.switchTo().alert();
		WebElement btn = driver.findElement(By.id(button));
		alert.accept();
	}

	public void closeAll() {                                              //27.close browser
		driver.close();
	}

	public void closeCurrent() {
		driver.quit();                                                    //28. close window
	}

	public void maximize() {                                              //29. maximize window
		driver.manage().window().maximize();
	}

	public void switchFrame(String id) {                                  //30. frame id(for window)
		driver.switchTo().frame(id);
	}

	public void frameIndex(int index) {
		driver.switchTo().frame(index);
	}                                                                      //31. frame index (drag)

	public void frameName(String name) {
		driver.switchTo().frame(name);                                     //32. frame name
	}

	public void mouseOverClick(String attributevalue, String btnvalue) {
		Actions actions = new Actions(driver);
		WebElement mouseover = driver.findElement(By.id(attributevalue));    //33. action movement
		actions.moveToElement(mouseover).perform();
		WebElement btn = driver.findElement(By.id(btnvalue));
		btn.click();

	}

	public void rightClick(String attributevalue, String btnvalue) {         //34. right click(action)
		Actions actions = new Actions(driver);
		WebElement rClick = driver.findElement(By.id(attributevalue));
		WebElement btn = driver.findElement(By.id(btnvalue));
		actions.moveToElement(rClick).contextClick(btn);
	}

	public void pressTab(String attributevalue) {                            //35. tab press, attribute value, send keys to tab
		Actions actions = new Actions(driver);
		WebElement webElement = driver.findElement(By.id(attributevalue));
		webElement.sendKeys(Keys.TAB);
	}

	public void doubleClick(String attributevalue) {                         //36. double click (action)
		Actions actions = new Actions(driver);
		WebElement textBox = driver.findElement(By.id(attributevalue));
		actions.doubleClick(textBox).perform();
	}

	public void robot() throws AWTException { 
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);                                //37. robot down(press)
		robot.keyRelease(KeyEvent.VK_DOWN);

	}

	public void robotUp() throws AWTException {                          //38. robot up(release)
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_UP);
		robot.keyRelease(KeyEvent.VK_UP);
	}

	public void robotEnter() throws AWTException {
		Robot robot = new Robot();                                      //39.robot enter(value)
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getScreenshot(String s) throws IOException {               //40. takes screen shot (full window)
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		System.out.println(source);
		System.out.println(source);
		s ="";       //"D:\\Chrome downloads\\screenshot6814747403650910544.png";
		File file = new File(s);
		FileUtils.copyFile(source, file);
	}

	public void switchWindowUrl(String url) {                              //41. switch url window
		driver.switchTo().window(url);
	}

	public void switchWindowTitle(String title) {                           
		driver.switchTo().window(title);                                    //42. switch window title
	}

	public void switchWindowId(String id) {
		driver.switchTo().window(id);                                      //43. window id
	}

	public String getWindowHandle() {
		String winId = driver.getWindowHandle();                           //44. present window
		return winId;
	}

	public Set<String> getWindowHandles() {                                //45. subWindow
		Set<String> windowHandles = driver.getWindowHandles();
		return windowHandles;
	}

	public void navigateUrl(String url) {                                  //46.navigate url(store window history)
		driver.navigate().to(url);
	}

	public void navigateBack() {
		driver.navigate().back();                                         //47. back navigate
	}

	public void navigateForward() {
		driver.navigate().forward();                                      //48.forward navigatee
	}

	public void refresh() {
		driver.navigate().refresh();                                      //49. refresh navigate
	}

	public void switchWndowTitle(String title) {
		driver.switchTo().window(title);                                   //50. window title
	}

	public void switchWndowId(String id) {
		driver.switchTo().window(id);                                       //51. window id
	}

	public String getWinowHandle() {
		String winId = driver.getWindowHandle();                           //52.  super window
		return winId;
	}

	public Set<String> getWinowHandles() {
		Set<String> windowHandles = driver.getWindowHandles();              //53. sub windows
		return windowHandles;

	}


// String data;
	
	public String getData(String sheetName, int rowNo, int cellNo) throws IOException {

		String data = null;
		File file = new File("C:\\Users\\sssud\\eclipse-workspace\\Practicemvn\\Excel s\\adactinhotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(rowNo);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(cellNo);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					data = cell.getStringCellValue();
					break;
				case NUMERIC:
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						data = dateFormat.format(dateCellValue);
					}

					else {
						double d = cell.getNumericCellValue();
						BigDecimal b = BigDecimal.valueOf(d);
						data = b.toString();
					}
					break;
				default:
					break;

				}
			}
		}
		return data;
	}

	
	
	
	
	public void writeData(String sheetName, int rowNo, int cellNo, String newdata, String olddata, String data)
			throws IOException {
		newdata = "java";
		//rowNo = 0;
		//cellNo = 1;
		sheetName = "datas";
		File file = new File("C:\\Users\\sssud\\eclipse-workspace\\Practicemvn\\Excel s\\today1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(newdata);
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);

	}

	public String upDateData(String sheetName, int rowNo, int cellNo, String newdata, String olddata, String data)
			throws IOException {
		sheetName = "datas";
		newdata = "python";
		File file = new File("C:\\Users\\sssud\\eclipse-workspace\\Practicemvn\\Excel s\\today1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		newdata = cell.getStringCellValue();
		if (newdata.equals(olddata)) {
			cell.setCellValue(newdata);
		}
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		return newdata;
	}

}
	
	

