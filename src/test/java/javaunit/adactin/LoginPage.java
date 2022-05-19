package javaunit.adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass2{
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "username")
	private WebElement txtUserName;
	
	@FindBy(id = "password")
	private WebElement txtPassword;
	
	@FindBy(id = "login")
	private WebElement btnLogin;
	
	public WebElement getTxtUserName(){
		return txtUserName;
	}
	
	public WebElement getTxtPassword() {
		return txtPassword;
	}
	
    public WebElement getBtnLogin() {
    	return btnLogin;
    }
    
    public void login(String username , String password) {
    	textSend(getTxtUserName(), username);
    	textSend(getTxtPassword(), password);
    	click(getBtnLogin());
    }
}
