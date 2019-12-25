import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class LocalTestRunnerSetIP {
    protected static final String IP = "172.16.0.129";
    protected static final int DELAY_FOR_PRESENTATION_ONLY = 0;
    protected static WebDriver driver;
    protected static final String ADMIN_PANEL_USER = "admin";
    protected static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    protected static final String USER_EMAIL = System.getenv("USER_EMAIL");
    protected static final String USER_PASSWORD = System.getenv("USER_PASSWORD");
    protected static AdminPanel admin = new AdminPanel();

    @BeforeClass
    public static void startDriver() throws Exception {
        System.out.println("@BeforeClass-Start Driver");

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void stopDriver() throws Exception {
        System.out.println("@AfterClass - Stop Driver");
        driver.quit();
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

        // Click Login Button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        // Click Search field to close dropdown menu.
        driver.findElement(By.xpath("//input[@name='search']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
    }

    public boolean isCustomerLogined() throws Exception {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        if (driver.findElements(By.cssSelector("ul.dropdown-menu.dropdown-menu-right > li"))
                    .size() > 2) {
            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
            driver.findElement(By.cssSelector("input[name='search']")).click();
            return true;
        } else {
            Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

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
}
