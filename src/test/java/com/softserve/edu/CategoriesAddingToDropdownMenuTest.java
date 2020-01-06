package com.softserve.edu;

import org.junit.Test;
import org.openqa.selenium.By;

/**
 * The {@code} class CategoriesAddingToDropdownMenuTest adds new categories in drop-down menu
 * of next tabs: “Tablets”, “Software”, “Phones & PDAs”, “Cameras”, “MP3 Players”.
 * 
 * @version 13.0.1 15 Oct 2019
 */
public class CategoriesAddingToDropdownMenuTest extends CategoriesTestRunner {
	private final String ADD_CATEGORY_NAME = "input-name1";
	private final String ADD_META_TAG_TITLE = "input-meta-title1";
	private final String SWITCH_TO_DATA_TAB = "//a[@href='#tab-data']";
	private final String INPUT_PARENT = "input-parent";
	/*
	 * This test method adds Tablets category to drop-down menu.
	 */
	@Test
	public void addTablets() {
		driver.findElement(By.id(ADD_CATEGORY_NAME)).click();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).clear();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).sendKeys("Tablets");
		
		driver.findElement(By.id(ADD_META_TAG_TITLE)).click();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).clear();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).sendKeys("Tablets");
		driver.findElement(By.xpath(SWITCH_TO_DATA_TAB)).click();
		
		driver.findElement(By.id(INPUT_PARENT)).click();
		driver.findElement(By.id(INPUT_PARENT)).clear();
		driver.findElement(By.id(INPUT_PARENT)).sendKeys("Tablets");
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Tablets']")).click();
	
	}
	
	/*
	 * This test method adds Software category to drop-down menu.
	 */
	@Test
	public void addSoftware() {
		driver.findElement(By.id(ADD_CATEGORY_NAME)).click();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).clear();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).sendKeys("Software");
		
		driver.findElement(By.id(ADD_META_TAG_TITLE)).click();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).clear();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).sendKeys("Software");
		driver.findElement(By.xpath(SWITCH_TO_DATA_TAB)).click();
		
		driver.findElement(By.id(INPUT_PARENT)).click();
		driver.findElement(By.id(INPUT_PARENT)).clear();
		driver.findElement(By.id(INPUT_PARENT)).sendKeys("Software");
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Software']")).click();
	
	}
	
	/*
	 * This test method adds Smartphones category to drop-down menu.
	 */
	@Test
	public void addSmartphones() {
		driver.findElement(By.id(ADD_CATEGORY_NAME)).click();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).clear();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).sendKeys("Smartphones");
		
		driver.findElement(By.id(ADD_META_TAG_TITLE)).click();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).clear();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).sendKeys("Smartphones");
		driver.findElement(By.xpath(SWITCH_TO_DATA_TAB)).click();
		
		driver.findElement(By.id(INPUT_PARENT)).click();
		driver.findElement(By.id(INPUT_PARENT)).clear();
		driver.findElement(By.id(INPUT_PARENT)).sendKeys("Phones & PDAs");
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Phones & PDAs']")).click();
	
	}
	
	/*
	 * This test method adds Cameras category to drop-down menu.
	 */
	@Test
	public void addCameras() {
		driver.findElement(By.id(ADD_CATEGORY_NAME)).click();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).clear();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).sendKeys("Cameras");
		
		driver.findElement(By.id(ADD_META_TAG_TITLE)).click();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).clear();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).sendKeys("Cameras");
		driver.findElement(By.xpath(SWITCH_TO_DATA_TAB)).click();
		
		driver.findElement(By.id(INPUT_PARENT)).click();
		driver.findElement(By.id(INPUT_PARENT)).clear();
		driver.findElement(By.id(INPUT_PARENT)).sendKeys("Cameras");
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='Cameras']")).click();
	
	}
	
	/*
	 * This test method adds MP3 Players category to drop-down menu.
	 */
	@Test
	public void addMP3s() {
		driver.findElement(By.id(ADD_CATEGORY_NAME)).click();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).clear();
		driver.findElement(By.id(ADD_CATEGORY_NAME)).sendKeys("MP3 Players");
		
		driver.findElement(By.id(ADD_META_TAG_TITLE)).click();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).clear();
		driver.findElement(By.id(ADD_META_TAG_TITLE)).sendKeys("MP3 Players");
		driver.findElement(By.xpath(SWITCH_TO_DATA_TAB)).click();
		
		driver.findElement(By.id(INPUT_PARENT)).click();
		driver.findElement(By.id(INPUT_PARENT)).clear();
		driver.findElement(By.id(INPUT_PARENT)).sendKeys("MP3 Players");
		driver.findElement(By.xpath("//ul[@class='dropdown-menu']//a[text()='MP3 Players']")).click();

	}
}
