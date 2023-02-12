package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.LocatorFactory;

public class AmazonHomePage extends BasePage {
	
	
	public AmazonHamburgerMenuPage clickHamburger() {
		
		By linkHamburgerMenu = LocatorFactory.getByLocator(LocatorType.ID, "nav-hamburger-menu");
		click(linkHamburgerMenu,WaitStrategy.CLICKABLE,"Hamburger Menu link");
		return new AmazonHamburgerMenuPage();
	}
	
	
}
