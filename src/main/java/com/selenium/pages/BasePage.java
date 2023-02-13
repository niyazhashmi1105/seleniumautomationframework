package com.selenium.pages;

import static com.selenium.reports.FrameworkLogger.log;

import java.time.Duration;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.constants.FrameworkConstants;
import com.selenium.driver.DriverManager;
import com.selenium.enums.LogType;
import com.selenium.enums.WaitStrategy;
import com.selenium.factories.ExplicitWaitFactory;

public class BasePage {


	protected void click(By by,WaitStrategy wait, String elementName) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.click();
		log(LogType.EXTENTANDCONSOLE, elementName+" is clicked successfully");
	}

	protected void sendKeys(By by, String value ,WaitStrategy wait,String elementName) {

		WebElement element = ExplicitWaitFactory.performExplicitWait(by,wait);
		element.sendKeys(value);
		log(LogType.EXTENTANDCONSOLE, value+" is entered successfully on "+elementName);

	}

	protected String getTitle() {
		return DriverManager.getDriver().getTitle();
	}

	public static void implicitlyWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.getImplicitWaitTime()));
	}

	public static void windowMaximize() {
		DriverManager.getDriver().manage().window().maximize();
	}

	public static void clickAnElementMatchingText(List<WebElement> elements, Predicate<WebElement> condition,String elementName) {

		
					elements.stream()
							.parallel()
							.filter(condition)
							.findFirst()
							.ifPresent(WebElement::click);
							
		log(LogType.EXTENTANDCONSOLE, elementName+" is clicked successfully");
	}
	
	public static void getElementFromList(List<WebElement> ele,String value,String elementName) {
		
		for(int i=0;i<ele.size();i++) {
			if(ele.get(i).getText().equalsIgnoreCase(value)) {
				ele.get(i).click();
				break;
			}
		}
		log(LogType.EXTENTANDCONSOLE, elementName+" is clicked successfully");
		
	}
}
