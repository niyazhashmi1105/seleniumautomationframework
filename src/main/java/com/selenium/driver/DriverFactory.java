package com.selenium.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class DriverFactory {

	private DriverFactory() {

	}

	public static void initDriver(String browser){

		if(Objects.isNull(DriverManager.getDriver())) {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriver driver = new ChromeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("edge")) {
				WebDriver driver = new EdgeDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriver driver = new FirefoxDriver();
				DriverManager.setDriver(driver);
			}
			else if(browser.equalsIgnoreCase("safari")) {
				WebDriver driver = new SafariDriver();
				DriverManager.setDriver(driver);
			}
		else {
			System.out.println("Please provide valid "+ browser+ " in config properties file");
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
