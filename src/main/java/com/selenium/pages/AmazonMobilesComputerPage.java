package com.selenium.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.driver.DriverManager;

public final class AmazonMobilesComputerPage extends BasePage {
	
	AmazonMobilesComputerPage() {}
	
	public String clickOnHeaders(String headerName) {
		
		List<WebElement> linkHeaders = DriverManager.getDriver().findElements(By.xpath("//div[@id='nav-xshop']/a"));
		getElementFromList(linkHeaders,"Amazon miniTV","Amazon MiniTv link");
		return getTitle();
	}

}
