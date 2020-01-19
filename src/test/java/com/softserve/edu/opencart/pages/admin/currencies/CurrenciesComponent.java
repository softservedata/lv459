package com.softserve.edu.opencart.pages.admin.currencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrenciesComponent {
    WebDriver driver;

    private WebElement productLayout;

    private WebElement checkBox;
    private WebElement title;
    private WebElement code;
    private WebElement value;
    private WebElement date;
    private WebElement editButton;

    public CurrenciesComponent(WebElement productLayout) {
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements() {
        checkBox = productLayout.findElement(By.xpath("//input[@name='selected[]']"));
        title = productLayout.findElement(By.xpath("//tbody/tr/td[2]"));
        code = productLayout.findElement(By.xpath("//tbody/tr/td[3]"));
        value = productLayout.findElement(By.xpath("//tbody/tr/td[4]"));
        date = productLayout.findElement(By.xpath("//tbody/tr/td[5]"));
        editButton = productLayout.findElement(By.xpath("//*[@data-original-title='Edit']"));
    }

    public WebElement getProductLayout() {
        return productLayout;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public CurrenciesPage clickCheckBox(){
        getCheckBox().click();
        return new CurrenciesPage(driver);
    }

    public WebElement getTitle() {
        return title;
    }

    public String getTitleText() {
        return getTitle().getText();
    }

    public WebElement getCode() {
        return code;
    }

    public WebElement getValue() {
        return value;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getEditButton() {
        return editButton;
    }

    public EditCurrenciesPage clickEditButton(){
        getEditButton().click();
        return new EditCurrenciesPage(driver);
    }

}
