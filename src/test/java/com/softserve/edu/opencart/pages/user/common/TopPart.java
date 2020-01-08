package com.softserve.edu.opencart.pages.user.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.ApplicationStatus;
import com.softserve.edu.opencart.data.Currencies;
import com.softserve.edu.opencart.data.Product;
import com.softserve.edu.opencart.data.User;
import com.softserve.edu.opencart.pages.user.HomePage;
import com.softserve.edu.opencart.pages.user.account.AccountLogoutPage;
import com.softserve.edu.opencart.pages.user.account.LoginPage;
import com.softserve.edu.opencart.pages.user.account.MyAccountPage;
import com.softserve.edu.opencart.pages.user.account.RegisterPage;
import com.softserve.edu.opencart.pages.user.account.WishListPage;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import com.softserve.edu.opencart.pages.user.search.SearchUnsuccessPage;

public abstract class TopPart {
    protected final String OPTION_NULL_MESSAGE = "DropdownComponent is null";
    protected final String OPTION_NOT_FOUND_MESSAGE = "Option %s not found in %s";
    protected final String PAGE_DO_NOT_EXIST="Page do not exist!!!";
    //
    protected final String TAG_ATTRIBUTE_VALUE = "value";
    protected final String TAG_ATTRIBUTE_SRC = "src";
    //
    protected final String LIST_CURRENCIES_CSSSELECTOR = "div.btn-group.open ul.dropdown-menu li";
    protected final String DROPDOWN_MYACCOUNT_CSSSELECTOR = ".dropdown-menu-right li";
    //
	protected WebDriver driver;
    //
    private WebElement currency;
    private WebElement myAccount;
    private WebElement wishList;
    private WebElement shoppingCart;
    private WebElement checkout;
    private WebElement logo;
    private WebElement searchTopField;
    private WebElement searchTopButton;
    private WebElement cartButton;
    //
    // private MainMenuComponent MainMenuComponent; 
    private DropdownComponent dropdownComponent;
    //ButtonCartContainerComponent
    private DropdownGuest dropdownGuest;
    private DropdownLogged dropdownLogged;

	public TopPart(WebDriver driver) {
		this.driver = driver;
		initElements();
	}

	private void initElements() {
		// init elements
        currency = driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        myAccount = driver.findElement(By.cssSelector(".list-inline > li > a.dropdown-toggle"));
        wishList = driver.findElement(By.id("wishlist-total"));
        shoppingCart = driver.findElement(By.cssSelector("a[title='Shopping Cart']"));
        checkout = driver.findElement(By.cssSelector("a[title='Checkout']"));
        logo = driver.findElement(By.cssSelector("#logo a"));
        searchTopField = driver.findElement(By.name("search"));
        searchTopButton = driver.findElement(By.cssSelector("button.btn.btn-default"));
        cartButton = driver.findElement(By.cssSelector("#cart > button"));
	}

	// Page Object

    // currency
    public WebElement getCurrency() {
    	//return driver.findElement(By.cssSelector(".btn.btn-link.dropdown-toggle"));
        return currency;
    }

    public String getCurrencyText() {
        return getCurrency().getText();
    }

    public void clickCurrency() {
        getCurrency().click();
    }

    // myAccount
    public WebElement getMyAccount() {
        return myAccount;
    }

    public String getMyAccountText() {
        return getMyAccount().getText();
    }

    public void clickMyAccount() {
        getMyAccount().click();
    }

    // wishList
    public WebElement getWishList() {
        return wishList;
    }

    public String getWishListText() {
        return getWishList().getText();
    }

    public void clickWishList() {
        getWishList().click();
    }

//    public int getWishListNumber() {
//        Use getWishListText()
//    }

    // shoppingCart
    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public String getShoppingCartText() {
        return getShoppingCart().getText();
    }

    public void clickShoppingCart() {
        getShoppingCart().click();
    }

    // checkout
    public WebElement getCheckout() {
        return checkout;
    }

    public String getCheckoutText() {
        return getCheckout().getText();
    }

    public void clickCheckout() {
        getCheckout().click();
    }

