package com.softserve;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AdminPanel extends LocalTestRunnerSetIP {

    public void deleteCustomer (String email) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        WebDriver webDriver = new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // log in as Admin
        loginAdmin(webDriver);

        //find customer by email
        findCustomerByEmail(webDriver , email);


        if (webDriver.findElements(By.xpath("//td[contains(text(),'No results!')]")).size() > 0) {
            //do nothing
            System.out.println("No registered customer!");
        } else {
            System.out.println("Customer is registered and we proceed -with new search customer");

            findCustomerByEmail(webDriver , email);

            System.out.println("find customer by email #2- completed");

            dropCustomer(webDriver , email);
        }
        //logout admin
        logoutAdmin(webDriver);

        webDriver.quit();
    }

    public void createCustomer (String email, String password)
            throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        WebDriver webDriver = new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // log in as Admin
        loginAdmin(webDriver);

        //find customer by email
        findCustomerByEmail (webDriver , email);

        if (webDriver.findElements(By.xpath("//td[contains(text(),'No results!')]")).size() > 0) {
            System.out.println("No registered customer! -- Proceed with creation!");

            // create customer
            createCustomer(webDriver , email , password);
        } else {

            // do nothing
            System.out.println("Customer is already in DB!");
        }
        //logout admin
        logoutAdmin(webDriver);
        webDriver.quit();
    }

    public void loginAdmin (WebDriver webDriver) throws Exception{
        System.out.println("@Before method - Loading Page");
        webDriver.get(String.format("http://%s/opencart/upload/admin/", IP));

        // Fill username
        webDriver.findElement(By.id("input-username")).click();
        webDriver.findElement(By.id("input-username")).clear();
        webDriver.findElement(By.id("input-username")).sendKeys("admin");

        // Fill password
        webDriver.findElement(By.id("input-password")).click();
        webDriver.findElement(By.id("input-password")).clear();
        webDriver.findElement(By.id("input-password")).sendKeys(DB_PASSWORD);

        // CLick 'Login' button
        webDriver.findElement(By.id("input-password")).sendKeys(Keys.ENTER);
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

    }

    public void logoutAdmin (WebDriver webDriver) throws Exception{
        // Click 'Logout' button
        webDriver.findElement(By.cssSelector("a[href*='common/logout']")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

    }

    public void findCustomerByEmail (WebDriver webDriver, String email)
            throws Exception {

        webDriver.findElement(By.xpath("//img[@title='OpenCart']")).click();
        // Goto 'Customer' section
        webDriver.findElement(By.id("button-menu")).click();
        webDriver.findElement(By.id("menu-customer")).click();
        webDriver.findElement(By.xpath("//a[.='Customers']")).click();

        // Filter customer by email
        webDriver.findElement(By.id("input-email")).click();

        webDriver.findElement(By.id("input-email")).clear();
        webDriver.findElement(By.id("input-email")).sendKeys(email);
        webDriver.findElement(By.id("button-filter")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

    }

    public void dropCustomer(WebDriver webDriver, String email) throws Exception {

        System.out.println("Trying to check this checkbutton");
        // Delete customer
        String checkbutton = "//td[contains(text(), '%s')]/./preceding-sibling::td[@class='text-center']/./input[@name='selected[]']";
//        String checkbutton = "//td[contains(text(), '%s')]/preceding-sibling::td/input";
//
        System.out.println("email used : " + email);
        String request = String.format(checkbutton, email);
        System.out.println(request);
        webDriver.findElement(By.xpath(request)).click(); // cannot click this button // it is clicking from time to time - why????

//        webDriver.findElement(By.name(request)).click(); // cannot click this button // it is clicking from time to time - why????

//        webDriver.findElement(By.xpath("//input[@name='selected[]']")).click();


        // click delete button
        webDriver.findElement(By.xpath("//button[@data-original-title='Delete']")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // confirm delete customer
        webDriver.switchTo().alert().accept();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    private void createCustomer (WebDriver webDriver, String email , String password) {
        webDriver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

        webDriver.findElement(By.id("input-firstname")).click();
        webDriver.findElement(By.id("input-firstname")).clear();
        webDriver.findElement(By.id("input-firstname")).sendKeys("Se");

        webDriver.findElement(By.id("input-lastname")).click();
        webDriver.findElement(By.id("input-lastname")).clear();
        webDriver.findElement(By.id("input-lastname")).sendKeys("Pe");

        webDriver.findElement(By.id("input-email")).click();
        webDriver.findElement(By.id("input-email")).clear();
        webDriver.findElement(By.id("input-email")).sendKeys(email);

        webDriver.findElement(By.id("input-telephone")).click();
        webDriver.findElement(By.id("input-telephone")).clear();
        webDriver.findElement(By.id("input-telephone")).sendKeys("123456");

        webDriver.findElement(By.id("input-password")).click();
        webDriver.findElement(By.id("input-password")).clear();
        webDriver.findElement(By.id("input-password")).sendKeys(password);

        webDriver.findElement(By.id("input-confirm")).click();
        webDriver.findElement(By.id("input-confirm")).clear();
        webDriver.findElement(By.id("input-confirm")).sendKeys(password);

        webDriver.findElement(By.xpath("//button[@data-original-title='Save']")).click();

        // this assert can be used to get confirmation that user is made.
//        Assert.assertEquals("Success: You have modified customers!" ,
//                webDriver.findElement(By.xpath("//div[@class='alert alert-success']")).getText());
    }
}
