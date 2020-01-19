package com.softserve.edu.ukrNet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.opencart.data.EmailStatus;
import com.softserve.edu.opencart.data.IUser;

public class MainEmailPage {

    protected WebDriver driver;
    private WebElement mailWidget;
    private WebElement inputLogin;
    private WebElement inputPassword;
    private WebElement buttonSubmit;

    public MainEmailPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("mail widget")));

        WebElement frame = driver.findElement(By.name("mail widget"));
        driver.switchTo().frame(frame);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (!EmailStatus.get().isLogged()) {
        inputLogin = driver.findElement(By.id("id-input-login"));
        inputPassword = driver.findElement(By.id("id-input-password"));
        buttonSubmit = driver.findElement(By.className("form__submit"));
        }
    }

    public WebElement getMailWidget() {
        return mailWidget;
    }

    public WebElement getInputEmail() {
        return inputLogin;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonSubmit() {
        return buttonSubmit;
    }

    public void clickInputEmail() {
        getInputEmail().click();
    }

    public void clickInputPassword() {
        getInputPassword().click();
    }

    public void clickButtonSubmit() {
        getButtonSubmit().click();
    }

    public void clearInputEmail() {
        getInputEmail().clear();
    }

    public void clearInputPassword() {
        getInputPassword().clear();
    }

    public void setInputEmail(String email) {
        getInputEmail().sendKeys(email);
    }

    public void setInputPassword(String password) {
        getInputPassword().sendKeys(password);
    }

    public void enterEmail(String email) {
        clickInputEmail();
        clearInputEmail();
        setInputEmail(email);
    }

    public void enterPassword(String password) {
        clickInputPassword();
        clearInputPassword();
        setInputPassword(password);
    }

    public void fillLogin(IUser user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickButtonSubmit();
    }

    public MainLoggedPage successfulLogin(IUser validUser) {
        if (!EmailStatus.get().isLogged()) {
            fillLogin(validUser);
        }
        return new MainLoggedPage(driver);
    }

}
