package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import com.softserve.edu.opencart.pages.user.account.AccountLogoutPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountAmendedPage;
import com.softserve.edu.opencart.tests.LocalAdminSingleThreadRunner;
import com.softserve.edu.opencart.tools.ListUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UpdateCustomersTest extends LocalAdminSingleThreadRunner {

    /**
     * Test by Serhii Perepeliuk.
     * Update of existing customer.
     * Prerequisites to test - customer exists in database.
     */

    @DataProvider
    private Object[][] getValidCustomer() {
        return ListUtils.toMultiArray(UserRepository.get().fromCsv());
//        return new Object[][]{

//                {UserRepository.get().getValidCustomer()}
//        };
    }

    @DataProvider
    private Object[][] getInvalidCustomer() {
        return new Object[][]{
                {UserRepository.get().getInvalidCustomer()}
        };
    }

    @DataProvider
    private Object[][] getCustomersFromCSV() {
        return ListUtils.toMultiArray(UserRepository.get().fromCsv());
    }

    @Test(dataProvider = "getValidCustomer")
    public void updateValidCustomerTest(IUser validCustomer) {

        prerequisites(validCustomer);

        // Test started ...
        MyAccountAmendedPage customerUpdated= loadMainPage()
                .gotoLoginPage()
                .successfulLogin(validCustomer)
                .gotoEditAccountRight()
                .changeFirstNameField(FIRST_NAME_AMEND)
                ;


        Assert.assertTrue(
                customerUpdated.getAlerstSuccessText().equals(CUSTOMER_UPDATED_MESSAGE));


        String amendedFirstName = customerUpdated
                .gotoEditAccountRight()
                .getValueFirstNameText();

        Assert.assertEquals(amendedFirstName, FIRST_NAME_AMEND);

        // Test finished...

        // Clear base from test customer
        afterRequisites(validCustomer);
    }

    /**
     * Prerequisites - checks if customer is in the database already and
     * deletes if present. In the end of test - also checks for customers
     * presence and deletes if any.
     */
    private void prerequisites(IUser customer) {
        if (loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .filterByEmail(customer.getEmail())
                .getContainer()
                .isCustomerNoResults()
            ){
            AccountLogoutPage page = loadMainPage()
                    .gotoRegisterPage()
                    .fillValidCustomerDetails(customer)
                    .gotoHomePage()
                    .logout();
        }

    }

    private void afterRequisites (IUser customer){
        CustomersPage page = loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .deleteCustomer(customer.getEmail());

    }
}
