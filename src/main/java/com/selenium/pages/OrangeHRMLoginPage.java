package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.LocatorFactory;
import com.selenium.utils.DecodeUtils;

public class OrangeHRMLoginPage extends BasePage {
	
	
	public OrangeHRMLoginPage enterUsername(String username) {
		
		By textboxUsername = LocatorFactory.getByLocator(LocatorType.NAME , "username");
		sendKeys(textboxUsername,username,WaitStrategy.PRESENCE,"Username field");
		return this;
	}
	
	public OrangeHRMLoginPage enterPassword(String password) {
		
		By textboxPassword = LocatorFactory.getByLocator(LocatorType.XPATH , "//input[@type='password' and @name='password']");
		sendKeys(textboxPassword,DecodeUtils.getDecodedString(password),WaitStrategy.PRESENCE,"Password field");
		return this;
	}

	public OrangeHRMHomePage clickSubmit() {
		
		By btnSubmit = LocatorFactory.getByLocator(LocatorType.XPATH , "//button[@type='submit']");
		click(btnSubmit,WaitStrategy.PRESENCE,"Submit button");
		return new OrangeHRMHomePage();
	}
	
	public String getPageTitle() {
		return getTitle();
		
	}
}
