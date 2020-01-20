package com.softserve.edu.opencart.tests;

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

        System.out.println("Prerequisites: Customer is not in database: " + page
                .getContainer().isCustomerNoResults());
        presentationSleep(2);


        presentationSleep(2);

    }
}
