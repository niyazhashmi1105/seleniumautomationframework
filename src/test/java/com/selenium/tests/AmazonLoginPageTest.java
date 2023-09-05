package com.selenium.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AmazonLoginPageTest {
	
	
	WebDriver driver;
	
	//@Test
	public void amaZonLoginWithCredentials() {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//span[text()='Account & Lists']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("9000598160");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("pass123");
		driver.findElement(By.id("signInSubmit")).click();
		
	}
	
	@Test
	public void getLanguageSelection() {
		
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement element = driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
		Actions action = new Actions(driver);
		action.moveToElement(element);
		List<WebElement> languageRadioBtns = driver.findElements(By.xpath("//span[@class='nav-text']/span[2]"));
		
		System.out.println(languageRadioBtns.size());
		
		for(int i=0;i<languageRadioBtns.size();i++) {
			
			if(languageRadioBtns.get(i).getText().equals("HI")) {
				driver.findElement(By.xpath("//span[@class='nav-text']/i")).click();
				break;
			}
		}
	}
	

}
