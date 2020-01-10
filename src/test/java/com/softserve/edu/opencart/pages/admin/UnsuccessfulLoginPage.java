package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UnsuccessfulLoginPage extends LoginPage {

    private WebElement wrongLoginButton;
    private WebElement getCloseWrongLoginAlert;

    public UnsuccessfulLoginPage(WebDriver driver) {
        super(driver);
        initElements();
    }
    private void initElements(){
        wrongLoginButton = driver.findElement(By.xpath("//*[@class = 'alert alert-danger']"));
        getCloseWrongLoginAlert = driver.findElement(By.xpath("//button[@class = 'close']"));
    }


}
