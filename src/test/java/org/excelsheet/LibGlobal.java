package org.excelsheet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobal {
	WebDriver driver;

		
		public void configBrowser() {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
			 driver.manage().window().maximize();
			
		}
		public void launchUrl(String url) {
			driver.get(url);
		}
		public WebElement locateByXpath(String xpathExpression) {
			WebElement element = driver.findElement(By.xpath(xpathExpression));
			return element;

		}
		public WebElement locateById(String id) {
			WebElement element = driver.findElement(By.id(id));
			return element;
			

		}
		public WebElement locateByName(String name) {
			WebElement element = driver.findElement(By.name(name));
			return element;

		}
		public void inputText(WebElement element,String Url) {
			element.sendKeys(Url);
			

		}
		public void click(WebElement element) {
			element.click();

		}

	

}
