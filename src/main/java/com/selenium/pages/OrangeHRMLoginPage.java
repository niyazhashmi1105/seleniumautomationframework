package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.WaitStrategy;

public class OrangeHRMLoginPage extends BasePage {
	
	private final By textboxUsername = By.name("username");
	private final By textboxPassword = By.xpath("//input[@type='password' and @name='password']");
	private final By btnSubmit =  By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxUsername,username,WaitStrategy.PRESENCE);
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxPassword,password,WaitStrategy.PRESENCE);
		return this;
	}

	public OrangeHRMHomePage clickSubmit() {
		click(btnSubmit,WaitStrategy.CLICKABLE);
		return new OrangeHRMHomePage();
	}
	
	public String getPageTitle() {
		return getTitle();
		
	}
}
