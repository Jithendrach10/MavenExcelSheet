package javaunit.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass2 {
	
	public BookHotelPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="first_name")
     private WebElement txtFirstName;
	
	@FindBy(id ="last_name")
    private WebElement txtLastName;
	
	@FindBy(id ="address")
    private WebElement txtAddress;
	
	@FindBy(id ="cc_num")
    private WebElement txtCardNo;
	
	@FindBy(id = "cc_type")
	private WebElement dDnCardType;
	
    @FindBy(id = "cc_exp_month")
	private WebElement dDnMonth;
    
    @FindBy(id = "cc_exp_year")
  	private WebElement dDnYear; 
    
    @FindBy(id = "cc_cvv")
  	private WebElement txtCvvNum;
    
    @FindBy(id = "book_now")
  	private WebElement btnBookNo;
    
    public WebElement getTxtFirstName() {
    	return txtFirstName;
    }
     public WebElement getTxtLastName() {
    	    	return txtLastName; 	
    }
    
     public WebElement getTxtAddress() {
	    	return  txtAddress;    	
    }
     public WebElement getTxtCardNo() {
	    	return   txtCardNo;    	
 }
     
     public WebElement getdDnCardType() {
	    	return   dDnCardType;    	
}
     
     public WebElement getdDnMonth() {
	    	return   dDnMonth;    	
}    
     
     public WebElement getdDnYear() {
	    	return   dDnYear;    	
}     
     public WebElement getTxtCvvNum() {
	    	return   txtCvvNum;    	
}    
     public WebElement getbtnBookNo() {
	    	return   btnBookNo;    	
}     
     
  public void bookHotels(String firstName, String LastName, String address, String cardNo,
		  String cardType , String month , String year , String cvvNu) {
	 
	  textSend(getTxtFirstName(), firstName);
	  textSend(getTxtLastName(), LastName);
	  textSend(getTxtAddress(), address);
	  textSend(getTxtCardNo(), cardNo);
	  selectByVisible(getdDnCardType(),cardType); 
	  selectByVisible(getdDnMonth(),month); 
	  //selectByVisible(getdDnYear(),year); 
	  selectByValue(getdDnYear(),"2022");
	  textSend(getTxtCvvNum(),cvvNu);
	   click(getbtnBookNo());
	  
  }
     
     
     
     
}
