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
import com.selenium.exceptions.InvalidBrowserException;
import com.selenium.utils.PropertyUtils;

/**
 * Driver class responsible for invoking and closing browsers.
 * 
 * <p>
 * It is also responsible  for setting up the driver variable to DriverManager which 
 * handles thread safety for the webdriver instance.
 * 
 *@author NIYAZ
 * @version1.0
 * @see DriverManager
 * @see com.selenium.tests
 */


public final class DriverFactory {

	/**
	 * private constructor to avoid external instantiation
	 */
	private DriverFactory() {}

	/**
	 * 
	 * @param browser value will be passed from BaseTest.
	 * <p>
	 * Values can be CHROME,EDGE,FIREFOX and SAFARI
	 */
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
			throw new InvalidBrowserException("Please provide valid "+ browser+ " in config properties file");
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
