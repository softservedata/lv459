package com.softserve.edu;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * The {@code} class ProductsAddingTest adds products into the next categories:
 * “Tablets”, “Software”, “Phones & PDAs”, “Cameras”, “MP3 Players”.
 * 
 * @version 13.0.1 15 Oct 2019
 */
public class ProductsAddingTest extends ProductsTestRunner {
	private final String SWITCH_TO_LINKS_TAB = "//li/a[text()='Links']";
	private final String INPUT_MANUFACTURER = "input-manufacturer";
	private final String INPUT_CATEGORY = "input-category";
	/*
	 * This test method adds items to Tablets tab.
	 */
	@Test
	public void addSamsungToTablets() throws Exception {
		driver.findElement(By.xpath(
				"//td[text()='Samsung Galaxy Tab 10.1']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_MANUFACTURER)).click();
		driver.findElement(By.id(INPUT_MANUFACTURER)).clear();
		driver.findElement(By.id(INPUT_MANUFACTURER)).sendKeys("Samsung");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Tablets");
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(":nth-child(2) > .col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addHTCtoSmartphones() throws Exception {
		driver.findElement(
				By.xpath("//td[text()='HTC Touch HD']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Smartphones");
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addiPhoneToSmartphones() throws Exception {
		driver.findElement(By.xpath("//td[text()='iPhone']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Smartphones");
		Thread.sleep(2000); // For Presentation Only	
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addPalmToSmartphones() throws Exception {
		driver.findElement(
				By.xpath("//td[text()='Palm Treo Pro']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Smartphones");
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Cameras tab.
	 */
	@Test
	public void addCanonToCameras() throws Exception {
		driver.findElement(
				By.xpath("//td[text()='Canon EOS 5D']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Cameras");
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Cameras tab.
	 */
	@Test
	public void addNikonToCameras() throws Exception {
		driver.findElement(By.xpath("//td[text()='Nikon D300']/following-sibling::td[*]/a")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath(SWITCH_TO_LINKS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_MANUFACTURER)).click();
		driver.findElement(By.id(INPUT_MANUFACTURER)).clear();
		driver.findElement(By.id(INPUT_MANUFACTURER)).sendKeys("Nikon");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id(INPUT_CATEGORY)).click();
		driver.findElement(By.id(INPUT_CATEGORY)).clear();
		driver.findElement(By.id(INPUT_CATEGORY)).sendKeys("Cameras");
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
}
