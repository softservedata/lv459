package com.softserve.edu;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartTest extends LocalTestRunner {
	private final String ADD_TO_CART_BUTTON_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";
	private final String ADD_TO_CART_BY_STARTS_WITH = "//a[starts-with(.,'%s')]/../../following-sibling::div/button[contains(@onclick, 'cart.add')]";

	@Test
	public void modifyCartByXPath() throws Exception {
		// Precondition
		//
		// Steps
		// Type Search Field
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("mac");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Search Button
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		//WebElement spanButton = driver.findElement(By.id("cart-total"));
//		String spantext = driver.findElement(By.id("cart-total")).getText();
		// Add to cart MacBook
		driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, "MacBook"))).click();
		// BUG! Refresh Div, but driver used cached
		// USE Explicit Waits
		//
		//driver.navigate().refresh();
		Thread.sleep(1000); // For Presentation Only
		//
		//
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(
//        		ExpectedConditions.stalenessOf(spanButton));
//        (new WebDriverWait(driver, 10))
//        	.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='cart']//span[text()='" + spantext + "']")));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
//		WebElement alert = driver.findElement(By.cssSelector("div.alert.alert-success button"));
//		alert.click();
//		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
//        (new WebDriverWait(driver, 10)).until(
//        		ExpectedConditions.stalenessOf(alert));
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//
		// Add to cart MacBook
		driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, "MacBook Air"))).click();
		Thread.sleep(1000); // For Presentation Only
		// Add to cart MacBook
		driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, "MacBook"))).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Goto Cart
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, 'checkout/cart')]")).click();
		//
		// Check
		WebElement quantity = driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input"));
		Assert.assertEquals("2", quantity.getAttribute("value"));
		Thread.sleep(4000); // For Presentation Only
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

	//@Test
	public void addToCartAppleCinema() throws Exception {
		// Precondition
		//
		// Steps
		// Type Search Field
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Apple Cinema");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Search Button
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Add to cart MacBook
		driver.findElement(By.xpath(String.format(ADD_TO_CART_BY_STARTS_WITH, "Apple Cinema"))).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Choose Medium
		driver.findElement(By.xpath("//div[@id='product']//div[@class='radio']/label[text()[contains(., 'Medium')]]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Choose Checkbox 2
		driver.findElement(By.xpath("//div[@id='product']//div[@class='checkbox']/label[text()[contains(., 'Checkbox 2')]]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Text
		driver.findElement(By.xpath("//input[@placeholder='Text']")).sendKeys("My Text");
		Thread.sleep(1000); // For Presentation Only
		//
		// Open Select
		driver.findElement(By.xpath("//select")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Choose Red
		driver.findElement(By.xpath("//option[starts-with(.,'Red')]")).click();
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Text
		driver.findElement(By.xpath("//textarea[@placeholder='Textarea']")).sendKeys("Area Text");
		Thread.sleep(1000); // For Presentation Only
		//
		String filename = System.getenv().get("USERPROFILE") + "/Downloads/MyUpload.png";
		//System.out.println("filename = " + filename);
		//filename = System.getenv("USERPROFILE") + "/Downloads/MyUpload.txt";
		//System.out.println("filename2 = " + filename);
		//
		// Choose File
		// Search By XPath $x("//button[starts-with(@id,'button-upload')]/input")
		// d5259ffed2a1f884149ec29af8c7b669c59dee5d
		//driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input")).sendKeys(filename);
		WebElement uploadInput = driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
				uploadInput, "value", "d5259ffed2a1f884149ec29af8c7b669c59dee5d");
		Thread.sleep(1000); // For Presentation Only
		System.out.println("***value = " + uploadInput.getAttribute("value"));
		//
		// Type Date
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).click();
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).clear();
		driver.findElement(By.xpath("//div[@class='input-group date']/input")).sendKeys("2019-12-19");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Time
		driver.findElement(By.xpath("//div[@class='input-group time']/input")).click();
		driver.findElement(By.xpath("//div[@class='input-group time']/input")).clear();
		driver.findElement(By.xpath("//div[@class='input-group time']/input")).sendKeys("11:50");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type Date-Time
		driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).click();
		driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).clear();
		driver.findElement(By.xpath("//div[@class='input-group datetime']/input")).sendKeys("2019-12-19 11:50");
		Thread.sleep(1000); // For Presentation Only
		//
		// Type quantity
		driver.findElement(By.id("input-quantity")).click();
		driver.findElement(By.id("input-quantity")).clear();
		driver.findElement(By.id("input-quantity")).sendKeys("5");
		Thread.sleep(1000); // For Presentation Only
		//
		// Click Add to Cart Button
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(10000); // For Presentation Only
		//
		//
		// Check
		WebElement alertMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		Assert.assertTrue(alertMessage.getText().contains("Success: You have added"));
		Thread.sleep(1000); // For Presentation Only
		//
		
		/*
		//
		// Goto Cart
		driver.findElement(By.xpath("//div[@id='top-links']//a[contains(@href, 'checkout/cart')]")).click();
		//
		// Check
		WebElement quantity = driver.findElement(By.xpath("//div[@id='content']//a[text()='MacBook']/../following-sibling::td//input"));
		Assert.assertEquals("2", quantity.getAttribute("value"));
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
		*/
	}

}
