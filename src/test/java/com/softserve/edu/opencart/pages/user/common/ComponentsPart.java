package com.softserve.edu.opencart.pages.user.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComponentsPart extends TopPart {
    private WebElement monitors;
    public final String MONITORS = "Monitors";

    public ComponentsPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        monitors = driver.findElement(By.xpath("//div[@class='col-sm-3']"
                + "//a[contains(text(), 'Monitors')]"));
    }

    //Page Object

    // get Title
    public WebElement getMonitors() {
        return monitors;
    }

    public String getMonitorsText() {
        return monitors.toString();
    }

    public void clickOnMonitors() {
        getMonitors().click();
    }

    //Functional

    //Business Logic
}
