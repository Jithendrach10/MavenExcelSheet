package javaunit.adactin;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;

public class AdactinHotelPom extends BaseClass2{
	static String url;
	static String txt;
	@BeforeClass
	public static void beforClass() {
		configChrome();
		enterUrl("http://adactinhotelapp.com/");
		manageWin();
	    url = driver.getCurrentUrl();
	    
	}
	
@Test
public void booking() throws IOException, InterruptedException {
	//1.login
   
	LoginPage loginpage  = new LoginPage();
	
	 //
	String username = getData("Sheet1",1 ,0,path);
	String password = getData("Sheet1",1 ,1,path);
	
	
	loginpage.login(username,password);         		//object of class loginpage class.methodname of loginpageclass																																																																																						,path);
	
   
	SearchHotelPage searchHotelPage = new SearchHotelPage();
	String Location = getData("Sheet1",1 ,2,path);
	String hotels = getData("Sheet1",1 ,3,path);
	String roomType = getData("Sheet1",1 ,4,path);
	String noRoom = getData("Sheet1",1 ,5,path);
	String dateIn = getData("Sheet1",1,6,path);
	String dateOut = getData("Sheet1",1,7,path);
	String adultPerRoom = getData("Sheet1",1,8,path);
	String childPerRoom = getData("Sheet1",1,9,path);
	searchHotelPage.searchHotel( Location,hotels,roomType,noRoom ,dateIn ,dateOut,adultPerRoom,childPerRoom );
	
	SelectHotelPage selectHotelPage = new SelectHotelPage();   
	 selectHotelPage.selectHotel();
	 
	 
	 BookHotelPage bookHotelPage = new BookHotelPage(); 
	 
	String firstName = getData("Sheet1",1,10,path);
	String LastName = getData("Sheet1",1,11,path);
	String address = getData("Sheet1",1,12,path);
	String cardNo = getData("Sheet1",1,13,path);
	String cardType = getData("Sheet1",1,14,path);
	String month = getData("Sheet1",1,15,path);
	String year = getData("Sheet1",1,16,path);
	String cvvNu = getData("Sheet1",1,17,path);
	 bookHotelPage.bookHotels(firstName,LastName,address,cardNo, cardType, month, year, cvvNu);
	
	 BookConfirmationPage bookConfirmation2 = new BookConfirmationPage();
		bookConfirmation2.bookConfirmation();
		
		getData("Sheet1",1,18,path);

	
	 BookedItinPage bookItinPage = new BookedItinPage();
	String orderId = getData("Sheet1",1,19,path);
	 bookItinPage.bookItin(orderId);
	 BookConfirmationPage2 bookConfirmationPage2 = new BookConfirmationPage2();
	 bookConfirmationPage2.bookConfirm2();

	 
	
	
	
	 
//Assert.assertTrue(url.contains("adactinhotel"));	
		
		
		
		
}
	
//@AfterClass
//public static void after(){
//	
//}
	
	
    
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