    // logo
    public WebElement getLogo() {
        return logo;
    }

    public void clickLogo() {
        getLogo().click();
    }

    // searchTopField
    public WebElement getSearchTopField() {
        return searchTopField;
    }

    public String getSearchTopFieldText() {
        return getSearchTopField().getAttribute(TAG_ATTRIBUTE_VALUE);
    }

    public void clearSearchTopField() {
        getSearchTopField().clear();
    }

    public void clickSearchTopField() {
        getSearchTopField().click();
    }

    public void setSearchTopField(String text) {
        getSearchTopField().sendKeys(text);
    }

    // searchTopButton
    public WebElement getSearchTopButton() {
        return searchTopButton;
    }

    public void clickSearchTopButton() {
        getSearchTopButton().click();
    }

    // cartButton
    public WebElement getCartButton() {
        return cartButton;
    }

    public String getCartButtonText() {
        return getCartButton().getText();
    }

    public void clickCartButton() {
        getCartButton().click();
    }

//  public int getCartButtonCount() {
//  Use getCartButtonText()
//}

//  public int getCartButtonSum() {
//  Use getCartButtonText()
//}
    
    // dropdownComponent
    protected DropdownComponent getDropdownComponent() {
        //LeaveUtils.castExceptionByCondition(dropdownOptions == null, OPTION_NULL_MESSAGE);
    	if (dropdownComponent == null)
        {
            // TODO Develop Custom Exception 
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownComponent;
    }

    private DropdownComponent createDropdownComponent(By searchLocator) {
        dropdownComponent = new DropdownComponent(driver, searchLocator);
        return getDropdownComponent();
    }

    private void clickDropdownComponentByPartialName(String optionName) {
        //LeaveUtils.castExceptionByCondition(!getDropdownOptions().isExistDropdownOptionByPartialName(optionName),
        //        String.format(OPTION_NOT_FOUND_MESSAGE, optionName, dropdownOptions.getListOptionsText().toString()));
    	if (!getDropdownComponent().isExistDropdownOptionByPartialName(optionName))
        {
            // TODO Develop Custom Exception 
            throw new RuntimeException(String.format(OPTION_NOT_FOUND_MESSAGE, optionName, getDropdownComponent().getListOptionsText().toString()));
        }
    	getDropdownComponent().clickDropdownOptionByPartialName(optionName);
    	dropdownComponent = null;
    	//closeDropdownComponent();
    }

    private void closeDropdownComponent() {
        clickSearchTopField();
        dropdownComponent = null;
    }

    // dropdownGuest
    protected DropdownGuest getDropdownGuest() {
    	if (dropdownGuest == null)
        {
            // TODO Develop Custom Exception 
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownGuest;
    }

    private DropdownGuest createDropdownGuest() {
        dropdownGuest = new DropdownGuest(driver);
        return getDropdownGuest();
    }

    private void clickDropdownGuestRegister() {
    	getDropdownGuest().clickRegister();
    	dropdownGuest = null;
    }
    
    private void clickDropdownGuestLogin() {
    	getDropdownGuest().clickLogin();
    	dropdownGuest = null;
    }

    private void closeDropdownGuest() {
        clickSearchTopField();
        dropdownGuest = null;
    }
    
    // dropdownLogged
    protected DropdownLogged getDropdownLogged() {
    	if (dropdownLogged == null)
        {
            // TODO Develop Custom Exception 
            throw new RuntimeException(OPTION_NULL_MESSAGE);
        }
        return dropdownLogged;
    }

    private DropdownLogged createDropdownLogged() {
        dropdownLogged = new DropdownLogged(driver);
        return getDropdownLogged();
    }

    private void clickDropdownLoggedMyAccount() {
    	getDropdownLogged().clickMyAccount();
    	dropdownLogged= null;
    }

    private void clickDropdownLoggedOrderHistory() {
    	getDropdownLogged().clickOrderHistory();
    	dropdownLogged= null;
    }

    private void clickDropdownLoggedTransactions() {
    	getDropdownLogged().clickTransactions();
    	dropdownLogged= null;
    }

    private void clickDropdownLoggedDownloads() {
    	getDropdownLogged().clickDownloads();
    	dropdownLogged= null;
    }

    private void clickDropdownLoggedLogout() {
    	getDropdownLogged().clickLogout();
    	dropdownLogged= null;
    }

    private void closeDropdownLogged() {
        clickSearchTopField();
        dropdownLogged= null;
    }
    
	// Functional

    // currency
 	private void openCurrencyDropdownComponent() {
 		//clickSearchTopField();
 		closeDropdownComponent();
 		clickCurrency();
 		createDropdownComponent(By.cssSelector(LIST_CURRENCIES_CSSSELECTOR));
 	}
 	
 	//protected void clickCurrencyByPartialName(String currencyName) { // Code Smell
    protected void clickCurrencyByPartialName(Currencies optionName) {
    	openCurrencyDropdownComponent();
    	//clickDropdownComponentByPartialName(currencyName);
    	clickDropdownComponentByPartialName(optionName.toString());
    }

    public List<String> getListCurrencyNames() {
    	openCurrencyDropdownComponent();
        List<String> result = getDropdownComponent().getListOptionsText();
        closeDropdownComponent();
        return result;
    }
    
    // myAccount
    protected void openMyAccountDropdown() {
		clickSearchTopField();
		clickMyAccount();
	}
    
    // TODO myAccount
    
    // searchTopField
    private void fillSearchTopField(String searchText) {
        clickSearchTopField();
        clearSearchTopField();
        setSearchTopField(searchText);
    }
    
    protected void defaultLogin(User user) {
    	if (!ApplicationStatus.get().isLogged()) {
        	new LoginPage(driver)
    			.fillLogin(user);
    	} else {
    		// TODO throw Custom Exception
    	}
    }
    
	// Business Logic
    
    public HomePage gotoHomePage() {
        clickLogo();
        return new HomePage(driver);
    }
    
	//public SearchSuccessPage successfulSearch(String searchText) {
    public SearchSuccessPage successfulSearch(Product product) {
		//fillSearchTopField(searchText);
		fillSearchTopField(product.getName());
		clickSearchTopButton();
		return new SearchSuccessPage(driver);
	}
	
    public SearchUnsuccessPage unsuccessfulSearch(String searchText){
    //public SearchUnsuccessPage unsuccessfulSearch(Product product){
    	fillSearchTopField(searchText);
        //fillSearchTopField(product.getName());
        clickSearchTopButton();
        return new SearchUnsuccessPage(driver);
    }

    // dropdownGuest
    public LoginPage gotoLoginPage() {
    	openMyAccountDropdown();
    	createDropdownGuest();
    	clickDropdownGuestLogin();
        return new LoginPage(driver);
    }

    public RegisterPage gotoRegisterPage() {
    	openMyAccountDropdown();
    	createDropdownGuest();
    	clickDropdownGuestRegister();
        return new RegisterPage(driver);
    }

    // dropdownLogged
    public MyAccountPage gotoMyAccount() {
    	openMyAccountDropdown();
    	createDropdownLogged();
    	clickDropdownLoggedMyAccount();
        return new MyAccountPage(driver);
    }
    
//    public OrderHistoryPage gotoOrderHistory() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedOrderHistory();
//        return new OrderHistoryPage(driver);
//    }
    
//    public TransactionsPage gotoTransactions() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedTransactions();
//        return new TransactionsPage(driver);
//    }
    
//    public DownloadsPage gotoDownloads() {
//    	openMyAccountDropdown();
//    	createDropdownLogged();
//    	clickDropdownLoggedDownloads();
//        return new DownloadsPage(driver);
//    }
    
    public AccountLogoutPage logout() {
    	openMyAccountDropdown();
    	createDropdownLogged();
    	clickDropdownLoggedLogout();
        return new AccountLogoutPage(driver);
    }

    // wishList
    public WishListPage gotoWishListPage() {
    	clickWishList();
        return new WishListPage(driver);
    }
    
    public WishListPage gotoWishListPage(User user) {
    	clickWishList();
    	defaultLogin(user);
        return new WishListPage(driver);
    }

}
