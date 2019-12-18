package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartTest extends LocalTestRunner {
	private final String ADD_TO_CART_BUTTON_XPATH = "//a[text()='%s']/../../following-sibling::div/button[contains(@onclick, 'cart.add')]"; 

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
		// Add to cart MacBook
		driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_XPATH, "MacBook"))).click();
		// BUG! Refresh Div, but driver used cached
		// USE Explicit Waits
		//
		//driver.navigate().refresh();
		Thread.sleep(1000); // For Presentation Only
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
		//
		// Return to Previous State
		driver.findElement(By.xpath("//img[contains(@src, '/logo.png')]")).click();
		Thread.sleep(1000); // For Presentation Only
	}

}
