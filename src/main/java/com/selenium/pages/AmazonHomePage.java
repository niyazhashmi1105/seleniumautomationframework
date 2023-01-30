package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.WaitStrategy;

public class AmazonHomePage extends BasePage {
	
	
	private String linkHamburgerMenu = "nav-hamburger-menu";
	
	public AmazonHamburgerMenuPage clickHamburger() {
		click(By.id(linkHamburgerMenu),WaitStrategy.CLICKABLE,"Hamburger Menu link");
		return new AmazonHamburgerMenuPage();
	}
	
	
}
