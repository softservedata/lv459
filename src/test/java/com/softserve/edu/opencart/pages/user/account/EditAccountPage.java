package com.softserve.edu.opencart.pages.user.account;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page with Editing account options
 */
public class EditAccountPage extends MyAccountPage {

    private WebElement firstNameField;
    private WebElement emailField;
    private WebElement continueButton;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;


    public EditAccountPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        firstNameField = driver.findElement(By.name("firstname"));
        emailField = driver.findElement(By.id("input-email"));
        firstName = driver.findElement(By.id("input-firstname"));
        lastName = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        telephone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));
        continueButton =
                driver.findElement(By.xpath("//input[@value='Continue']"));
    }

    // Page Object

    //FirstName field
    public void clickFirstName() {
        firstName.click();
    }

    public void clearFirstName() {
        firstName.clear();
    }

    public String getFirstNameText() {
    return firstName.getText();
    }

    public String getValueFirstNameText() {
        return firstName.getAttribute("value");
    }

    public void sendFirstNameKeys(String chars) {
        firstName.sendKeys(chars);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    //
    //LastName field
    public void clickLastName() {
        lastName.click();
    }

    public void clearLastName() {
        lastName.clear();
    }

    public String getLastNameText() {
        return lastName.getText();
    }

    public void sendLastNameKeys(String chars) {
        lastName.sendKeys(chars);
    }

    public WebElement getLastName() {
        return lastName;
    }

    //
    //Email field
    public void clickEmail() {
        email.click();
    }

    public void clearEmail() {
        email.clear();
    }

    public String getEmailText() {
        return email.getText();
    }

    public void sendEmailKeys(String chars) {
        email.sendKeys(chars);
    }

    public WebElement getEmail() {
        return email;
    }

    //
    //Telephone field
    public void clickTelephone() {
        telephone.click();
    }

    public void clearTelephone() {
        telephone.clear();
    }

    public String getTelephoneText() {
        return telephone.getText();
    }

    public void sendTelephoneKeys(String chars) {
        telephone.sendKeys(chars);
    }

    public WebElement getTelephone() {
        return telephone;
    }

    //
    //Fax field
    public void clickFax() {
        fax.click();
    }

    public void clearFax() {
        fax.clear();
    }

    public String getFaxText() {
        return fax.getText();
    }

    public void sendFaxKeys(String chars) {
        fax.sendKeys(chars);
    }

    public WebElement getFax() {
        return fax;
    }


    // Functional

    public void clickClearSendFirstName(String newName) {
        clickFirstName();
        clearFirstName();
        sendFirstNameKeys(newName);
    }

    // firstNameField
    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public String getFirstNameFieldText() {
        return getFirstNameField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public String getEmailFieldText() {
        return getEmailField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearFirstNameField() {
        getFirstNameField().clear();
    }

    public void clickFirstNameField() {
        getFirstNameField().click();
    }

    public void setFirstNameField(String text) {
        getFirstNameField().sendKeys(text);
    }

    // continueButton
    public WebElement getContinueButton() {
        return continueButton;
    }

    public String getContinueButtonText() {
        return getContinueButton().getText();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    // Functional

    // Business Logic

    public MyAccountPage gotoContinue() {
        clickContinueButton();
        return new MyAccountPage(driver);
    }

    public MyAccountAmendedPage clickClearSendLastName(String name) {

        clickLastName();
        clearLastName();
        sendLastNameKeys(name);
        clickContinueButton();

        return new MyAccountAmendedPage (driver);
    }

    // Business Logic

    public MyAccountAmendedPage changeFirstNameField(String newName) {
        clickClearSendFirstName(newName);
        clickContinueButton();
        return new MyAccountAmendedPage(driver);
    }

}