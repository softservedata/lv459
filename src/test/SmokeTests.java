import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class SmokeTests extends LocalTestRunnerGeneralSettings {

    /**
     * Smoke test if the Opencart main page is opened.
     */
    @Test
    public void smokeTest() {

        driver.get(String.format("http://%s/opencart/upload/", IP));

        Assert.assertTrue(
                driver.findElements(By.className("common-home")).size() > 0);
    }
}
