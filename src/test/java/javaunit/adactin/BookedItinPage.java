package javaunit.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookedItinPage extends BaseClass2{        //cancel all in the class
	public BookedItinPage() {
		PageFactory.initElements(driver,this);
	}
 @FindBy(id= "order_id_text")
 private WebElement searchOrderId;
 
 @FindBy(id="search_hotel_id")
 private WebElement btnGo;
 
 @FindBy(name="ids[]")
 private WebElement btnButton;  
 
 @FindBy(name="cancelall")
 private WebElement btnCancel;
 
 public WebElement getSearchOrderId(){
	 return searchOrderId;
 }
 
 public WebElement getbtnGo(){
	 return btnGo;
 }
 public WebElement getbtnButton(){
	 return btnButton;
 }
 public WebElement getbtnCancel(){
	 return btnCancel;
 }
public void bookItin(String orderId) {
	textSend(getSearchOrderId(),orderId);
	click(getbtnGo());
	click( getbtnButton());
	click(getbtnCancel());
	alertAccept();
	
	
}
 
 
}
