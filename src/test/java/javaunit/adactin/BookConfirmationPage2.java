package javaunit.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfirmationPage2 extends BaseClass2{
	public BookConfirmationPage2() {
		PageFactory.initElements(driver,this );
	}
	@FindBy(id="logout") 
	private WebElement btnLogout;
	
	public WebElement getBtnLogout() {
		return btnLogout;
	}
	
    public void bookConfirm2() {
   	
    	click(getBtnLogout());
    }
	

}


