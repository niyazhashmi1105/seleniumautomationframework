package com.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.selenium.constants.FrameworkConstants;
import com.selenium.enums.ConfigProperties;

public final class PropertyUtils {

	private PropertyUtils() {

	}

	private static Properties prop= new Properties();
	private static final Map<String,String> configMap= new HashMap<>();

	static {

		try {
			FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigFilePath());
			prop.load(fis);

			for(Map.Entry<Object, Object> entry:prop.entrySet()) {
				configMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
			}
			
			//prop.entrySet().forEach(entry-> configMap.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));

		}catch(IOException e) {
			e.printStackTrace();
		}
	}


	public static String getValue(ConfigProperties key) throws Exception {


		if(Objects.isNull(key)|| Objects.isNull(configMap.get(key.name().toLowerCase()))){
			throw new Exception("Property name "+key+" not found in config.properties.Please check!!");
		}
		return configMap.get(key.name().toLowerCase());
	}

}
