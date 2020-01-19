package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditUserPage extends MenuPart {
    private WebElement statusSelect;
    private WebElement saveButton;

    public EditUserPage(WebDriver driver) {
        super(driver);
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

    public void setStatus(String status) {
        Select select = new Select(getStatusSelect());
        select.selectByValue(status);
    }
    
    public EditUserSuccessPage changeUserStatus(String status) {
        setStatus(status);
        clickSaveButton();
        return new EditUserSuccessPage(driver);
    }

}
