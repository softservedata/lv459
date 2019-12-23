import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public abstract class LocalTestRunnerCustomerUpdate extends LocalTestRunnerSetIP {

    @Before
    public void pageLoad() throws Exception {
        System.out.println("@Before method - Loading Page");
        driver.get(String.format("http://%s/opencart/upload/", IP));
        admin.createCustomer(USER_EMAIL , USER_PASSWORD);
    }

    @After
    public void stopPage() throws  Exception {
        System.out.println("@After method - Stop Page");
        admin.deleteCustomer(USER_EMAIL);
    }
}
