package com.softserve.edu.rest.test;

import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;

public class LoginTest extends RestTestRunner {
	public static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

	@DataProvider
	public Object[][] createUser() {
		logger.info("@DataProvider createUser() DONE");
		return new Object[][]{
				{ UserRepository.getAdmin(), UserRepository.getVasya() }
		};
	}

	@Test(dataProvider = "createUser", priority = 1)
	public void createUser(User admin, User newUser) {
		logger.info("createUserPositiveTest  START, admin = " + admin);

		AdminService adminService = loadApplication()
				.successfulAdminLogin(admin)
				.createUser(newUser);

		Assert.assertTrue(adminService.isUserCreated(newUser));

		adminService.getAllUsers();
		adminService.logout();

		logger.info("createUserPositiveTest DONE, user = " + admin);
	}

	@DataProvider
    public Object[][] newUser() {
		logger.info("@DataProvider newUser() DONE");
        return new Object[][]{
                { UserRepository.getVasya() }
        };
    }

	@Test(dataProvider = "newUser", priority = 2)
	public void verifyNewUserLogin(User user) {
		logger.info("loginNewUserTest START, user = " + user);

		UserService userService = loadApplication()
				.successfulUserLogin(user);

		Assert.assertNotEquals(userService.getToken(),"Error Login");

		userService.logout();

		logger.info("loginNewUserTest DONE, user = " + user);
	}

	@DataProvider
	public Object[][] invalidUser() {
		logger.info("@DataProvider invalidUser() DONE");
		return new Object[][]{
				{ UserRepository.notExistingUser() }
		};
	}

	@Test(dataProvider = "invalidUser", priority = 3, expectedExceptions = RuntimeException.class)
	public void verifyLoginNegativeTest(User user) {
		logger.info("loginNegativeTest START, user = " + user);

		UserService userService = loadApplication()
				.successfulUserLogin(user);

		logger.info("loginNegativeTest DONE, user = " + user);
	}

}
