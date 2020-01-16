package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserComponent {
    private WebElement userLayout;
    private WebElement email;
    private WebElement editButton;
    
    public UserComponent(WebElement userLayout) {
        this.userLayout = userLayout;
        initElements();
    }
    
    private void initElements() {
        editButton = userLayout.findElement(By.cssSelector(".text-right a.btn"));
    }
}
