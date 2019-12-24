package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AjaxTest {

    @Test
    public void AjaxIframePage() throws Exception {
    	System.out.println("PATH: " + this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
        System.setProperty("webdriver.chrome.driver",
                this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath());
                //this.getClass().getResource("/chromedriver-windows-32bit.exe").getPath().substring(1));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://devexpress.github.io/devextreme-reactive/react/grid/docs/guides/paging/");
        //
        // Move to Element by JavaScript Injection
        WebElement position = driver.findElement(By.id("use-paging-with-other-data-processing-plugins"));
        // WebElement position =
        // driver.findElement(By.cssSelector("#using-paging-with-other-data-processing-plugins"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", position);
        //
        // IWebElement position =
        // driver.FindElement(By.CssSelector("#using-paging-with-other-data-processing-plugins"));
        // javaScript.ExecuteScript("arguments[0].scrollIntoView(true);", position);
        //
        // Move to Element by Action
        // Actions action = new Actions(driver);
        // action.moveToElement(position).perform();
        Thread.sleep(2000); // Do no use
        //
        // Switch To IFrame
        driver.switchTo().frame(
                driver.findElement(By.xpath("//div[@id='grid-paging-remote-paging-demo-pane-preview']//iframe")));
        // Switch To IFrame
        // driver.SwitchTo().Frame(driver.FindElement(By.XPath("//div[@id='grid-paging-remote-paging-demo-pane-preview']//iframe")));
        //
        // Search First Element
        WebElement tdNevadaFirstData = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        System.out.println("tdNevadaFirstData.getText() = " + tdNevadaFirstData.getText());
        String removeText = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[3]")).getText();
        System.out.println("removeText = " + removeText);
        // IWebElement tdNevadaFirstData =
        // driver.FindElement(By.XPath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        // string firstDate = tdNevadaFirstData.Text;
        // Console.WriteLine("1. tdNevadaFirstData = " + tdNevadaFirstData.Text);
        //
        // Goto to Page 2
        driver.findElement(By.xpath("//span[text()='2']")).click();
        // Thread.sleep(4000); // Do no use
        //
        // Explicit Wait
        // Thread.sleep(2000); // DO NOT USE
        //
        // Turn off Implicit Wait
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        //
//        (new WebDriverWait(driver, 10)).until(
//        		ExpectedConditions.stalenessOf(tdNevadaFirstData));
        //
//-        (new WebDriverWait(driver, 10)).until(
//-        		ExpectedConditions.invisibilityOfElementLocated(
//-        				By.xpath("//td[text()='" + tdNevadaFirstData.getText() + "']")));
        //
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[text()='" + removeText + "']")));
        //
        // Turn on Implicit Wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //
        // Search First Element
        WebElement tdNevadaSecondData = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[2]"));
        //WebElement tdNevadaSecondData = driver.findElement(By.xpath("//td[text()='Nevada']/preceding-sibling::td[1]"));
        //Thread.sleep(4000); // DO NOT USE
        System.out.println("tdNevadaSecondData.getText() = " + tdNevadaSecondData.getText());
        //
		Thread.sleep(4000); // DO NOT USE
		driver.quit();
    }

}
