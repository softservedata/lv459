import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Testing function to update Customers details via main site Opencart page.
 * Prerequisites: Customer with USER_EMAIL and USER_PASSWORD is present in DB.
 *     Prerequisites are made by AdminPanel class methods.
 */
public class CustomerUpdateTests
        extends LocalTestRunnerCustomerUpdate {

    public String newPass = "password";

    /**
     * Updating Last Name of Customer
     * @throws Exception
     */
    @Test
    public void tc11updateLastNameFieldTest() throws Exception{

        String newLastName = "New Last Name";
        // Log in as Customer
        super.loginCustomer(USER_EMAIL , USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Edit Lastname Field
        driver.findElement(By.cssSelector("input[name='lastname']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).clear();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(newLastName);

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Search and assert message element
        Assert.assertEquals("Success: Your account has been successfully updated." ,
                            driver.findElement(By.cssSelector("i.fa.fa-check-circle")).getText());

        //Log out customer
        super.logOutCustomer();

        //Log in customer
        super.loginCustomer(USER_EMAIL, USER_PASSWORD);

        // Click Edit Your Account Information
        driver.findElement(By.cssSelector("#content a[href*='account/edit']")).click();

        // Assert amended Last Name Field
        Assert.assertEquals(newLastName ,
            driver.findElement(By.cssSelector("input[name='lastname']")).getAttribute("value"));
    }

    /**
     * Updating Customer's password
     * @throws Exception
     */
    @Test
    public void tc12updatePasswordFieldTest () throws Exception{

        // Login as Customer
        super.loginCustomer(USER_EMAIL , USER_PASSWORD);

        // Click Change your password link
        driver.findElement(By.cssSelector("#content a[href*='account/password']")).click();

        // Edit Password Field
        driver.findElement(By.cssSelector("input[name='password']")).click();
        driver.findElement(By.cssSelector("input[name='password']")).clear();
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(newPass);

        //Edit Confirm password field
        driver.findElement(By.cssSelector("input[name='confirm']")).click();
        driver.findElement(By.cssSelector("input[name='confirm']")).clear();
        driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys(newPass);

        // Click "Continue" button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //Assertion:
        // Search message element
        //        Assert.assertEquals("Success: Your account has been successfully updated." ,
        //                            driver.findElement(By.cssSelector("i.fa.fa-check-circle")).getText());

        //Log out customer
        super.logOutCustomer();

        // Trying to log in with new password
        super.loginCustomer(USER_EMAIL, newPass);

        // Assert if Customer can login
        Assert.assertTrue(isCustomerLogined());
    }
}
