package org.excelsheet;

import org.openqa.selenium.WebElement;

public class Example extends LibGlobal {

	public static void main(String[] args) {
		
		LibGlobal l=new LibGlobal();
		l.configBrowser();
		l.launchUrl("https://www.facebook.com/");
		WebElement locateById = l.locateById("email");
		l.inputText(locateById, "suryakumar");
		WebElement locateById1 = l.locateById("pass");
		l.inputText(locateById1, "suryakumar@123");
		WebElement locateByName = l.locateByName("login");
		l.click(locateByName);
		
		



	}

}
