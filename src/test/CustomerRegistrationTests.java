import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerRegistrationTests extends LocalTestRunnerCustomerRegister {

    /**
     * Customer registration function test. Filling mandatory and not-mandatory
     * fields with valid valid credentials.
     * Prerequisites: customer with given email and password is not is DB.
     * email and password are taken from System environment, while other
     * data are hardcoded temporarily.
     * @throws Exception
     */
    @Test
    public void tc01customerRegistrationTest() throws Exception {

        System.out.println("Demonstration : Test Case 01...");
        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Se");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(USER_EMAIL);

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your address"
        driver.findElement(By.id("input-company")).clear();
        driver.findElement(By.id("input-company")).sendKeys("SoftServe");

        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("abc");

        driver.findElement(By.id("input-address-2")).clear();
        driver.findElement(By.id("input-address-2")).sendKeys("abc2");

        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("Lemberg");

        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(
                ((ChromeDriver) driver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(
                ((ChromeDriver) driver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm"))
                .sendKeys(USER_PASSWORD);

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY*2);

        String created = driver.findElement(By.xpath(
                "//h1[contains(text(), 'Your Account Has Been Created!')]"))
                .getText();

        // Checking if account is created
        Assert.assertEquals("Your Account Has Been Created!", created);

        // Log in with recently created customer's credentials

        //Assert if customer is logined.
        Assert.assertTrue(isCustomerLogined());

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Logout
        logOutCustomer();

        // Another assert if user created.
        loginCustomer(USER_EMAIL , USER_PASSWORD);
        Assert.assertTrue(isCustomerLogined());
        logOutCustomer();
    }

    /**
     * Customer registration function test. Trying to create customer with one
     * mandatory field filled with invalid credentails (First name more than
     * 32 symbols).
     * @throws Exception
     */
    @Test
    public void tc02customerRegistrationOneFieldInvalidTest() throws Exception {

        System.out.println("Demonstration : Test Case 02...");

        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("123456789012345678901234567890123");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(USER_EMAIL);

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your address"
        driver.findElement(By.id("input-company")).clear();
        driver.findElement(By.id("input-company")).sendKeys("SoftServe");

        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("abc");

        driver.findElement(By.id("input-address-2")).clear();
        driver.findElement(By.id("input-address-2")).sendKeys("abc2");

        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("Lemberg");

        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(
                ((ChromeDriver) driver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(
                ((ChromeDriver) driver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm")).sendKeys(USER_PASSWORD);

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY * 2);

        //Checking Error message next to field 'First name'
        Assert.assertEquals("First Name must be between 1 and 32 characters!" ,
                            driver.findElement(By.xpath(
                "//*[contains(text(),'First Name must be')]")).getText());

    }

    /**
     * Customer registration function test. Testing checkbox - 'Accept Privacy
     * policy' mandatory filed.
     * @throws Exception
     */
    @Test
    public void tc03customerRegistrationAllFieldValidNoCheckBoxTest() throws Exception {

        System.out.println("Demonstration : Test Case 03...");

        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Se");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(USER_EMAIL);

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your address"
        driver.findElement(By.id("input-company")).clear();
        driver.findElement(By.id("input-company")).sendKeys("SoftServe");

        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("abc");

        driver.findElement(By.id("input-address-2")).clear();
        driver.findElement(By.id("input-address-2")).sendKeys("abc2");

        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("Lemberg");

        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(
                ((ChromeDriver) driver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(
                ((ChromeDriver) driver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm")).sendKeys(USER_PASSWORD);

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY * 2);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY * 2);

        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Warning: You must agree')]")).getText() ,
                "Warning: You must agree to the Privacy Policy!");
    }

    /**
     * Customer registration function test. Privacy policy - checked, while all
     * other mandatory and not-mandatory fields - empty.
     * @throws Exception
     */
    @Test
    public void tc04customerRegistrationOnlyRulesCheckbox() throws Exception {

        System.out.println("Demonstration : Test Case 04...");

        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'First Name must be')]")).getText(),
                "First Name must be between 1 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Last Name must be')]")).getText(),
                "Last Name must be between 1 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'E-Mail Address does not')]")).getText(),
                "E-Mail Address does not appear to be valid!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Telephone must be between')]")).getText(),
                "Telephone must be between 3 and 32 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Address 1 must be')]")).getText(),
                "Address 1 must be between 3 and 128 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'City must be between 2')]")).getText(),
                "City must be between 2 and 128 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Postcode must be between 2')]")).getText(),
                "Postcode must be between 2 and 10 characters!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Please select a regio')]")).getText(),
                "Please select a region / state!");
        Assert.assertEquals(driver.findElement(By.xpath(
                "//*[contains(text(),'Password must be between 4')]")).getText(),
                "Password must be between 4 and 20 characters!");
    }

    /**
    Testing one field (email) by decision table technique.
     **/
    @Test
    public void tc05customerCreateEmailFieldTest() throws Exception {

        System.out.println("Demonstration : Test Case 05...");

        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("Se");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your address"
        driver.findElement(By.id("input-company")).clear();
        driver.findElement(By.id("input-company")).sendKeys("SoftServe");

        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("abc");

        driver.findElement(By.id("input-address-2")).clear();
        driver.findElement(By.id("input-address-2")).sendKeys("abc2");

        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("Lemberg");

        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(
                ((ChromeDriver) driver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(
                ((ChromeDriver) driver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm"))
                .sendKeys(USER_PASSWORD);

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        String testEmail;
        String xpathRequest = "//input[@value='%s']/following-sibling::" +
              "div[contains(text(),'E-Mail Address does not appear to be valid!')]";

        /* following tests skipped due to HTML browser email check.
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("a@");
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        */

        testEmail = "a@a";
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(testEmail);
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);

        Assert.assertEquals(driver.findElement(By.xpath(String.format(xpathRequest, testEmail))).getText(),
                "E-Mail Address does not appear to be valid!");

/*      The same problem with HTML email testing feature.
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        testEmail = "a@a.";
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(testEmail);
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(By.xpath(String.format(xpathRequest, testEmail))).getText(),
                            "E-Mail Address does not appear to be valid!");

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
*/

/*  correct email entry - is it necessary?
        testEmail = "a@a.a";
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(testEmail);
        if (!driver.findElement(By.name("agree")).isSelected()) {
            driver.findElement(By.name("agree")).click();
        }
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);
        driver.findElement(By.name("agree")).sendKeys(Keys.ENTER);
        Assert.assertEquals(driver.findElement(
                By.xpath("//h1[contains (text(), 'Been Created!')]")).getText(),
                            "Your Account Has Been Created!");
*/
    }

    /**
     * Test for correct work of Java+DB. Trying to drop test table by incorrect
     * first name.
     * @throws Exception
     */
    @Test
    public void tc06customerRegistrationDropSecurityTest() throws Exception {

        System.out.println("Demonstration : Test Case 06...");

        //Click "My account" dropdown list
        driver.findElement(By.className("dropdown")).click();

        //Click "Register" button
        driver.findElement(By.cssSelector("a[href*='account/register']")).click();

        // Filling section "Your personal details"
        driver.findElement(By.id("input-firstname")).clear();
        driver.findElement(By.id("input-firstname")).sendKeys("\"; drop table abc;");

        driver.findElement(By.id("input-lastname")).clear();
        driver.findElement(By.id("input-lastname")).sendKeys("Pe");

        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("x@x.x");

        driver.findElement(By.id("input-telephone")).clear();
        driver.findElement(By.id("input-telephone")).sendKeys("123");

        driver.findElement(By.id("input-fax")).clear();
        driver.findElement(By.id("input-fax")).sendKeys("456");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your address"
        driver.findElement(By.id("input-company")).clear();
        driver.findElement(By.id("input-company")).sendKeys("SoftServe");

        driver.findElement(By.id("input-address-1")).clear();
        driver.findElement(By.id("input-address-1")).sendKeys("abc");

        driver.findElement(By.id("input-address-2")).clear();
        driver.findElement(By.id("input-address-2")).sendKeys("abc2");

        driver.findElement(By.id("input-city")).clear();
        driver.findElement(By.id("input-city")).sendKeys("Lemberg");

        driver.findElement(By.id("input-postcode")).clear();
        driver.findElement(By.id("input-postcode")).sendKeys("79000");

        Select dropDownCountry = new Select(
                ((ChromeDriver) driver).findElementById("input-country"));
        dropDownCountry.selectByValue("220");

        Select dropDownRegion = new Select(
                ((ChromeDriver) driver).findElementById("input-zone"));
        dropDownRegion.selectByValue("3493");
        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Filling section "Your Password"
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password"))
                .sendKeys(USER_PASSWORD);

        driver.findElement(By.id("input-confirm")).clear();
        driver.findElement(By.id("input-confirm"))
                .sendKeys(USER_PASSWORD);

        // Checkbox "Privacy policy"
        driver.findElement(By.name("agree")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY);

        // Click Continue button
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(DELAY_FOR_PRESENTATION_ONLY*2);

        // TODO - check this assert once more
        Assert.assertFalse(isCustomerLogined());

        //TODO - assert in database

    }
}
