package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomersPage extends LeftMenuPart {

    private WebElement header;
    private WebElement footer;
    private WebElement deleteButton;
    private WebElement filterByEmailField;
    private WebElement filterButton;
    private WebElement customersList;
    private CustomersContainer container;

    public CustomersContainer getContainer() {
        return container;
    }

    /**
     * Customers page in OpenCart_Admin.
     *
     * @param driver
     */
    public CustomersPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        // init elements
        deleteButton =
                driver.findElement(By.cssSelector("button.btn.btn-danger"));
        filterByEmailField =
                driver.findElement(By.cssSelector("input#input-email"));
        filterButton =
                driver.findElement(By.cssSelector("button#button-filter"));
        customersList = driver.findElement(
                By.cssSelector("table.table.table-bordered.table-hover"));
        container = new CustomersContainer(customersList);

        //TODO CustomersContainer and CustomersComponent
        // table with results
        //        ("table.table.table-bordered.table-hover")

        // Page Object

    }

    //
    // Field find customer by email
    public WebElement getFilterByEmailField() {
        return filterByEmailField;
    }

    public String getFilterByEmailFieldText() {
        return getFilterByEmailField().getText();
    }

    public void clearFilterByEmailField() {
        filterByEmailField.clear();
    }

    public void clickFilterByEmailField() {
        filterByEmailField.click();
    }

    public void setFilterByEmailField(String customerEmail) {
        filterByEmailField.sendKeys(customerEmail);
    }

    //
    // Delete button

    private String getDeleteButtonText() {
        return deleteButton.getText();
    }

    private void clickDeleteButton() {
        deleteButton.click();
    }

    private WebElement getDeleteButton() {
        return deleteButton;
    }

    //
    // Filter button

    public WebElement getFilterButton() {
        return filterButton;
    }

    public String getFilterButtonText() {
        return getFilterByEmailField().getText();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public CustomersPage filterByEmail(String email) {

        filterByEmailField.click();
        filterByEmailField.clear();
        filterByEmailField.sendKeys(email);
        clickFilterButton();
        return new CustomersPage(driver);

    }

    // Checks checkbox for first position in customers list
    public void selectCheckBox() {
        if (!container.isCustomerNoResults()) {
            container.getCustomersList().get(0).selectCheckBox();
        }
    }

    public void clickConfirmationPopupConfirm() {
        driver.switchTo().alert().accept();
    }

    private CustomersPage clickAndConfirmDeleteCustomer() {
        clickDeleteButton();
        clickConfirmationPopupConfirm();

        return new CustomersPage(driver);
    }

    // Business logic

    public CustomersPage deleteCustomer(String email) {
        filterByEmail(email).clickAndConfirmDeleteCustomer();
    return new CustomersPage(driver);
    }

}


