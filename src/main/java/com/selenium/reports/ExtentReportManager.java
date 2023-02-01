package com.selenium.reports;

import java.util.Objects;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentReportManager {

	private ExtentReportManager() {}

	private static ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

	static ExtentTest getExtentTest() {
		return extTest.get();
	}
	static void setExtentTest(ExtentTest test) {
		if(Objects.nonNull(test))
			extTest.set(test);
	}

	static void unload() {
		if(Objects.isNull(extTest))
			extTest.remove();
	}


}
