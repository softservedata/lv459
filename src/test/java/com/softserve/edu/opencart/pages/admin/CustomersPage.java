package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends LeftMenuPart {

    private WebElement header;
    private WebElement homePageContent;
    private WebElement footer;

    public CustomersPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        //        burgerMenuComponent = new LeftMenuPart(driver);
        header = driver.findElement(By.cssSelector(".page-header"));
        homePageContent = driver.findElement(By.cssSelector(
                "#content>.container-fluid")); // contains below elements:
        //        1чотири вікна квадрати
        //        2карта світу + аналітика
        //        3активність і останні замовлення

        footer = driver.findElement(By.id("footer"));


    }
}
