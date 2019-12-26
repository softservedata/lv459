import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AdminPanel extends LocalTestRunnerSetIP {

    WebDriver webDriver;

    private WebDriver createAdminPanelWebDriver () {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        webDriver = new ChromeDriver(options);

        return webDriver;
    }

    public void createCustomer (String email, String password) throws Exception {

        //Create new WebDriver for Admin panel
        createAdminPanelWebDriver();

        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // log in as Admin
        loginAdmin(webDriver);

        //find customer by email
        findCustomerByEmail (webDriver , email);

        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        if (webDriver.findElements(By.xpath("//td[contains(text(),'No results!')]")).size() == 1) {

            // create customer
            createNewCustomer(webDriver , email , password);

        } else {

            // do nothing
            System.out.println("Customer is already in DB!");
        }
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //logout admin
        logoutAdmin(webDriver);
        webDriver.quit();
    }

    public void deleteCustomer (String email) throws Exception {

        //Create new WebDriver for Admin panel
        createAdminPanelWebDriver();

        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        // log in as Admin
        loginAdmin(webDriver);

        // find customer by email
        findCustomerByEmail(webDriver , email);

        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        if (webDriver.findElements(By.xpath("//td[contains(text(),'No results!')]")).size() > 0) {
            //do nothing
        } else {
//            findCustomerByEmail(webDriver , email);
            dropCustomer(webDriver , email);
        }

        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        //logout admin
        logoutAdmin(webDriver);

        webDriver.quit();
    }

    private void loginAdmin (WebDriver webDriver) throws Exception{
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

    private void logoutAdmin (WebDriver webDriver) throws Exception{
        // Click 'Logout' button
        webDriver.findElement(By.cssSelector("a[href*='common/logout']")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    private void findCustomerByEmail (WebDriver webDriver, String email)
            throws Exception {

        webDriver.findElement(By.xpath("//img[@title='OpenCart']")).click();

        // Goto 'Customer' section
        webDriver.findElement(By.id("button-menu")).click();
        webDriver.findElement(By.id("menu-customer")).click();
        webDriver.findElement(By.xpath("//li[@id='menu-customer']//a[contains (@href,'customer/customer&')]")).click();

        // Filter customer by email
        webDriver.findElement(By.id("input-email")).click();
        webDriver.findElement(By.id("input-email")).clear();
        webDriver.findElement(By.id("input-email")).sendKeys(email);

        webDriver.findElement(By.id("button-filter")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    private void dropCustomer(WebDriver webDriver, String email) throws Exception {

        System.out.println("Trying to check this checkbutton");
        // Delete customer
        String checkbutton = "//td[contains(text(), '%s')]/./preceding-sibling::td[@class='text-center']/./input[@name='selected[]']";
//        String checkbutton = "//td[contains(text(), '%s')]/preceding-sibling::td/input";

        System.out.println("email used : " + email);
        String request = String.format(checkbutton, email);
        System.out.println(request);
        webDriver.findElement(By.xpath(request)).click();

        // click delete button
        webDriver.findElement(By.xpath("//button[@data-original-title='Delete']")).click();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // confirm delete customer
        webDriver.switchTo().alert().accept();
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    private void createNewCustomer (WebDriver webDriver, String email , String password)
            throws Exception {
        //Click add new customer button
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

        //Click add address
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        webDriver.findElement(By.xpath("//li[@id='address-add']/a[@onclick='addAddress();']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        webDriver.findElement(By.id("input-firstname1")).click();
        webDriver.findElement(By.id("input-firstname1")).clear();
        webDriver.findElement(By.id("input-firstname1")).sendKeys("Se");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        webDriver.findElement(By.id("input-lastname1")).click();
        webDriver.findElement(By.id("input-lastname1")).clear();
        webDriver.findElement(By.id("input-lastname1")).sendKeys("Pe");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        webDriver.findElement(By.id("input-address-11")).click();
        webDriver.findElement(By.id("input-address-11")).clear();
        webDriver.findElement(By.id("input-address-11")).sendKeys("Sadova str.");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        webDriver.findElement(By.id("input-city1")).click();
        webDriver.findElement(By.id("input-city1")).clear();
        webDriver.findElement(By.id("input-city1")).sendKeys("Lemberg");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        Select dropDownCountry = new Select(
                ((ChromeDriver) webDriver).findElementById("input-country1"));
        dropDownCountry.selectByValue("220");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        Select dropDownRegion = new Select(
                ((ChromeDriver) webDriver).findElementById("input-zone1"));
        dropDownRegion.selectByValue("3493");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        webDriver.findElement(By.xpath("//button[@data-original-title='Save']")).click();
        //Click save new customer button
        webDriver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();

    }
}
