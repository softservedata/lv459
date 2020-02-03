package com.softserve.edu.rest.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
                { UserRepository.getAdmin()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyLogin(User admin){
        logger.info("checkUser Test  START, admin = " + admin);

        GuestService guestService = new GuestService();

        AdminService adminService = guestService
                .successfulAdminLogin(admin)
                .createUser(); //error user not found

       // logger.info("admin token = " + adminService.getToken());

        //logout
        adminService.logout();

    }
}
