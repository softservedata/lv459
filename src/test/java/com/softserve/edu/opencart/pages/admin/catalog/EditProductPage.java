//package com.softserve.edu.opencart.pages.admin.catalog;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
//
//public class EditProductPage extends LeftMenuPart {
//	private WebDriver driver;
//    private WebElement saveButton;
//    private WebElement dataButton;
//    private WebElement discountButton;
//    private WebElement specialButton;
//
//    static final String ADD_NEW_ROW_INTO_TABLE = "//table[@id='discount']//tfoot//button[@class='btn btn-primary']";
//    static final String LAST_ROW_IN_TABLE = "//table[@id='discount']/tbody/tr[last()]";
//
//    public EditProductPage(WebDriver driver) {
//        super(driver);
//        initElements();
//    }
//
//    public void initElements() {
//        saveButton = driver.findElement(By.cssSelector(".pull-right .btn.btn-primary"));
//        dataButton = driver.findElement(By.xpath("//a[contains(text(),'Data')]"));
//        discountButton = driver.findElement(By.xpath("//a[contains(text(),'Discount')]"));
//        specialButton = driver.findElement(By.xpath("//a[contains(text(),'Special')]"));
//    }
//
//
//    protected void clickSaveButton() {
//        saveButton.click();
//    }
//
//    private void clickDataButton() {
//        dataButton.click();
//    }
//
//    private void clickSpecialButton() {
//        specialButton.click();
//    }
//
//    private void clickDiscountButton() {
//        discountButton.click();
//    }
//
//    public DiscountEditProductPage goToDicounteditProductPage() {
//        clickDiscountButton();
//        return new DiscountEditProductPage(driver);
//    }
//
//    public SpecialEditProductPage goToSpecialEditProductPage() {
//        clickSpecialButton();
//        return new SpecialEditProductPage(driver);
//    }
//
//    public DataEditProductPage goToDataEditProductPage() {
//        clickDataButton();
//        return new DataEditProductPage(driver);
//    }
//
//}
