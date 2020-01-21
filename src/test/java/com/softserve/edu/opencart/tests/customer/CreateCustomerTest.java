package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import com.softserve.edu.opencart.pages.user.account.CustomerCreatedPage;
import com.softserve.edu.opencart.pages.user.account.RegisterPage;
import com.softserve.edu.opencart.tests.LocalAdminTestRunner;
import com.softserve.edu.opencart.tools.ListUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateCustomerTest extends LocalAdminTestRunner {

    /**
     * Test by Serhii Perepeliuk.
     * Create valid Customer
     * Create invalid Customer.
     */

    @DataProvider(parallel = true)
    private Object[][] getValidCustomer() {
        return new Object[][]{
                {UserRepository.get().getValidCustomer()}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] getInvalidCustomer() {
        return new Object[][]{
                {UserRepository.get().getInvalidCustomer()},
                {UserRepository.get().getValidCustomer()}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] getCustomersFromCSV() {
        return new Object[][]{
                ListUtils.toMultiArray(UserRepository.get()
                                .fromCsv())
                //                {UserRepository.get().fromCsv()}
        };
    }

    /**
     * Test for creating valid credentional's customer.
     *
     * @param validCustomer
     */
    @Test(dataProvider = "getValidCustomer")
    public void createValidCustomerTest(IUser validCustomer) {

        prerequisites(validCustomer);

        // Test started ...
        CustomerCreatedPage customerCreated = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(validCustomer);

        Assert.assertTrue(customerCreated.getMessageCreatedText()
                                  .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE));
        // Test finished...

        // Clear base from test customer
        prerequisites(validCustomer);
    }

    @Test(dataProvider = "getCustomersFromCSV")
    public void createValidCustomersFromCSVTest(IUser validCustomer) {

        prerequisites(validCustomer);

        // Test started ...
        CustomerCreatedPage customerCreated = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(validCustomer);

        Assert.assertTrue(customerCreated.getMessageCreatedText()
                                  .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE));
        // Test finished...

        // Clear base from test customer
        prerequisites(validCustomer);
    }

    @Test(dataProvider = "getInvalidCustomer")
    public void createInvalidCustomerTest(IUser invalidCustomer) {

        prerequisites(invalidCustomer);

        // Test started ...
        RegisterPage customerNotCreated = loadMainPage()
                .gotoRegisterPage()
                .fillInvalidCustomerDetails(invalidCustomer);
        Assert.assertTrue(customerNotCreated.getErrorMessages().size() > 0);

        Assert.assertTrue(customerNotCreated.getErrorMessages().get(0)
                                  .equals(CUSTOMER_FIRSTNAME_ERROR));
        // Test finished...

        // Clear base from test customer.
        prerequisites(invalidCustomer);
    }

    // from CSV
    @Test(dataProvider = "getCustomersFromCSV")
    public void createValidCustomerFromCSVFile(IUser validCustomer) {
        prerequisites(validCustomer);

        // Test started ...
        CustomerCreatedPage customerCreated = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(validCustomer);

        Assert.assertTrue(customerCreated.getMessageCreatedText()
                                  .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE));

        boolean assertion = customerCreated.getMessageCreatedText()
                .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE);

        System.out.println("Test finished... " + assertion);

        System.out.println(
                "Customer " + validCustomer.getFirstName() + " is created.");
        // Clear base from test customer
        prerequisites(validCustomer);

    }

    /**
     * Prerequisites - checks if customer is in the database already and
     * deletes if present. In the end of test - also checks for customers
     * presence and deletes if any.
     */
    private void prerequisites(IUser customer) {
        String userEmail = customer.getEmail();
        CustomersPage page = loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .deleteCustomer(userEmail);
    }

}
