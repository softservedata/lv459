package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.ICategory;
import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class AddCategoryPage extends LeftMenuPart {
	
	private WebElement inputName;
	private WebElement inputTitle;
	private WebElement dataButton;
	private WebElement inputParent;
	private WebElement saveButton;
	
	public AddCategoryPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		// init elements
		inputName = driver.findElement(By.id("input-name1"));
		inputTitle = driver.findElement(By.id("input-meta-title1"));
		dataButton = driver.findElement(By.xpath("//a[@href='#tab-data']"));
		inputParent = driver.findElement(By.cssSelector("#input-parent"));
		saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa"));
	}
	
	public void typeName(String arg) {
		inputName.click();
		inputName.clear();
		inputName.sendKeys(arg);
	}
	
	public ModifiedCatatalogPage addCategory(ICategory arg) {
		typeName(arg.getName());
		typeTitle(arg.getTitle());
		clickDataButton();
		typeParent(arg.getParent());
		saveButton.click();
		return new ModifiedCatatalogPage(driver);
	}
	
	public AddCategoryPage typeTitle(String arg) {
		inputTitle.click();
		inputTitle.clear();
		inputTitle.sendKeys(arg);
		return this;
	}
	
	public AddCategoryPage clickDataButton() {
		dataButton.click();
		return this;
	}
	
	public AddCategoryPage typeParent(String arg) {
		inputParent.click();
		inputParent.clear();
		inputParent.sendKeys(arg);
		return this;
	}
	
	public ModifiedCatatalogPage gotoModifiedCatalogPage() {
		saveButton.click();
		return new ModifiedCatatalogPage(driver);
	}
	
}
