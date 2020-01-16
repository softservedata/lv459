package com.softserve.edu.opencart.pages.admin.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class DropdownList {

    protected WebDriver driver;

    //First level elems
    private WebElement settings;
    private WebElement users;
    private WebElement localisation;
    private WebElement tools;

    //Second level elems
    private WebElement storeLocation;
    private WebElement languages;
    private WebElement currencies;
    private WebElement stockStatuses;

    //Arrays
    private ArrayList<WebElement> firstLevel = new ArrayList<>();
    private ArrayList<WebElement> secondLevel = new ArrayList<>();

    protected DropdownList(){
        initElementsFirstLevel();
        initElementsSecondLevel();
    }

    private void initElementsFirstLevel() {
        settings = driver.findElement(By.xpath("//*[contains(text(), 'Settings')]"));
        users = driver.findElement(By.xpath("//li/a[contains(text(), 'Users') and @class='parent']"));
        localisation = driver.findElement(By.xpath("//li/a[contains(text(), 'Localisation')]"));
        tools = driver.findElement(By.xpath("//li/a[contains(text(), 'Tools')]"));
    }

    private void initElementsSecondLevel() {
        storeLocation = driver.findElement(By.xpath("//li/a[contains(text(), 'Store Location')]"));
        languages = driver.findElement(By.xpath("//li/a[contains(text(), 'Languages')]"));
        currencies = driver.findElement(By.xpath("//li/a[contains(text(), 'Currencies')]"));
        stockStatuses = driver.findElement(By.xpath("//li/a[contains(text(), 'Stock Statuses')]"));
    }

    private void AddElementsFirstLevel() {
        firstLevel.add(settings);
        firstLevel.add(users);
        firstLevel.add(localisation);
        firstLevel.add(tools);
    }

    protected void AddElementsSecondLevel() {
        secondLevel.add(storeLocation);
        secondLevel.add(languages);
        secondLevel.add(currencies);
        secondLevel.add(stockStatuses);
    }

    public ArrayList<WebElement> getElementsFirstLevel(){
        AddElementsFirstLevel();
        return firstLevel;
    }

    public ArrayList<WebElement> getElementsSecondLevel(){
        AddElementsSecondLevel();
        return secondLevel;
    }
}
