package LoginUser;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddingQuickL {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception{
        System.setProperty("webdriver.chrome.driver",
                AddingQuickL.class.getResource("/chromedriver-windows-32bit.exe").getPath());
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception{
        Thread.sleep(2000);
        driver.quit();
    }

    @Before
    public void setUp() throws Exception{
        driver.get("http://192.168.234.128/opencart/upload/index.php?route=common/home");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        loginUser();
    }

    @After
    public void tearDown() throws Exception{
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.manage().deleteAllCookies();
    }

    private WebElement getElementByName(String name) {
        WebElement result = null;
        List<WebElement> containers = driver.findElements(By.cssSelector("div.row #content div.row"));
        for (WebElement current : containers) {
            if (current.findElement(By.cssSelector("h4 > a")).getText().equals(name)) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // Develop Custom Exception
            throw new RuntimeException("WebElement by title/name: " + name + " not found");
        }
        return result;
    }

    @Test
    public void addingQuickL() throws InterruptedException {

        driver.findElement(By.cssSelector("#logo .img-responsive")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//*[@id='content']/div[2]/div[1]/div/div[3]/button[1]/i")).click();
        //WebElement addButton = getElementByName("MacBook").findElement(By.cssSelector("i.fa.fa-shopping-cart"));
        getElementByName("MacBook").findElement(By.cssSelector("i.fa.fa-shopping-cart")).click();
    }

    public void loginUser() throws InterruptedException {
        driver.findElement(By.cssSelector("a[title='My Account']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#top-links a[href*='account/login']")).click();
        driver.findElement(By.id("input-email")).sendKeys("user1@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys(System.getenv().get("password"));
        driver.findElement(By.xpath("//input[contains(@class, 'btn btn-primary')]")).submit();

    }

}
