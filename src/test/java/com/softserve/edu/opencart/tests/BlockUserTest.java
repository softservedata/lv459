package com.softserve.edu.opencart.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;

public class BlockUserTest extends LocalAdminTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctAdmin() {
        return new Object[][] { { AdminRepo.get().getValidAdmin() }, };
    }

    @Test
    public void blockUserTest() {

    }

}
