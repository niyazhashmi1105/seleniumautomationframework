package com.selenium.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.selenium.annotation.FrameworkAnnotation;
import com.selenium.reports.ExtentLogger;
import com.selenium.reports.ExtentReport;
import com.selenium.utils.ELKUtils;


public class Listener implements ITestListener,ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReports();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReports();
	}
	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());
		ExtentReport.addAuthors(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).author());
		ExtentReport.addCategories(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotation.class).category());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
		ELKUtils.sendResultstoELK(result.getMethod().getMethodName(), "pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed", true);
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		ELKUtils.sendResultstoELK(result.getMethod().getMethodName(), "fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		ELKUtils.sendResultstoELK(result.getMethod().getMethodName(), "skip");
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * 
		 * This will be implemented according to the need
		 */
	}

	@Override
	public void onFinish(ITestContext context) {

		/*
		 * 
		 * This will be implemented according to the need
		 */
	}
}
