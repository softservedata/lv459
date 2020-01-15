package com.softserve.edu.opencart.data;

public final class ProductRepository {

    private static volatile ProductRepository instance = null;

    private ProductRepository() {
    }

    public static ProductRepository get() {
        if (instance == null) {
            synchronized (ProductRepository.class) {
                if (instance == null) {
                    instance = new ProductRepository();
                }
            }
        }
        return instance;
    }

    public IProduct getMacBook() {
        return Product.get()
                .setName("MacBook")
                .setDescription("Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..")
                .setPriceDollarExTax("500.00")
                .build();
    }

    public IProduct getIPhone3() {
        return Product.get()
                .setName("iPhone 3")
                .setDescription("iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..")
                .setPriceDollarExTax("101.00")
                .build();
    }

    public IProduct getAppleCinema30() {
        return Product.get()
                .setName("Apple Cinema 30\"")
                .setDescription("The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution. Designed sp..")
                .setPriceDollarExTax("90.00")
                .build();
    }

    public IProduct getCustomItem(String name) {
        return Product.get()
                .setName(name)
                .setDescription(new String())
                .setPriceDollarExTax(new String())
                .build();
    }
    //    private ProductRepository() {
//    }
//
//    public static Product getDefault() {
//        return getMacBook();
//    }
//
//    public static Product getMacBook() {
//        return new Product("MacBook",
//                "Intel Core 2 Duo processor Powered by an Intel Core 2 Duo processor at speeds up to 2.1..", "500.00")
//                .addPrice(Currencies.EURO, "472.33")
//                .addPrice(Currencies.POUND_STERLING, "368.73")
//                .addPrice(Currencies.US_DOLLAR, "602.00");
//    }
//
//    public static Product getIPhone3() {
//        return new Product("iPhone 3",
//                "iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a nam..", "101.00")
//                .addPrice(Currencies.EURO, "96.66")
//                .addPrice(Currencies.POUND_STERLING, "75.46")
//                .addPrice(Currencies.US_DOLLAR, "123.20");
//    }
//
//    public static Product getAppleCinema30() {
//        return new Product("Apple Cinema 30\"",
//                "The 30-inch Apple Cinema HD Display delivers an amazing 2560 x 1600 pixel resolution. Designed sp..", "90.00")
//                .addPrice(Currencies.EURO, "86.31")
//                .addPrice(Currencies.POUND_STERLING, "67.38")
//                .addPrice(Currencies.US_DOLLAR, "110.20");
//    }
//
//    public static Product getInvalid() {
//        return new Product("Bok", "Intel", "100");
//    }

}
