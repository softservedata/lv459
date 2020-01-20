package com.softserve.edu.opencart.pages.user.shop;

import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SamsungSyncMaster941BWPage extends BreadCrumbPart {

    private WebElement title;

    public SamsungSyncMaster941BWPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        title = driver.findElement(By.xpath("//h1[contains(text(), 'Samsung SyncMaster 941BW')]"));
    }

    //Page Object

    // get Title
    public WebElement getTitle(){
        return title;
    }

    public String getTitleText(){
        return title.toString();
    }

    //Functional

    //Business Logic
}
