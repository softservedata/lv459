package com.softserve.edu.opencart.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.IUser;

public class UsersContainerComponent {

    private final String USERS_COMPONENT_CSS_SELECTOR = ".table-hover > tbody > tr";
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
        for (WebElement current : driver.findElements(By.cssSelector(USERS_COMPONENT_CSS_SELECTOR))) {
            userComponents.add(new UserComponent(driver, current));
        }
    }

    // Page Object

    // productComponents
    private List<UserComponent> getUserComponents() {

        return userComponents;
    }

    // Functional

    public UserComponent getUserByEmail(IUser validUser) {
        UserComponent userComponent = null;
        for (UserComponent user : getUserComponents()) {
            if (user.getEmailFieldText().toLowerCase()
                    .equals(validUser.getEmail().toLowerCase())) {
                userComponent = user;
                break;
            }
        }
        return userComponent;
    }
}
