package com.softserve;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerCustomerRegister
        extends LocalTestRunnerSetIP {

    @Before
    public void pageLoad() throws Exception {
        System.out.println("@Before method - Loading Page");
        driver.get(String.format("http://%s/opencart/upload/", IP));
        admin.deleteCustomer(USER_EMAIL);
    }

    @After
    public void stopPage() throws  Exception {
        System.out.println("@After method - Stop Page");
        if (isCustomerLogined()) logOutCustomer();
        admin.deleteCustomer(USER_EMAIL);

    }


    public boolean isCustomerLogined() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        if (driver.findElements(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li"))
                    .size() > 2) {
            driver.findElement(By.cssSelector("input[name='search']")).click();
            return true;
        } else {
            driver.findElement(By.cssSelector("input[name='search']")).click();
            return false;
        }
    }

    protected void logOutCustomer() {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        driver.findElement(By.cssSelector(
            "ul.dropdown-menu.dropdown-menu-right > li > a[href*='account/logout']"))
                .click();
        driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        driver.findElement(By.xpath("//input[@class='form-control input-lg']")).click();
    }

    protected void loginCustomer (String email, String pwd) throws Exception {
        if (isCustomerLogined()) {
            logOutCustomer();
        }

        driver.findElement(By.cssSelector("a[title='My Account']")).click();

        // Click loginCustomer Button
        driver.findElement(By.cssSelector("a[href*='account/login']")).click();

        // Steps
        // Type Login Email
        driver.findElement(By.cssSelector("#input-email")).click();
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("#input-email"))
                .sendKeys(email);

        // Type Password
        //driver.findElement(By.id("input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).click();
        driver.findElement(By.cssSelector("#input-password")).clear();
        driver.findElement(By.cssSelector("#input-password"))
                .sendKeys(pwd);
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        //
        // Click Login Button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        driver.findElement(By.cssSelector("img.img-responsive")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    public boolean checkIfCustomerIsRegistered(String customerEmail, String customerPassword) throws Exception {

        WebDriver webdriver = new ChromeDriver();
        webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Admin Panel
        webdriver.get(String.format("http://%s/opencart/upload/admin/", IP));

        // Log in as Admin
        loginIntoAdminPanel(webdriver, ADMIN_PANEL_USER , DB_PASSWORD);

        // Click side panel > Customer section
        webdriver.findElement(By.id("menu-customer")).click();
        webdriver.findElement(By.xpath("//a[.='Customers']")).click();

        // Filter customers by email
        webdriver.findElement(By.id("input-email")).click();
        webdriver.findElement(By.id("input-email")).clear();
        webdriver.findElement(By.id("input-email")).sendKeys(USER_EMAIL);
        webdriver.findElement(By.id("button-filter")).click();

        // return boolean
        if (webdriver.findElements(By.xpath("//td[contains(text(),'No results!')]")).size() > 0) {

            webdriver.findElement(By.cssSelector("a[href*='common/logout']")).click();
            webdriver.quit();
            return false;
        }
        webdriver.findElement(By.cssSelector("a[href*='common/logout']")).click();
        webdriver.quit();
        return true;
    }

    public void loginIntoAdminPanel (WebDriver driver, String username, String password) throws Exception {

        driver.get(String.format("http://%s/opencart/upload/admin/", IP));

        // logging as Admin into Administration panel

        // Fill username
        driver.findElement(By.id("input-username")).click();
        driver.findElement(By.id("input-username")).clear();
        driver.findElement(By.id("input-username")).sendKeys(username);

        // Fill password
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(password);

        // CLick 'Login' button
        driver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }
}
