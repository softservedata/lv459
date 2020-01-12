package com.softserve.edu.opencart.data;

public class ProductInfoRepository {

    private ProductInfoRepository(){
    }

    //???
    //  Does it need here to add default get method like ProductRepository class???

    public static ProductInfo getMacBook() {
        return new ProductInfo(ProductNames.MacBook,
                "Brand: Apple\n" +
                        "Product Code: Product 16\n" +
                        "Reward Points: 600\n" +
                        "Availability: In Stock",
                "500").addPrice(Currencies.US_DOLLAR, "368.73");
    }

    public static ProductInfo getAppleCinema(){
        return new ProductInfo(ProductNames.Apple_Cinema_30,
                "Brand: Apple\n" +
                        "Product Code: Product 15\n" +
                        "Reward Points: 100\n" +
                        "Availability: In Stock",
                "90.00").addPrice(Currencies.US_DOLLAR, "110.00");
    }

    ///???
    //  Does it need here to add getInvalid() method like ProductRepository class???

}
