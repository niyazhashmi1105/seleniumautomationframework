package com.selenium.tests;


import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.selenium.pages.AmazonHomePage;

public final class AmazonHamburgerMenuPageTest extends BaseTest {
	
	private AmazonHamburgerMenuPageTest() {}
	
	@Test
	public void amazonHamburgerMenuTest(Map<String,String> data) {
		String title = new AmazonHomePage().clickHamburger().clickMobilesComputers().clickOnSubMenuItem(data.get("menuItem")).getTitle();
		Assertions.assertThat(title).isNotNull().isNotBlank();
	}

}
