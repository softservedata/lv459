import org.junit.After;
import org.junit.Before;

public abstract class LocalTestRunnerCustomerUpdate extends
                                                    LocalTestRunnerGeneralSettings {

    @Before
    public void pageLoad() throws Exception {
        System.out.println("@Before method - Loading Page");

        // Prerequisites : create test customer
        driver.get(String.format("http://%s/opencart/upload/", IP));
        admin.createCustomer(USER_EMAIL , USER_PASSWORD);
    }

    @After
    public void stopPage() throws  Exception {

        // After method : delete test customer
        System.out.println("@After method - Stop Page");
        admin.deleteCustomer(USER_EMAIL);
    }
}
