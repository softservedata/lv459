package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartEmptyPage extends BreadCrumbPart {

    private WebElement Empty_Shopping_Cart_Name;
    private WebElement Empty_Shopping_Cart_Message;
	private WebElement Continue_Button;

    public CartEmptyPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

        Empty_Shopping_Cart_Name = driver.findElement(By.xpath("//h1"));
        Empty_Shopping_Cart_Message = driver.findElement(By.xpath("//div[@id='content']//p"));
        Continue_Button = driver.findElement(By.xpath("//div[@id='content']//a"));
    	

    }

    //Page Object
    
    public WebElement getEmptyShoppingCartName() {
        return Empty_Shopping_Cart_Name;
    }

    public String getEmptyShoppingCartNameText() {
        return getEmptyShoppingCartName().getText();
    }

    public WebElement getEmptyShoppingCartMessage() {
        return Empty_Shopping_Cart_Message;
    }

    public String EmptyShoppingCartMessageText() {
        return getEmptyShoppingCartMessage().getText();
    }

    public WebElement getContinueButton() {
        return Continue_Button;
    }

    public void clickContinueButton(){
        getContinueButton().click();
    }

    
    //Functional

    //Business logic
}
