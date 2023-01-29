package com.selenium.tests;


import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.selenium.drivermanager.DriverManager;

public final class HomePageTests extends BaseTest {

	private HomePageTests() {}


	@Test
	public void test1() {
		
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Selenium",Keys.ENTER);
		String title= DriverManager.getDriver().getTitle();
		
		assertThat(title)
		.as("Title is not null").isNotNull()
		.as("doesn't contain expected text").containsIgnoringCase("Google Search")
		.matches("\\w.* "+"Google Search")
		.hasSizeBetween(15, 100);
		
		List<WebElement> links= DriverManager.getDriver().findElements(By.xpath("//a/h3"));
		assertThat(links)
				  .hasSize(12)
				  .extracting(e->e.getText())
				  .contains("Selenium");
				  
		
	}
}
