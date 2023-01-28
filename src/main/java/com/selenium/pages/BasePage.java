package com.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.selenium.constants.FrameworkConstants;
import com.selenium.drivermanager.DriverManager;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;

public class BasePage {


	protected void click(By by, WaitStrategy wait) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.click();
	}

	protected void sendKeys(By by, String value,WaitStrategy wait) {
		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.sendKeys(value);
	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void implicitlyWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
	}
}
