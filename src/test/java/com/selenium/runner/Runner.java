package com.selenium.runner;

import org.testng.TestNG;

import com.selenium.listeners.AnnotationTransformer;
import com.selenium.listeners.Listener;
import com.selenium.listeners.MethodInterceptor;
import com.selenium.tests.BaseTest;
import com.selenium.tests.OrangeHRMLoginPageTest;

public class Runner {

	static TestNG testng;
	public static void main(String[] args) {
		
		testng = new TestNG();
		Listener listener = new Listener();
		MethodInterceptor methodInterceptor = new MethodInterceptor();
		AnnotationTransformer annotationTransformer = new AnnotationTransformer();
		
		testng.addListener(listener);
		testng.addListener(methodInterceptor);
		testng.addListener(annotationTransformer);
		testng.setTestClasses(new Class[] {BaseTest.class,OrangeHRMLoginPageTest.class});
		testng.run();
	}

}
