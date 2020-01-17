package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditUserPage extends MenuPart {

    private WebDriver driver;
    private WebElement statusSelect;
    private WebElement saveButton;

    public EditUserPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        statusSelect = driver.findElement(By.id("input-status"));
        saveButton = driver.findElement(By.cssSelector(".fa.fa-save"));
    }

    public WebElement getStatusSelect() {
        return statusSelect;
    }

    public WebElement getSaveButton() {
        return saveButton;
    }

    public void clickSaveButton() {
        getSaveButton().click();
    }

}
