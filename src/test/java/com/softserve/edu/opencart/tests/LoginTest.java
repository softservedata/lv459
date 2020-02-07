package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.EditAccountPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.UnsuccessfulLoginPage;
import com.softserve.edu.opencart.tools.DataBaseUtils;
import com.softserve.edu.opencart.tools.ListUtils;

public class LoginTest extends EpizyUserTestRunner {

	// some staff here
	@DataProvider//(parallel = true)
	public Object[][] customers() {
		return new Object[][] {
			{ UserRepository.get().getDefault() },
			//{ UserRepository.get().getHahaha() },
		};
	}

	@DataProvider(parallel = true)
	public Object[][] externalCustomers() {
		//return ListUtils.toMultiArray(UserRepository.get().fromCsv());
		return ListUtils.toMultiArray(UserRepository.get().fromExcel());
	}

	//@Test(dataProvider = "customers")
	//@Test(dataProvider = "externalCustomers")
	public void checkSuccessful(IUser validUser) throws Exception {
		// Test Data
		// User validUser = UserRepository.getDefault();
		//
		// Steps
		MyAccountPage myAccountPage = loadApplication()
				.gotoLoginPage()
				.successfulLogin(validUser);
		presentationSleep();
		//
		// Check
		Assert.assertTrue(ApplicationStatus.get().isLogged());
		presentationSleep();
		//
		// Steps
		// GOTO EditAccountPage + Message
		EditAccountPage editAccountPage = myAccountPage
				.gotoEditAccountRight();
		presentationSleep();
		//
		// Check
		Assert.assertEquals(editAccountPage.getFirstNameFieldText(), validUser.getFirstName());
		//
		// Return to Previous State
		HomePage homePage = editAccountPage.gotoContinue() // optional
				.gotoLogoutRight()
				.gotoContinue();
		//
		// Check (optional)
		Assert.assertFalse(ApplicationStatus.get().isLogged());
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
	}

	@DataProvider//(parallel = true)
	public Object[][] invalidUsers() {
		return new Object[][] {
			{ UserRepository.get().getInvalid() },
		};
	}

	@BeforeSuite
	public void beforeSuiteInvalidUsers() {
		DataBaseUtils.openConnection();
	}

	@AfterSuite
	public void afterSuiteInvalidUsers() {
		DataBaseUtils.closeConnection();
	}

	@BeforeMethod
	public void beforeMethodInvalidUsers() {
		DataBaseUtils.setLoginedUsersToNull();
	}

	@AfterMethod
	public void afterMethodInvalidUsers(ITestResult result){
		Object[] inputArgs = result.getParameters();
		IUser invalidUser = (IUser) inputArgs[0]; 
		DataBaseUtils.clearLoginedUsers(invalidUser);
	}
	
	@Test(dataProvider = "invalidUsers")
	public void checkUnsuccessful(IUser invalidUser) throws Exception {
		//
		// Steps
		UnsuccessfulLoginPage unsuccessfulLoginPage = loadApplication()
				.gotoLoginPage()
				.unsuccessfulLoginPage(invalidUser)
				.unsuccessfulLoginPage(invalidUser)
				.unsuccessfulLoginPage(invalidUser)
				.unsuccessfulLoginPage(invalidUser)
				.unsuccessfulLoginPage(invalidUser);
		presentationSleep();
		//
		// Check
		Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
				.contains(UnsuccessfulLoginPage.EXPECTED_LOGIN_MESSAGE));
		presentationSleep();
		//
		// Steps
		unsuccessfulLoginPage = unsuccessfulLoginPage
				.unsuccessfulLoginPage(invalidUser);
		//
		// Check
		Assert.assertTrue(unsuccessfulLoginPage.getAlertWarningText()
				.contains(UnsuccessfulLoginPage.EXPECTED_LOCK_MESSAGE));
		presentationSleep();
		//
		// Return to Previous State
		HomePage homePage = unsuccessfulLoginPage
				.gotoHomePage();
		//
		// Check (optional)
		Assert.assertTrue(homePage
				.getSlideshow0FirstImageAttributeSrcText()
				.contains(HomePage.EXPECTED_IPHONE6));
		presentationSleep();
	}

}
