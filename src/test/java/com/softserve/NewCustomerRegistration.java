package com.softserve;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class NewCustomerRegistration {



  @Test
  public void newCustomerRegistration() throws Exception {

    //    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //    System.setProperty("webdriver.chrome.driver",
    //                       this.getClass().getResource(Reg
    //                                                   "chromedriver*").getPath());
    //

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/");

    driver.findElement(By.className("dropdown")).click(); // a[title="My
    // account"]
    //    Thread.sleep(1000);
    driver.findElement(By.linkText("Register")).click(); // a[href*=]

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
    //    Thread.sleep(1000);

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
    //    Thread.sleep(1000);

    // Filling section "Your Password"

    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("qwerty");

    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("qwerty");

    driver.findElement(By.name("agree")).click();

    //    Thread.sleep(1000);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    /* WebElement element3 =
                    driver.findElement(
                        By.linkText("My Account")); // finds my account login
        // page in the footer
            System.out.println(element3.getTagName());
    */
    //    Thread.sleep(1000);

    String created =
        driver
            .findElement(By.xpath("//h1[contains(text(), 'Your" + " Account Has Been Created!')]"))
            .getText();
    System.out.println(created);
    Assert.assertEquals(created, "Your Account Has Been Created!");
    driver.quit();
  }

  @Test
  public void deleteTestCustomer() throws Exception {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/admin");

    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).clear();
    driver.findElement(By.id("input-username")).sendKeys("admin");

    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("Lv459_Taqc");

    driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);

    Thread.sleep(1000);

    driver.findElement(By.id("menu-customer")).click();

    //    driver.findElement(By.xpath("//a[contains(@href,'Customers')]")).click();
    driver.findElement(By.xpath("//a[.='Customers']")).click();

    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("lv459@i.ua");

    driver.findElement(By.id("button-filter")).click();
    // this edit button doesn't work. can find table, but cannot find 'Edit' button
    //    driver.findElement(By.xpath("//table[contains(.,'lv459@i.ua')]")).click();
    //
    // $x("//table[contains(.,'lv459@i.ua')]//following-sibling::a[contains(data-original-title='Edit')]")

    driver.findElement(By.name("selected[]")).click();

    driver.findElement(By.className("btn-danger")).click();

    Thread.sleep(1000);

    driver.switchTo().alert().accept();

    String text =
        driver
            .findElement(By.xpath("//*[contains(text(),'Success: You have modified customers!')]"))
            .getText();

    System.out.println(text);

    Assert.assertEquals("You have modified customers!", text);

    driver.quit();
  }

  @Test
  public void newCustomerRegistrationOnefieldInvalid() throws Exception {

    //    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //    System.setProperty("webdriver.chrome.driver",
    //                       this.getClass().getResource(Reg
    //                                                   "chromedriver*").getPath());
    //

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/");

    driver.findElement(By.className("dropdown")).click();
    //    Thread.sleep(1000);
    driver.findElement(By.linkText("Register")).click();

    // Filling section "Your personal details"
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("123456789012345678901234567890123");

    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Pe");

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("lv459@i.ua");

    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("123");

    driver.findElement(By.id("input-fax")).clear();
    driver.findElement(By.id("input-fax")).sendKeys("456");
    //    Thread.sleep(1000);

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
    //    Thread.sleep(1000);

    // Filling section "Your Password"

    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("qwerty");

    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("qwerty");

    driver.findElement(By.name("agree")).click();

    //    Thread.sleep(1000);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    /* WebElement element3 =
                    driver.findElement(
                        By.linkText("My Account")); // finds my account login
        // page in the footer
            System.out.println(element3.getTagName());
    */
    //    Thread.sleep(1000);

    Assert.assertEquals(
        driver
            .findElement(
                By.xpath(
                    "//*[contains(text(),'Warning: E-Mail Address is already " + "registered!')]"))
            .getText(),
        "Warning: E-Mail Address is already registered!");

    driver.findElements(By.className("text-danger"));

    driver.quit();
  }

  @Test
  public void newCustomerRegistrationAllFieldsInvalid() throws Exception {

    //    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //    System.setProperty("webdriver.chrome.driver",
    //                       this.getClass().getResource(Reg
    //                                                   "chromedriver*").getPath());
    //

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/");

    driver.findElement(By.className("dropdown")).click();
    //    Thread.sleep(1000);
    driver.findElement(By.linkText("Register")).click();

    driver.findElement(By.name("agree")).click();

    //    Thread.sleep(1000);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    /* WebElement element3 =
                    driver.findElement(
                        By.linkText("My Account")); // finds my account login
        // page in the footer
            System.out.println(element3.getTagName());
    */
    //    Thread.sleep(1000);

    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'First Name must be between 1 and 32 characters!')]"))
            .getText(),
        "First Name must be between 1 and 32 characters!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath(
                    "//*[contains(text(),'Last Name must be between 1 and 32 " + "characters!')]"))
            .getText(),
        "Last Name must be between 1 and 32 characters!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
            .getText(),
        "E-Mail Address does not appear to be valid!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
            .getText(),
        "Telephone must be between 3 and 32 characters!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'Address 1 must be between 3 and 128 characters!')]"))
            .getText(),
        "Address 1 must be between 3 and 128 characters!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'City must be between 2 and 128 characters!')]"))
            .getText(),
        "City must be between 2 and 128 characters!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'Postcode must be between 2 and 10 characters!')]"))
            .getText(),
        "Postcode must be between 2 and 10 characters!");
    Assert.assertEquals(
        driver
            .findElement(By.xpath("//*[contains(text(),'Please select a region / state!')]"))
            .getText(),
        "Please select a region / state!");
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]"))
            .getText(),
        "Password must be between 4 and 20 characters!");

    driver.findElements(By.className("text-danger"));
  }

  @Test
  public void newCustomerEmailField() throws Exception {

    //    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    //    System.setProperty("webdriver.chrome.driver",
    //                       this.getClass().getResource(Reg
    //                                                   "chromedriver*").getPath());
    //

    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://172.16.0.128/opencart/upload/");

    driver.findElement(By.className("dropdown")).click();
    driver.findElement(By.linkText("Register")).click();

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("a");
    if (!driver.findElement(By.name("agree")).isSelected()) {
      driver.findElement(By.name("agree")).click();
    }
    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    // popup window ??? how to handle?

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("a@");
    if (!driver.findElement(By.name("agree")).isSelected()) {
      driver.findElement(By.name("agree")).click();
    }
    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    // popup window ??? how to handle?

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("a@a");
    if (!driver.findElement(By.name("agree")).isSelected()) {
      driver.findElement(By.name("agree")).click();
    }
    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
            .getText(),
        "E-Mail Address does not appear to be valid!");


    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("a@a.");
    if (!driver.findElement(By.name("agree")).isSelected()) {
      driver.findElement(By.name("agree")).click();
    }
    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
    Assert.assertEquals(
        driver
            .findElement(
                By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
            .getText(),
        "E-Mail Address does not appear to be valid!");


    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("a@a.a");
    if (!driver.findElement(By.name("agree")).isSelected()) {
      driver.findElement(By.name("agree")).click();
    }
    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    Assert.assertEquals(driver.findElements(By.xpath(
            "//*[contains(text(),'E-Mail Address does not appear to be " +
            "valid!')]")).size(), 0);
  }

  @Test
    public void sytem ()
  {
      String u = System.getenv("DB_USERNAME");
    System.out.println(u);
  }
}
