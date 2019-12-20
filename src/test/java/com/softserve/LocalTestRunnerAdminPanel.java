package com.softserve;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public abstract class LocalTestRunnerAdminPanel extends LocalTestRunnerSetIP {

    @Before
    public void pageLoad() throws Exception{
        System.out.println("@Before method - Loading Page");

    }

    @After
    public void stopPage() {
        System.out.println("@After method - Log out");

        // Click 'Logout' button
        driver.findElement(By.cssSelector("a[href*='common/logout']"));
    }


}
