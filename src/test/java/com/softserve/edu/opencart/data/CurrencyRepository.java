package com.softserve.edu.opencart.data;

public class CurrencyRepository {
    private static volatile CurrencyRepository instance = null;

    private CurrencyRepository() {
    }

    public static CurrencyRepository get() {
        if (instance == null) {
            synchronized (CurrencyRepository.class) {
                if (instance == null) {
                    instance = new CurrencyRepository();
                }
            }
        }
        return instance;
    }

    public ICurrency getDefault() {
        return getUACurrency();

    }

    public ICurrency getUACurrency() {
        return Currency.get()
                .setCurrencyTitle("Hryvnia")
                .setCurrencyCode("UAH")
                .setCurrencyDecimalPlaces(2)
                .setCurrencyValue(25)
                .setCurrencyStatus("1")
                .setCurrencySymbolRight("₴")
                .build();
    }
    public ICurrency getUKCurrency() {
        return Currency.get()
                .setCurrencyTitle("Pound Sterling")
                .setCurrencyCode("GBP")
                .setCurrencyDecimalPlaces(2)
                .setCurrencyValue(0.61250001)
                .setCurrencyStatus("1")
                .setCurrencySymbolLeft("£")
                .build();
    }
    public ICurrency getEUCurrency() {
        return Currency.get()
                .setCurrencyTitle("Euro")
                .setCurrencyCode("EUR")
                .setCurrencyDecimalPlaces(2)
                .setCurrencyValue(0.78460002)
                .setCurrencyStatus("1")
                .setCurrencySymbolRight("€")
                .build();
    }
    public ICurrency getUSCurrency() {
        return Currency.get()
                .setCurrencyTitle("US Dollar")
                .setCurrencyCode("USD")
                .setCurrencyDecimalPlaces(2)
                .setCurrencyValue(1)
                .setCurrencyStatus("1")
                .setCurrencySymbolLeft("$")
                .build();
    }
}