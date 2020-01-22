package com.softserve.edu.opencart.data;

public final class AdminProductRepository {
	
	private static volatile AdminProductRepository instance = null;
    
    private AdminProductRepository() {
        
    }
    
    public static AdminProductRepository get() {
        if (instance == null) {
            synchronized (AdminProductRepository.class) {
                if (instance == null) {
                    instance = new AdminProductRepository();
                }
            }
        }
        return instance;
    }
    
    public IAdminProduct getSamsung() {
        return AdminProduct.get()
        		.setName("Samsung")
        		.setTitle("Tablet")
        		.setModel(" ")
        		.build();
    }
    
    public IAdminProduct getIPhone() {
        return AdminProduct.get()
        		.setName("iPhone")
        		.setTitle("Smartphones")
        		.setModel("11 Pro")
        		.build();
    }
    
    public IAdminProduct getNikon() {
        return AdminProduct.get()
        		.setName("Nikon")
        		.setTitle("Cameras")
        		.setModel(" ")
        		.build();
    }
    
}
