package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.GuestService;
import com.softserve.edu.rest.services.UserService;
import com.softserve.edu.rest.test.RestTestRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * speretc
 */

public class AddItemTest extends RestTestRunner {
    public static final Logger logger =
            LoggerFactory.getLogger(AddItemTest.class);

    @DataProvider
    public Object[][] correctAdmin() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin()},
                };
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyPostAddItem(User user) {
        logger.info("AddItemPositiveTest AddItem START, user = " + user);
        logger.debug("AddItemPositiveTest started!");

        Item item = ItemRepository.getDefaultItemIndex0();

        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                .successfulAdminLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        //Steps

        String result = service.postNewItemByIndex(item)
                .getItemByIndex(item);

        //
        //Check
        Assert.assertEquals(item.getItemText(), result);

        //
        //Steps

        logger.debug("AddItemPositiveTest finished!");
        logger.info("AddItemPositiveTest DONE, user = " + user + "item = " + item);
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyPostOverwriteExistingItem(User user) {
        logger.info("OverwriteItemByIndexPositiveTest AddItem START, user = " + user);
        logger.debug("OverwriteItemByIndexPositiveTest started!");

        Item initialItem = ItemRepository.getDefaultItemIndex0();

        Item replacedItem = ItemRepository.getItemIndex1();
        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                .successfulAdminLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        //Steps

        String result = service.postOverwriteItemByIndex(initialItem, replacedItem)
                .getItemByIndex(initialItem);

        //
        //Check
        Assert.assertEquals(replacedItem.getItemText(), result);

        //
        //Steps

        logger.debug("OverwriteItemByIndexPositiveTest finished!");
        logger.info("OverwriteItemByIndexPositiveTest DONE, user = "
                    + user + "item = " + initialItem
                    + "\t" + "replaced by item : " + replacedItem);
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyPutOverwriteExistingItem(User user) {
        logger.info("OverwriteItemByIndexPutPositiveTest AddItem START, user = " + user);
        logger.debug("OverwriteItemByIndexPutPositiveTest started!");

        Item initialItem = ItemRepository.getDefaultItemIndex0();

        Item replacedItem = ItemRepository.getItemIndex1();
        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                .successfulAdminLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        //Steps

        String result = service.postNewItemByIndex(initialItem)
                .putOverwriteItemByIndex(initialItem, replacedItem)
                .getItemByIndex(initialItem);

        //
        //Check
        Assert.assertEquals(replacedItem.getItemText(), result);

        //
        //Steps

        logger.debug("OverwriteItemByIndexPutPositiveTest finished!");
        logger.info("OverwriteItemByIndexPutPositiveTest DONE, user = "
                    + user + "item = " + initialItem
                    + "\t" + "replaced by item : " + replacedItem);
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyDeleteItem(User user) {
        logger.info("DeteleItemByIndexPositiveTest AddItem START, user = " + user);
        logger.debug("DeteleItemByIndexPositiveTest started!");

        Item item = ItemRepository.getDefaultItemIndex0();
        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                .successfulAdminLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        //Steps

        String result = service.postNewItemByIndex(item)
                .deleteItemByIndex(item)
                .getItemByIndex(item)
                ;

        //
        //Check
        Assert.assertEquals(result, null);

        //
        //Steps

        logger.debug("DeteleItemByIndexPositiveTest finished!");
        logger.info("DeteleItemByIndexPositiveTest DONE, user = "
                    + user + "item = " + item);
    }

}