package com.softserve.edu.opencart.pages.admin.currencies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrenciesComponent {
    WebDriver driver;

    private WebElement component;

    private WebElement checkBox;
    private WebElement title;
    private WebElement code;
    private WebElement value;
    private WebElement date;
    private WebElement editButton;

    public CurrenciesComponent(WebElement component) {
        this.component = component;
        initElements();
    }

    private void initElements() {
        checkBox = component.findElement(By.xpath(".//input[@name='selected[]']"));
        title = component.findElement(By.xpath("./td[2]"));
        code = component.findElement(By.xpath("./td[3]"));
        value = component.findElement(By.xpath("./td[4]"));
        date = component.findElement(By.xpath("./td[5]"));//const!!!!!!!!!!
        editButton = component.findElement(By.xpath(".//a[@data-original-title='Edit']"));
    }

    public WebElement getProductComponent() {
        return component;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public void clickCheckBox(){
        getCheckBox().click();
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
