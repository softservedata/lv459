package com.softserve.edu.opencart.pages.admin;

import com.softserve.edu.opencart.data.IUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CustomersContainer {

    private boolean customerNoResults = false;
    private List<WebElement> customersTable;
    private List<CustomersComponent> customersList = new ArrayList<>();
    private WebElement table;

    public CustomersContainer(WebElement table) {
        this.table = table;
        initElements();
    }

    private void initElements() {
        // to find table for container
        //        .findElement(By.cssSelector(
        //        "table.table.table-bordered.table-hover")));

        // To be realised later - List of  Customers

        // Init table rows
        //        ("table.table.table-bordered.table-hover")
        customersTable = table.findElements(By.cssSelector("tbody > tr"));
        customerNoResults =
                customersTable.get(0).getText().equals("No results!");

        // init customers list as CustomerContainer
        if (!customerNoResults) {
            for (int i = 0; i < customersTable.size(); i++) {
                customersList.add(new CustomersComponent
                                     (customersTable.get(i)));
            }
        }
        System.out.println("customerNoResults " + customerNoResults);
        System.out.println("customersTable " + customersTable.toString());

    }

    // create list of Customer components
    private List<CustomersComponent> customersListInit(
            List<WebElement> webElementList) {

        if (!isCustomerNoResults()) {
            WebElement current;
            for (int i = 0; i < customersTable.size(); i++) {
                current = customersTable.get(i);
            }

        }
        return null;
    }

    public boolean isCustomerNoResults() {
        return customerNoResults;
    }

    public List<CustomersComponent> getCustomersList() {
        return customersList;
    }


}
