package com.selenium.exceptions;

@SuppressWarnings("serial")
public class InvalidPropertyFilePathException extends InvalidPathFilesException {


	public InvalidPropertyFilePathException(String message) {
		super(message);
	}

	public InvalidPropertyFilePathException(String message,Throwable cause) {
		super(message,cause);
	}

}
