package com.softserve.edu.opencart.tests;

import org.testng.annotations.BeforeMethod;

import com.softserve.edu.opencart.pages.admin.account.SigninPage;

public abstract class LocalAdminTestRunner extends EpizyUserTestRunner {
	private String adminServerUrl = "http://10.26.34.76/opencart/upload/admin";
	
	@BeforeMethod
	public void beforeMethod() {
		//driver.get(adminServerUrl);
		getDriver().get(adminServerUrl);
	}

	public SigninPage loadSigninPage() {
		//return new SigninPage(driver);
		return new SigninPage(getDriver());
	}

}
