package com.selenium.factories;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;

public final class LocatorFactory {
	
	private LocatorFactory() {}
	
	
	private static Map<LocatorType,Function<String,By>> map = new EnumMap<>(LocatorType.class);
	
	
	private static Function<String,By> xpath = By::xpath;
	private static Function<String,By> id = By::id;
	private static Function<String,By> name = By::name;
	private static Function<String,By> className = By::className;
	private static Function<String,By> linkText = By::linkText;
	private static Function<String,By> partialLinkedText = By::partialLinkText;
	private static Function<String,By> cssSelector = By::cssSelector;
	private static Function<String,By> tagName = By::tagName;
	
	static {
			map.put(LocatorType.XPATH, xpath);
			map.put(LocatorType.ID, id);
			map.put(LocatorType.NAME, name);
			map.put(LocatorType.CLASSNAME, className);
			map.put(LocatorType.LINKTEXT, linkText);
			map.put(LocatorType.PARTIALLINKTEXT, partialLinkedText);
			map.put(LocatorType.CSSSELECTOR, cssSelector);
			map.put(LocatorType.TAGNAME, tagName);
		}
	
	
	public static By getByLocator(LocatorType locator, String value) {
		
		return map.get(locator).apply(value);
	}
	

}
