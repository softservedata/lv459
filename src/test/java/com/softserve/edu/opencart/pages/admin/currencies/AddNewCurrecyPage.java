package com.softserve.edu.opencart.pages.admin.currencies;

import com.softserve.edu.opencart.data.ICurrency;
import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCurrecyPage extends LeftMenuPart {

    private WebDriver driver;

    private WebElement saveButton;
    private WebElement cancelButton;

    private WebElement currencyTitle;
    private WebElement currencyCode;
    private WebElement currencySymbolLeft;
    private WebElement currencySymbolRight;
    private WebElement currencyDecimalPlaces;
    private WebElement currencyValue;
    private WebElement currencyStatus;
    private WebElement currencyStatusEnabled;


    public AddNewCurrecyPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        saveButton = driver.findElement(By.xpath("//*[@data-original-title='Save']"));
        cancelButton = driver.findElement(By.xpath("//*[@data-original-title='Cancel']"));
        currencyTitle = driver.findElement(By.id("input-title"));
        currencyCode = driver.findElement(By.id("input-code"));
        currencySymbolLeft = driver.findElement(By.id("input-symbol-left"));
        currencySymbolRight = driver.findElement(By.id("input-symbol-right"));
        currencyDecimalPlaces = driver.findElement(By.id("input-decimal-place"));
        currencyValue = driver.findElement(By.id("input-value"));
        currencyStatus = driver.findElement(By.id("input-status"));
        currencyStatusEnabled = driver.findElement(By.xpath("//*[@id='input-status']/option[@value = '1']"));

    }

    private void clickSaveButton() {
        saveButton.click();
    }

    private void clickTitle() {
        currencyTitle.click();
    }

    private void clearTitle() {
        currencyTitle.clear();
    }

    private void setTitle(String titleField) {
        currencyTitle.sendKeys(titleField);
    }

    private void clickCode() {
        currencyCode.click();
    }

    private void clearCode() {
        currencyCode.clear();
    }

    private void setCode(String codeField) {
        currencyCode.sendKeys(codeField);
    }

    private void clickSymbolLeft() {
        currencySymbolLeft.click();
    }

    private void clearSymbolLeft() {
        currencySymbolLeft.clear();
    }

    private void setSymbolLeft(String symbolLeftField) {
        currencySymbolLeft.sendKeys(symbolLeftField);
    }

    private void clickSymbolRight() {
        currencySymbolRight.click();
    }

    private void clearSymbolRight() {
        currencySymbolRight.clear();
    }

    private void setSymbolRight(String symbolRightField) {
        currencySymbolRight.sendKeys(symbolRightField);
    }

    private void clickDecimalPlace() {
        currencyDecimalPlaces.click();
    }

    private void clearDecimalPlace() {
        currencyDecimalPlaces.clear();
    }

    private void setDecimalPlace(int decimalPlaceField) {
        currencyDecimalPlaces.sendKeys(String.valueOf(decimalPlaceField));
    }

    private void clickValue() {
        currencyValue.click();
    }

    private void clearValue() {
        currencyValue.clear();
    }

    private void setValue(double valueField) {
        currencyValue.sendKeys(String.valueOf(valueField));
    }

    private void clickStatus() {
        currencyStatus.click();
    }

    private void clickCurrencyStatusEnabled() {
        currencyStatusEnabled.click();
    }


    private void setStatus() {
        clickStatus();
        clickCurrencyStatusEnabled();
    }

    private void enterTitle(ICurrency currency) {
        clickTitle();
        clearTitle();
        setTitle(currency.getCurrencyTitle());
    }

    private void enterCode(ICurrency currency) {
        clickCode();
        clearCode();
        setCode(currency.getCurrencyCode());
    }

    private void enterSymbolLeft(ICurrency currency) {
        clickSymbolLeft();
        clearSymbolLeft();
        setSymbolLeft(currency.getCurrencySymbolLeft());
    }

    private void enterSymbolRight(ICurrency currency) {
        clickSymbolRight();
        clearSymbolRight();
        setSymbolRight(currency.getCurrencySymbolRight());
    }

    private void enterDecimalPlace(ICurrency currency) {
        clickDecimalPlace();
        clearDecimalPlace();
        setDecimalPlace(currency.getCurrencyDecimalPlaces());
    }

    private void enterValue(ICurrency currency) {
        clickValue();
        clearValue();
        setValue(currency.getCurrencyValue());
    }

    private void fillInAllFields(ICurrency currency) {
        enterTitle(currency);
        enterCode(currency);
        enterSymbolRight(currency);
        enterDecimalPlace(currency);
        enterValue(currency);
        setStatus();
    }

    public CurrenciesPage addNewCurrency(ICurrency currency) {
        fillInAllFields(currency);
        clickSaveButton();
        return new CurrenciesPage(driver);
    }


}
