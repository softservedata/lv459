package com.softserve.edu.opencart.data;

public interface ICurrency {
    String getCurrencyTitle();

    String getCurrencyCode();

    String getCurrencySymbolLeft();

    String getCurrencySymbolRight();

    int getCurrencyDecimalPlaces();

    double getCurrencyValue();

    String getCurrencyStatus();
}
