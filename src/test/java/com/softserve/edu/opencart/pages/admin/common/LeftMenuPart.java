package com.softserve.edu.opencart.pages.admin.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.pages.admin.account.SigninPage;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;

public class LeftMenuPart extends HeaderPart {

	private final String NAVIGATE_PANNEL_ACTIVE = "active";
	private final String NAVIGATION_MENU_LIST_CSSSELECTOR = "#menu > li";
	//
	private WebElement navigatePannel;
	private WebElement menuButton;
	private WebElement logoutButton;
	//
	private NavigationComponent navigationComponent;
	
	public LeftMenuPart(WebDriver driver) {
		super(driver);
		initElements();
	}

	private void initElements() {
		// init elements
		navigatePannel = driver.findElement(By.id("column-left"));
		menuButton = driver.findElement(By.id("button-menu"));
		logoutButton = driver.findElement(By.cssSelector("a[href*='route=common/logout']"));
	}

	// Page Object

	// navigatePannel
	public WebElement getNavigatePannel() {
		return navigatePannel;
	}

	public String getNavigatePannelAttribute(String attributeName) {
		return getNavigatePannel().getAttribute(attributeName);
	}

	public String getNavigatePannelClassAttribute() {
		return getNavigatePannelAttribute(TAG_ATTRIBUTE_CLASS);
	}

	// menuButton
	public WebElement getMenuButton() {
		return menuButton;
	}

	public void clickMenuButton() {
		getMenuButton().click();
	}
	
	// logoutButton
	public WebElement getLogoutButton() {
		return logoutButton;
	}

    public String getLogoutButtonText() {
        return getLogoutButton().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

	public void clickLogoutButton() {
		getLogoutButton().click();
	}
	
	// navigationComponent
	
	public NavigationComponent getNavigationComponent() {
		return navigationComponent;
	}
	
	// Functional

	public boolean isNavigatePannelActive() {
		return getNavigatePannelClassAttribute().equals(NAVIGATE_PANNEL_ACTIVE);
	}

	// navigatePannel
	public void activeNavigatePannel() {
		if (!isNavigatePannelActive()) {
			clickMenuButton();
			navigationComponent = new NavigationComponent(navigatePannel, By.cssSelector(NAVIGATION_MENU_LIST_CSSSELECTOR));
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			//System.out.println("***LEFTMENU: " + navigationComponent.getListOptionsText());
		}
	}

	public void deactivateNavigatePannel() {
		if (isNavigatePannelActive()) {
			clickMenuButton();
		}
		navigationComponent = null;
	}
	
	// Business Logic

	public CurrenciesPage gotoCurrenciesPage() {
		activeNavigatePannel();
		getNavigationComponent()
			.clickNavigationOptionByPartialName("System", "Localisation", "Currencies"); // TODO Use Enum
		return new CurrenciesPage(driver);
	}
	
    public SigninPage logout() {
    	clickLogoutButton();
        return new SigninPage(driver);
    }

}
