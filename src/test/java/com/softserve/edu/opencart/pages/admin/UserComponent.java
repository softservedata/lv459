package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.WebElement;

public class UserComponent {
    private WebElement userLayout; 
    
    public UserComponent(WebElement userLayout) {
        this.userLayout = userLayout;
        initElements();
    }
    
    private void initElements() {
        // init elements
    }
}
