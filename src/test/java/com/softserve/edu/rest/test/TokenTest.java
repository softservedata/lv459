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
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getExtend()}
        };
    }
    
    @DataProvider
    public Object[][] correctAdminShort() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getShort()}
        };
    }

    @Test(dataProvider = "correctAdminExtend")
    public void verifyTokenChange(User admin, Lifetime extend){
        logger.info("verifyTokenChange START, admin = " + admin.toString());
        
        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .changeCurrentLifetime(extend);

        Assert.assertEquals(adminService.getCurrentLifetime(), extend);
        
        logger.info("verifyTokenChange DONE, admin = " + admin);
    }
    
    @Test(dataProvider = "correctAdminShort")
    public void verifyTokenLifetime(User admin, Lifetime tokenShort){
        logger.info("verifyTokenLifetime START, admin = " + admin.toString());
        
        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .changeCurrentLifetime(tokenShort);
              //  .waitTokenLifeTime(tokenShort);
        System.out.println(adminService.isUserLogged(admin));
        //Assert.assertEquals(adminService.getCurrentLifetime(),);
        
        logger.info("verifyTokenLifetime DONE, admin = " + admin);
    }
}
