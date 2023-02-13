package com.selenium.tests;


import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.selenium.annotation.FrameworkAnnotation;
import com.selenium.enums.CategoryType;
import com.selenium.pages.AmazonHomePage;

public final class AmazonHamburgerMenuPageTest extends BaseTest {
	
	private AmazonHamburgerMenuPageTest() {}
	
	@FrameworkAnnotation(author={"Niyaz","Hashmi"},category={CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test
	public void amazonHamburgerMenuTest(Map<String,String> data) {
		String title = new AmazonHomePage().clickHamburger().clickMobilesComputers().clickOnSubMenuItem(data.get("menuSubItem")).clickOnHeaders("Amazon miniTV");
		Assertions.assertThat(title).isNotNull();
	}

}
