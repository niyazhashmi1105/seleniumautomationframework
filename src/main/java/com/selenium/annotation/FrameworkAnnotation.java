package com.selenium.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.selenium.enums.CategoryType;

@Retention(RUNTIME)
@Target(METHOD)

public @interface FrameworkAnnotation {
	
	public String[] author() default{};
	public CategoryType[] category() default{};
	

}
