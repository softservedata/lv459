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
}
