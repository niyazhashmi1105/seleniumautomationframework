package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.LocatorFactory;

public class OrangeHRMHomePage extends BasePage {

	public OrangeHRMHomePage clickWelcome() {
		
		By linkWelcome = LocatorFactory.getByLocator(LocatorType.XPATH, "//p[@class='oxd-userdropdown-name']");
		click(linkWelcome,WaitStrategy.CLICKABLE,"Welcome link");
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		
		By linkLogout = LocatorFactory.getByLocator(LocatorType.XPATH, "//li/a[text()='Logout']");
		click(linkLogout,WaitStrategy.CLICKABLE,"Logout link");
		return new OrangeHRMLoginPage();
	}
}
