package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.ItemRepository;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
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
    public Object[][] user() {
        return new Object[][]{
                {UserRepository.getAdmin(), ItemRepository.getItemIndex1()},
                {UserRepository.getVasya(), ItemRepository.getItemVasya()},
                {UserRepository.getDana(), ItemRepository.getItemDana()},
                };
    }

    @DataProvider
    public Object[][] twoUsers() {
        return new Object[][]{
                {UserRepository.getAdmin(), ItemRepository.getItemIndex1(),
                    UserRepository.getVasya(), ItemRepository.getItemVasya()},
                {UserRepository.getAdmin(), ItemRepository.getItemIndex1(),
                    UserRepository.getDana(), ItemRepository.getItemDana()},
                };
    }

    /**
     * Positive test for adding item via POST service
     * @param user
     */
    @Test(dataProvider = "user") // - BUG HERE - run test as admin - OK / run test as user - FAILS
    public void verifyPostAddItem(User user, Item item) {
        logger.info("AddItemPositiveTest AddItem START, user = " + user);
        logger.debug("AddItemPositiveTest started!");

        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        // Steps
        String result = service
                .postNewItemByIndex(item)
                .getItemByIndex(item);

        //
        // Check
        Assert.assertEquals(item.getItemText(), result);

        //
        // Steps
        logger.debug("AddItemPositiveTest finished!");
        logger.info("AddItemPositiveTest DONE, user = " + user + "item = " + item);
    }

    /**
     * Positive test for updating item via POST service
     * @param user
     */
    @Test(dataProvider = "user") // - BUG HERE - run test as admin - OK / run test as user - FAILS
    public void verifyPostOverwriteExistingItem(User user, Item item) {
        logger.info("OverwriteItemByIndexPositiveTest AddItem START, user = " + user);
        logger.debug("OverwriteItemByIndexPositiveTest started!");

        Item initialItem = item;

        Item replacedItem = ItemRepository.getItemIndex1();
        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        // Steps

        String result =service
                .postOverwriteItemByIndex(initialItem, replacedItem)
                .getItemByIndex(initialItem);

        //
        // Check
        Assert.assertEquals(replacedItem.getItemText(), result);

        //
        // Steps

        logger.debug("OverwriteItemByIndexPositiveTest finished!");
        logger.info("OverwriteItemByIndexPositiveTest DONE, " +
                "user = " + user +
                "item = " + initialItem + "\t" +
                "replaced by item : " + replacedItem);
    }

    /**
     * Positive test for updating item via PUT service
      * @param user
     */
    @Test(dataProvider = "user") // - BUG HERE - run test as admin - OK / run test as user - FAILS
    public void verifyPutOverwriteExistingItem(User user, Item item) {
        logger.info("OverwriteItemByIndexPutPositiveTest AddItem START, user = " + user);
        logger.debug("OverwriteItemByIndexPutPositiveTest started!");

        Item initialItem = item;

        Item replacedItem = ItemRepository.getItemIndex1();
        // prerequisites - run test as admin / run test as user?
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                ;

        //
        // Steps
        String result = service
                        .postNewItemByIndex(initialItem)
                        .putOverwriteItemByIndex(initialItem, replacedItem)
                        .getItemByIndex(initialItem);

        //
        // Check
        Assert.assertEquals(replacedItem.getItemText(), result);

        //
        // Steps

        logger.debug("OverwriteItemByIndexPutPositiveTest finished!");
        logger.info("OverwriteItemByIndexPutPositiveTest DONE," +
                " user = " + user +
                "item = " + initialItem + "\t" +
                "replaced by item : " + replacedItem);
    }

    /**
     * Positive test for deleting item via DELETE service
     * @param user
     */
    @Test(dataProvider = "user")
    public void verifyDeleteItem(User user, Item item) {
        logger.info("DeleteItemByIndexPositiveTest AddItem START, user = " + user);
        logger.debug("DeleteItemByIndexPositiveTest started!");
        // prerequisites
        // login
        UserService service = new GuestService()
                .successfulUserLogin(user)
                ;
        logger.info("We've got token = " + service.getToken());

        //
        // Step
        String result = service
                .postNewItemByIndex(item)
                .deleteItemByIndex(item)
                .getItemByIndex(item);

        //
        // Check
        Assert.assertEquals(result, null);

        //
        // Step
        logger.debug("DeleteItemByIndexPositiveTest finished!");
        logger.info("DeleteItemByIndexPositiveTest DONE, user = " + user +
                    "item = " + item);
    }

    @Test(dataProvider = "twoUsers")
    public void gettingStrangeUserItem(User user1, Item item1, User user2, Item item2) {
        // prerequisites - login as admin and create two users

        // Steps
        // Login as Vasya and create item

        // Getting item
        String resultVasya = new GuestService()
                .successfulUserLogin(user1)
                .postNewItemByIndex(item1)
                .getItemByIndex(item1)
                ;

        Assert.assertEquals(resultVasya, item1.getItemText());

        // Login as Dana and create item
        String resultDana =  loadApplication()
                .successfulUserLogin(user2)
                .postNewItemByIndex(item2)
                .getItemByIndex(item2);

        Assert.assertEquals(resultDana, item2.getItemText());

        //Assert that it is not possible to get smb else item.
        Assert.assertNotEquals(resultDana, item1.getItemText());
    }

    @Test(dataProvider = "user")
    public void getUserItemByIndex (User user, Item item){
        String result = loadApplication()
                .successfulUserLogin(user)
                .postNewItemByIndex(item)
                .getItemByIndex(item)
                ;

        Assert.assertEquals(result, item.getItemText());

    }

//TODO - finish this test. till now it doesnt work. I'm getting null pointer exception.
//    P.S. updated- doesn't work due to DEFECT in GET, POST, PUT maybe delete with not admin username!!!!
    @Test(dataProvider = "user")
    public void gettingItemAsAdmin(User user, Item item) {

        //prerequisites
        // create user and put user's Item
        prerequisitesCreateItem(user, item);


        // Step: login as admin
        // Step: get user's item by item index and user name
        Object o = loadApplication()
                .successfulUserLogin(user)
                .successfulAdminLogin(user)
                .getUserItemByIndexAkaAdmin(item, user) // doesn't work - null pointer exception, I guess on stage forming url with two path variables
                ;

//        System.out.println("result of test Admin watch items of some user : " + result);
//        Assert.assertEquals(result, itemDana.getItemText());

    }

    private void prerequisitesCreateUser(User user){
        AdminService adminService = new GuestService()
                .successfulUserLogin(UserRepository.getAdmin())
                .successfulAdminLogin(UserRepository.getAdmin())
                .createUser(user);
    }

    private void prerequisitesCreateItem (User user, Item item){
        // login
        UserService userService = new GuestService()
                .successfulUserLogin(user)
                .postNewItemByIndex(item);
    }


}
