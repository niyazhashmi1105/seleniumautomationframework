package com.selenium.tests;


import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginPageTest extends BaseTest {

	private OrangeHRMLoginPageTest() {}

	@Test(dataProvider="LoginTestDataProvider")
	public void loginLogoutTest(String username, String password) {

		
		String title = new OrangeHRMLoginPage().enterUsername(username).enterPassword(password).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}
	
	@Test(dataProvider="LoginTestDataProvider")
	public void newTest(String username, String password) {

		
		String title = new OrangeHRMLoginPage().enterUsername(username).enterPassword(password).clickSubmit()
				.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
	}

	@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			{"Admin","admin123"},
			//{"admin","admin1234"}
		};
			
	}

}
