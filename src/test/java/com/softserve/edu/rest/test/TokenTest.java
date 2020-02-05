package com.softserve.edu.rest.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;

public class TokenTest extends RestTestRunner{
    public static final Logger logger = LoggerFactory.getLogger(TokenTest.class);

    @DataProvider
    public Object[][] correctAdminExtend() {
        logger.info("@DataProvider correctAdminExtend() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getExtend()}
        };
    }
    
    @DataProvider
    public Object[][] correctAdminShort() {
        logger.info("@DataProvider correctAdminShort() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getShort()}
        };
    }

    @Test(dataProvider = "correctAdminExtend", priority = 1)
    public void verifyTokenChange(User admin, Lifetime extend){
        logger.info("verifyTokenChange START, admin = " + admin.toString());
        
        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .changeCurrentLifetime(extend);

        Assert.assertEquals(adminService.getCurrentLifetime(), extend);
        
        logger.info("verifyTokenChange DONE, admin = " + admin);
    }
    
    @Test(dataProvider = "correctAdminShort", priority = 2)
    public void verifyTokenLifetime(User admin, Lifetime tokenShort){
        logger.info("verifyTokenLifetime START, admin = " + admin.toString());
        
        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .changeCurrentLifetime(tokenShort)
                .waitTokenLifeTime(tokenShort);
        
        Assert.assertFalse(adminService.isUserLogged(admin));
        
        logger.info("verifyTokenLifetime DONE, admin = " + admin);
    }
}
