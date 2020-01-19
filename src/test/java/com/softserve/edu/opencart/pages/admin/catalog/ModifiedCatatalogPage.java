package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModifiedCatatalogPage extends CategoriesPage {

	private WebElement success;
	
	public ModifiedCatatalogPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		success = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		
	}

	public String getSuccessText() {
		return success.getText();
	}
	

}
