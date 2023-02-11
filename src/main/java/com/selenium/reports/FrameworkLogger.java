package com.selenium.reports;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;

import com.selenium.enums.LogType;

public class FrameworkLogger {
	
	private FrameworkLogger() {};
	
	private static Consumer<String> PASS = (message)->ExtentReportManager.getExtentTest().pass(message);
	private static Consumer<String> FAIL = (message)->ExtentReportManager.getExtentTest().fail(message);
	private static Consumer<String> SKIP = (message)->ExtentReportManager.getExtentTest().skip(message);
	private static Consumer<String> INFO = (message)->ExtentReportManager.getExtentTest().info(message);
	private static Consumer<String> CONSOLE = (message)->System.out.println("INFO------> "+message);
	private static Consumer<String> EXTENTANDCONSOLE = PASS.andThen(CONSOLE);
	
	
	private static Map<LogType,Consumer<String>> map = new EnumMap<>(LogType.class);
	
	static {
		
			map.put(LogType.PASS, PASS);
			map.put(LogType.FAIL, FAIL);
			map.put(LogType.SKIP, SKIP);
			map.put(LogType.INFO, INFO);
			map.put(LogType.CONSOLE, CONSOLE);
			map.put(LogType.EXTENTANDCONSOLE, EXTENTANDCONSOLE);
		}
	public static void log(LogType status, String message) {
		map.get(status).accept(message);
	}

}
