package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
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
        return new Object[][]{
                {UserRepository.getAdmin1(), ItemRepository.getBook(), ItemRepository.getCopybook(),
                        ItemRepository.getBook2(), ItemRepository.getCopybook2()}
        };
    }

    @Test(dataProvider = "correctUser")
    public void verifyIsItemAdded(User admin, Item book, Item copybook, Item book2, Item copybook2) {
        //
        // Step
        // Adding items "book" and "copybook"
        AdminService addItems = loadApplication()
                .resetServiceToInitialState()
                .successfulAdminLogin(admin)
                .addItem(book)
                .addItem(copybook)
                .getAllItems();

        Assert.assertEquals(addItems.getUserItemByIndex(book), book.getItemText());
        Assert.assertEquals(addItems.getUserItemByIndex(copybook), copybook.getItemText());

        // Updating items "book" to "book2" and "copybook" to "copybook2"
        AdminService updateItems = addItems
                .updateItem(book, book2)
                .updateItem(copybook, copybook2)
                .getAllItems();

        Assert.assertEquals(updateItems.getUserItemByIndex(book2), book2.getItemText());
        Assert.assertEquals(updateItems.getUserItemByIndex(copybook2), copybook2.getItemText());

        // Updating items "book2" and "copybook2"
        AdminService deleteItems = updateItems
                .deleteItem(book2)
                .deleteItem(copybook2)
                .getAllItems();

        Assert.assertEquals(deleteItems.getUserItemByIndex(book2), null);
        Assert.assertEquals(deleteItems.getUserItemByIndex(copybook2), null);

        // Logout
        updateItems.logout();

    }
}