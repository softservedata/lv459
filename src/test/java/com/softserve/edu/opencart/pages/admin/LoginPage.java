package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends DashboardRefPart{

    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";

    private WebElement username;
    private WebElement password;
    private WebElement loginButton;
    private WebElement forgotPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    //username
    private void initElements(){
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

    private void enterEmail(String username) {
        clickUsernameField();
        setUsername(username);
        clearUsernameField();
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

    public MainPage successfulLogin(Admin validAdmin){
        fillLogin(validAdmin);
        return new MainPage(driver);
    }

    public UnsuccessfulLoginPage unsuccessfulLoginPage(Admin invalidAdmin){
        fillLogin(invalidAdmin);
        return new UnsuccessfulLoginPage(driver);
    }
}
