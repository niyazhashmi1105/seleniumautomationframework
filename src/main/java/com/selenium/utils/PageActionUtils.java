package com.selenium.utils;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.selenium.driver.DriverManager;



public class PageActionUtils {
	
	private PageActionUtils() {};
	

	  public static boolean isPresentFromListOfWebELements(By by, Predicate<List<WebElement>> elementPredicate) {
		    return elementPredicate.test(DriverManager.getDriver().findElements(by));
		}

}
