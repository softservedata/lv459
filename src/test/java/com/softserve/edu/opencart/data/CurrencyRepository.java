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
        return getNewUACurrency();

    }

    public ICurrency getNewUACurrency() {
        return Currency.get()
                .setCurrencyTitle("Hryvnia")
                .setCurrencyCode("UAH")
                .setCurrencyDecimalPlaces(2)
                .setCurrencyValue(25)
                .setCurrencyStatus("1")
                .setCurrencySymbolRight("₴")
                .build();
    }
}