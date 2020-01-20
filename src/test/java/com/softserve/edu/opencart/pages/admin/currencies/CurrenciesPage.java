package com.softserve.edu.opencart.pages.admin.currencies;

import com.softserve.edu.opencart.data.ICurrency;
import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CurrenciesPage extends LeftMenuPart {

    private CurrenciesContainerComponent currenciesContainerComponent;
    private WebElement refreshButton;
    private WebElement addNewButton;
    private WebElement deleteButton;

    public CurrenciesPage(WebDriver driver) {
        super(driver);
        initElements();
    }


    private void initElements() {
        currenciesContainerComponent = new CurrenciesContainerComponent(driver);
        refreshButton = driver.findElement(By.xpath("//*[@data-original-title='Refresh Currency Values']"));
        addNewButton = driver.findElement(By.xpath("//*[@data-original-title='Add New']"));
        deleteButton = driver.findElement(By.xpath("//*[@data-original-title='Delete']"));
    }

    public WebElement getDeleteButton() {
        return deleteButton;
    }

    public void clickDeleteButton() {
        getDeleteButton().click();
    }

    public WebElement getAddNewButton() {
        return addNewButton;
    }

    public void clickAddNewButton() {
        getAddNewButton().click();
    }

    public WebElement getRefreshButton() {
        return refreshButton;
    }

    public void clickRefreshButton() {
        getRefreshButton().click();
    }


    public CurrenciesContainerComponent getCurrenciesContainerComponent() {
        return currenciesContainerComponent;
    }

    //Business Logic
    public EditCurrenciesPage deleteProductOnShoppingCart(ICurrency currency) {
        currenciesContainerComponent.clickEditButtonByTitle(currency);
        return new EditCurrenciesPage(driver);
    }

    public AddNewCurrecyPage gotoAddNewCurrecyPage (){
        clickAddNewButton();
        return new AddNewCurrecyPage(driver);
    }

}
