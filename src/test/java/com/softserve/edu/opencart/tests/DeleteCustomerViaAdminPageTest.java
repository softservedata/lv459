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
        CustomersPage homepage = loadApplication()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage();

        presentationSleep(2);

    }
}
