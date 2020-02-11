package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.admin.CustomersPage;
import com.softserve.edu.opencart.pages.user.account.CustomerCreatedPage;
import com.softserve.edu.opencart.pages.user.account.RegisterPage;
import com.softserve.edu.opencart.tests.runner.LocalAdminSingleThreadRunner;
import com.softserve.edu.opencart.tools.ListUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class CreateCustomerTest extends LocalAdminSingleThreadRunner {

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
    public void createValidCustomerTest(IUser validCustomer) throws SQLException {

//        prerequisites(validCustomer);
        prerequisitesDeleteByJDBC(validCustomer);

        // Test started ...
        CustomerCreatedPage customerCreated = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(validCustomer);

        Assert.assertTrue(customerCreated.getMessageCreatedText()
                                  .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE));
        // Test finished...

        // Clearing base from test customer
//        prerequisites(validCustomer);
        prerequisitesDeleteByJDBC(validCustomer);
    }

    //    @Test(dataProvider = "getCustomersFromCSV")
    public void createValidCustomersFromCSVTest(IUser validCustomer) {

        prerequisitesDeleteWithPageObject(validCustomer);

        // Test started ...
        CustomerCreatedPage customerCreated = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(validCustomer);

        Assert.assertTrue(customerCreated.getMessageCreatedText()
                                  .equals(CUSTOMER_SUCCESSFULLY_CREATED_MESSAGE));
        // Test finished...

        // Clear base from test customer
        prerequisitesDeleteWithPageObject(validCustomer);
    }

    @Test(dataProvider = "getInvalidCustomer")
    public void createInvalidCustomerTest(IUser invalidCustomer) {

//        prerequisites(invalidCustomer);

        // Test started ...
        RegisterPage customerNotCreated = loadMainPage()
                .gotoRegisterPage()
                .fillInvalidCustomerDetails(invalidCustomer);
        Assert.assertTrue(customerNotCreated.getErrorMessages().size() > 0);

        Assert.assertTrue(customerNotCreated.getErrorMessages().get(0)
                                  .equals(CUSTOMER_FIRSTNAME_ERROR));
        // Test finished...

        // Clear base from test customer.
//        prerequisites(invalidCustomer);
    }

    // from CSV
    //    @Test(dataProvider = "getCustomersFromCSV")
    public void createValidCustomerFromCSVFile(IUser validCustomer) {
        prerequisitesDeleteWithPageObject(validCustomer);

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
        prerequisitesDeleteWithPageObject(validCustomer);

    }

    /**
     * Prerequisites - checks if customer is in the database already and
     * deletes if present. In the end of test - also checks for customers
     * presence and deletes if any.
     */
    private void prerequisitesDeleteWithPageObject(IUser customer) {
        String userEmail = customer.getEmail();
        CustomersPage page = loadAdminPage()
                .successfulLogin(AdminRepo.get().validAdmin())
                .gotoCustomersCustomersPage()
                .deleteCustomer(userEmail);
    }



    //    // TODO prerequisites with Hibernate and JDBC -- JDBC done
    //        prerequisitesHibernate(customer);
    //    /**
    //     * Prerequisites - checks if customer is in the database already and
    //     * deletes if present. In the end of test - also checks for customers
    //     * presence and deletes if any. - by means of Hibernate
    //     */

    private void prerequisitesDeleteByJDBC (IUser user) throws SQLException {
        if (JDBCprerequisitesUtil.prerequisitesFindUser(user)) {
            JDBCprerequisitesUtil.prerequisitesDeleteUser(user);
        }
    }

    // HIBERNATE still TODO  :(
//    //  private static SessionFactory sessionFactory;
//
//    //
//    // Create the SessionFactory from 'hibernate.cfg.xml' file
//    static {
//        try {
//            sessionFactory =
//                    new Configuration().configure().buildSessionFactory();
//        } catch (Throwable e) {
//            // Make sure you lxog the exception, as it might be swallowed
//            System.err.println("SessionFactory creation failed." + ex);
//            throw new ExceptionInInitializerError(ex);
//        }
//    }
//
//    private void prerequisitesHibernate(IUser customer) {
//        Session session = sessionFactory.openSession();
//        try {
//            session.beginTransaction();
//
//            String query = String.format(
//                    "delete * from opencart.oc_customer where email=\"%s\"",
//                    customer.getEmail());
//
////            System.out.println("delete query string = " + query);
//
//            IUser hiby = (IUser)session.get(User.class, customer.getId());
//            session.getTransaction().commit();
//            System.out.println("session getUser.class finished work. User.class find by customer email = " + hiby.getEmail()); //null pointer
//
////            session.delete(customer); // INFO: HHH000114: Handling transient entity in delete processing
////            session.remove(customer); // INFO: HHH000114: Handling transient entity in delete processing
//
//
////            IUser local = session.get(IUser.class, customer.getEmail());
////            System.out.println("local = " + local.getFirstName() + " " + local.getEmail());
////            session.getTransaction().commit();
//
//
//        } finally {
//
//            session.close();
//
//        }
//        System.exit(0);
//
//    }

}
