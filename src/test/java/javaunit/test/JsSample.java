package javaunit.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsSample {

	 static WebDriver driver;
	 
	 @BeforeClass
	 public static void beforeClass() {
		 //BrowserLaunch
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("http://adactinhotelapp.com/");
		 driver.manage().window().maximize();
	
	}
	 @Before
	 public void beforeMethod() {
		 //Taking ScreenShot
		long timeMillis  = System.currentTimeMillis();
		System.out.println(timeMillis);
		
	}
	 
	 @Test
	 public void test() {
		//Basic Logic
		 WebElement txtUserName = driver.findElement(By.id("username"));
		 txtUserName.sendKeys("Jithendra7989");
		 
		 WebElement txtPass = driver.findElement(By.id("password"));
		 txtPass.sendKeys("Jith8888@");
 
		 WebElement btnLgn = driver.findElement(By.id("login"));
		 btnLgn.click();
		 
	}
	 
	 @After
	 //take ScreenShot
	 public void afterMethod() {
      long time = System.currentTimeMillis();
      System.out.println(time);

	}
	 
	 @AfterClass
	 //closing browser
	 public static  void afterClass() {
	   driver.quit();

	}
	 
}
