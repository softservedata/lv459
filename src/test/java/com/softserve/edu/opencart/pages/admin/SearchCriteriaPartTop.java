package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class SearchCriteriaPartTop extends MenuPart {

    private WebElement criteriaSearchButton;
    private WebElement emailSearchInput;

    public SearchCriteriaPartTop(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        criteriaSearchButton = driver.findElement(By.id("button-filter"));
        emailSearchInput = driver.findElement(By.id("input-email"));
    }

    public WebElement getEmailSearchInput() {
        return emailSearchInput;
    }

    public WebElement getCriteriaSearchButton() {
        return criteriaSearchButton;
    }

    public void clickCriteriaSearchButton() {
        getCriteriaSearchButton().click();
    }

    public void clickEmailSearchInput() {
        getEmailSearchInput().click();
    }

    public void clearEmailSearchInput() {
        getEmailSearchInput().clear();
    }

    public void setEmailSearckInput(String email) {
        getEmailSearchInput().sendKeys(email);
    }

    public void fillEmailSearchInput(String email) {
        clickEmailSearchInput();
        clearEmailSearchInput();
        setEmailSearckInput(email);
    }

    public SearchSuccessPage searchByEmail(String email) {
        fillEmailSearchInput(email);
        clickCriteriaSearchButton();
        return new SearchSuccessPage(driver);
    }
}
