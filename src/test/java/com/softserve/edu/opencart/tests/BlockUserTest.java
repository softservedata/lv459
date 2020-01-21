package com.softserve.edu.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;

public class BlockUserTest extends LocalAdminTestRunner {
    
    @DataProvider // (parallel = true)
    public Object[][] correctUsers() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin(),UserRepository.get().emailUser()},
            };
    }
/**
 * This test go to administration panel, block user, try to login with this user
 * and verify error message.
 * @param validAdmin - administrator with correct credentials.
 * @param validUser - user with correct credentials.
 */
    @Test(dataProvider = "correctUsers", priority = 1)
    public void blockUserTest(IAdmin validAdmin, IUser validUser) {
        loadAdminPage()
        .successfulLogin(validAdmin)
        .getTotalStatisticContainer()
        .goToTotalCustomers()
        .successfullSearchByEmail(validUser)
        .getUserContainer()
        .getUserByEmail(validUser)
        .editUser()
        .changeUserStatus(USER_DISABLED);

      String errorMessage =  loadMainPage()
        .gotoLoginPage()
        .unsuccessfulLogin(validUser)
        .getAlertWarningText();
      
      Assert.assertEquals(errorMessage, EXPECTED_ERROR_MESSAGE);
    }
    
    /**
     * This test go to administration panel, unblock user, try to login with this user
     * and verify that we go to the right customer.
     * @param validAdmin - administrator with correct credentials.
     * @param validUser - user with correct credentials.
     */
    @Test(dataProvider = "correctUsers", priority = 2)
    public void unblockUserTest(IAdmin validAdmin, IUser validUser) {
        loadAdminPage()
        .successfulLogin(validAdmin)
        .getTotalStatisticContainer()
        .goToTotalCustomers()
        .successfullSearchByEmail(validUser)
        .getUserContainer()
        .getUserByEmail(validUser)
        .editUser()
        .changeUserStatus(USER_ENABLED);
      
        String email =  loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validUser)
                .gotoEditAccountRight()
                .getEmailFieldText();
              Assert.assertEquals(email, validUser.getEmail());
    }

}
