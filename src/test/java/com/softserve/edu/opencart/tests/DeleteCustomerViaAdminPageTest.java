package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import com.softserve.edu.opencart.pages.admin.HomePage;
import org.testng.annotations.Test;

public class DeleteCustomerViaAdminPageTest extends LocalAdminTestRunner {

    @Test
    public void sampleTest() {
        CustomersPage homepage = loadApplication()
                .successfulLogin(AdminRepo.getValidAdmin())
                .gotoCustomersCustomersPage();

        presentationSleep(2);



    }
}
