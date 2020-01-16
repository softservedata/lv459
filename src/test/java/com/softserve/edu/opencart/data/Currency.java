package com.softserve.edu.opencart.data;

interface ITitle {
    ICode setCurrencyTitle(String title);
}

interface ICode {
    IDecimalPlaces setCurrencyCode(String code);
}

interface IDecimalPlaces {
    IValue setCurrencyDecimalPlaces(int decimalPlaces);
}

interface IValue {
    IStatus setCurrencyValue(double Value);
}

interface IStatus {
    IBuilderCurrency setCurrencyStatus(String status);
}

interface IBuilderCurrency {
    ICurrency build();
}

interface ISymbolLeft extends IBuilderCurrency {
    ISymbolRight setCurrencySymbolLeft(String symbolLeft);
}

interface ISymbolRight extends IBuilderCurrency {
    IBuilderCurrency setCurrencySymbolRight(String symbolRight);
}

public final class Currency implements
        IStatus, IValue, IDecimalPlaces, ICode, ITitle, ICurrency, IBuilderCurrency {
    private String title;
    private String code;
    private String symbolLeft;//optional
    private String symbolRight;//optional
    private int decimalPlaces;
    private double value;
    private String status;


    private Currency() {
        this.symbolLeft = new String();
        this.symbolRight = new String();
    }

    public static ITitle get() {
        return new Currency();
    }

    public ICode setCurrencyTitle(String title) {
        this.title = title;
        return this;
    }

    public IDecimalPlaces setCurrencyCode(String code) {
        this.code = code;
        return this;
    }

    public ISymbolRight setCurrencySymbolLeft(String symbolLeft) {
        this.symbolLeft = symbolLeft;
        return null;
    }

    public IBuilderCurrency setCurrencySymbolRight(String symbolRight) {
        this.symbolRight = symbolRight;
        return this;
    }

    public IValue setCurrencyDecimalPlaces(int decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
        return this;
    }

    public IStatus setCurrencyValue(double value) {
        this.value = value;
        return this;
    }

    public ISymbolLeft setCurrencyStatus(String status) {
        this.status = status;
        return null;
    }

    public ICurrency build() {
        return this;
    }

    //getters

    public String getCurrencyTitle() {
        return title;
    }

    public String getCurrencyCode() {
        return code;
    }

    public String getCurrencySymbolLeft() {
        return symbolLeft;
    }

    public String getCurrencySymbolRight() {
        return symbolRight;
    }

    public int getCurrencyDecimalPlaces() {
        return decimalPlaces;
    }

    public double getCurrencyValue() {
        return value;
    }

    public String getCurrencyStatus() {
        return status;
    }
}
