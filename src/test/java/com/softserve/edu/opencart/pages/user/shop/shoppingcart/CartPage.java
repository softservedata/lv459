package com.softserve.edu.opencart.pages.user.shop.shoppingcart;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.shop.wishlist.EmptyWishListPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BreadCrumbPart {

    private ShoppingCartProductContainerComponent shoppingCartProductContainerComponent;
   // private CouponCartComponent couponCartComponent;
   // private GiftCartComponent giftCartComponent;
   // private TotalTaxComponent totalTaxComponent;
    //private WebElement ContinueShoppingButton;
    //private WebElement CheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements(){

        shoppingCartProductContainerComponent = new ShoppingCartProductContainerComponent(driver);
//        couponCartComponent = new CouponCartComponent(driver);
//        giftCartComponent = new GiftCartComponent(driver);
//        totalTaxComponent = new TotalTaxComponent(driver);
//        ContinueShoppingButton = driver.findElement(By.xpath("//div[@id='content']//div[@class='pull-left']"));
//        CheckoutButton = driver.findElement(By.xpath("//div[@class='pull-right']"));
    }


    //Page Object


    public ShoppingCartProductContainerComponent getShoppingCartProductContainerComponent(){
        return shoppingCartProductContainerComponent;
    }

   /* public CouponCartComponent getCouponCartComponent(){
        return couponCartComponent;
    }

    public GiftCartComponent getGiftCartComponent(){
        return giftCartComponent;
    }
    public TotalTaxComponent getTotalTaxComponent(){
        return totalTaxComponent;
    }

    public WebElement getContinueShoppingButton(){
        return ContinueShoppingButton;
    }

    public void clickContinueShoppingButton(){
        getContinueShoppingButton().click();
    }

    public WebElement getCheckoutButton(){
        return CheckoutButton;
    }

    public void clickCheckoutButton(){
        getCheckoutButton().click();
    }
*/
    //Functional

    //Business logic

    public CartPage refreshProductOnShoppingCart(IProduct product){
        shoppingCartProductContainerComponent.clickRefreshButtonByProductName(product);
        return new CartPage(driver);
    }

    public CartEmptyPage deleteProductOnShoppingCart(IProduct product){
        shoppingCartProductContainerComponent.clickDeleteButtonByProductName(product);
        return new CartEmptyPage(driver);
    }

    /*public HomePage continueShopping() {
        clickContinueShoppingButton();
        return new HomePage(driver);
    }*/

    public CartEmptyPage removeAllProductsFromCartPage() {
        initElements();
        List<WebElement> closeButtons = driver.findElements(By.cssSelector(".fa.fa-times-circle"));
        //System.out.println(closeButtons.size());
        while (closeButtons.size() > 0) {
            closeButtons.get(0).click();
            closeButtons = driver.findElements(By.cssSelector(".fa.fa-times-circle"));
        }
        return new CartEmptyPage(driver);
    }
}
