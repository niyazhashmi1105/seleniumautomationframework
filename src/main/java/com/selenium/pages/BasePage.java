package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.constants.FrameworkConstants;
import com.selenium.drivermanager.DriverManager;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;
import com.selenium.reports.ExtentLogger;

public class BasePage {


	protected void click(By by, WaitStrategy wait, String elementName) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.click();
		try {
			ExtentLogger.pass(elementName+" is clicked successfully", true);
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	protected void sendKeys(By by, String value,WaitStrategy wait, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.sendKeys(value);
		try {
			ExtentLogger.pass(value+" is entered successfully on "+elementName, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void implicitlyWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
	}
}
