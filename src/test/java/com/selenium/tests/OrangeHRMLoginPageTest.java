package com.selenium.tests;


import java.util.Map;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import com.selenium.annotation.FrameworkAnnotation;
import com.selenium.enums.CategoryType;
import com.selenium.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginPageTest extends BaseTest {

	private OrangeHRMLoginPageTest() {}
	
	@FrameworkAnnotation(author={"Niyaz","Hashmi"},category={CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test
	public void loginLogoutTest(Map<String,String> data) {

		
		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@FrameworkAnnotation(author={"Niyaz","Hashmi"},category={CategoryType.SMOKE,CategoryType.REGRESSION})
	@Test
	public void newTest(Map<String,String> data) {

		
		String title = new OrangeHRMLoginPage().enterUsername(data.get("username")).enterPassword(data.get("password")).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}

}
