//package com.softserve.edu.opencart.pages.admin.catalog;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class DiscountEditProductPage extends EditProductPage {
//	
//	private WebDriver driver;
//	private WebElement addNewDiscauntButton;
//	
//	public DiscountEditProductPage(WebDriver driver) {
//		super(driver);
//        initElements();
//	}
//	
//	private void initElement() {
//        addNewDiscauntButton =  driver.findElement(By.xpath(ADD_NEW_ROW_INTO_TABLE));
//    }
//
//    private void clickAddNewDiscountButton() {
//        addNewDiscauntButton.click();
//    }
//
//    private DiscountTableComponent addDiscountTableComponent() {
//        clickAddNewDiscountButton();
//        return new DiscountTableComponent(driver);
//    }
//
//    private DiscountTableComponent getLastDiscountTableComponent() {
//        return new DiscountTableComponent(driver);
//    }
//
//    public void addNewDiscount(Discount discount) {
//        addDiscountTableComponent().fillInAllFields(discount);
//        clickSaveButton();
//    }
//
//    public void deleteLastDiscountTableComponent() {
//        getLastDiscountTableComponent().deleteComponent();
//        clickSaveButton();
//    }
//
//}
