package com.softserve.edu.opencart.pages.admin.currencies;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.softserve.edu.opencart.data.ICurrency;

public class CurrenciesContainerComponent {
    private WebDriver driver;

    private final String CURRENCY_TABLE_COMPONENTS = "//div/table/tbody/tr";

    private List<CurrenciesComponent> currenciesComponents;


    public CurrenciesContainerComponent(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        currenciesComponents = new ArrayList<>();
        for (WebElement current : driver.findElements(By.xpath(CURRENCY_TABLE_COMPONENTS))) {
            currenciesComponents.add(new CurrenciesComponent(current));
        }
    }

    //Page Object

    public List<CurrenciesComponent> getCurrenciesComponents() {
        return currenciesComponents;
    }

    //Functional

    public int getCurrenciesComponentsCount() {
        return getCurrenciesComponents().size();
    }
    public List<String> getCurrencyComponentTitles()
    {
        List<String> currencyComponentTitles = new ArrayList<>();
        for (CurrenciesComponent current : getCurrenciesComponents())
        {
            currencyComponentTitles.add(current.getTitleText());
        }
        return currencyComponentTitles;
    }

    protected CurrenciesComponent getCurrenciesComponentByTitle(ICurrency currency) {
        CurrenciesComponent result = null;
        for (CurrenciesComponent current : getCurrenciesComponents()) {
            if (current.getTitleText().toLowerCase()
                    .equals(currency.getCurrencyTitle().toLowerCase())) {
                result = current;
                break;
            }
        }
        if (result == null) {
            // TODO Develop Custom Exception
            // Use String.format()
            throw new RuntimeException("CurrencyTitle: " + currency.getCurrencyTitle() + " not Found.");
        }
        return result;
    }

    public String getCurrencyTitleText(ICurrency currency) {
        return getCurrenciesComponentByTitle(currency).getTitleText();
    }

    public void clickEditButtonByTitle(ICurrency currency) {
        getCurrenciesComponentByTitle(currency).clickEditButton();
    }

    public void clickCheckBoxButtonByTitle(ICurrency currency) {
        getCurrenciesComponentByTitle(currency).clickCheckBox();
    }

}
