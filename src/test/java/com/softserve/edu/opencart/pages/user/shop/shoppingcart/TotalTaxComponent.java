package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalTaxComponent {

   // protected WebElement productLayout;

    private WebElement Sub_Total;
    private WebElement Eco_Tax;
    private WebElement Vat;
    private WebElement Total;

    ///????????????????????????????????????????????????????????
    protected WebDriver driver;  // What I should to use (driver or productLayout)

    public TotalTaxComponent(WebDriver driver) {

        this.driver = driver;
        initElements();
    }

    private void initElements(){

        Sub_Total = driver.findElement(By.xpath("//strong[text()='Sub-Total:']/../following-sibling::td"));
        Eco_Tax = driver.findElement(By.xpath("//strong[text()='Eco Tax (-2.00):']/../following-sibling::td"));
        Vat = driver.findElement(By.xpath("//strong[text()='VAT (20%):']/../following-sibling::td"));
        Total = driver.findElement(By.xpath("//strong[text()='Total:']/../following-sibling::td"));
    }


    //Page Object

   /* public WebElement getProductLayout() {
        return productLayout;
    }*/

    public WebElement getSubTotal(){
        return Sub_Total;
    }

    public String getSubTotalText(){
        return getSubTotal().getText();
    }

    public WebElement getEcoTax(){
        return Eco_Tax;
    }

    public String getEcoTaxText(){
        return getEcoTax().getText();
    }

    public WebElement getVat() {
        return Vat;
    }

    public String getVatText(){
        return getVat().getText();
    }

    public WebElement getTotal() {
        return Total;
    }

    public String getTotalText(){
        return getTotal().getText();
    }

    //Functional

    //Business logic
}
