package javaunit.adactin;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class JUnitAdactin extends BaseClass2{
	static String url;
@BeforeClass

public static void beforeClass(){
	configChrome();
	enterUrl("http://adactinhotelapp.com/");
	manageWin();
	 url = driver.getCurrentUrl();
}

@Test

  public void adactinLogin() throws IOException, InterruptedException {
	
	
	WebElement txtUserName =  locatedId("username");
	String name = getData("Sheet1",1,0, path);
	textSend(txtUserName, name);
	
	WebElement txtPass =  locatedId("password");
	String password = getData("sheet1",1,1,path);
	textSend(txtPass,password);
	
	WebElement btnLogin = locatedId("login");
	click(btnLogin);
	
	
	  Assert.assertTrue(url.contains("adactinhotel"));



	WebElement selectLocation =  locatedId("location");
	String location = getData("sheet1",1,2,path);
	textSend(selectLocation,location);
	
	WebElement selectHotel =  locatedId("hotels");
	String hotel = getData("sheet1",1,3,path);
	textSend(selectHotel,hotel);
	
	WebElement searchRoomType  =  locatedId("room_type");
	String RoomType= getData("sheet1",1,4,path);  
	textSend( searchRoomType,RoomType);
	
	WebElement selectNumRooms =  locatedId("room_nos");
	String numRoom= getData("sheet1",1,5,path);
	textSend(selectNumRooms,numRoom);
	
	WebElement selectCheckInDate=  locatedId("datepick_in");
	String checkInDate= getData("sheet1",1,6,path);
	textSend(selectCheckInDate,checkInDate);
	
	WebElement selectCheckOutDat =  locatedId("datepick_out");
	String checkOutDate= getData("sheet1",1,7,path);
	textSend(selectCheckOutDat,checkOutDate);
	
	WebElement selectAdults=  locatedId("adult_room");
	String adult= getData("sheet1",1,8,path);
	textSend(selectAdults,adult);
	
	WebElement selectChildren =  locatedId("child_room");
	String children= getData("sheet1",1,9,path);
	textSend(selectChildren,children);
	
		WebElement btnSubmit = locatedId("Submit");
		click(btnSubmit);
		//Assert.assertTrue("verify url", getCurrentUrl().contains("adactinhotelapp.com/SearchHotel"));
		
		Assert.assertTrue(url.contains("adactinhotel")); 
		
		WebElement btnRadio = locatedId("radiobutton_0");  
		click(btnRadio);
    
		WebElement btnCont = locatedId("continue");
		click(btnCont);
		
		Assert.assertTrue(url.contains("adactinhotel"));  
		
		WebElement txtFrstName =  locatedId("first_name");
		String frstName= getData("sheet1",1,10,path);  
		textSend(txtFrstName,frstName);
		
		WebElement txtLastName = locatedByName("last_name");
		String lastName = getData("sheet1",1,11,path);
		textSend(txtLastName, lastName);
		
		WebElement txtAddress = locatedByName("address");
		String address = getData("sheet1",1,12,path);   
		textSend(txtAddress, address);
		
		WebElement txtCardNo = locatedId("cc_num");
		String cardNo = getData("sheet1",1,13,path);
		textSend(txtCardNo, cardNo);
		
		WebElement txtCardType = locatedId("cc_type");
		String cardType = getData("sheet1",1,14,path);
		textSend(txtCardType, cardType);
		
		WebElement txtMonths = locatedId("cc_exp_month");
		String months = getData("sheet1",1,15,path);
		textSend(txtMonths, months);
		
		WebElement txtYear = locatedId("cc_exp_year");
		String year = getData("sheet1",1,16,path);
		textSend(txtYear, year);
		
	    WebElement  dDnCvv = locatedId("cc_cvv");
	     String cvv = getData("sheet1", 1, 17,path);
	     textSend(dDnCvv, cvv);
	     
	     WebElement btnBook = locatedId("book_now");
		    click(btnBook);
		Thread.sleep(6000);
		    
		    WebElement btnOrder = locatedId("order_no");
	
		    String txt = getAttribute(btnOrder);
		    // textSend(btnOrder,txt);
		     System.out.println(txt);
	    WriteData("sheet1", 1, 18,txt);
	   
         
	
}





	
}

