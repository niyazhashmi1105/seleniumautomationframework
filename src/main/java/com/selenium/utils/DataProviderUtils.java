package com.selenium.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.testng.annotations.DataProvider;

import com.selenium.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils() {}
	private static List<Map<String,String>> list = new ArrayList<>();

	@DataProvider(parallel=false)
	public static Object[] getData(Method m) {

		String testCaseName = m.getName();
		if(list.isEmpty()) {
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
		}
		List<Map<String,String>> smallList = new ArrayList<>(list);
		
		Predicate<Map<String,String>> isTestCaseNameMatching = map-> !map.get("testcasename").equalsIgnoreCase(testCaseName);
		Predicate<Map<String,String>> isExecuteNo = map-> map.get("execute").equalsIgnoreCase("no");
		
		smallList.removeIf(isTestCaseNameMatching.or(isExecuteNo));
		System.out.println(smallList);
		return smallList.toArray();
	}

}
