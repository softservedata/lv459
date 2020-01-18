package com.softserve.edu.opencart.data;

public class AppleCinemaInfoRepository {

    private AppleCinemaInfoRepository() {
    }

    private static volatile AppleCinemaInfoRepository instance = null;

    public static AppleCinemaInfoRepository get() {
        if (instance == null) {
            synchronized (AppleCinemaInfoRepository.class) {
                if (instance == null) {
                    instance = new AppleCinemaInfoRepository();
                }
            }
        }
        return instance;
    }

    /*public static MacBookInfo getDefault() {
        return getMacBookInfo();
    }*/


    public static AppleCinemaInfo getMacBookInfo() {
        return new AppleCinemaInfo("test1",
                "text1",
                "fee9e81729574a48e990d2a6fcfd01c98be0c8e7",
                "2020-01-21",
                "11:00",
                "2020-01-21 11:00",
                "2");
    }




}
