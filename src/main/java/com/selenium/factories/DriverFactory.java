package com.selenium.factories;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.selenium.driver.DriverManager;
import com.selenium.enums.ConfigProperties;
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
	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver=null;

		//String runmode = System.getProperty("runmode");
		String runmode = PropertyUtils.get(ConfigProperties.RUNMODE);
		if(browser.equalsIgnoreCase("chrome")) {
			if(runmode.equalsIgnoreCase("remote")) {
				ChromeOptions chromeOpt = new ChromeOptions();
				chromeOpt.setCapability("browserName", "chrome");
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), chromeOpt);
			}
			else 
				driver = new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("edge")) {

			if(runmode.equalsIgnoreCase("remote")) {
				EdgeOptions edgeOpt = new EdgeOptions();
				edgeOpt.setCapability("browserName", "MicrosoftEdge");
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), edgeOpt);
			} else 
				driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {

			if(runmode.equalsIgnoreCase("remote")) {
				FirefoxOptions firefoxOpt = new FirefoxOptions();
				firefoxOpt.setCapability("browserName", "firefox");
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), firefoxOpt);
			} else 
				driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {

			if(runmode.equalsIgnoreCase("remote")) {
				SafariOptions safariOpt = new SafariOptions();
				safariOpt.setCapability("browserName", "safari");
				driver = new RemoteWebDriver(new URL(PropertyUtils.get(ConfigProperties.SELENIUMGRIDURL)), safariOpt);
			} else 
				driver = new SafariDriver();
		}
		return driver;
	}

}
