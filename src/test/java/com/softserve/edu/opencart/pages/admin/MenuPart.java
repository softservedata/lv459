package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Duplicated. Can be easily deleted.
 */
public abstract class MenuPart extends DashboardRefPart {

    private WebElement burgerMenu;
    private WebElement bellButton;
    private WebElement topMenuHomeButton;
    private WebElement lifeRingButton;
    private WebElement logOutButton;

    public MenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        burgerMenu = driver.findElement(By.id("button-menu"));
        bellButton = driver.findElement(By.xpath("//ul/li[@class='dropdown']/a/span/../.."));
        topMenuHomeButton = driver.findElement(By.xpath("//ul/li[@class='dropdown']/a/i[@class='fa fa-home fa-lg']/.."));
        lifeRingButton = driver.findElement(By.xpath("//ul/li[@class='dropdown']/a/i[@class='fa fa-life-ring fa-lg']/.."));
        logOutButton = driver.findElement(By.xpath("//ul/li//i[@class='fa fa-sign-out fa-lg']/../.."));
    }

    // Page Object

    public WebElement getBurgerMenu() {
        return burgerMenu;
    }

    public WebElement getBellButton() {
        return bellButton;
    }

    public WebElement getTopMenuHomeButton() {
        return topMenuHomeButton;
    }

    public WebElement getLifeRingButton() {
        return lifeRingButton;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }

    public DropDownComponent getDropDownComponent() {
        return new DropDownComponent(driver, By.id("menu-catalog"));
    }

    public void clickBurgerMenu() {
        getBurgerMenu().click();
    }

    public void clickBellButton() {
        getBellButton().click();
    }

    public void clickTopMenuHomeButton() {
        getTopMenuHomeButton().click();
    }

    public void clickLifeRingButton() {
        getLifeRingButton().click();
    }

    public void clickLogOutButton() {
        getLogOutButton().click();
    }

    public DropDownComponent clickComponent() {
        return new DropDownComponent(driver, By.id("menu-catalog"));
    }


    // Functional

    // Business Logic

    public LoginPage LogOut() {
        clickLogOutButton();
        return new LoginPage(driver);
    }
}
