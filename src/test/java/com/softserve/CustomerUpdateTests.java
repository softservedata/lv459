package com.softserve;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerUpdateTests
        extends LocalTestRunnerCustomerRegister {

    /*
    Prerequisites - Customer with USER_EMAIL and USER_PASSWORD is present in DB.
     */
    public String newPass = "password";

    public void makePrerequisites() throws Exception {

        // prerequisites - Customer with given email is not in database.

        if (super.checkIfCustomerIsRegistered(USER_EMAIL , USER_PASSWORD)) {
            return;
        } else {

            // Create new Customer

            //Click dropdown list
            driver.findElement(By.className("dropdown")).click();
            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
            driver.findElement(By.cssSelector("a[href*='account/register']"))
                    .click();

            //
            // Filling section "Your personal details"
            driver.findElement(By.id("input-firstname")).clear();
            driver.findElement(By.id("input-firstname")).sendKeys("Se");

            driver.findElement(By.id("input-lastname")).clear();
            driver.findElement(By.id("input-lastname")).sendKeys("Pe");

            driver.findElement(By.id("input-email")).clear();
            driver.findElement(By.id("input-email")).sendKeys(USER_EMAIL);

            driver.findElement(By.id("input-telephone")).clear();
            driver.findElement(By.id("input-telephone")).sendKeys("123");

            driver.findElement(By.id("input-fax")).clear();
            driver.findElement(By.id("input-fax")).sendKeys("456");
            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

            //
            // Filling section "Your address"
            driver.findElement(By.id("input-company")).clear();
            driver.findElement(By.id("input-company")).sendKeys("SoftServe");

            driver.findElement(By.id("input-address-1")).clear();
            driver.findElement(By.id("input-address-1")).sendKeys("abc");

            driver.findElement(By.id("input-address-2")).clear();
            driver.findElement(By.id("input-address-2")).sendKeys("abc2");

            driver.findElement(By.id("input-city")).clear();
            driver.findElement(By.id("input-city")).sendKeys("Lemberg");

            driver.findElement(By.id("input-postcode")).clear();
            driver.findElement(By.id("input-postcode")).sendKeys("79000");

            Select dropDownCountry = new Select(
                    ((ChromeDriver) driver).findElementById("input-country"));
            dropDownCountry.selectByValue("220");

            Select dropDownRegion = new Select(
                    ((ChromeDriver) driver).findElementById("input-zone"));
            dropDownRegion.selectByValue("3493");
            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

            //
            // Filling section "Your Password"
            driver.findElement(By.id("input-password")).clear();
            driver.findElement(By.id("input-password"))
                    .sendKeys(USER_PASSWORD);

            driver.findElement(By.id("input-confirm")).clear();
            driver.findElement(By.id("input-confirm"))
                    .sendKeys(USER_PASSWORD);

            // Checkbox Rules checking
            driver.findElement(By.name("agree")).click();

            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY * 2);

            driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

            // logging out newly created Customer
            if (super.isCustomerLogined()) super.logOutCustomer();
        }
    }

    @Test
    public void tc11updateFirstNameFieldTest () throws Exception{
        makePrerequisites();

        super.loginCustomer(USER_EMAIL , USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Edit Lastname Field
        driver.findElement(By.cssSelector("input[name='lastname']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).clear();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("New Last Name");

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Search message element
//        Assert.assertEquals("Success: Your account has been successfully updated." ,
//                            driver.findElement(By.cssSelector("i.fa.fa-check-circle")).getText());

        super.logOutCustomer();

        super.loginCustomer(USER_EMAIL, USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Asset amended Last Name Field
        Assert.assertEquals("New Last Name" ,
            driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value"));
    }

    @Test
    public void tc12updatePasswordFieldTest () throws Exception{
        // Login as Customer
        makePrerequisites();
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

        super.logOutCustomer();

        // Logging with new password
        super.loginCustomer(USER_EMAIL, newPass);

        // Assert if Customer can login
        Assert.assertTrue(isCustomerLogined());

        // TODO - drop amended password
    }

 // TODO other tests

    private void changePassword (String oldPassword, String newPassword) throws Exception {
        super.loginCustomer(USER_EMAIL , oldPassword);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/password']")).click();


        // Edit Password Field
        driver.findElement(By.cssSelector("input[name='password']")).click();
        driver.findElement(By.cssSelector("input[name='password']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(newPassword);

        // Edit Confirm Password Field
        driver.findElement(By.cssSelector("input[name='confirm']")).click();
        driver.findElement(By.cssSelector("input[name='confirm']")).clear();
        driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys(newPassword);

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Search message element
        //        Assert.assertEquals("Success: Your account has been successfully updated." ,
        //                            driver.findElement(By.cssSelector("i.fa.fa-check-circle")).getText());

        super.logOutCustomer();
    }
}
