package com.softserve.edu.rest.test;

import com.softserve.edu.rest.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

public class LoginTest extends RestTestRunner {
	public static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@DataProvider
    public Object[][] correctUser() {
		//logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin() },
				//{ UserRepository.createVasya() },
        };
    }

	//@Test(dataProvider = "correctUser")
	public void verifyLogin(User user) {
		logger.info("loginPositiveTest START, user = " + user);

	    UserService userService = loadApplication()
				.successfulUserLogin(user);

		//Assert.assertNotEquals(userService.getToken(),"Error Login");
        Assert.assertTrue(userService.isUserLogged(user));

	    userService.logout();

	    logger.info("loginPositiveTest DONE, user = " + user);
	    }

	@Test(dataProvider = "correctUser")
	public void createUser(User admin, User newUser) {
		logger.info("createUserPositiveTest  START, admin = " + admin);

		//create user
		AdminService adminService = loadApplication()
				.successfulAdminLogin(admin)
				.createUser(newUser);

		Assert.assertTrue(adminService.isUserCreated(newUser));

		adminService.getAllUsers();

		adminService.logout();

		logger.info("createUserPositiveTest DONE, user = " + admin);
	}

}
