package com.selenium.tests;


import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.selenium.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginPageTest extends BaseTest {

	private OrangeHRMLoginPageTest() {}

	@Test
	public void loginLogoutTest(Map<String,String> data) {

		
		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@Test
	public void newTest(Map<String,String> data) {

		
		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}

}
