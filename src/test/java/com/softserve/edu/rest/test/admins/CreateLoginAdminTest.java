package com.softserve.edu.rest.test.admins;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.test.RestTestRunner;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLoginAdminTest extends RestTestRunner {

    protected GuestService guestService = guestService = loadApplication();

    @DataProvider
    public Object[][] correctUser() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin() },
        };
    }

    @Test(dataProvider = "correctUser", priority = 1)
    public void loginAdminTest(User user){

        AdminService adminService = guestService
                .successfulAdminLogin(user);

        /// Ask how to do Assert

        adminService.logout();

    }

    @DataProvider
    public Object[][] correctAdminCreate() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin(), UserRepository.getNewAdmin()},
        };
    }

    @Test(dataProvider = "correctAdminCreate", priority = 2)
    public void createNewAdminTest(User user, User user1){ //change param

        AdminService adminService = guestService
                .successfulAdminLogin(user)
                .createNewAdmin(user1);


        adminService.logout();
        //.successfulAdminLogin(user1);
    }


    @DataProvider
    public Object[][] correctAdminNew() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getNewAdmin() },
        };
    }

    @Test(dataProvider = "correctAdminNew", priority = 3)     //Test don't work
    public void loginNewAdminTest(User user){

        AdminService adminService = guestService
                .successfulAdminLogin(user);

        adminService.logout();
    }

}
