package com.selenium.pages;

import static com.selenium.reports.FrameworkLogger.log;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.constants.FrameworkConstants;
import com.selenium.driver.DriverManager;
import com.selenium.enums.LogType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;

public class BasePage {


	protected void click(By by, WaitStrategy wait, String elementName) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.click();
		log(LogType.EXTENTANDCONSOLE, elementName+" is clicked successfully");
	}

	protected void sendKeys(By by, String value,WaitStrategy wait, String elementName) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.sendKeys(value);
		log(LogType.EXTENTANDCONSOLE, value+" is entered successfully on "+elementName);

	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void implicitlyWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
	}
}
