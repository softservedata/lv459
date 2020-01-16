package com.softserve.edu.opencart.data;

public final class AdminRepo {

    private static volatile AdminRepo instance = null;
    
    private AdminRepo() {
        
    }
    
    public static AdminRepo get() {
        if (instance == null) {
            synchronized (AdminRepo.class) {
                if (instance == null) {
                    instance = new AdminRepo();
                }
            }
        }
        return instance;
    }
    
    public IAdmin getDefault() {
        return getValidAdmin();
    }

    public IAdmin getValidAdmin() {
        return Admin.get()
                .setLogin("admin")
                .setPassword(System.getenv("DB_PASSWORD"))
                .build();
    }
}
