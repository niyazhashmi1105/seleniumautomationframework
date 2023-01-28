package com.selenium.tests;


import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import com.selenium.pages.OrangeHRMLoginPage;

public final class OrangeHRMLoginPageTest extends BaseTest {

	private OrangeHRMLoginPageTest() {

	}


	@Test
	public void loginlogoutTest() {
		OrangeHRMLoginPage ohlp = new OrangeHRMLoginPage();
		String title = ohlp.enterUsername("Admin").enterPassword("admin123").clickSubmit()
						.clickWelcome().clickLogout().getPageTitle();
		Assertions.assertThat(title)
					.isEqualTo("OrangeHRM");
	}


	
}
