package com.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidExcelPathException extends InvalidPathFilesException {

	public InvalidExcelPathException(String message) {
		super(message);
	}
	
	public InvalidExcelPathException(String message, Throwable cause) {
		super(message,cause);
	}

}
