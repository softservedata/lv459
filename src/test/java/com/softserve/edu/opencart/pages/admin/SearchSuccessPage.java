package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.WebDriver;

public class SearchSuccessPage extends SearchCriteriaPartTop {

    private UsersContainerComponent usersContainerComponent;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        usersContainerComponent = new UsersContainerComponent(driver);
    }
    
    public UsersContainerComponent getUserContainer() {
        return usersContainerComponent;
    }

    // Page Object

    // firstNameField

    // Functional

    // Business Logic
}
