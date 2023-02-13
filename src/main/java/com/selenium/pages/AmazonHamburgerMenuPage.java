package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.LocatorFactory;

public class AmazonHamburgerMenuPage extends BasePage {
	
	
	public AmazonHamburgerMenuPage clickMobilesComputers() {
		
		By linkMobilesComputers = LocatorFactory.getByLocator(LocatorType.XPATH, "//div[normalize-space()='Mobiles, Computers']");
		click(linkMobilesComputers,WaitStrategy.CLICKABLE,"Mobiles and Computers");
		return this;
	}
	
	public AmazonMobilesComputerPage clickOnSubMenuItem(String menuText) {
		
		By linkSubMenu = LocatorFactory.getByLocator(LocatorType.XPATH, "//a[text()='"+menuText+"']");
		click(linkSubMenu,WaitStrategy.CLICKABLE,menuText);
		if(menuText.contains("Power Banks")) {
			return new AmazonMobilesComputerPage();
		}
		return null;
	}
	
}
