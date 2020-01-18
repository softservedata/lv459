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
        editButton = userLayout.findElement(By.cssSelector(".text-right > a"));
        email = userLayout.findElement(By.xpath("//td[contains(text(), '@')]"));
    }

    public WebElement getEditButton() {
        return editButton;
    }
    
    public WebElement getEmailField() {
        return email;
    }

    public void clickEditButton() {
        getEditButton().click();
    }
    
    public String getEmailFieldText() {
        return getEmailField().getText();
    }

    public EditUserPage editUser() {
        clickEditButton();
        return new EditUserPage(driver);
    }
}
