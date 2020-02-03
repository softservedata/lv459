package com.softserve.edu.rest.data;

public class ItemRepository {

    //TODO add this repo to USER
    public static Item getDefaultItemIndex0() {
        return new Item("0", "ItemWithIndex0");
    }

    public static Item getItemIndex1() {
        return new Item("1", "ItemWithIndex1");
    }

    public static Item getItemIndex2() {
        return new Item("2", "ItemWithIndex2");
    }

    public static Item getBook() {
        return new Item("3", "Book");
    }

    public static Item getCopybook() {
        return new Item("4", "Copybook");
    }

}
