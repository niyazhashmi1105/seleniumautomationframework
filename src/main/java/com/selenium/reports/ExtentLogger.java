package com.selenium.reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.selenium.driver.DriverManager;
import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class ExtentLogger {

	private ExtentLogger() {}

	public static void pass(String message) {
		ExtentReportManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentReportManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentReportManager.getExtentTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded){
		if(PropertyUtils.get(ConfigProperties.SKIPSTEPSCREENSHOTS).equalsIgnoreCase("yes")&& isScreenshotNeeded) {
			ExtentReportManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		}
		else {
			skip(message);
		}
	}
	private static String getBase64Image() {
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
