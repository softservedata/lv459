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
                ItemRepository.getBook2(), ItemRepository.getCopybook2()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyIsItemAdded(User admin, Item book, Item copybook, Item book2, Item copybook2) {
        //
        // Step
        AdminService addItems = loadApplication()
                .resetServiceToInitialState()
                .successfulAdminLogin(admin)
                .addItem(book)
                .addItem(copybook)
                .getAllItems();
        // TODO Asserts


        AdminService updateItems = addItems
                .updateItem(book, book2)
                .updateItem(copybook, copybook2)
                .getAllItems();
        // TODO Asserts

        AdminService deleteItems = updateItems
                .deleteItem(book2)
                .deleteItem(copybook2)
                .getAllItems();
        // TODO Asserts


        //
        // Check
/*        logger.info("Expected result: " + UserRepository.getAdmin1());
        logger.info("Actual result: " + adminService.toString());
        Assert.assertTrue(adminService.toString().equals(UserRepository.getAdmin1().toString()));*/

        updateItems.logout();

    }
}