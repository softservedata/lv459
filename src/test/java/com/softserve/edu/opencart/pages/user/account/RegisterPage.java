package com.softserve.edu.opencart.pages.user.account;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * Page with mandatory and not-mandatory fields to create new customer.
 */
public class RegisterPage extends AccountSidebarGuestPart {

    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement telephone;
    private WebElement fax;
    private WebElement company;
    private WebElement address1;
    private WebElement address2;
    private WebElement city;
    private WebElement postcode;
    private Select country;
    private Select region;
    private WebElement password;
    private WebElement confirmPassword;
    private WebElement newsletter;
    private WebElement rulesCheckbox;
    private WebElement continueButton;
    List<WebElement> errorsWebElements;

    public RegisterPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements

        firstName = driver.findElement(By.id("input-firstname"));
        lastName = driver.findElement(By.id("input-lastname"));
        email = driver.findElement(By.id("input-email"));
        telephone = driver.findElement(By.id("input-telephone"));
        fax = driver.findElement(By.id("input-fax"));
        company = driver.findElement(By.id("input-company"));
        address1 = driver.findElement(By.id("input-address-1"));
        address2 = driver.findElement(By.id("input-address-2"));
        city = driver.findElement(By.id("input-city"));
        postcode = driver.findElement(By.id("input-postcode"));
        country = new Select(
                ((driver).findElement(By.id("input-country"))));
        region = new Select(
                ((driver).findElement(By.id("input-zone"))));
        password = driver.findElement(By.id("input-password"));
        confirmPassword = driver.findElement(By.id("input-confirm"));
        rulesCheckbox = driver.findElement(By.name("agree"));
        continueButton =
                driver.findElement(By.xpath("//input[@value='Continue']"));
        errorsWebElements =
                driver.findElements(By.cssSelector("div.text-danger"));
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

    //
    //Company field
    public void clickCompany() {
        company.click();
    }

    public void clearCompany() {
        company.clear();
    }

    public String getCompanyText() {
        return company.getText();
    }

    public void sendCompanyKeys(String chars) {
        company.sendKeys(chars);
    }

    public WebElement getCompany() {
        return company;
    }

    //
    //Address1 field
    public void clickAddress1() {
        address1.click();
    }

    public void clearAddress1() {
        address1.clear();
    }

    public String getAddress1Text() {
        return address1.getText();
    }

    public void sendAddress1Keys(String chars) {
        address1.sendKeys(chars);
    }

    public WebElement getAddress1() {
        return address1;
    }

    //
    //Address2 field
    public void clickAddress2() {
        address2.click();
    }

    public void clearAddress2() {
        address2.clear();
    }

    public String getAddress2Text() {
        return address2.getText();
    }

    public void sendAddress2Keys(String chars) {
        address2.sendKeys(chars);
    }

    public WebElement getAddress2() {
        return address2;
    }

    //
    //City field
    public void clickCity() {
        city.click();
    }

    public void clearCity() {
        city.clear();
    }

    public String getCityText() {
        return city.getText();
    }

    public void sendCityKeys(String chars) {
        city.sendKeys(chars);
    }

    public WebElement getCity() {
        return city;
    }

    //
    //Postcode field
    public void clickPostcode() {
        postcode.click();
    }

    public void clearPostcode() {
        postcode.clear();
    }

    public String getPostcodeText() {
        return postcode.getText();
    }

    public void sendPostcodeKeys(String chars) {
        postcode.sendKeys(chars);
    }

    public WebElement getPostcode() {
        return postcode;
    }

    //
    //Country field
    public List<WebElement> getCountryOptions() {
        return country.getOptions();
    }

    public void selectCountryByValue(String chars) {
        country.selectByValue(chars);
    }

    public Select getCountry() {
        return country;
    }

    //Region field
    public List<WebElement> getRegionOptions() {
        return region.getOptions();
    }

    public void selectRegionByValue(String chars) {
        region.selectByValue(chars);
    }

    public Select getRegion() {
        return region;
    }

    //
    //Password field
    public void clickPassword() {
        password.click();
    }

    public void clearPassword() {
        password.clear();
    }

    public String getPasswordText() {
        return password.getText();
    }

    public void sendPasswordKeys(String chars) {
        password.sendKeys(chars);
    }

