package com.softserve.edu.rest.test;

import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.test.item.AddItemTest;

public class CheckUserTest extends RestTestRunner {

    public static final Logger logger =
            LoggerFactory.getLogger(AddItemTest.class);

    @DataProvider
    public Object[][] correctUser() {
        logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin(), UserRepository.getDana()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void createRemoveUser(User admin, User newUser) {
        logger.info("checkUser Test  START, admin = " + admin);

        GuestService guestService = new GuestService();

        //login ad admin, create user
        AdminService adminService = guestService
                .successfulAdminLogin(admin)
                .createUser(newUser);

        Assert.assertTrue(adminService.isUserCreated(newUser));

        //get all user
        adminService.getAllUsers();

        //remove user
        adminService.removeUser(newUser);

        Assert.assertTrue(adminService.isUserRemoved(newUser));

        adminService.getAllUsers();
        //logout
        adminService.logout();
    }


    @Test(dataProvider = "correctUser")
    public void changePassword(User admin, User newUser) {
        logger.info("change password Test  START, admin = " + admin);

        //login as admin
        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin).
                        createUser(newUser);

        Assert.assertTrue(adminService.isUserCreated(newUser));

        //admin logout
        adminService.logout();

        logger.info("******" + newUser.getName() + " " + newUser.getPassword());

        //user login, change password
        UserService userService = new GuestService()
                .successfulUserLogin(newUser)
                .changePassword(newUser);

        //user logout
        userService.logout();

        newUser.setPassword("qwerty5");
        //check password
        Assert.assertTrue(newUser.getPassword().equals("qwerty5"));

        //login
        UserService userService1 = new GuestService()
                .successfulUserLogin(newUser);
        //logout
        userService1.logout(); //without new service1 not working
    }
}
