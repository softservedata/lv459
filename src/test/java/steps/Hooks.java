package steps;

import cucumber.api.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    public WebDriver driver;

    @Before
    public void openUrl() {

    }

    @After
    public void quitDriver (){

        driver.quit();
    }
}
