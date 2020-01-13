package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class DashboardRefPart {

    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    protected WebDriver driver;

    private WebElement logo;

    public DashboardRefPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        logo = driver.findElement(By.xpath("//img[@title = 'OpenCart']"));
    }

    public WebElement getDashboardRef() {
        return logo;
    }

    public void clickDashboardRef() {
        getDashboardRef().click();
    }
}
