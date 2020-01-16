package com.softserve.edu.opencart.data;

public class AdminPanelStatus {

    private static volatile AdminPanelStatus instance = null;

    private boolean isLogged;

    private AdminPanelStatus() {
        isLogged = false;
    }

    public static AdminPanelStatus get() {
        if (instance == null) {
            synchronized (AdminPanelStatus.class) {
                if (instance == null) {
                    instance = new AdminPanelStatus();
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
