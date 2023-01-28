package com.selenium.constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	
	private static final String RESOURCE_PATH= System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILE_PATH= RESOURCE_PATH+"/config/config.properties";
	private static final int IMPLICITWAITTIME= 20;
	private static final int EXPLICITWAITTIME= 10;
	
	public static String getConfigFilePath() {
		return CONFIGFILE_PATH;
	}


	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}

	public static int getExplicitWaitTime() {
		return EXPLICITWAITTIME;
	}

	
}
