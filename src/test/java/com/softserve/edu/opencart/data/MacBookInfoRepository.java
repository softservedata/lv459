package com.softserve.edu.opencart.data;

public class MacBookInfoRepository {

    private MacBookInfoRepository() {
    }

    private static volatile MacBookInfoRepository instance = null;

    public static MacBookInfoRepository get() {
        if (instance == null) {
            synchronized (MacBookInfoRepository.class) {
                if (instance == null) {
                    instance = new MacBookInfoRepository();
                }
            }
        }
        return instance;
    }

    public static MacBookInfo getDefault() {
        return getMacBookInfo();
    }


    public static MacBookInfo getMacBookInfo() {
        return new MacBookInfo("1");
    }



}


