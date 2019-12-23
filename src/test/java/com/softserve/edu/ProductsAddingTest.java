package com.softserve.edu;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Test object: horizontal and vertical menu on Opencart (content equals).
 * Test design technique: state transition diagram.
 * Test items: 
 * -tab “Desktops”,
 * -tab “Laptops & Notebooks”,
 * -tab “Components”,
 * -tab “Tablets”,
 * -tab “Software”,
 * -tab “Phones & PDAs”,
 * -tab “Cameras”,
 * -tab “MP3 Players”,
 * -menus which are visible after clicking on some tab,
 * -changes after adding new tab,
 * -menus of each tab.
 * 
 * @version 13.0.1 15 Oct 2019
 */
public class ProductsAddingTest extends AdminTestRunner {
	private final String POINT_ON_CATALOG_TAB = "//li[@id='menu-catalog']//i[contains(@class, 'fa fa-tags fw')]";
	private final String GET_PRODUCTS_TAB = "#menu-catalog > :nth-child(2) > :nth-child(2) > a";
	/*
	 * This test method adds items to Tablets tab.
	 */
	@Test
	public void addSamsungToTablets() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=49')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-manufacturer")).click();
		driver.findElement(By.id("input-manufacturer")).clear();
		driver.findElement(By.id("input-manufacturer")).sendKeys("Samsung");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Tablets");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(":nth-child(2) > .col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addHTCtoSmartphones() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=28')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Smartphones");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addiPhoneToSmartphones() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=40')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Smartphones");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Smartphones tab.
	 */
	@Test
	public void addPalmToSmartphones() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=29')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Smartphones");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > li > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Cameras tab.
	 */
	@Test
	public void addCanonToCameras() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=30')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Cameras");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
	/*
	 * This test method adds items to Cameras tab.
	 */
	@Test
	public void addNikonToCameras() throws Exception {
		driver.findElement(By.xpath(POINT_ON_CATALOG_TAB)).click();
		Thread.sleep(2000); // For Presentation Only
		driver.findElement(By.cssSelector(GET_PRODUCTS_TAB)).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'id=31')]")).click();
		Thread.sleep(1000); // For Presentation Only
		driver.findElement(By.xpath("//a[contains(@href,'links')]")).click();
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-manufacturer")).click();
		driver.findElement(By.id("input-manufacturer")).clear();
		driver.findElement(By.id("input-manufacturer")).sendKeys("Nikon");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.id("input-category")).click();
		driver.findElement(By.id("input-category")).clear();
		driver.findElement(By.id("input-category")).sendKeys("Cameras");
		Thread.sleep(1000); // For Presentation Only
		
		driver.findElement(By.cssSelector(".col-sm-10 > .dropdown-menu > :nth-child(2) > a")).click();
		driver.findElement(By.cssSelector(".pull-right > .btn-primary")).click();
		Thread.sleep(1000); // For Presentation Only
	}
	
}
