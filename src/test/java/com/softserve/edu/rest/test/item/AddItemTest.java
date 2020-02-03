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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public void verifyAddItem(User user) {
        logger.info("LoginPositiveTest AddItem START, user = " + user);
        logger.debug("LoginPositiveTest started!");
        Item item = ItemRepository.getDefaultItemIndex0();
        // prerequisites - run test as admin / run test as user?
        UserService service = new GuestService()
                .successfulUserLogin(user)
                //                .successfulAdminLogin(user)
                ;

        logger.info("We've got token = " + service.getToken());

        //        service.getItemByIndex("0");
        service.postNewItemByIndex(item)
               .getItemByIndex(item);

        //
        //Steps

        //
        //Check

        //
        //Steps

        logger.debug("AddItemPositiveTest finished!");
        logger.info("AddItemPositiveTest DONE, user = " + user + "item = " + item);
    }
}