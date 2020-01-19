package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NavigationComponent {

	private final String OPTIONNAME_NOT_FOUND = "OptionName not Found.";
	private final String NAVIGATION_OPTIONS_TEXT_CSSSELECTOR = "> a.parent";
	private final String NAVIGATION_OPTIONS_LIST_CSSSELECTOR = "> ul > li";
	//
	private WebElement parent;
	//
	private List<WebElement> listOptions;

	// level 0 "#column-left"
	// level 1 "#menu > li"
	// "#menu-system > ul > li"
	//

	public NavigationComponent(WebElement parent, By searchLocator) {
		this.parent = parent;
		initElements(searchLocator);
	}

	private void initElements(By searchLocator) {
		// init elements
		listOptions = parent.findElements(searchLocator);
	}

	// Page Object

	// listOptions
	public List<WebElement> getListOptions() {
		return listOptions;
	}

	// Functional

	// listOptions
	public WebElement getNavigationOptionByPartialName(String optionName) {
		WebElement result = null;
		for (WebElement current : getListOptions()) {
			WebElement liCurrent = current.findElement(By.cssSelector(NAVIGATION_OPTIONS_TEXT_CSSSELECTOR));
			if (liCurrent.getText().toLowerCase().contains(optionName.toLowerCase())) {
				result = current;
				break;
			}
		}
		// TODO Move to Utility
		if (result == null) {
			// TODO Develop Custom Exception
			throw new RuntimeException(OPTIONNAME_NOT_FOUND);
		}
		return result;
	}

	public List<String> getListOptionsText() {
		List<String> result = new ArrayList<>();
		for (WebElement current : getListOptions()) {
			WebElement liCurrent = current.findElement(By.cssSelector(NAVIGATION_OPTIONS_TEXT_CSSSELECTOR));
			result.add(liCurrent.getText());
		}
		return result;
	}

	public boolean isExistOptionByPartialName(String optionName) {
		boolean isFound = false;
		for (String current : getListOptionsText()) {
			if (current.toLowerCase().contains(optionName.toLowerCase())) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public void clickNavigationOptionByPartialName(String... optionName) {
		String firstOptionName = optionName[0];
		WebElement currentElement = getNavigationOptionByPartialName(firstOptionName);
		// Check if "active open" 
		currentElement.click();
		if (optionName.length > 1) {
			String[] nextOptionName = new String[optionName.length - 1];
			for (int i = 0; i < nextOptionName.length; i++) {
				nextOptionName[i] = optionName[i + 1];
			}
			new NavigationComponent(currentElement, By.cssSelector(NAVIGATION_OPTIONS_LIST_CSSSELECTOR))
				.clickNavigationOptionByPartialName(nextOptionName);
		}
	}

	// Business Logic

}
