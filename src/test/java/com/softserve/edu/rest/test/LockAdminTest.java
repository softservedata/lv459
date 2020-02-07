package com.softserve.edu.rest.test;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LockAdminTest extends RestTestRunner {
    public static final Logger logger = LoggerFactory.getLogger(LockUnlockUserTest.class);

    @DataProvider
    public Object[][] lockAdmin() {
        logger.info("@DataProvider lockAdmin() DONE");
        return new Object[][]{
                { UserRepository.getAdmin() }
        };
    }

    @Test(dataProvider = "lockAdmin", priority = 1)
    public void lockItself(User admin) {
        logger.info("lockAdminTest  START, lockAdmin = " + admin);

        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .lockUser(admin);

        Assert.assertTrue(adminService.isAdminLocked(admin));
    }

    @Test(dataProvider = "lockAdmin", priority = 2)
    public void verifyAdminLogin(User admin) {
        logger.info("lockedAdminLogin START, user = " + admin);

        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin);

        Assert.assertTrue(adminService.isUserLogged(admin));

        logger.info("lockedAdminLogin DONE, user = " + admin);
    }

}
