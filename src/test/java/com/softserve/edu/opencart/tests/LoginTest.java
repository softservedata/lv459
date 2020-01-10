package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.EditAccountPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;

public class LoginTest extends EpizyUserTestRunner {

	// some staff here
	@DataProvider // (parallel = true)
	public Object[][] customers() {
		return new Object[][] {
			{ UserRepository.getDefault() },
			//{ UserRepository.getHahaha() },
		};
	}

	@Test(dataProvider = "customers")
	public void checkSuccessful(User validUser) throws Exception {
		// Test Data
		// User validUser = UserRepository.getDefault();
		//
		// Steps
		MyAccountPage myAccountPage = loadApplication().gotoLoginPage().successfulLogin(validUser);
		presentationSleep();
		//
		// Check
		Assert.assertTrue(ApplicationStatus.get().isLogged());
		presentationSleep();
		//
		// Steps
		// GOTO EditAccountPage + Message
		EditAccountPage editAccountPage = myAccountPage.gotoEditAccountRight();
		presentationSleep();
		//
		// Check
		Assert.assertEquals(editAccountPage.getFirstNameFieldText(), validUser.getFirstName());
		//
		// Return to Previous State
		HomePage homePage = editAccountPage.gotoContinue() // optional
				.gotoLogoutRight().gotoContinue();
		//
		// Check (optional)
		Assert.assertFalse(ApplicationStatus.get().isLogged());
		Assert.assertTrue(homePage.getSlideshow0FirstImageAttributeSrcText().contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
	}

}
