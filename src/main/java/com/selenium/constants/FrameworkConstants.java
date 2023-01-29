package com.selenium.constants;

import com.selenium.enums.ConfigProperties;
import com.selenium.utils.PropertyUtils;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final int IMPLICITWAITTIME = 20;
	private static final int EXPLICITWAITTIME = 10;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentReportFilePath = "";
	private static final String EXCELFILEPATH =  RESOURCEPATH+"/excel/testdata.xlsx";
	
	public static String getExtentReportFilePath() throws Exception {
		
		if(extentReportFilePath.isEmpty()) {
			extentReportFilePath=createReportFilePath();
		}
		return extentReportFilePath;
	}

	private static String createReportFilePath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else {
			return EXTENTREPORTFOLDERPATH+"index.html";
		}
	}

	public static String getExcelFilePath() {
		return EXCELFILEPATH;
	}

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}


	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}

	public static int getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}

	
}
