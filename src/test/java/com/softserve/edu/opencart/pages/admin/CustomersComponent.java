package com.softserve.edu.opencart.pages.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CustomersComponent {

    private WebElement checkbox;
    private String customerName;
    private String email;
    private String customerGroup;
    private String customerStatus;
    private String customerIP;
    private String customerDateAdded;
    private WebElement current;
    // TODO add buttons

    public CustomersComponent(WebElement current) {
        this.current = current;
        initElements();
    }

    private void initElements() {
        checkbox = current.findElement(By.cssSelector("td:nth-child(1)"));
        customerName = current.findElement(By.cssSelector("td:nth-child(2)"))
                .getText();
        email = current.findElement(By.cssSelector("td:nth-child(3)"))
                .getText();
        customerGroup = current.findElement(By.cssSelector("td:nth-child(4)"))
                .getText();
        customerStatus = current.findElement(By.cssSelector("td:nth-child(5)"))
                .getText();
        customerIP = current.findElement(By.cssSelector("td:nth-child(6)"))
                .getText();
        customerDateAdded =
                current.findElement(By.cssSelector("td:nth-child(7)"))
                        .getText();

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public String getCustomerIP() {
        return customerIP;
    }

    public void setCustomerIP(String customerIP) {
        this.customerIP = customerIP;
    }

    public String getCustomerDateAdded() {
        return customerDateAdded;
    }

    public void setCustomerDateAdded(String customerDateAdded) {
        this.customerDateAdded = customerDateAdded;
    }

    // Page Object

    // Check if selected
    public boolean isChecked() {
        return checkbox.isSelected();
    }

    // Select
    public void selectCheckBox() {
        checkbox.click();
    }

}
