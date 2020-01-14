package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BreadCrumbPart {

    private ShoppingCartProductContainerComponent shoppingCartProductContainerComponent;
    private CouponCartComponent couponCartComponent;
    private GiftCartComponent giftCartComponent;
    private TotalTaxComponent totalTaxComponent;
    private WebElement ContinueShoppingButton;
    private WebElement CheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

        shoppingCartProductContainerComponent = new ShoppingCartProductContainerComponent(driver);
        couponCartComponent = new CouponCartComponent(driver);
        giftCartComponent = new GiftCartComponent(driver);
        totalTaxComponent = new TotalTaxComponent(driver);
        ContinueShoppingButton = driver.findElement(By.xpath("//div[@id='content']//div[@class='pull-left']"));
        CheckoutButton = driver.findElement(By.xpath("//div[@class='pull-right']"));
    }


    //Page Object


    public ShoppingCartProductContainerComponent getShoppingCartProductContainerComponent(){
        return shoppingCartProductContainerComponent;
    }

    //Functional

    //Business logic

    public CartPage refreshProductOnShoppingCart(Product product){
        shoppingCartProductContainerComponent.clickRefreshButtonByProductName(product);
        return new CartPage(driver);
    }

    public CartEmptyPage deleteProductOnShoppingCart(Product product){
        //?????????????????????
        // видаляти все чи один елемент
        shoppingCartProductContainerComponent.clickDeleteButtonByProductName(product);
        return new CartEmptyPage(driver);
    }
}
