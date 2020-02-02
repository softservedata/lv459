package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import com.softserve.edu.rest.test.RestTestRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddItemTest extends RestTestRunner {
    public static final Logger logger =
            LoggerFactory.getLogger(AddItemTest.class);
    // org.slf4j.LoggerFactory
    //public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DataProvider
    public Object[][] correctAdmin() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin()},
                };
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyAddItem(User user) {
        logger.info("loginPositiveTest AddItem START, user = " + user);
        logger.debug("loginPositiveTest started!");

        // prerequisites. create new user.
        UserService userService = new GuestService()
                .successfulUserLogin(user);

        AdminService adminService = userService.successfulAdminLogin(user)
                .successfulAdminLogin(user);

        System.out.println(
                "logined user as admin: token " + adminService.toString());

        System.out.println(adminService.getToken());
        //
        //Steps

        //
        //Check
        //Assert.assertTrue(userService.isUserLogged(user));
        //
        //Step
//        GuestService guestService = userService.logout();
        //Assert.assertFalse(guestService.isUserLogged(user));
        //
//        AdminService adminService = guestService
//                .successfulAdminLogin(user);
//        //
//        guestService = adminService.logout();
        //
        //log.debug("loginPositiveTest finished!");
        //logger.info("loginPositiveTest DONE, user = " + user);
    }
}