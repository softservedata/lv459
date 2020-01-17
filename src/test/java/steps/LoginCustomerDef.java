package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class LoginCustomerDef {

    private final String SERVER_URL = System.getenv().get("OPENCART_URL");
    private WebDriver driver;
    protected static final String USER_PASSWORD =
            System.getenv("USER_PASSWORD");

    @Given("user is in database")
    public void userIsInDatabase() {
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
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get(SERVER_URL);
    }

    @When("I click \"([^\"]*)\" button")
    public void iClickButton(String arg0) {
        driver.findElement(By.className("dropdown")).click();

    }

    @When("^I type email \"([^\"]*)\"$")
    public void iTypeEmail(String email) {
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    @When("I type password")
    public void iTypePassword() {
        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);
    }

    @When("I click Login button")
    public void iClickButtonSpan() {
        // Click Login button
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @When("^I click \"([^\"]*)\" link$")
    public void iClickLink(String arg0) throws Throwable {
        driver.findElement(
                By.cssSelector("a[href*='account/" + arg0.toLowerCase() + "']"))
                .click();
    }

    @Then("Content with \"([^\"]*)\" visible")
    public void contentWithVisible(String arg0) {
    }

    @Then("^goto \"([^\"]*)\" Page$")
    public void gotoAdressPage() {
        System.out.println("");
//        driver.findElement();
    }
}
