package com.softserve.edu.rest.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.dto.RestParameters;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;

public class LoginTest extends RestTestRunner {
	public static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@DataProvider
    public Object[][] correctUser() {
		//logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin() },
        };
    }

	@Test(dataProvider = "correctUser")
	public void verifyLogin(User user) {
//		logger.info("loginPositiveTest START, user = " + user);
	    //log.debug("loginPositiveTest started!");
		//
	    //Steps
	    UserService userService = new GuestService()
	        	.successfulUserLogin(user);
	    RestParameters urlParameters = new RestParameters()
				.addParameter("token", userService.getToken());
	    //SimpleEntity loginedAdmins = loginResource.httpGetLoginedAdmins(null, urlParameters);
		//System.out.println("loginedAdmins: " + loginedAdmins);
	    //System.out.println("++++++++");
	    //
	    //Check
//	    Assert.assertTrue(userService.isUserLogged(user));

	    //
	    //Step
	    GuestService guestService = userService.logout();
	    System.out.println("======" + userService.getToken());
	    //Assert.assertFalse(guestService.isUserLogged(user));
	    //
	    AdminService adminService = guestService
	        	.successfulAdminLogin(user);
	    //
	    guestService = adminService.logout();
	    //
	    //log.debug("loginPositiveTest finished!");
//	    logger.info("loginPositiveTest DONE, user = " + user);
	    }
}
