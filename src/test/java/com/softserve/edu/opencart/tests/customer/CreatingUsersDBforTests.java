package com.softserve.edu.opencart.tests.customer;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.pages.user.account.AccountLogoutPage;
import com.softserve.edu.opencart.tests.runner.LocalAdminSingleThreadRunner;

public class CreatingUsersDBforTests extends LocalAdminSingleThreadRunner {


    //// ONLY FOR INITIATION OF DB

    //    @Test
    public void createUser() {

        //        IUser customer = UserRepository.get().getValidCustomer();
        //        IUser customer = UserRepository.get().getBohdanaUser();
        //        IUser customer = UserRepository.get().getCorrectUser();
        //        IUser customer = UserRepository.get().getHahaha(); //
        //        getAdmin(); = getDefault
        //        IUser customer = UserRepository.get().getYuriiUaUser();
        IUser customer = UserRepository.get().getYuriiUkUser();
        AccountLogoutPage page = loadMainPage()
                .gotoRegisterPage()
                .fillValidCustomerDetails(customer)
                .gotoHomePage()
                .logout();
    }
}
