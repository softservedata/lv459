package com.softserve.edu.opencart.data;

public class ProductInfoMacRepository {

    private ProductInfoMacRepository() {
    }

    private static volatile ProductInfoMacRepository instance = null;

    public static ProductInfoMacRepository get() {
        if (instance == null) {
            synchronized (ProductInfoMacRepository.class) {
                if (instance == null) {
                    instance = new ProductInfoMacRepository();
                }
            }
        }
        return instance;
    }

    public static ProductInfoMacBook getDefault() {
        return getMacBookInfo();
    }


    public static ProductInfoMacBook getMacBookInfo() {
        return new ProductInfoMacBook("1");
    }



}


