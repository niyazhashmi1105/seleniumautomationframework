package com.selenium.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonTest {

	static private WebDriver driver;
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		
		driver.findElement(By.xpath("(//span[text()='Sign in'])[1]")).click();
		
		driver.navigate().back();
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14",Keys.ENTER);
		
		List<WebElement> iphone14List = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']"));
		System.out.println(iphone14List.size());
		
		String brandName= null;
		String modelName = null;
		
		for(int i=0;i<iphone14List.size();i++) {
			
			List<WebElement> iphone14Elements = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span"));
			
			String text = iphone14Elements.get(i).getText();
			
			if(text.contains("Apple iPhone 14 (128 GB)")) {
				  
			 System.out.println(iphone14Elements.size());
			 	continue;
			}
			
			if(text.equals("Apple iPhone 14 (256 GB) - Blue")) {
				iphone14Elements.get(i).click();
				brandName = driver.findElement(By.xpath("(//td/span[@class='a-size-base po-break-word'])[1]")).getText();
				modelName = driver.findElement(By.xpath("(//td/span[@class='a-size-base po-break-word'])[2]")).getText();
			}
			
		}
		System.out.println("Brand Name= "+brandName+" "+ "ModelName= "+ modelName);
		
		
	}
	
	

}
