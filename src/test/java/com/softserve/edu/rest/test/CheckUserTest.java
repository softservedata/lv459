package com.softserve.edu.rest.test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;

public class CheckUserTest extends RestTestRunner {


    @DataProvider
    public Object[][] correctUser() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyLogin(User admin){

        GuestService guestService = new GuestService();

        AdminService adminService = guestService
                .successfulAdminLogin(admin);

        adminService.createUser();

        //guestService.getCurrentLifetime();

        //logout
        adminService.logout();
    }
}
