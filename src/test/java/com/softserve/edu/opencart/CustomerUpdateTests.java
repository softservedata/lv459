package com.softserve.edu.opencart;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Testing function to update Customers details via main site Opencart page.
 * Prerequisites: Customer with USER_EMAIL and USER_PASSWORD is present in DB.
 *     Prerequisites are made by AdminPanel class methods.
 */
public class CustomerUpdateTests
        extends LocalTestRunnerCustomerUpdate {

    public String newPass = "password";

    /**
     * Updating Last Name of Customer
     * @throws Exception
     */
    @Test
    public void tc11updateLastNameFieldTest() throws Exception{

        System.out.println("Demonstration : Test Case 11...");

        String newLastName = "New Last Name";
        // Log in as Customer
        super.loginCustomer(USER_EMAIL , USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Edit Lastname Field
        driver.findElement(By.cssSelector("input[name='lastname']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).clear();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(newLastName);

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Search and assert message element
        Assert.assertEquals("Success: Your account has been successfully updated." ,
                            driver.findElement(By.cssSelector("div.alert.alert-success")).getText());

        //Log out customer
        super.logOutCustomer();

        //Log in customer
        super.loginCustomer(USER_EMAIL, USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Assert amended Last Name Field
        Assert.assertEquals(newLastName ,
            driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value"));
    }

    /**
     * Updating Customer's password
     * @throws Exception
     */
    @Test
    public void tc12updatePasswordFieldTest () throws Exception{

        System.out.println("Demonstration : Test Case 12...");

        // Login as Customer
        super.loginCustomer(USER_EMAIL , USER_PASSWORD);

        // Click Change your password link
        driver.findElement(By.cssSelector("#content a[href*='account/password']")).click();

        // Edit Password Field
        driver.findElement(By.cssSelector("input[name='password']")).click();
        driver.findElement(By.cssSelector("input[name='password']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(newPass);

        //Edit Confirm password field
        driver.findElement(By.cssSelector("input[name='confirm']")).click();
        driver.findElement(By.cssSelector("input[name='confirm']")).clear();
        driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys(newPass);

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //Assertion:
        // Search message element
        //        Assert.assertEquals("Success: Your account has been successfully updated." ,
        //                            driver.findElement(By.cssSelector("i.fa.fa-check-circle")).getText());

        //Log out customer
        super.logOutCustomer();

        // Trying to log in with new password
        super.loginCustomer(USER_EMAIL, newPass);

        // Assert if Customer can login
        Assert.assertTrue(isCustomerLogined());
    }

    /**
     * Updating Customer's address
     * @throws Exception
     */
    @Test
    public void tc13updateAddressFieldTest () throws Exception{

        System.out.println("Demonstration : Test Case 13...");

        // Login as Customer
        super.loginCustomer(USER_EMAIL , USER_PASSWORD);
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click your address book entries link
        driver.findElement(By.cssSelector("#content a[href*='account/address']")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click Change your address book entries link
        driver.findElement(By.cssSelector("#content a[href*='account/address/edit']")).click();

        // Edit City Field
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        driver.findElement(By.cssSelector("input#input-city.form-control")).click();
        driver.findElement(By.cssSelector("input#input-city.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-city.form-control")).sendKeys("New Lemberg");

        //Edit Address 1 field
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        driver.findElement(By.cssSelector("input#input-address-1.form-control")).click();
        driver.findElement(By.cssSelector("input#input-address-1.form-control")).clear();
        driver.findElement(By.cssSelector("input#input-address-1.form-control")).sendKeys("New Street");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        // Click "Continue" button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

//        ("//div[@id='content']//input[@class='btn btn-primary']" by xpath

        Assert.assertEquals("Your address has been successfully updated" ,
                    driver.findElement(By.cssSelector("div.alert.alert-success")).getText());
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Log out customer
        super.logOutCustomer();

        // Log in customer
        super.loginCustomer(USER_EMAIL, USER_PASSWORD);

        // Click your address book entries link
//        driver.findElement(By.cssSelector("#content a[href*='account/account']")).click();
        driver.findElement(By.cssSelector("#content a[href*='account/address']")).click();

        // Assert if address book amended.
        String address = driver.findElement(By.xpath(
            "//div[@id ='content']//td[@class ='text-left']")).getAttribute("innerText");

        System.out.println(address);

        String amendedAddress = driver.findElement(By.xpath(
                "//div[@id ='content']//td[@class ='text-left']")).getText();

        // Getting text with break lines. Converting to line and assertion.
        String[] trimmedText = amendedAddress.split("\n");
        boolean newCity = false;
        boolean newStreet = false;

        for (String str : trimmedText) {
            if (str.equals("New Lemberg")) {
               newCity = true;
            }
            if (str.equals("New Street")) {
                newStreet = true;
            }
        }
        Assert.assertTrue(newCity);
        Assert.assertTrue(newStreet);

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }
}
