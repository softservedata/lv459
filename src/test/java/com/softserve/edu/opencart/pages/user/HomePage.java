package com.softserve.edu.opencart.pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.pages.user.common.ProductsContainerComponent;
import com.softserve.edu.opencart.pages.user.common.TopPart;

public class HomePage extends TopPart {
	public static final String EXPECTED_IPHONE6 = "iPhone6";
	//
	private WebElement slideshow0;
	//
	private ProductsContainerComponent productsContainerComponent;

	public HomePage(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		slideshow0 = driver.findElement(By.id("slideshow0"));
		productsContainerComponent = new ProductsContainerComponent(driver);
	}

	// Page Object

	// slideshow0
	public WebElement getSlideshow0() {
		return slideshow0;
	}

	public WebElement getSlideshow0FirstImage() {
		// return getSlideshow0().findElement(By.cssSelector("a > img"));
		return getSlideshow0().findElement(By.xpath(".//a/img"));
		// return Slideshow0.findElement(By.xpath("//a/img")); // ERROR
		// return driver.findElement(By.xpath("//div[@id='slideshow0']//a/img"));
	}

	public String getSlideshow0FirstImageAttributeText(String attribute) {
		return getSlideshow0FirstImage().getAttribute(attribute).trim();
	}

	public String getSlideshow0FirstImageAttributeSrcText() {
		return getSlideshow0FirstImageAttributeText(TAG_ATTRIBUTE_SRC);
	}

	// productComponentsContainer
	public ProductsContainerComponent getProductComponentsContainer() {
		return productsContainerComponent;
	}
	
	// Functional

	// Business Logic
	
	public HomePage chooseCurrency(Currencies currency)
    {
        clickCurrencyByPartialName(currency);
        return new HomePage(driver);
    }
}
