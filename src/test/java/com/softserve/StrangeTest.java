package com.softserve;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StrangeTest {

    @Test
    public void checkPath (){
        System.out.println(this.getClass().getResource("chromedriver"));
        WebDriver driver = new ChromeDriver();
    System.out.println(driver);

    driver.quit();
    }
}
