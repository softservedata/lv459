package com.softserve.edu.opencart.pages.admin.catalog;

public class Discount {
	private int quantity;
    private int priority;
    private double price;
    private String startDate;
    private String endData;


    public Discount(int quantity, int priority, double price, String startDate, String endData) {
        this.quantity = quantity;
        this.priority = priority;
        this.price = price;
        this.startDate = startDate;
        this.endData = endData;
    }
    //setters

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndData(String endData) {
        this.endData = endData;
    }
    //getters

    public int getQuantityWeb() {
        return quantity;
    }

    public int getPriority() {
        return priority;
    }

    public double getPrice() {
        return price;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndData() {
        return endData;
    }
}
