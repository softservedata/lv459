import org.junit.Test;

public class SimpleTest extends LocalTestRunnerSetIP {

    @Test
    public void myProbas() throws Exception {
//
        AdminPanel admin = new AdminPanel();
        admin.createCustomer(USER_EMAIL , USER_PASSWORD);

        System.out.println(String.format("//td[contains(text(), '%s')]/./preceding-sibling::td[@class='text-center']/./input[@name='selected[]']", "lv459"));
    }
}
