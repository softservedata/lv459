package com.softserve;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerRegistrationTest extends LocalTestRunnerMainPage {

    @Test
    public void customerRegistrationTest() throws Exception {

        // prerequisites - delete from base user with (USER_EMAIL) email

        //Click dropdown list
        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(DELAY);
        driver.findElement(By.cssSelector("a[href*='account/register']"))
                .click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Se");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email"))
                .sendKeys(USER_EMAIL);

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(DELAY);

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
        Thread.sleep(DELAY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY);
        Thread.sleep(DELAY);

        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        String created = driver.findElement(By.xpath(
                "//h1[contains(text(), 'Your Account Has Been Created!')]"))
                .getText();
        Assert.assertEquals(created, "Your Account Has Been Created!");

        Thread.sleep(DELAY * 2);
    }

    @Test
    public void loginTest() throws Exception {
        if (super.isLogined()) {
            super.logOut();
        }

        driver.findElement(By.cssSelector("a[title='My Account']")).click();

        // Click login Button
        driver.findElement(By.cssSelector("a[href*='account/login']")).click();
        System.out.println("a[href*='account/login'] is found?");
        Thread.sleep(DELAY); // For Presentation Only

        // Steps
        // Type Login Email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email"))
                .sendKeys(USER_EMAIL);
        Thread.sleep(DELAY); // For Presentation Only

        // Type Password
        //driver.findElement(By.id("input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password"))
                .sendKeys(USER_PASSWORD);
        Thread.sleep(DELAY); // For Presentation Only
        //
        // Click Login Button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        Thread.sleep(DELAY * 2);

        if (super.isLogined()) super.logOut();
    }

    @Test
    public void customerRegistrationOneFieldInvalidTest() throws Exception {

        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(DELAY);
        driver.findElement(By.cssSelector("a[href*='account/register']"))
                .click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname"))
                .sendKeys("123456789012345678901234567890123");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email"))
                .sendKeys(USER_EMAIL);

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(DELAY);

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
        Thread.sleep(DELAY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm"))
                .sendKeys(USER_PASSWORD);

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY);

        // Clicking "Continue" button
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'First Name must be between 1 and 32 " +
                "characters!')]"))
                                    .getText(),
                            "First Name must be between 1 and 32 characters!");
    }

    @Test
    public void customerRegistrationAllFieldsInvalidTest() throws Exception {

        driver.findElement(By.className("dropdown")).click();
        Thread.sleep(DELAY);
        driver.findElement(By.cssSelector("a[href*='account/register']"))
                .click();

        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY);

        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'First Name must be between 1 and 32 " +
                "characters!')]"))
                                    .getText(),
                            "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Last Name must be between 1 and 32 " +
                "characters!')]"))
                                    .getText(),
                            "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'E-Mail Address does not appear to be " +
                "valid!')]"))
                                    .getText(),
                            "E-Mail Address does not appear to be valid!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Telephone must be between 3 and 32 " +
                "characters!')]"))
                                    .getText(),
                            "Telephone must be between 3 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Address 1 must be between 3 and 128 " +
                "characters!')]"))
                                    .getText(),
                            "Address 1 must be between 3 and 128 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'City must be between 2 and 128 " +
                "characters!')]"))
                                    .getText(),
                            "City must be between 2 and 128 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Postcode must be between 2 and 10 " +
                "characters!')]"))
                                    .getText(),
                            "Postcode must be between 2 and 10 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Please select a region / state!')]"))
                                    .getText(),
                            "Please select a region / state!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Password must be between 4 and 20 " +
                "characters!')]"))
                                    .getText(),
                            "Password must be between 4 and 20 characters!");

        List<WebElement> list =
                driver.findElements(By.className("text-danger"));

        for (WebElement current : list) {
            System.out.println(current.getText());
        }
    }

    @Test
    public void customerCreateEmailFieldTest() throws Exception {

        driver.findElement(By.className("dropdown")).click();
        driver.findElement(By.cssSelector("a[href*='account/register']"))
                .click();

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        // popup window ??? how to handle?

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a@");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        // popup window ??? how to handle?

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a@a");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
        Assert.assertEquals(
                driver
                        .findElement(
                                By.xpath(
                                        "//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
                        .getText(),
                "E-Mail Address does not appear to be valid!");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a@a.");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
        Assert.assertEquals(
                driver
                        .findElement(
                                By.xpath(
                                        "//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
                        .getText(),
                "E-Mail Address does not appear to be valid!");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a@a.a");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElements(
                By.xpath(
                        "//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
                                    .size(), 0);
    }
}
