package com.selenium.pages;

import org.openqa.selenium.By;

import com.selenium.enums.WaitStrategy;
import com.selenium.utils.DynamicXpathUtils;

public class AmazonHamburgerMenuPage extends BasePage {
	
	private String linkMobilesComputers = "//div[normalize-space()='Mobiles, Computers']";
	private String linkSubMenu = "//a[text()='%s']";
	
	public AmazonHamburgerMenuPage clickMobilesComputers() {
		click(By.xpath(linkMobilesComputers),WaitStrategy.CLICKABLE,"Mobiles and Computers");
		return this;
	}
	
	public AmazonMobilesComputerPage clickOnSubMenuItem(String menuText) {
		String newXpath = DynamicXpathUtils.getXpath(linkSubMenu, menuText);
		click(By.xpath(newXpath),WaitStrategy.CLICKABLE,menuText);
		if(menuText.contains("Power Banks")) {
			return new AmazonMobilesComputerPage();
		}
		return null;
	}

}
