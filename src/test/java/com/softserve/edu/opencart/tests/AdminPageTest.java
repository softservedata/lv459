package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import com.softserve.edu.opencart.pages.admin.HomePage;
import org.testng.annotations.Test;

public class AdminPageTest extends LocalAdminTestRunner {

    @Test
    public void sampleTest() {
        HomePage homepage = loadApplication().successfulLogin(AdminRepo.getValidAdmin());

        presentationSleep(1);

        CustomersPage customersPage = homepage.gotoCustomersCustomersPage();

        presentationSleep(4);
    }
}
