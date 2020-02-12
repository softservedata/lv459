package com.softserve.edu.rest.test.admins;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.test.RestTestRunner;


/**
 * Taliana's tests
 */
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
    public void loginAdminTest(User existAdmin){

        AdminService adminService = guestService
                .successfulAdminLogin(existAdmin);

        Assert.assertTrue(adminService.isUserLogged(existAdmin));

        adminService.getAllUsers();

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
    public void createNewAdminTest(User existAdmin, User newAdmin){ //change param

        AdminService adminService = guestService
                .successfulAdminLogin(existAdmin)
                .createUser(newAdmin);

        Assert.assertTrue(adminService.isUserCreated(newAdmin));

        adminService.getAllUsers();

        adminService.logout();

    }


    @Test(dataProvider = "correctAdminCreate", priority = 3)
    public void loginNewAdminTest(User existAdmin, User newAdmin){

        AdminService adminService = guestService
                .successfulAdminLogin(existAdmin)
                .createUser(newAdmin)
                .successfulAdminLogin(newAdmin);

        Assert.assertTrue(adminService.isUserLogged(newAdmin));

        adminService.getAllUsers();

        adminService.logout();
    }

    @Test(dataProvider = "correctAdminCreate", priority = 4)
    public void logoutNewAdminTest(User existAdmin, User newAdmin){

        AdminService adminService = guestService
                .successfulAdminLogin(existAdmin)
                .createUser(newAdmin)
                .successfulAdminLogin(newAdmin);

    Assert.assertTrue(adminService.isUserLogged(newAdmin));

    adminService.getAllUsers();

    adminService.removeUser(newAdmin);

    Assert.assertTrue(adminService.isUserRemoved(newAdmin));

    adminService.getAllUsers();

    }



}
