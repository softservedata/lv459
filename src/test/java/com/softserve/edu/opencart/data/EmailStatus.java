package com.softserve.edu.opencart.data;

public class EmailStatus {
    private static volatile EmailStatus instance = null;

    private boolean isLogged;

    private EmailStatus() {
        isLogged = false;
    }

    public static EmailStatus get() {
        if (instance == null) {
            synchronized (EmailStatus.class) {
                if (instance == null) {
                    instance = new EmailStatus();
                }
            }
        }
        return instance;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }


}
