package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserComponent {

    private WebDriver driver;
    private WebElement userLayout;
    private WebElement email;
    private WebElement editButton;

    public UserComponent(WebDriver driver, WebElement userLayout) {
        this.userLayout = userLayout;
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        editButton = userLayout.findElement(By.cssSelector(".text-right a.btn"));
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public void clickEditButton() {
        getEditButton().click();
    }

    public EditUserPage editUser() {
        clickEditButton();
        return new EditUserPage(driver);
    }
}
