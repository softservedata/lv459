package com.softserve.edu.opencart.data;

public class AdminRepo {
    protected static final String DB_PASSWORD = System.getenv("DB_PASSWORD");

    public static Admin getValidAdmin () {
        return new Admin("admin", DB_PASSWORD);
    }
}
