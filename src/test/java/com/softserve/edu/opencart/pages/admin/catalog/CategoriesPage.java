package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.common.LeftMenuPart;
/**
 * 
 * @author alessandro
 *
 */
public class CategoriesPage extends LeftMenuPart {

	private WebElement title;
	private WebElement addNewButton;
	private WebElement rebuildButton;
	private WebElement deleteButton;
	private WebElement inputCategoryName;
	private WebElement inputMetaTagTitle;
	private WebElement switchToData;
	private WebElement inputParent;
	private WebElement saveButton;
	
	public CategoriesPage(WebDriver driver) {
		super(driver);
		initElements();
	}
	
	private void initElements() {
		// init elements
		title = driver.findElement(By.cssSelector("div.page-header h1"));
		addNewButton = driver.findElement(By.cssSelector(".pull-right > .btn-primary"));
		rebuildButton = driver.findElement(By.cssSelector(".btn-default"));
		deleteButton = driver.findElement(By.cssSelector("button.btn.btn-danger"));
		//
		inputCategoryName = driver.findElement(By.id("#input-name1"));
		inputMetaTagTitle = driver.findElement(By.id("#input-meta-title1"));
		switchToData = driver.findElement(By.cssSelector("#form-category > ul > li.active > a"));
		inputParent = driver.findElement(By.id("#input-parent"));
		saveButton = driver.findElement(By.cssSelector(".btn-primary > .fa"));
	}

	// Page Object

	// title
	public WebElement getTitle() {
		return title;
	}

	public String getTitleText() {
		return getTitle().getText();
	}

	//addNewButton
	public WebElement getAddNewButton() {
		return addNewButton;
	}

	public String getAddNewButtonText() {
		return getAddNewButton().getText();
	}
	
	public void clickAddNewButton() {
        getAddNewButton().click();
    }
	
	//rebuildButton
	public WebElement getRebuildButton() {
		return rebuildButton;
	}

	public String getRebuildButtonText() {
		return getRebuildButton().getText();
	}
	
	public void clickRebuildButton() {
        getRebuildButton().click();
    }
	
	//deleteButton
	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public String getDeleteButtonText() {
		return getDeleteButton().getText();
	}
	
	public void clickDeleteButton() {
        getDeleteButton().click();
    }
	
	
	// Functional

	// Business Logic
	
}
