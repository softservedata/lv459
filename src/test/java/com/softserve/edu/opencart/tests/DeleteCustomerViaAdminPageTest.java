package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import org.testng.annotations.Test;

public class DeleteCustomerViaAdminPageTest extends LocalAdminTestRunner {

    /**
     * Test by Serhii Perepeliuk.
     * Prerequisites to test for creation of new customer.
     */
    @Test
    public void sampleTest() {
        CustomersPage homepage = loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .filterByEmail(System.getenv("USER_EMAIL"));

        presentationSleep(1);
        String email = System.getenv("USER_EMAIL");

        presentationSleep(2);

    }
}
