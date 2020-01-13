package com.softserve.edu.opencart.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.user.common.ProductComponent;

public class UsersContainerComponent {
    //TODO Incorrect selector
    private final String USERS_COMPONENT_CSSSELECTOR = ".product-layout";
    protected WebDriver driver;
    //
    private List<UserComponent> productComponents;

    public UsersContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        productComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(USERS_COMPONENT_CSSSELECTOR)))
        {
            productComponents.add(new UserComponent(current));
        }
    }

    // Page Object

    // productComponents
    public List<UserComponent> getUserComponents()
    {

        return productComponents;
    }

    // Functional

    public int getUserComponentCount()
    {
        return getUserComponents().size();
    }

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
