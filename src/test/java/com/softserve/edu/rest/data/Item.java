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

    public Item setItemIndex(String itemIndex) {
        this.itemIndex = itemIndex;
        return this;
    }

    public String getItemText() {
        return itemText;
    }

    public Item setItemText(String itemText) {
        this.itemText = itemText;
        return this;

    }

    @Override
    public String toString() {
        return "Item{" +
                "itemIndex='" + itemIndex + '\'' +
                ", itemText='" + itemText + '\'' +
                '}';
    }
}
