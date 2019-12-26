import org.junit.After;
import org.junit.Before;

public abstract class LocalTestRunnerCustomerRegister
        extends LocalTestRunnerGeneralSettings {

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
