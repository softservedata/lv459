package com.softserve;

import org.junit.Test;

public class SimpleTest extends LocalTestRunnerCustomerRegister{

    @Test
    public void myProbas() throws Exception {
//
        AdminPanel admin = new AdminPanel();
        admin.deleteCustomer(USER_EMAIL);

        System.out.println(String.format("//td[contains(text(), '%s')]/./preceding-sibling::td[@class='text-center']/./input[@name='selected[]']", "lv459"));
    }
}
