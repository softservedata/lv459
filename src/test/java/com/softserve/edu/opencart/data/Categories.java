package com.softserve.edu.opencart.data;

public enum Categories {
    ALL_CATEGORIES("All Categories"),
    COMPONENTS("Components");
    //
    private String name;

    private Categories(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