    public WebElement getPassword() {
        return password;
    }

    //
    //Confirm Password field
    public void clickConfirmPassword() {
        confirmPassword.click();
    }

    public void clearConfirmPassword() {
        confirmPassword.clear();
    }

    public void sendConfirmPasswordKeys(String chars) {
        confirmPassword.sendKeys(chars);
    }

    public String getConfirmPasswordText() {
        return confirmPassword.getText();
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    //
    //Rules Checkbox field
    public void clickRulesCheckbox() {
        rulesCheckbox.click();
    }

    public String getRulesCheckboxText() {
        return rulesCheckbox.getText();
    }

    public WebElement getRulesCheckbox() {
        return rulesCheckbox;
    }

    public boolean isCheckedRulesCheckbox() {
        return rulesCheckbox.isSelected();
    }

    //
    //Continue Button
    public void clickContinueButton() {
        continueButton.click();
    }

    public String getContinueButtonText() {
        return continueButton.getText();
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    // Functional

    public void clickClearSendFirstName(IUser customer) {
        clickFirstName();
        clearFirstName();
        sendFirstNameKeys(customer.getFirstName());
    }

    public void clickClearSendLastName(IUser customer) {

        clickLastName();
        clearLastName();
        sendLastNameKeys(customer.getLastName());
    }

    public void clickClearSendEmail(IUser customer) {
        clickEmail();
        clearEmail();
        sendEmailKeys(customer.getEmail());
    }

    public void clickClearSendTelephone(IUser customer) {

        clickTelephone();
        clearTelephone();
        sendTelephoneKeys(customer.getTelephone());
    }

    public void clickClearSendFax(IUser customer) {
        clickFax();
        clearFax();
        sendFaxKeys(customer.getFax());
    }

    public void clickClearSendCompany(IUser customer) {
        clickCompany();
        clearCompany();
        sendCompanyKeys(customer.getCompany());
    }

    public void clickClearSendAddress1(IUser customer) {
        clickAddress1();
        clearAddress1();
        sendAddress1Keys(customer.getAddress1());
    }

    public void clickClearSendAddress2(IUser customer) {
        clickAddress2();
        clearAddress2();
        sendAddress2Keys(customer.getAddress2());
    }

    public void clickClearSendCity(IUser customer) {
        clickCity();
        clearCity();
        sendCityKeys(customer.getCity());
    }

    public void clickClearSendPostcode(IUser customer) {
        clickPostcode();
        clearPostcode();
        sendPostcodeKeys(customer.getPostCode());
    }

    public void clickClearSendPassword(IUser customer) {
        clickPassword();
        clearPassword();
        sendPasswordKeys(customer.getPassword());
    }

    public void clickClearSendConfirmPassword(IUser customer) {
        clickConfirmPassword();
        clearConfirmPassword();
        sendConfirmPasswordKeys(customer.getPassword());
    }

    public void fillFormCreateCustomer(IUser customer) {
        clickClearSendFirstName(customer);
        clickClearSendLastName(customer);
        clickClearSendEmail(customer);
        clickClearSendTelephone(customer);
        clickClearSendFax(customer);
        clickClearSendCompany(customer);
        clickClearSendAddress1(customer);
        clickClearSendAddress2(customer);
        clickClearSendCity(customer);
        clickClearSendPostcode(customer);
        country.selectByValue((customer.getCountry()));
        region.selectByValue((customer.getRegionState()));
        clickClearSendPassword(customer);
        clickClearSendConfirmPassword(customer);
        clickRulesCheckbox();
        clickContinueButton();
    }

    public List <String> getErrorMessages (){

        List<String> current = new ArrayList<>();

        if (errorsWebElements!=null){
            for (int i = 0; i < errorsWebElements.size(); i++){
                current.add(errorsWebElements.get(i).getText());
            }
        }
        return current;

    }
    // Business Logic

    public RegisterPage fillInvalidCustomerDetails(IUser customer) {
        fillFormCreateCustomer(customer);
        return new RegisterPage(driver);
    }

    public CustomerCreatedPage fillValidCustomerDetails(IUser customer) {
        fillFormCreateCustomer(customer);
        return new CustomerCreatedPage(driver);
    }

}