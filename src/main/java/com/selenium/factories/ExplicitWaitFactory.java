package com.selenium.factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.constants.FrameworkConstants;
import com.selenium.drivermanager.DriverManager;
import com.selenium.enums.WaitStrategy;

public final class ExplicitWaitFactory {

	private ExplicitWaitFactory() {

	}
	public static WebElement performExplicitWait(By by, WaitStrategy wait) {

		WebElement element = null;

		if(wait == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.elementToBeClickable(by));
		}
		else if(wait== WaitStrategy.PRESENCE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.presenceOfElementLocated(by));
		}
		else if(wait== WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitWaitTime()))
					.until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		else {
			element = DriverManager.getDriver().findElement(by);
		}
		return element;

	}

}
