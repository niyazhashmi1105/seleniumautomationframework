package com.selenium.pages;

import com.selenium.driver.DriverManager;

public class AmazonMobilesComputerPage extends BasePage {
	
	AmazonMobilesComputerPage() {}
	
	public String getTitle() {
		
		return DriverManager.getDriver().getTitle();
		
	}

}
