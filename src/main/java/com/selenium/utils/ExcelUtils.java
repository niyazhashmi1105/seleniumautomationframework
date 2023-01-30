package com.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.constants.FrameworkConstants;

public final class ExcelUtils {

	private ExcelUtils() {}

	public static List<Map<String,String>> getTestDetails(String sheetName){
		FileInputStream fis = null;
		
		List<Map<String,String>> list = null;

		try {
			fis = new FileInputStream(FrameworkConstants.getExcelFilePath());
			try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
				XSSFSheet sheet = workbook.getSheet(sheetName);

				Map<String, String> map = null;
				list = new ArrayList<>();

				int lastRowNum = sheet.getLastRowNum();
				int lastColNum = sheet.getRow(0).getLastCellNum();
							
				for(int i=1;i<=lastRowNum;i++) {
					map = new HashMap<>();
					for(int j=0;j<lastColNum;j++) {
						
						String key = sheet.getRow(0).getCell(j).getStringCellValue();
						String value = sheet.getRow(i).getCell(j).getStringCellValue();
						map.put(key, value);
					}
					list.add(map);
				}
			}

		}catch(IOException e) {e.printStackTrace();}
		finally {
			try {
				if(Objects.nonNull(fis))		
					fis.close();
			}catch(IOException e) {e.printStackTrace();}
		}
		return list;
	}



}
