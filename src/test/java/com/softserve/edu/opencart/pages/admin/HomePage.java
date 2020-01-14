package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends MenuPart {

    private BurgerMenuComponent burgerMenuComponent;
    private WebElement header;
    private WebElement homePageContent;
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        burgerMenuComponent = new BurgerMenuComponent(driver);
        header = driver.findElement(By.cssSelector(".page-header"));
        homePageContent = driver.findElement(By.cssSelector("#content>.container-fluid")); // contains below elements:
        //        1чотири вікна квадрати
        //        2карта світу + аналітика
        //        3активність і останні замовлення

        footer = driver.findElement(By.id("footer"));


    }

    // Page Object

    // Functional

    // Business Logic


}
