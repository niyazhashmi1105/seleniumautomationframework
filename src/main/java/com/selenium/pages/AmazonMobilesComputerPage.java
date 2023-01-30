package com.selenium.pages;

import com.selenium.drivermanager.DriverManager;

public class AmazonMobilesComputerPage extends BasePage {
	
	AmazonMobilesComputerPage() {}
	
	public String getTitle() {
		
		return DriverManager.getDriver().getTitle();
		
	}

}
