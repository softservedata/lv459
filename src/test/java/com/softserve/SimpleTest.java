package com.softserve;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleTest {

  @Test
  public void registrationNewCustomer() throws Exception {
    //    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //    System.setProperty("webdriver.chrome.driver",
    //                       this.getClass().getResource(Reg
    //                                                   "chromedriver*").getPath());
    //

    System.out.println(this.getClass().getResource("chromedriver"));
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/");

    driver.findElement(By.className("dropdown")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Register")).click();

    // Filling section "Your personal details"
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Se");

    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Pe");

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("lv459@i.ua");

    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("123");

    driver.findElement(By.id("input-fax")).clear();
    driver.findElement(By.id("input-fax")).sendKeys("456");
    Thread.sleep(1000);

    // Filling section "Your address"

    driver.findElement(By.id("input-company")).clear();
    driver.findElement(By.id("input-company")).sendKeys("SoftServe");

    driver.findElement(By.id("input-address-1")).clear();
    driver.findElement(By.id("input-address-1")).sendKeys("abc");

    driver.findElement(By.id("input-address-2")).clear();
    driver.findElement(By.id("input-address-2")).sendKeys("abc2");

    driver.findElement(By.id("input-city")).clear();
    driver.findElement(By.id("input-city")).sendKeys("Lemberg");

    driver.findElement(By.id("input-postcode")).clear();
    driver.findElement(By.id("input-postcode")).sendKeys("79000");

    Select dropDownCountry = new Select(((ChromeDriver) driver).findElementById("input-country"));
    dropDownCountry.selectByValue("220");

    Select dropDownRegion = new Select(((ChromeDriver) driver).findElementById("input-zone"));
    dropDownRegion.selectByValue("3493");
    Thread.sleep(1000);

    // Filling section "Your Password"

    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("qwerty");

    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("qwerty");

    driver.findElement(By.name("agree")).click();

    Thread.sleep(1000);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    /* WebElement element3 =
                    driver.findElement(
                        By.linkText("My Account")); // finds my account login
        // page in the footer
            System.out.println(element3.getTagName());
    */
    Thread.sleep(5000);

    driver.quit();
  }
}
