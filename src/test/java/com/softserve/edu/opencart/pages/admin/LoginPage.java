package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.Admin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends DashboardRefPart {

    private WebElement username;
    private WebElement password;
    private WebElement loginButton;
    private WebElement forgotPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    //username
    private void initElements() {
        username = driver.findElement(By.id("input-username"));
        password = driver.findElement(By.id("input-password"));
        loginButton = driver.findElement(By.xpath("//button"));
        forgotPassword = driver.findElement(By.xpath("//span/a"));
    }

    public WebElement getUsername() {
        return username;
    }

    public String getUsernameText() {
        return getUsername().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearUsernameField() {
        getUsername().clear();
    }

    public void clickUsernameField() {
        getUsername().click();
    }

    public void setUsername(String username) {
        getUsername().sendKeys(username);
    }

    // password
    public WebElement getPassword() {
        return password;
    }

    public String getPasswordText() {
        return getPassword().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearPasswordField() {
        getPassword().clear();
    }

    public void clickPasswordField() {
        getPassword().click();
    }

    public void setPassword(String password) {
        getPassword().sendKeys(password);
    }

    //Forgotten password
    public WebElement forgotPassword() {
        return forgotPassword;
    }

    public String forgotPasswordText() {
        return forgotPassword().getText();
    }

    public ForgotPasswordAdminPage clickForgotPassword() {
        return new ForgotPasswordAdminPage(driver);
    }

    // loginButton
    public WebElement getLoginButton() {
        return loginButton;
    }

    public String getLoginButtonText() {
        return getLoginButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    // Functional

    private void enterUsername(String username) {
        clickUsernameField();
        clearUsernameField();
        setUsername(username);
    }

    private void enterPassword(String password) {
        clickPasswordField();
        clearPasswordField();
        setPassword(password);
    }

    public void fillLogin(Admin admin) {
        enterUsername(admin.getUsername());
        enterPassword(admin.getPassword());
        clickLoginButton();
    }

    // Business Logic
    //Вертає хоум пейджу після успішного логування
    public HomePage successfulLogin(Admin validAdmin) {
        fillLogin(validAdmin);
        return new HomePage(driver);
    }

    //Вертає пейджу неуспішоного логування
    public UnsuccessfulLoginPage unsuccessfulLoginPage(Admin invalidAdmin) {
        fillLogin(invalidAdmin);
        return new UnsuccessfulLoginPage(driver);
    }
}
