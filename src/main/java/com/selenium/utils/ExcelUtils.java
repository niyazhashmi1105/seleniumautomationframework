package com.selenium.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.selenium.constants.FrameworkConstants;
import com.selenium.exceptions.FrameworkException;
import com.selenium.exceptions.InvalidExcelPathException;

public final class ExcelUtils {

	private ExcelUtils() {}
	
	

	public static List<Map<String,String>> getTestDetails(String sheetName){
		
		
		List<Map<String,String>> list = null;

		try(FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelFilePath())) {
			
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

		}catch(FileNotFoundException e) {
			throw new InvalidExcelPathException("Excel File you are trying to read not found");
		}
		catch(IOException e) {
			throw new FrameworkException("Some IO exception happended while reading excel file");
			}
		
		return list;
	}
}
