package com.softserve.edu.opencart.data;

public enum ProductNames {
    MacBook("MacBook"),
    Apple_Cinema_30("Apple Cinema 30\"");

    private String name;

    private ProductNames(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
