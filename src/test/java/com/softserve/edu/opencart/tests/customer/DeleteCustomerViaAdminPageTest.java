package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.tests.LocalAdminTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.pages.admin.CustomersPage;

public class DeleteCustomerViaAdminPageTest extends LocalAdminTestRunner {

    /**
     * Test by Serhii Perepeliuk.
     * Prerequisites to test for creation of new customer.
     */
    @Test
    public void sampleTest() {
        String userEmail = System.getenv("USER_EMAIL");

        CustomersPage page = loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .filterByEmail(userEmail)
                .deleteCustomer(userEmail)
                ;
        Assert.assertTrue(page.getContainer().isCustomerNoResults());


/*        String errorMessage =  loadmainPage()
                .gotoRegisterPage()
                .
                // TODO HERE THE TEST*/

    }
}
