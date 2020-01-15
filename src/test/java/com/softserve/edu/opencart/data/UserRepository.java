package com.softserve.edu.opencart.data;

public final class UserRepository {
    private static volatile UserRepository instance = null;

    private UserRepository() {
    }

    public static UserRepository get() {
        if (instance == null) {
            synchronized (UserRepository.class) {
                if (instance == null) {
                    instance = new UserRepository();
                }
            }
        }
        return instance;
    }

    public IUser getDefault() {
        return getHahaha();
    }

    public IUser getHahaha() {
        return User.get()
                .setFirstName("hahaha")
                .setLastName("hahaha")
                .setEmail("hahaha@gmail.com")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostCode("postCode_5")
                .setCountry("country_5")
                .setRegionState("regionState_5")
                //.setPassword(System.getenv().get("MY_PASSWORD"))
                .setPassword("qwerty")
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }
    
    public IUser getCorrectUser() {
        return User.get()
                .setFirstName("hahaha")
                .setLastName("hahaha")
                .setEmail("mail123@gmail.com")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostCode("postCode_5")
                .setCountry("country_5")
                .setRegionState("regionState_5")
                .setPassword(System.getenv().get("OPENCART_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }

    public IUser getAdmin() {
        return User.get()
                .setFirstName("hahaha")
                .setLastName("hahaha")
                .setEmail("hahaha@gmail.com")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostCode("postCode_5")
                .setCountry("country_5")
                .setRegionState("regionState_5")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }
    
    public IUser getEmailUser() {
        return User.get()
                .setFirstName("")
                .setLastName("")
                .setEmail("lv459@ukr.net")
                .setTelephone("")
                .setAddress1("")
                .setCity("")
                .setPostCode("")
                .setCountry("")
                .setRegionState("")
                .setPassword(System.getenv().get("OPENCART_ADMIN_PASSWORD"))
                .setSubscribe(true)
                .setFax("")
                .setCompany("")
                .setAddress2("")
                .build();
    }
}