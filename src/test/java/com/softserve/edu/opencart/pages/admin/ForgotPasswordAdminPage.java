package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.account.LoginPage;
import com.softserve.edu.opencart.pages.admin.common.DashboardRefPart;

public class ForgotPasswordAdminPage extends DashboardRefPart {

    private WebElement forgotPasswordHeader;
    private WebElement email;
    private WebElement resetButton;
    private WebElement cancelButton;

    public ForgotPasswordAdminPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        forgotPasswordHeader = driver.findElement(By.xpath("//div[@class='panel-heading']"));
        email = driver.findElement(By.id("input-email"));
        resetButton = driver.findElement(By.xpath("//button"));
        cancelButton = driver.findElement(By.xpath("//*[@class='btn btn-default']"));
    }

    // Page Object

    public WebElement getForgotPasswordHeader() {
        return forgotPasswordHeader;
    }

    public String forgotPasswordHeaderText() {
        return getForgotPasswordHeader().getText();
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }

    public void clickResetButton() {
        getResetButton().click();
    }

    public WebElement getEmail() {
        return email;
    }

    public String getEmailText() {
        return getEmail().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearEmailField() {
        getEmail().clear();
    }

    public void clickEmailField() {
        getEmail().click();
    }

    public void setEmail(String email) {
        getEmail().sendKeys(email);
    }

    // Functional
    public void enterEmail(String email) {
        clickEmailField();
        clearEmailField();
        setEmail(email);
    }

    // Business Logic
    public LoginPage clickCancelButton() {
        getCancelButton().click();
        return new LoginPage(driver);
    }

}