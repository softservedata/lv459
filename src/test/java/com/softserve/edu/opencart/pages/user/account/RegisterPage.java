package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends AccountSidebarGuestPart {

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;
    private WebElement company;
    private WebElement address1;
    private WebElement address2;
    private WebElement city;
    private WebElement postcode;
    private Select country;
    private Select region;
    private WebElement password;
    private WebElement newsletter;
    private WebElement rulesCheckbox;
    private WebElement continueButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        firstName = driver.findElement(By.id("input-firstname"));
        lastName = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        telephone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));
        company = driver.findElement(By.id("input-company"));
        address1 = driver.findElement(By.id("input-address-1"));
        address2 = driver.findElement(By.id("input-address-2"));
        city = driver.findElement(By.id("input-city"));
        postcode = driver.findElement(By.id("input-postcode"));
        country = new Select(
                ((driver).findElement(By.id("input-country"))));
        region = new Select(
                ((driver).findElement(By.id("input-zone"))));
        password = driver.findElement(By.id("input-password"));
        rulesCheckbox = driver.findElement(By.name("agree"));
        continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));

    }

    // Page Object


    // Functional

    // Business Logic

}