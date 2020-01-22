package com.softserve.edu.opencart.pages.admin.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.softserve.edu.opencart.pages.admin.catalog.CategoriesPage;
import com.softserve.edu.opencart.pages.admin.catalog.ProductsPage;
import com.softserve.edu.opencart.pages.admin.currencies.CurrenciesPage;

public abstract class LeftMenuPart extends TopMenuPart {
    private final String NAVIGATE_PANNEL_ACTIVE = "active";
    private final String NAVIGATION_MENU_LIST_CSSSELECTOR = "#menu > li";
    //
    private WebElement navigatePannel;
    private WebElement logoutButton;
    //
    private NavigationComponent navigationComponent;
    protected WebElement profile;
    protected WebElement catalog;
    protected WebElement extensions;
    protected WebElement design;
    protected WebElement sales;
    protected WebElement customers;
    protected WebElement marketing;
    protected WebElement system;
    protected WebElement reports;
    protected WebElement stats;
    protected WebElement header;
    protected WebElement footer;

    WebDriverWait wait = new WebDriverWait(driver, 5);

    
    protected WebElement categories;
    protected WebElement products;

    protected DropDownComponent dropDownCustomer;

    public LeftMenuPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        // init elements
        header = driver.findElement(By.cssSelector(".page-header"));
        footer = driver.findElement(By.id("footer"));

        if (driver.findElement(By.cssSelector(("nav#column-left"))).getAttribute("class").isEmpty()) {
            //Expand 'burger menu'
            driver.findElement(By.cssSelector(("#button-menu"))).click();
        }

        catalog = driver.findElement(By.id("menu-catalog"));
        extensions = driver.findElement(By.id("menu-extension"));
        design = driver.findElement(By.id("menu-design"));
        sales = driver.findElement(By.id("menu-sale"));
        customers = driver.findElement(By.id("menu-customer"));
        marketing = driver.findElement(By.id("menu-marketing"));
        system = driver.findElement(By.id("menu-system"));
        reports = driver.findElement(By.id("menu-report"));
        stats = driver.findElement(By.id("stats"));
        
        categories = driver.findElement(
				By.xpath("//li[@id='menu-catalog']//a[contains(text(),'Categories')]"));
        products = driver.findElement(
				By.xpath("//li[@id='menu-catalog']//a[contains(text(),'Products')]"));

        navigatePannel = driver.findElement(By.id("column-left"));
    }

    //CUSTOM
    public WebElement getSystem() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(system));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return system;
    }

    public void clickSystem() {
        getSystem().click();
    }

    public WebElement getLocalisation() {
        WebElement localisation = driver.findElement(By.xpath("//*[@id='menu-system']//a[contains(text(), 'Localisation')]"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(localisation));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return localisation;
    }

    public void clickLocalisation() {
        getLocalisation().click();
    }

    public WebElement getCurrencies() {
        WebElement currencies = driver.findElement(By.xpath("//*[@id='menu-system']//li/a[contains(text(), 'Currencies')]"));
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(currencies));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return currencies;
    }

    public void clickCurrencies() {
        getCurrencies().click();
    }


    //CUSTOM

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
            clickBurgerMenu();
            navigationComponent = new NavigationComponent(navigatePannel, By.cssSelector(NAVIGATION_MENU_LIST_CSSSELECTOR));
        }
    }

    public void deactivateNavigatePannel() {
        if (isNavigatePannelActive()) {
            clickBurgerMenu();
        }
        navigationComponent = null;
    }

    // Business Logic

    public CurrenciesPage gotoCurrenciesPage() {
        activeNavigatePannel();
        getNavigationComponent()
                .clickNavigationOptionByPartialName("System", "Localisation", "Currencies");
        return new CurrenciesPage(driver);
    }

    public CurrenciesPage gotoCurrencyPage() {
        activeNavigatePannel();
        clickSystem();
        clickLocalisation();
        clickCurrencies();
        return new CurrenciesPage(driver);
    }

////
//    public void Categories() {
//        catalog.click();
//    }
//    
//    public void clickCategories() {
//        categories.click();
//    }
//    
//    public void clickCategories() {
//    	clickCatalog();
//    	clickCategories();
//    	return new CategoriesPage(WebDriver driver);
//    }
//    
//    public void clickProducts() {
//        products.click();
//    }
//    
//    public ProductsPage gotoProductPage() {
//    	clickCatalog();
//    	clickProducts();
//    	return new ProductsPage(driver);
//    }
////   

    
    //Categories
    public void clickCatalog() {
        catalog.click();
    }
    
    public void clickCategories() {
        categories.click();
    }
    
    public CategoriesPage gotoCategoriesPage() {
    	clickCatalog();
    	clickCategories();
    	return new CategoriesPage(driver);
    }
    
    //Products
    public void clickProducts() {
        products.click();
    }
    
    public ProductsPage gotoProductPage() {
    	clickCatalog();
    	clickProducts();
    	return new ProductsPage(driver);
    }
//   

    public void clickCustomers() {
        customers.click();
    }

    public String getCustomersText() {
        return customers.getText();
    }

    public WebElement getCustomers() {
        return customers;
    }
    
}
