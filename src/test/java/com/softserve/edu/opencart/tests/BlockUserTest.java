package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class BlockUserTest extends LocalAdminTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctAdmin() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin(),UserRepository.get().emailUser()},
            };
    }

    @Test(dataProvider = "correctAdmin", priority = 1)
    public void blockUserTest(IAdmin validAdmin, IUser validUser) {
        loadApplication()
        .successfulLogin(validAdmin)
        .getTotalStatisticContainer()
        .goToTotalCustomers()
        .successfullSearchByEmail(validUser)
        .getUserContainer()
        .getUserByEmail(validUser)
        .clickEditButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
