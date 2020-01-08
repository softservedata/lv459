package com.softserve.edu.opencart.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getHahaha();
    }

    public static User getHahaha() {
        return new User("hahaha@gmail.com", "hahaha",
                System.getenv().get("MY_PASSWORD"));
    }

    public static User getAdmin() {
        return new User("hahaha@gmail.com", "123",
                System.getenv().get("MY_PASSWORD"));
    }

}