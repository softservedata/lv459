package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;

public class AdminMenuTest extends LocalAdminTestRunner {
	
	// some staff here
	@DataProvider//(parallel = true)
	public Object[][] admins() {
		return new Object[][] {
			{ UserRepository.get().getAdmin() },
			//{ UserRepository.get().getAdmin() },
		};
	}
	
	@Test(dataProvider = "admins")
	public void checkSuccessful(IUser validAdmin) throws Exception {
		// Test Data
		// User validUser = UserRepository.getDefault();
		//
		// Steps
		CurrenciesPage currenciesPage = loadSigninPage()
				.successfulLogin(validAdmin)
				.gotoCurrenciesPage();
		presentationSleep(2);
		//
		// Check
		Assert.assertTrue(currenciesPage.getTitleText().toLowerCase()
				.contains(CurrenciesPage.EXPECTED_TITLE_MESSAGE.toLowerCase()));
		presentationSleep(2);
		//
		// Return to Previous State
		SigninPage signinPage = currenciesPage
				.logout();
		presentationSleep(2);
		//
		// Check (optional)
		Assert.assertTrue(signinPage.getPanelTitleText().toLowerCase()
				.contains(SigninPage.EXPECTED_PANEL_TITLE_MESSAGE.toLowerCase()));
		presentationSleep(2);
	}
	
}
