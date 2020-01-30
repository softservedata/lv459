package com.softserve.edu.rest.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

public class LoginLogoutTest extends RestTestRunner {
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
	
	//@Test(dataProvider = "correctUser")
	public void verifyLogin(User user) {
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
        		.successfulAdminLogin(user);
        //
        guestService = adminService.logout();
        //
        //log.debug("loginPositiveTest finished!");
        //logger.info("loginPositiveTest DONE, user = " + user);
    }

	@DataProvider
    public Object[][] correctAdminTime() {
		//logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getExtend() },
        };
    }

	//@Test(dataProvider = "correctAdminTime")
	public void verifyLifeTimeToken(User admin, Lifetime lifetime) {
		//logger.info("loginPositiveTest START, user = " + user);
        //log.debug("loginPositiveTest started!");
		//
        // Steps
		GuestService guestService = loadApplication()
				.resetServiceToInitialState();
        //
        // Check
        Assert.assertTrue(guestService.getCurrentLifetime()
        		.equals(LifetimeRepository.getDefault()));
        //
        // Step
        AdminService adminService = guestService
        		.successfulAdminLogin(admin)
        		.changeCurrentLifetime(lifetime);
        //
        // Check
        Assert.assertTrue(adminService.getCurrentLifetime()
        		.equals(LifetimeRepository.getExtend()));
        //
        // Return to Previous State
        guestService = adminService.logout();
        //
        //log.debug("loginPositiveTest finished!");
        //logger.info("loginPositiveTest DONE, user = " + user);
    }

	@Test(dataProvider = "correctAdminTime")
	      //expectedExceptions = RuntimeException.class)
	public void verifyException(User admin, Lifetime lifetime) {
		// logger.info("loginPositiveTest START, user = " + user);
		// log.debug("loginPositiveTest started!");
		//
		// Steps
		GuestService guestService = loadApplication()
				.resetServiceToInitialState();
		//
		// Check
		//guestService.updateLifetime();
		guestService.updateCurrentLifetime();
		//
		// log.debug("loginPositiveTest finished!");
		// logger.info("loginPositiveTest DONE, user = " + user);
	}

}
