package com.softserve.edu.opencart.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UsersContainerComponent {

    private final String USERS_COMPONENT_CSSSELECTOR = ".table.table-bordered.table-hover tbody tr";
    protected WebDriver driver;
    //
    private List<UserComponent> userComponents;

    public UsersContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        userComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(USERS_COMPONENT_CSSSELECTOR))) {
            userComponents.add(new UserComponent(driver, current));
        }
    }

    // Page Object

    // productComponents
    public List<UserComponent> getUserComponents() {

        return userComponents;
    }

    // Functional

//    public List<String> getUserComponentNames()
//    {
//        List<String> productComponentNames = new ArrayList<>();
//        for (UserComponent current : getUserComponents())
//        {
//            productComponentNames.add(current.getNameText());
//        }
//        return productComponentNames;
//    }

//    protected ProductComponent getUserComponentByName(String productName)
//    {
//        ProductComponent result = null;
//        for (UserComponent current : getUserComponents())
//        {
//            if (current.getNameText().toLowerCase()
//                    .equals(productName.toLowerCase()))
//            {
//                result = current;
//                break;
//            }
//        }
//        if (result == null)
//        {
//            // TODO Develop Custom Exception
//            // Use String.format()
//            throw new RuntimeException("ProductName: " + productName + " not Found.");
//        }
//        return result;
//    }
}
