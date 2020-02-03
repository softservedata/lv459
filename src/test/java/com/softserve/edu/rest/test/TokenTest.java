package com.softserve.edu.rest.test;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.data.LifetimeRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;

public class TokenTest extends RestTestRunner{

    @DataProvider
    public Object[][] correctUser() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                { UserRepository.getAdmin(), LifetimeRepository.getExtend()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyTokenChange(User admin, Lifetime extend){

        AdminService adminService = loadApplication()
                .successfulAdminLogin(admin)
                .changeCurrentLifetime(extend);

        AssertJUnit.assertEquals(adminService.getCurrentLifetime(), extend);
    }
}
