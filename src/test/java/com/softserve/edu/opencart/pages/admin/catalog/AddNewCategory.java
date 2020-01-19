package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class AddNewCategory extends LeftMenuPart {
	
	public AddNewCategory(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private WebElement inputCategoryName;
	private WebElement inputMetaTagTitle;
	private WebElement dataButton;
	private WebElement inputParent;
	private WebElement saveButton;
	
	private void initElements() {
		// init elements
		inputCategoryName = driver.findElement(By.id("input-name1"));
		inputMetaTagTitle = driver.findElement(By.id("input-meta-title1"));
		dataButton = driver.findElement(By.xpath("//a[@href='#tab-data']"));
		inputParent = driver.findElement(By.cssSelector("#input-parent"));
		saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa"));
	}
	
	public AddNewCategory typeCategoryName(String arg) {
		inputCategoryName.click();
		inputCategoryName.clear();
		inputCategoryName.sendKeys(arg);
		return this;
	}
	
	public AddNewCategory typeMetaTagTitle(String arg) {
		inputMetaTagTitle.click();
		inputMetaTagTitle.clear();
		inputMetaTagTitle.sendKeys(arg);
		return this;
	}
	
	public AddNewCategory clickDataButton() {
		dataButton.click();
		return this;
	}
	
	public AddNewCategory typeParent(String arg) {
		inputParent.click();
		inputParent.clear();
		inputParent.sendKeys(arg);
		return this;
	}
	
	public ModifiedCategoriesPage gotoModifiedCategoriesPage() {
		saveButton.click();
		return new ModifiedCategoriesPage(driver);
	}
	
}
