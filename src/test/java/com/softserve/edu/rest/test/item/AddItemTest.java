package com.softserve.edu.rest.test.item;

import com.softserve.edu.rest.data.Item;
import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.data.UserRepository;
import com.softserve.edu.rest.services.AdminService;
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
    // org.slf4j.LoggerFactory
    //public final Logger logger = LoggerFactory.getLogger(this.getClass());

    @DataProvider
    public Object[][] correctAdmin() {
        //logger.info("@DataProvider correctUser() DONE");
        return new Object[][]{
                {UserRepository.getAdmin()},
                };
    }

    @Test(dataProvider = "correctAdmin")
    public void verifyAddItem(User user) {
        logger.info("loginPositiveTest AddItem START, user = " + user);
        logger.debug("loginPositiveTest started!");

        // prerequisites.
        UserService
                service = new GuestService()
                .successfulUserLogin(user)
//                .successfulAdminLogin(user)
                ;

        System.out.println("token = " + service.getToken());

//        service.getItemByIndex("0");
        service.postNewItemByIndex(new Item("0", "new item from idea!"));

        //
        //Steps

        //
        //Check

        //
        //Steps

        //log.debug("loginPositiveTest finished!");
        //logger.info("loginPositiveTest DONE, user = " + user);
    }
}