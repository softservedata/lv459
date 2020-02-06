package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LockUnlockUserTest extends RestTestRunner {
    public static final Logger logger = LoggerFactory.getLogger(LockUnlockUserTest.class);

    @DataProvider
    public Object[][] lockUser() {
        logger.info("@DataProvider lockUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), UserRepository.getVasya() }
        };
    }

    @Test(dataProvider = "lockUser", priority = 1)
    public void lockUser(User admin, User userToLock) {
        logger.info("lockUserPositiveTest  START, userToLock = " + userToLock) ;

        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .createUser(userToLock)
                .lockUser(userToLock);

        adminService.getAllLockedUsers(); //Doesn't work

        //Assert.assertTrue(adminService.getAllLockedUsers().contains("Vasya"));
        Assert.assertTrue(adminService.isUserLocked(userToLock));

        // TODO: 07-Feb-20 Separate test
        //Verify login locked User
        UserService userService = loadApplication()
                .successfulUserLogin(userToLock);

        logger.info("lockUserPositiveTest DONE, userToLock = " + userToLock);
    }

    @Test(dataProvider = "lockUser", priority = 2)
    public void unlockUser(User admin, User userToLock) {
        logger.info("unlockUserPositiveTest  START, userToUnlock = " + userToLock);

        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                //.unlockUser(userToLock)
                .unlockAllUsers();

        Assert.assertNotEquals(adminService.getAllLockedUsers(), "ERROR, user locked");

        //Verify login unlocked User
        UserService userService = loadApplication()
                .successfulUserLogin(userToLock);

        Assert.assertTrue(adminService.isUserLogged(userToLock));

        logger.info("unlockUserPositiveTest DONE, userToUnlock = " + userToLock);
    }

}
