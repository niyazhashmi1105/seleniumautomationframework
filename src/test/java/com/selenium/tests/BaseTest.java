package com.selenium.tests;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.selenium.driver.DriverFactory;

public class BaseTest {


	protected BaseTest() {}
	
	
	@SuppressWarnings("unchecked")
	@BeforeMethod
	public void setUp(Object[] data){
		Map<String,String> map = (Map<String,String>)data[0];
		DriverFactory.initDriver(map.get("browser"));
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();
	}
	
	
}
