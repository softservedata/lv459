package com.softserve.edu.opencart.data;

import com.softserve.edu.opencart.tools.CSVReader;

import java.util.List;

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
                .setNewPassword("qwerty")
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }

    public IUser getBohdanaUser() {
        return User.get()
                .setFirstName("Dana")
                .setLastName("Dobushovska")
                .setEmail("bohdanadobushovska@gmail.com")
                .setTelephone("12345")
                .setAddress1("address")
                .setCity("Lviv")
                .setPostCode("12345")
                .setCountry("Ukraine")
                .setRegionState("L'vivska Oblast'")
                //.setPassword(System.getenv().get("MY_PASSWORD"))
                .setPassword("qwerty")
                .setNewPassword("qwerty")
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getYuriiUkUser() {
        return User.get()
                .setFirstName("user")
                .setLastName("user")
                .setEmail("spirnyak2010@gmail.com")
                .setTelephone("12345")
                .setAddress1("address")
                .setCity("city")
                .setPostCode("12345")
                .setCountry("country")
                .setRegionState("region'")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                .setNewPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
                .build();
    }

    public IUser getYuriiUaUser() {
        return User.get()
                .setFirstName("user")
                .setLastName("user")
                .setEmail("spirnyak2010_2@gmail.com")
                .setTelephone("12345")
                .setAddress1("address")
                .setCity("city")
                .setPostCode("12345")
                .setCountry("country")
                .setRegionState("region'")
                .setPassword(System.getenv().get("MY_PASSWORD"))
                .setNewPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax")
                .setCompany("company")
                .setAddress2("address2")
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
                .setNewPassword(System.getenv().get("OPENCART_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }

    public IUser getIncorrectUser() {
        return User.get()
                .setFirstName("hahaha")
                .setLastName("hahaha")
                .setEmail("mail1234@gmail.com")
                .setTelephone("telephone_5")
                .setAddress1("address1_5")
                .setCity("city_5")
                .setPostCode("postCode_5")
                .setCountry("country_5")
                .setRegionState("regionState_5")
                .setPassword("wrongpassword")
                .setNewPassword("wrongpassword")
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
                .setNewPassword(System.getenv().get("MY_PASSWORD"))
                .setSubscribe(true)
                .setFax("fax_5")
                .setCompany("company_5")
                .setAddress2("address2_5")
                .build();
    }

    public IUser emailUser() {
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
                .setPassword(System.getenv().get("OPENCART_PASSWORD_RESTORE"))
                .setNewPassword(System.getenv().get("OPENCART_PASSWORD_RESTORE"))
                .setSubscribe(true)
                .setFax("")
                .setCompany("")
                .setAddress2("")
                .build();
    }

    public IUser getValidCustomer() {
        return User.get()
                .setFirstName("SeNew")
                .setLastName("PeNew")
                .setEmail(System.getenv("USER_EMAIL"))
                .setTelephone("+380675515")
                .setAddress1("Ploshcha Rynok")
                .setCity("Lemberg")
                .setPostCode("79000")
                .setCountry("220")
                .setRegionState("3493")
                .setPassword(System.getenv("USER_PASSWORD"))
                .setNewPassword(System.getenv("USER_PASSWORD"))
                .setSubscribe(true)
                .setFax("+38065065")
                .setCompany("SoftServe")
                .setAddress2("no address")
                .build();
    }

    public IUser getInvalidCustomer() {
        return User.get()
                .setFirstName("123456789012345678901234567890123")
                .setLastName("Pe")
                .setEmail(System.getenv("USER_EMAIL"))
                .setTelephone("+380675515")
                .setAddress1("Ploshcha Rynok")
                .setCity("Lemberg")
                .setPostCode("79000")
                .setCountry("220")
                .setRegionState("3489")
                .setPassword(System.getenv("USER_PASSWORD"))
                .setNewPassword(System.getenv("USER_PASSWORD"))
                .setSubscribe(true)
                .setFax("+38065065")
                .setCompany("SoftServe")
                .setAddress2("no address")
                .build();
    }

    public List<IUser> fromCsv(String filename) {
        return User.getByLists(new CSVReader(filename).getAllCells());
    }

    public List<IUser> fromCsv() {
        return fromCsv("users.csv");
    }
}