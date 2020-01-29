package com.softserve.edu.rest.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

public class LoginLogoutTest {
	////public static final Logger logger = LoggerFactory.getLogger(LoginLogoutTest.class); // org.slf4j.LoggerFactory
	//public final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//@Test
	public void checkVariables() {
		//logger.info("checkVariables() START");
		System.out.println("JENKINS_LV426_PASSWORD = "
				+ System.getenv().get("JENKINS_LV426_PASSWORD"));
		System.out.println("password.variable = " + System.getProperty("password.variable"));
		//logger.info("checkVariables() DONE");
	}

	@DataProvider
    public Object[][] correctUser() {
		//logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin() },
        };
    }
	
	@Test(dataProvider = "correctUser")
	public void loginPositiveTest(User user) {
		//logger.info("loginPositiveTest START, user = " + user);
        //log.debug("loginPositiveTest started!");
		//
        //Steps
        UserService userService = new GuestService()
        		.successfulUserLogin(user);
        //
        //Check
        //Assert.assertTrue(userService.isUserLogged(user));
        //
        //Step
        GuestService guestService = userService.logout();
        //Assert.assertFalse(guestService.isUserLogged(user));
        //
        AdminService adminService = guestService
        		.SuccessfulAdminLogin(user);
        //
        guestService = adminService.logout();
        //
        //log.debug("loginPositiveTest finished!");
        //logger.info("loginPositiveTest DONE, user = " + user);
    }
}
