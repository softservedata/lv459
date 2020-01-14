package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.WebDriver;

public class SearchSuccessPage extends SearchCriteriaPart {

    private UsersContainerComponent usersContainerComponent;

    public SearchSuccessPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        usersContainerComponent = new UsersContainerComponent(driver);
    }

    // Page Object

    // firstNameField

    // Functional

    // Business Logic
}
