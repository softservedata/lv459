package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;

public class AddProductPage extends LeftMenuPart {
	
	private WebElement inputName;
	private WebElement inputTitle;
	private WebElement dataButton;
	private WebElement inputModel;
	private WebElement saveButton;

	public AddProductPage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		inputName = driver.findElement(By.id("input-name1"));
		inputTitle = driver.findElement(By.id("input-meta-title1"));
		dataButton = driver.findElement(By.xpath("//a[@href='#tab-data']"));
		inputModel = driver.findElement(By.id("input-model"));
		saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa"));
	}
	
	public AddProductPage typeName(String arg) {
		inputName.click();
		inputName.clear();
		inputName.sendKeys(arg);
		return this;
	}
	
	public AddProductPage typeTitle(String arg) {
		inputTitle.click();
		inputTitle.clear();
		inputTitle.sendKeys(arg);
		return this;
	}
	
	public AddProductPage clickDataButton() {
		dataButton.click();
		return this;
	}
	
	public AddProductPage typeModel(String arg) {
		inputModel.click();
		inputModel.clear();
		inputModel.sendKeys(arg);
		return this;
	}
	
	public ModifiedCatatalogPage gotoModifiedCategoriesPage() {
		saveButton.click();
		return new ModifiedCatatalogPage(driver);
	}
	
}
