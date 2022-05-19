package org.excelsheet;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdactinHotelSample {

	public static void main(String[] args) throws IOException {
		 BaseClSeleniumSyntax baseClass = new  BaseClSeleniumSyntax();
		
		 //webDriver
		 baseClass.configChrome();
		 //get url
		  
		 baseClass.enterUrl("http://adactinhotelapp.com/");
		 //maximize window
		 baseClass.manageWin();
		 
// txtUserName.sendKeys("Jithendra7989");
			
		WebElement txtUserName = baseClass.locatedId("username");
		 String name = baseClass.getData("Sheet1",1,0); 
		 baseClass.textSend(txtUserName,name);
		 
		 WebElement txtPass = baseClass.locatedId("password");
		 String pass = baseClass.getData("Sheet1",1,1); 
		 baseClass.textSend(txtPass,pass);
		 
		 WebElement btnLogin = baseClass.locatedId("login");
		 baseClass.click(btnLogin);
		 
		 WebElement dDnLocation = baseClass.locatedId("location");
		 baseClass.selectByIndex(dDnLocation ,5);
		
		 baseClass.getData("sheet1", 1, 2); 
       
        WebElement dDnHotels1 = baseClass.locatedId("hotels");
		baseClass.selectByIndex(dDnHotels1 ,2);
         //getOptions(String str, int index );
		 baseClass.getData("sheet1", 1, 3); 
		
	     WebElement dDnRoomType = baseClass.locatedId("room_type");
	     //baseClass.selectByIndex(dDnRoomType ,2);
	     String txt = baseClass.getData("sheet1", 1, 4); 
	     baseClass.textSend(dDnRoomType ,txt);
	    // baseClass.selectByValue(dDnRoomType,"2-Two");
		 
	     WebElement dDnRoomNum = baseClass.locatedId("room_nos");
	     
	     String text2 = baseClass.getData("sheet1", 1, 5); 
	     baseClass.textSend(dDnRoomNum ,text2);
	     
//         WebElement dDnAdult = driver.findElement(By.id("adult_room"));
//          select = new Select(dDnAdult);
//         select.selectByIndex(1); 
	    
	     WebElement  dDnAdult = baseClass.locatedId("adult_room");
	     String text3 = baseClass.getData("sheet1", 1, 8); 
	     baseClass.textSend(dDnAdult ,text3);
	     
	     
	     WebElement  dDnChild = baseClass.locatedId("child_room");
	     String child1 = baseClass.getData("sheet1", 1, 9);
	     baseClass.textSend(dDnChild, child1);
	     
	     
	     WebElement element2 = baseClass.locatedId("Submit"); 
	    baseClass.click(element2);
	    
	    WebElement btnRadio = baseClass.locatedId("radiobutton_0");
	     baseClass.click(btnRadio);
	    
	    WebElement btncontinue = baseClass.locatedId("continue");
	    baseClass.click(btncontinue);
	    
	    WebElement txtFristNam = baseClass.locatedId("first_name");
	      String frName = baseClass.getData("sheet1", 1, 10);
	    baseClass.textSend(txtFristNam, frName) ;
	     
	    WebElement txtLastNam = baseClass.locatedId("last_name");
	      String lsName = baseClass.getData("sheet1", 1, 11);
	    baseClass.textSend(txtLastNam, lsName) ; 
	     
	    WebElement txtAddres = baseClass.locatedId("address");
	      String adres = baseClass.getData("sheet1", 1, 12);
	    baseClass.textSend(txtAddres, adres); 
	     
	    WebElement numCredit = baseClass.locatedId("cc_num");
	      String cred = baseClass.getData("sheet1", 1, 13);
	    baseClass.textSend(numCredit, cred); 
	     

	     WebElement  dDnCard = baseClass.locatedId("cc_type");
	     String card = baseClass.getData("sheet1", 1, 14);
	     baseClass.textSend(dDnCard, card);
	     
	     WebElement  dDnExpMonth = baseClass.locatedId("cc_exp_month");
	     String epMonth = baseClass.getData("sheet1", 1, 15);
	     baseClass.textSend(dDnExpMonth, epMonth);
	     
	     WebElement  dDnExpYear = baseClass.locatedId("cc_exp_year");
	     String epYear = baseClass.getData("sheet1", 1, 16);
	     baseClass.textSend(dDnExpYear, epYear);
	     
	     WebElement  dDnCvv = baseClass.locatedId("cc_cvv");
	     String cvv = baseClass.getData("sheet1", 1, 17);
	     baseClass.textSend(dDnCvv, cvv);
	     
	     WebElement btnBook = baseClass.locatedId("book_now");
		    baseClass.click(btnBook);
		    
		 //   getAttribute(WebElement element, String name);
		 //   String refName = baseClass.getData("sheet1", 1, 18);
		    
	}



}
