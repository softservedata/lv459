package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ModifiedCategoriesPage extends CategoriesPage {

	private WebElement success;
	
	public ModifiedCategoriesPage(WebDriver driver) {
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
