package javaunit.adactin;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfirmationPage extends BaseClass2{
	public BookConfirmationPage() {
		PageFactory.initElements(driver,this );
	}
	//@FindBy(id="order_no") 
	//private WebElement txtOrder;
	
	 
//    @FindBy(id="order_no")
//    private WebElement txtOrder;
    
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnItinerary;
	
	//public WebElement getTxtOrder() {
	//	return txtOrder;
	//}
//	public WebElement getTxtOrder() {
//		return txtOrder;
	
	public WebElement getBtnItinerary() {
		return btnItinerary;
	}
	
    public void bookConfirmation(){
    	//getAttribute(txtOrder);
   // getAttribute(getTxtOrder(),Order1);
    	
    	  //textSend(getTxtOrder());
         // textSend(txtOrder, Order2);
    	//WriteData("Sheet1", 2, 18, txtOrder);
    	click(getBtnItinerary());
    }
	

}
