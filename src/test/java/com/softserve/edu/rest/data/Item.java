package com.softserve.edu.rest.data;

public class Item {

    private String itemIndex;

    private String itemText;

    public Item(String itemIndex, String itemText) {
        this.itemIndex = itemIndex;
        this.itemText = itemText;
    }

    public String getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }
}
