package com.selenium.factories;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;

import com.selenium.enums.LocatorType;

public final class LocatorFactory {
	
	private LocatorFactory() {}
	
	
	private static Map<LocatorType,Function<String,By>> map = new EnumMap<>(LocatorType.class);
	
	static {
			map.put(LocatorType.XPATH, By::xpath);
			map.put(LocatorType.ID, By::id);
			map.put(LocatorType.NAME, By::name);
			map.put(LocatorType.CLASSNAME,  By::className);
			map.put(LocatorType.LINKTEXT, By::linkText);
			map.put(LocatorType.PARTIALLINKTEXT, By::partialLinkText);
			map.put(LocatorType.CSSSELECTOR, By::cssSelector);
			map.put(LocatorType.TAGNAME, By::tagName);
		}
	
	
	public static By getByLocator(LocatorType locator, String value) {
		
		return map.get(locator).apply(value);
	}
	

}
