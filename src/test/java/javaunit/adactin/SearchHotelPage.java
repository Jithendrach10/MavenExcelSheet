package javaunit.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass2 {
	
	public SearchHotelPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(id="location")
	private WebElement dDnLocation;
	
	@FindBy(id="hotels")
	private WebElement dDnhotels;
	
	@FindBy(id="room_type")
	private WebElement dDnRoomType;

	@FindBy(id="room_nos")
	private WebElement dDnRoomno; 
	
	@FindBy(id="datepick_in")
	private WebElement dDnDatepickIn;
	
	@FindBy(id="datepick_out")
	private WebElement dDnDatepickOut;
	
	@FindBy(id="adult_room")
	private WebElement dDnaAdultRoom;
	
	@FindBy(id="child_room")
	private WebElement dDnChildRoom;
	
	@FindBy(id="Submit")
	private WebElement dDnSubmit;
	
	public WebElement getdDnLocation(){
		return dDnLocation;
	}
	public WebElement getdDnhotels(){
		return dDnhotels;
	}
    public WebElement getdDnRoomType(){
			return dDnRoomType;
    }		
			
	 public WebElement getdDnRoomno(){
				return dDnRoomno;
	 }	
						
	 public WebElement getdDnDatepickIn(){
			return dDnDatepickIn;					
}
	 
	 public WebElement getdDnDatepickOut(){
			return dDnDatepickOut;					
}
	 
	 public WebElement getdDnaAdultRoom(){
			return dDnaAdultRoom;					
}
	 public WebElement getdDnChildRoom(){
			return dDnChildRoom;					
}
	 public WebElement getdDnSubmit(){
			return dDnSubmit;					
}
	 
	 public void searchHotel(String Location,String hotels, String roomType, 
			 String noRoom , String dateIn , String dateOut,String adultPerRoom, 
			 String childPerRoom ) {
		 
		 selectByVisible(getdDnLocation(),Location); 
		
		 selectByVisible(getdDnhotels(),hotels); 
		 selectByVisible(getdDnRoomType(),roomType); 
		 selectByVisible(getdDnRoomno(),noRoom ); 
		 textSend(getdDnDatepickIn(),dateIn);
		 textSend(getdDnDatepickOut(),dateOut);
		 selectByVisible(getdDnaAdultRoom(),adultPerRoom);
		 selectByVisible( getdDnChildRoom(),childPerRoom );
		 click(getdDnSubmit());
	 }
		
	}	

