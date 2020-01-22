package com.softserve.edu.opencart.pages.admin.catalog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DiscountTableComponent {

	 private WebDriver driver;
	    private WebElement tableElement;
	    private WebElement deleteButton;
	    private WebElement quantity;
	    private WebElement priority;
	    private WebElement price;
	    private WebElement startDate;
	    private WebElement endData;


	    DiscountTableComponent(WebDriver driver) {
	        this.driver = driver;
	        initElements();
	    }

	    private void initElements() {
	        tableElement = driver.findElement(By.xpath("//table[@id='discount']/tbody/tr[last()]"));
	        deleteButton = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
	        quantity = tableElement.findElement(By.xpath("//td/input[@placeholder='Quantity']"));
	        priority = tableElement.findElement(By.xpath("//td/input[@placeholder='Priority']"));
	        price = tableElement.findElement(By.xpath("//td/input[@placeholder='Price']"));
	        startDate = tableElement.findElement(By.xpath("//td/div/input[@placeholder='Date Start']"));
	        endData = tableElement.findElement(By.xpath("//td/div/input[@placeholder='Date End']"));
	    }

	    private void clickDeleteButton() {
	        deleteButton.click();
	    }
	    private void clickQuantity() {
	        quantity.click();
	    }
	    private void clearQuantity() {
	        quantity.clear();
	    }
	    private void setQuantity(int countOfProduct) {
	        quantity.sendKeys(String.valueOf(countOfProduct));
	    }

	    private void clickPriority() {
	        priority.click();
	    }
	    private void clearPriority() {
	        priority.clear();
	    }
	    private void setPriority(int  productPriority) {
	        priority.sendKeys(String.valueOf(productPriority));
	    }

	    private void clickPrice() {
	        price.click();
	    }

	    private void clearPrice() {
	        price.clear();
	    }

	    private void setPrice(double priceOfProduct) {
	        price.sendKeys(String.valueOf(priceOfProduct));
	    }

	    private void clickStartDate() {
	        startDate.click();
	    }

	    private void clearStartDate() {
	        startDate.clear();
	    }

	    private void setStartDate(String startDateOfDiscount) {
	        startDate.sendKeys(startDateOfDiscount);
	    }

	    private void clickEndDate() {
	        endData.click();
	    }

	    private void clearEndDate() {
	        endData.clear();
	    }

	    private void setEndDate(String endDateOfDiscount) {
	        endData.sendKeys(endDateOfDiscount);
	    }


	    private void enterQuantity(Discount discount) {
	        clickQuantity();
	        clearQuantity();
	        setQuantity(discount.getQuantityWeb());
	    }

	    private void enterPriority(Discount discount) {
	        clickPriority();
	        clearPriority();
	        setPriority(discount.getPriority());
	    }

	    private void enterPrice(Discount discount) {
	        clickPrice();
	        clearPrice();
	        setPrice(discount.getPrice());
	    }
	    private void enterStartDate(Discount discount) {
	        clickStartDate();
	        clearStartDate();
	        setStartDate(discount.getStartDate());
	    }
	    private void enterEndDate(Discount discount) {
	        clickEndDate();
	        clearEndDate();
	        setEndDate(discount.getEndData());
	    }


	    protected void fillInAllFields(Discount discount) {
	        enterQuantity(discount);
	        enterPriority(discount);
	        enterPrice(discount);
	        enterStartDate(discount);
	        enterEndDate(discount);
	    }

	    protected void deleteComponent() {
	        clickDeleteButton();
	    }

}
