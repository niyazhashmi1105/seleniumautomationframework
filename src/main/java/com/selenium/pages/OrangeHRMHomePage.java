package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.WaitStrategy;

public class OrangeHRMHomePage extends BasePage {

	private final By linkWelcome = By.xpath("//p[@class='oxd-userdropdown-name']");
	private final By linkLogout = By.xpath("//li/a[text()='Logout']");

	public OrangeHRMHomePage clickWelcome() {
		click(linkWelcome,WaitStrategy.HANDLESTALEELEMENT,"Welcome link");
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		click(linkLogout,WaitStrategy.CLICKABLE,"Logout link");
		return new OrangeHRMLoginPage();
	}
}
