package com.selenium.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.selenium.constants.FrameworkConstants;
import com.selenium.drivermanager.DriverManager;
import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static void initDriver() throws Exception {

		if(Objects.isNull(DriverManager.getDriver())) {
			WebDriver driver = new ChromeDriver();
			DriverManager.setDriver(driver);
			DriverManager.getDriver().get(PropertyUtils.getValue(ConfigProperties.URL));
			DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
			DriverManager.getDriver().manage().window().maximize();
		}
	}

	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
