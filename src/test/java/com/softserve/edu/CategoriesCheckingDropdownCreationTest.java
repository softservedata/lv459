package com.softserve.edu;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * The {@code} class CategoriesCheckingDropdownCreationTest checks if the new elements
 * has been added to drop-down menu of next tabs: “Tablets”, “Software”, “Phones & PDAs”,
 * “Cameras”, “MP3 Players”.
 * 
 * @version 13.0.1 15 Oct 2019
 */
public class CategoriesCheckingDropdownCreationTest extends LocalTestRunner {
	/*
	 * This test method checks if the new element has been added to drop-down menu
	 * of Tablets Tab
	 */
	@Test
	public void checkTablets() {
		
		String expectedTablets = "Tablets (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Tablets')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement tablets = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'Tablets (0)')]"));
		Assert.assertEquals(expectedTablets, tablets.getText());
		
	}
	
	/*
	 * This test method checks if the new element has been added to drop-down menu
	 * of Software Tab
	 */
	@Test
	public void checkSoftware() {
		
		String expectedSoftware = "Software (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Software')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement software = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'Software (0)')]"));
		Assert.assertEquals(expectedSoftware, software.getText());
		
	}
	
	/*
	 * This test method checks if the new element has been added to drop-down menu
	 * of Phones & PDAs Tab
	 */
	@Test
	public void checkSmartphones() {
		
		String expectedSmartphones = "Smartphones (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'Phones & PDAs')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement smartphones = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'Smartphones (0)')]"));
		Assert.assertEquals(expectedSmartphones, smartphones.getText());
		
	}
	
	/*
	 * This test method checks if the new element has been added to drop-down menu
	 * of Cameras Tab
	 */
	@Test
	public void checkCameras() {
		
		String expectedCameras = "Cameras (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li[@class='dropdown']/a[contains(text(),'Cameras')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement cameras = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[text()='Cameras (0)']"));
		Assert.assertEquals(expectedCameras, cameras.getText());
		
	}
	
	/*
	 * This test method checks if the new element has been added to drop-down menu
	 * of MP3 Players Tab
	 */
	@Test
	public void checkMP3() {
		
		String expectedMP3 = "MP3 Players (0)";
		
		WebElement components = driver.findElement(
				By.xpath("//li/a[contains(text(), 'MP3 Players')]"));
		Actions action = new Actions(driver);		
		action.moveToElement(components).perform();
		
		WebElement mp3 = driver.findElement(
				By.xpath("//ul[@class='list-unstyled']//a[contains(text(),'MP3 Players (0)')]"));
		Assert.assertEquals(expectedMP3, mp3.getText());
		
	}
	
}
