package com.softserve.edu.opencart.pages.user.common;

import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.pages.user.search.SearchSuccessPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComponentsTopPart extends TopPart {
    private WebElement showAllComponents;

    public ComponentsTopPart(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        showAllComponents = driver.findElement(By.xpath("//nav[@id='menu']//div[@class='dropdown-inner']/"
                + "following-sibling::a[contains(text(),"
                + " 'Show All Components')]"));
    }

    //Page Object

    // get Title
    public WebElement getShowAllComponents() {
        return showAllComponents;
    }

    public String getShowAllComponentsText() {
        return showAllComponents.toString();
    }

    public void clickShowAllComponents() {
        getShowAllComponents().click();
    }

    //Functional

    //Business Logic
    public ComponentsTopPart gotoShowAllComponents() {
        //fillSearchTopField(searchText);
        clickComponents();
        clickShowAllComponents();
        return new ComponentsTopPart(driver);
    }

}
