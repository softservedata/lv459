package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
import com.softserve.edu.rest.services.UserService;
import com.softserve.edu.rest.test.RestTestRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateUpdateItemsTest extends RestTestRunner {
    public static final Logger logger = LoggerFactory.getLogger(CreateUpdateItemsTest.class);

    @DataProvider
    public Object[][] correctUser() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin1(), ItemRepository.getBook(), ItemRepository.getCopybook(),
                ItemRepository.getBook2(), ItemRepository.getBook2()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyIsItemAdded(User admin, Item book, Item copybook, Item book2, Item copybook2) {
        //
        // Step
        AdminService adminService = loadApplication()
                .resetServiceToInitialState()
                .successfulAdminLogin(admin);
        //
        // Check
        logger.info("Expected result: " + UserRepository.getAdmin1());
        logger.info("Actual result: " + adminService.toString());
        Assert.assertTrue(adminService.toString().equals(UserRepository.getAdmin1().toString()));

        //AdminService newAdminService = adminService.getAllItems();
       // logger.info("Actual result: " + newAdminService.toString());
/*        logger.info("Expected result: " + book.toString());
        logger.info("Actual result: " + copybook.toString());*/
        adminService.logout();

    }
}