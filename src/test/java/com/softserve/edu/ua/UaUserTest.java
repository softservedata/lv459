package com.softserve.edu.ua;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UaUserTest extends LocalTestRunnerUa {
    @Test
    public void loginAsUkUser() throws Exception {
        WebElement price = driver.findElement(By.xpath("//a[text()='MacBook']/../following-sibling::p[@class='price']"));

    }

}