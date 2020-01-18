package com.softserve.edu.opencart.pages.user.shop.productinfoapplecinema;

import com.softserve.edu.opencart.data.AppleCinemaInfo;
import com.softserve.edu.opencart.data.MacBookInfo;
import com.softserve.edu.opencart.pages.user.common.BreadCrumbPart;
import com.softserve.edu.opencart.pages.user.shop.shoppingcart.AlertMessagePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppleCinemaPage extends BreadCrumbPart {


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

    DescriptionComponent descriptionComponent;
    SpecificationComponent specificationComponent;
    ReviewComponent reviewComponent;

    public AppleCinemaPage(WebDriver driver){
        super(driver);
        initElements();
    }


    private void initElements(){

        radioButton = driver.findElement(By.xpath("//div[@class='radio']/label[text()[contains(., 'Large')]]/input"));
        checkboxButton = driver.findElement(By.xpath("//div[@class='checkbox']/label[text()[contains(., 'Checkbox 3')]]/input"));
        textField = driver.findElement(By.xpath("//input[@placeholder='Text']"));
        selectField = driver.findElement(By.xpath("//select"));
        selectOptions = driver.findElement(By.xpath("//option[starts-with(.,'Green')]"));
        textAreaField = driver.findElement(By.xpath("//textarea[@placeholder='Textarea']"));
        uploadFileButton = driver.findElement(By.cssSelector("#button-upload222 i"));
        dateField = driver.findElement(By.xpath("//div[@class='input-group date']/input"));
        timeField = driver.findElement(By.xpath("//div[@class='input-group time']/input"));
        dateTimeField = driver.findElement(By.xpath("//div[@class='input-group datetime']/input"));
        quantityField = driver.findElement(By.cssSelector("#input-quantity"));
        addToCartButton = driver.findElement(By.cssSelector("#button-cart"));
        descriptionComponent = new DescriptionComponent(driver);
        specificationComponent = new SpecificationComponent(driver);
        reviewComponent = new ReviewComponent(driver);

    }


    //Page Object

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

    //clear Quantity Field
    public void clearQuantityField(){
        getQuantityField().clear();
    }

    //get Add To Cart Button
    public WebElement getAddToCartButton(){
        return addToCartButton;
    }

    //click Add To Cart Button
    public void clickAddToCartButton(){
        getAddToCartButton().click();
    }


    public DescriptionComponent getDescriptionComponent(){
        return descriptionComponent;
    }

    public SpecificationComponent getSpecificationComponent(){
        return specificationComponent;
    }

    public ReviewComponent getReviewComponent(){
        return reviewComponent;
    }

    //Functional

    //set Text Field
    public void setTextField(AppleCinemaInfo text){
        clickTextField();
        clearTextField();
        getTextField().sendKeys(text.getTextField());
    }

    public void setSelectOptions(){
        clickSelectField();
        getSelectOptions();
        clickSelectOptions();
    }

    //set Text Area Field
    public void setTextAreaField(AppleCinemaInfo text){
        clickTextAreaField();
        clearTextAreaField();
        getTextAreaField().sendKeys(text.getTextField());
    }

    public void setUploadFileButton(AppleCinemaInfo uploadFileValue){
        WebElement uploadInput = driver.findElement(By.xpath("//button[starts-with(@id,'button-upload')]/following-sibling::input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                uploadInput, "value", uploadFileValue.getUploadFileValue());
    }


    public void setDateField(AppleCinemaInfo date){
        clickDateField();
        clearDateField();
        getDateField().sendKeys(date.getDateField());
    }

    public void setTimeField(AppleCinemaInfo time){
        clickTimeField();
        clearTimeField();
        getTimeField().sendKeys(time.getTimeField());
    }

    public void setDateTimeField(AppleCinemaInfo datatime){
        clickDateTimeField();
        clearDateTimeField();
        getDateTimeField().sendKeys(datatime.getDateTimeField());
    }


    public void setQuantity(AppleCinemaInfo qty){
        clickQuantityField();
        clearQuantityField();
        getQuantityField().sendKeys( qty.getQuantityField());  //// Idk how correct is that.
    }





    //Business Logic

    public AlertMessagePage addAppleCinemaToCartWithAllOpt(AppleCinemaInfo text, AppleCinemaInfo textarea, AppleCinemaInfo fileValue, AppleCinemaInfo data,
                                                        AppleCinemaInfo time, AppleCinemaInfo datatime, AppleCinemaInfo qty){
        clickRadioButton();
        clickCheckboxButton();
        setTextField(text);
        setSelectOptions();
        setTextAreaField(textarea);
        setUploadFileButton(fileValue);
        setDateField(data);
        setTimeField(time);
        setDateTimeField(datatime);
        setQuantity(qty);
        return new AlertMessagePage(driver);
    }

}
