package com.selenium.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.DriverFactory;

public class BaseTest {


	protected BaseTest() {}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		DriverFactory.initDriver();
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
	
	
}
