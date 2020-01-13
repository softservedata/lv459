package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulLoginPage extends LoginPage {

    private WebElement wrongLoginAlert;
    private WebElement closeWrongLoginAlertButton;

    public UnsuccessfulLoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements(){
        wrongLoginAlert = driver.findElement(By.xpath("//*[@class = 'alert alert-danger']"));
        closeWrongLoginAlertButton = driver.findElement(By.xpath("//button[@class = 'close']"));
    }

    //TODO
}
