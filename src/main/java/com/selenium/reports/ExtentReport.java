package com.selenium.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.CategoryType;

public final class ExtentReport {

	private ExtentReport() {}

	private static ExtentReports extent;
	public static ExtentTest test;

	public static void initReports(){

		if(Objects.isNull(extent)) {
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Automation Report");
			spark.config().setReportName("Selenium Training");
		}
	}

	public static void flushReports(){

		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentReportManager.unload();
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		test=extent.createTest(testCaseName);
		ExtentReportManager.setExtentTest(test);
	}

	public static void addAuthors(String [] authors) {
		if(Objects.nonNull(authors)) {
			for(String temp:authors) {
				ExtentReportManager.getExtentTest().assignAuthor(temp);
			}
		}
	}

	public static void addCategories(CategoryType [] categories) {

		if(Objects.nonNull(categories)) {
			for(CategoryType temp:categories) {
				ExtentReportManager.getExtentTest().assignCategory(temp.toString());
			}
		}
	}
}
