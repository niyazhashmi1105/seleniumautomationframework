package com.selenium.driver;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.ConfigProperties;
import com.selenium.exceptions.BrowserInvocationFailedException;
import com.selenium.factories.DriverFactory;
import com.selenium.utils.PropertyUtils;

public final class Driver {
	
	private Driver() {}
	
	public static void initDriver(String browser) {
		
		if(Objects.isNull(DriverManager.getDriver())) {
			
		try {
				DriverManager.setDriver(DriverFactory.getDriver(browser));
			
			} catch (MalformedURLException e) {
				throw new BrowserInvocationFailedException("Please check the capabilities of browser");
			}
			DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
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
