package com.selenium.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomLevelTest {
	
	WebDriver driver;
	
	@Test
	public void zoomoutPageTest() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		zoomouttest(0.8);
		Thread.sleep(5000);
		//driver.quit();
	}
	
	private void zoomouttest(double zoomLevel) {
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.body.style.zoom= '"+zoomLevel+"'");
        System.out.println(zoomLevel);
	}

}
