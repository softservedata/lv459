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


    public static AppleCinemaInfo getAppleCinemaInfo() {
        return new AppleCinemaInfo("test1",
                "text1",
                "ab11fd00be88a38bf36227247541ca9f90b481c2",
                "2020-01-21",
                "11:00",
                "2020-01-21 11:00",
                "2");
    }




}
