package com.softserve;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CustomerRegistrationTest {

  private static WebDriver driver;
  public static int delay = 10;

  @BeforeClass
  public static void startDriver() throws Exception {
    System.out.println("@BeforeClass-Start Driver");

    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterClass
  public static void stopDriver() throws Exception {
    System.out.println("@AfterClass - Stop Driver");
    Thread.sleep(delay);
    driver.quit();
  }

  @Before
  public void pageLoad() {
    System.out.println("@Before method - Loading Page");
    driver.get("http://172.16.0.128/opencart/upload/");
    driver.findElement(By.className("dropdown")).click();
    if (driver.findElements(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li")).size()
        > 2) {
      System.out.println("Clicking logout");
      driver.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li > a[href*='logout']")).click();
    } else driver.findElement(By.className("dropdown")).click();
  }

  @After
  public void stopPage(){
    System.out.println("@After method - Stop Page");
  }

//  @Test
  public void testing() throws Exception{
    driver.findElement(By.cssSelector("a[title='My Account']")).click();
    Thread.sleep(delay); // For Presentation Only
    // Click login Button
    driver.findElement(By.cssSelector("#top-links a[href*='account/login']")).click();
    Thread.sleep(delay); // For Presentation Only
    //
    // Steps
    // Type Login Email
    driver.findElement(By.cssSelector("#input-email")).click();
    driver.findElement(By.cssSelector("#input-email")).clear();
    driver.findElement(By.cssSelector("#input-email")).sendKeys(System.getenv("USER_EMAIL"));
    Thread.sleep(delay); // For Presentation Only
    //
    // Type Password
    //driver.findElement(By.id("input-password")).click();
    driver.findElement(By.cssSelector("#input-password")).click();
    driver.findElement(By.cssSelector("#input-password")).clear();
    driver.findElement(By.cssSelector("#input-password")).sendKeys(System.getenv("USER_PASSWORD"));
    Thread.sleep(delay); // For Presentation Only
    //
    // Click Login Button
    driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

  }

  @Test
  public void customerRegistrationTest() throws Exception {

    driver.findElement(By.className("dropdown")).click();
        Thread.sleep(delay);
    driver.findElement(By.linkText("Register")).click(); // a[href*=]

    // Filling section "Your personal details"
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Se");

    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Pe");

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys(System.getenv("USER_EMAIL"));

    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("123");

    driver.findElement(By.id("input-fax")).clear();
    driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(delay);

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
        Thread.sleep(delay);

    // Filling section "Your Password"
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys(System.getenv("USER_PASSWORD"));

    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys(System.getenv("USER_PASSWORD"));

    driver.findElement(By.name("agree")).click();

        Thread.sleep(delay);
        Thread.sleep(delay);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    String created = driver.findElement(By.xpath(
            "//h1[contains(text(), 'Your Account Has Been Created!')]"))
            .getText();
    System.out.println(created);
    Assert.assertEquals(created, "Your Account Has Been Created!");
    Thread.sleep(delay);
    Thread.sleep(delay);

    Thread.sleep(delay*2);
  }

  @Test
  public void deleteCustomerTest() throws Exception {

    driver.get("http://172.16.0.128/opencart/upload/admin/");
    driver.findElement(By.id("input-username")).click();
    driver.findElement(By.id("input-username")).clear();
    driver.findElement(By.id("input-username")).sendKeys("admin");

    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys(System.getenv("DB_PASSWORD"));

    driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);

    Thread.sleep(delay);

    driver.findElement(By.id("menu-customer")).click();

    //    driver.findElement(By.xpath("//a[contains(@href,'Customers')]"))
    //    .click(); // also works
    driver.findElement(By.xpath("//a[.='Customers']")).click();

    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys(System.getenv("USER_EMAIL"));
    driver.findElement(By.id("button-filter")).click();
    driver.findElement(By.name("selected[]")).click();
    driver.findElement(By.className("btn-danger")).click();

    Thread.sleep(delay);

    driver.switchTo().alert().accept();

    Assert.assertTrue(driver.findElement(By.xpath(
            "//*[contains(text(),'Success: You have modified customers!')]"))
                              .getText().contains("You have modified customers!"));
    Thread.sleep(5000);
  }

  @Test
  public void customerRegistrationOneFieldInvalidTest() throws Exception {

    driver.findElement(By.className("dropdown")).click();
        Thread.sleep(delay);
    driver.findElement(By.linkText("Register")).click();

    // Filling section "Your personal details"
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("123456789012345678901234567890123");

    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Pe");

    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys(System.getenv("USER_EMAIL"));

    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("123");

    driver.findElement(By.id("input-fax")).clear();
    driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(delay);

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
        Thread.sleep(delay);

    // Filling section "Your Password"
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys(System.getenv("USER_PASSWORD"));

    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys(System.getenv("USER_PASSWORD"));

    driver.findElement(By.name("agree")).click();

        Thread.sleep(delay);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    Assert.assertEquals(driver.findElement(By.xpath(
            "//*[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText(),
            "First Name must be between 1 and 32 characters!");
  }

  @Test
  public void customerRegistrationAllFieldsInvalidTest() throws Exception {

    driver.findElement(By.className("dropdown")).click();
        Thread.sleep(delay);
    driver.findElement(By.linkText("Register")).click();

    driver.findElement(By.name("agree")).click();

        Thread.sleep(delay);

    driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'First Name must be between 1 and 32 characters!')]"))
            .getText(),
        "First Name must be between 1 and 32 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Last Name must be between 1 and 32 " + "characters!')]"))
            .getText(),
        "Last Name must be between 1 and 32 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid!')]"))
            .getText(),
        "E-Mail Address does not appear to be valid!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Telephone must be between 3 and 32 characters!')]"))
            .getText(),
        "Telephone must be between 3 and 32 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Address 1 must be between 3 and 128 characters!')]"))
            .getText(),
        "Address 1 must be between 3 and 128 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'City must be between 2 and 128 characters!')]"))
            .getText(),
        "City must be between 2 and 128 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Postcode must be between 2 and 10 characters!')]"))
            .getText(),
        "Postcode must be between 2 and 10 characters!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Please select a region / state!')]"))
            .getText(),
        "Please select a region / state!");
    Assert.assertEquals(driver.findElement(By.xpath("//*[contains(text(),'Password must be between 4 and 20 characters!')]"))
            .getText(),
        "Password must be between 4 and 20 characters!");

    List<WebElement> list = driver.findElements(By.className("text-danger"));

    for (WebElement current : list) {
      System.out.println(current.getText());
    }
  }

  @Test
  public void customerCreateEmailFieldTest() throws Exception {

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

    Assert.assertEquals(driver.findElements(
            By.xpath("//*[contains(text(),'E-Mail Address does not appear to be valid!')]")).size(),0);
  }
}
