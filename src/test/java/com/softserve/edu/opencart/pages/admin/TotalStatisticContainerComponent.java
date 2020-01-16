package com.softserve.edu.opencart.pages.admin;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalStatisticContainerComponent {

    private final String STATISTIC_COMPONENT_CSSSELECTOR = ".col-lg-3.col-md-3.col-sm-6";
    private final String CUSTOMERS_STATISTIC = "Total Customers";

    protected WebDriver driver;
    //
    private List<TotalStatisticComponent> statisticComponent;

    public TotalStatisticContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        // init elements
        statisticComponent = new ArrayList<>();
        for (WebElement current : driver.findElements(By.cssSelector(STATISTIC_COMPONENT_CSSSELECTOR))) {
            statisticComponent.add(new TotalStatisticComponent(current));
        }
    }

    public List<TotalStatisticComponent> getListStatisticCommpinent() {
        return statisticComponent;
    }

    public SearchSuccessPage goToTotalCustomers() {
        for (TotalStatisticComponent component : getListStatisticCommpinent()) {
            if (component.getStatisticNameText().toLowerCase().contains(CUSTOMERS_STATISTIC.toLowerCase())) {
                component.clickStatisticDetail();
                break;
            }
        }
        return new SearchSuccessPage(driver);
    }
}
