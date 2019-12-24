package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * The {@code} class ContentEqualsSmokeTest checks availability of those tabs:
 * “Desktops”, “Laptops & Notebooks”, “Components”, “Tablets”, “Software”,
 * “Phones & PDAs”, “Cameras”, “MP3 Players”
 *
 * @version 13.0.1 15 Oct 2019
 */

public class ContentEqualsSmokeTest extends LocalTestRunner {
	/*
	 * This test method checks if there are certain tabs.
	 */
	@Test
	public void checkTabs() throws Exception {
		
		WebElement desktops = driver.findElement(By.xpath("//li/a[contains(text(), 'Desktops')]"));
		Assert.assertEquals("Desktops", desktops.getText());
		
		WebElement laptops = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Laptops & Notebooks')]"));
		Assert.assertEquals("Laptops & Notebooks", laptops.getText());
		
		WebElement components = driver.findElement(By.xpath("//li/a[contains(text(), 'Components')]"));
		Assert.assertEquals("Components", components.getText());
		
		WebElement tablets = driver.findElement(By.xpath("//li/a[contains(text(), 'Tablets')]"));
		Assert.assertEquals("Tablets", tablets.getText());
		
		WebElement software = driver.findElement(By.xpath("//li/a[contains(text(), 'Software')]"));
		Assert.assertEquals("Software", software.getText());
		
		WebElement phones = driver.findElement(By.xpath("//li/a[contains(text(), 'Phones & PDAs')]"));
		Assert.assertEquals("Phones & PDAs", phones.getText());
		
		WebElement cameras = driver.findElement(
				By.xpath("//li[@class='dropdown']/a[contains(text(),'Cameras')]"));
		Assert.assertEquals("Cameras", cameras.getText());
		
		WebElement mp3 = driver.findElement(By.xpath("//li/a[contains(text(), 'MP3 Players')]"));
		Assert.assertEquals("MP3 Players", mp3.getText());
		Thread.sleep(2000); // For Presentation Only
		
	}
}
