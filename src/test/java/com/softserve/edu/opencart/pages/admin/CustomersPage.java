package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class CustomersPage extends LeftMenuPart {

    private WebElement header;
    private WebElement footer;
    private WebElement deleteButton;
    private WebElement filterByEmailField;
    private WebElement filterButton;
    private CustomersContainer customersList;

    /**
     * Customers page in OpenCart_Admin.
     * @param driver
     */
    public CustomersPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        // init elements
        deleteButton = driver.findElement(By.cssSelector("button.btn.btn-danger"));
        filterByEmailField = driver.findElement(By.cssSelector("input#input-email"));
        filterButton = driver.findElement(By.cssSelector("button#button-filter"));

        //TODO CustomersContainer and CustomersComponent
        // table with results
        //        ("table.table.table-bordered.table-hover")

        // results
        // <td class="text-center">
        // <input type="checkbox" name="selected[]" value="71">
        // </td> ...


        // no results
        //        <td class="text-center" colspan="8">No results!</td>

    }
}
