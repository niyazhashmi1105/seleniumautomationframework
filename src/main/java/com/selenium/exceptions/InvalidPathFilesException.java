package com.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidPathFilesException extends FrameworkException {
	
	public InvalidPathFilesException(String message) {
		super(message);
	}
	public InvalidPathFilesException(String message, Throwable cause) {
		super(message, cause);
	}

}
