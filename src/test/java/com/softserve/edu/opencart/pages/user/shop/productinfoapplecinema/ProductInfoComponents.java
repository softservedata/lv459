package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductInfoComponents{

    private WebElement productLayout;

    private WebElement radioButton;
    private WebElement checkboxButton;
    private WebElement textField;
    private WebElement selectField;
    private WebElement selectOptions;
    private WebElement textAreaField;
    private WebElement uploadFileButton;
    private WebElement dateField;
    private WebElement timeField;
    private WebElement dateTimeField;
    private WebElement quantityField;
    private WebElement addToCartButton;

    public ProductInfoComponents(WebElement productLayout){
        this.productLayout = productLayout;
        initElements();
    }

    private void initElements(){

        radioButton = productLayout.findElement(By.xpath("//div[@class='radio']/label[text()[contains(., '%s')]]"));
        checkboxButton = productLayout.findElement(By.xpath("//div[@class='checkbox']/label[text()[contains(., '%s')]]"));
        textField = productLayout.findElement(By.xpath("//input[@placeholder='Text']"));
        selectField = productLayout.findElement(By.xpath("//select"));
        selectOptions = productLayout.findElement(By.xpath("//option[starts-with(.,'%s')]"));
        textAreaField = productLayout.findElement(By.xpath("//textarea[@placeholder='Textarea']"));
        uploadFileButton = productLayout.findElement(By.cssSelector("#button-upload222 i"));
        dateField = productLayout.findElement(By.xpath("//div[@class='input-group date']/input"));
        timeField = productLayout.findElement(By.xpath("//div[@class='input-group time']/input"));
        dateTimeField = productLayout.findElement(By.xpath("//div[@class='input-group datetime']/input"));
        quantityField = productLayout.findElement(By.cssSelector("#input-quantity"));
        addToCartButton = productLayout.findElement(By.cssSelector("#button-cart"));

    }


    //Page Object


    // get Product Layout
    public WebElement getProductLayout(){
        return productLayout;
    }


    // get Radio Button
    public WebElement getRadioButton(){
        return radioButton;
    }

    //click Radio Button
    public void clickRadioButton(){
        getRadioButton().click();
    }

    //get Checkbox Button
    public WebElement getCheckboxButton(){
        return checkboxButton;
    }

    //click Checkbox Button
    public void clickCheckboxButton(){
        getCheckboxButton().click();
    }

    //get Text Field
    public WebElement getTextField(){
        return textField;
    }

    //click Text Field
    public void clickTextField(){
        getTextField().click();
    }

    // clear Text Field
    public void clearTextField(){
        getTextField().clear();
    }

    //get Select Field
    public WebElement getSelectField(){
        return selectField;
    }

    //click Select Field
    public void clickSelectField(){
        getSelectField().click();
    }

    //get Select Options
    public WebElement getSelectOptions(){
        return selectOptions;
    }

    //click Select Options
    public void clickSelectOptions(){
        getSelectOptions().click();
    }

    //get Text Area Field
    public WebElement getTextAreaField(){
        return textAreaField;
    }

    //click Text Area Field
    public void clickTextAreaField(){
        getTextAreaField().click();
    }

    // clear Text Area Field
    public void clearTextAreaField(){
        getTextAreaField().clear();
    }

    //get Upload File Button
    public WebElement getUploadFileButton(){
        return uploadFileButton;
    }

    //click Upload File Button
    public void clickUploadFileButton(){
        getUploadFileButton().click();
    }

    //get Date Field
    public WebElement getDateField(){
        return dateField;
    }

    //click Date Field
    public void clickDateField(){
        getDateField().click();
    }

    //clear Date Field
    public void clearDateField(){
        getDateField().clear();
    }

    //get Time Field
    public WebElement getTimeField(){
        return timeField;
    }

    //click Time Field
    public void clickTimeField(){
        getTimeField().click();
    }

    //clear Time Field
    public void clearTimeField(){
        getTimeField().clear();
    }

    // get Date Time Field
    public WebElement getDateTimeField(){
        return dateTimeField;
    }

    //click Date Time Field
    public void clickDateTimeField(){
        getDateTimeField().click();
    }

    //clear Date Time Field
    public void clearDateTimeField(){
        getDateTimeField().clear();
    }

    //get Quantity Field
    public WebElement getQuantityField(){
        return quantityField;
    }

    //click Quantity Field
    public void clickQuantityField(){
        getQuantityField().click();
    }

    //get Add To Cart Button
    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    //click Add To Cart Button
    public void clickAddToCartButton(){
        getAddToCartButton().click();
    }





    //Functional

    //Business Logic


}
