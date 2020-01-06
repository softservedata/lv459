package com.softserve.edu.opencart.pages.user.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;

public class ProductsDisplayComponent extends ProductsContainerComponent {

	private WebElement listViewButton;
	private WebElement gridViewButton;
	// TODO productCompare
	private Select inputSort;
	private Select inputLimit;

	public ProductsDisplayComponent(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		listViewButton = driver.findElement(By.id("list-view"));
		gridViewButton = driver.findElement(By.id("grid-view"));
		// TODO ProductCompare
		inputSort = new Select(driver.findElement(By.id("input-sort")));
		inputLimit = new Select(driver.findElement(By.id("input-limit")));
	}

	// Page Object

	// listViewButton
	public WebElement getListViewButton() {
		return listViewButton;
	}

	public void clickListViewButton() {
		getListViewButton().click();
	}

	// gridViewButton
	public WebElement getGridViewButton() {
		return gridViewButton;
	}

	public void clickGridViewButton() {
		getGridViewButton().click();
	}

	// productCompare

	// inputSort
	public Select getInputSort() {
		return inputSort;
	}

	public WebElement getInputSortWebElement() {
		return getInputSort().getWrappedElement();
	}

	public String GetInputSortText() {
		return getInputSort().getFirstSelectedOption().getText();
	}

	public void setInputSort(String text) {
		getInputSort().selectByVisibleText(text);
	}

	public void clickInputSort() {
		getInputSortWebElement().click();
	}

	// inputLimit
	public Select getInputLimit() {
		return inputLimit;
	}

	public WebElement getInputLimitWebElement() {
		return getInputLimit().getWrappedElement();
	}

	public String getInputLimitText() {
		return getInputLimit().getFirstSelectedOption().getText();
	}

	public void setInputLimit(String text) {
		getInputLimit().selectByVisibleText(text);
	}

	public void clickInputLimit() {
		getInputLimitWebElement().click();
	}

	// Functional

	// Business Logic

	public ProductsDisplayComponent viewProductsByList() {
		clickListViewButton();
		//initElements();
		//return this;
		return new ProductsDisplayComponent(driver);
	}

	public ProductsDisplayComponent viewProductsByGrid() {
		clickGridViewButton();
		//initElements();
		//return this;
		return new ProductsDisplayComponent(driver);
	}

}
