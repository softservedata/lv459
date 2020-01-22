package com.softserve.edu.opencart.data;

public final class CategoryRepository {
	
	 private static volatile CategoryRepository instance = null;
	    
	    private CategoryRepository() {
	        
	    }
	    
	    public static CategoryRepository get() {
	        if (instance == null) {
	            synchronized (CategoryRepository.class) {
	                if (instance == null) {
	                    instance = new CategoryRepository();
	                }
	            }
	        }
	        return instance;
	    }
	    
	    public ICategory getTablets() {
	        return Category.get()
	        		.setName("Tablets")
	        		.setTitle("Tablets")
	        		.setParent("Tablets")
	        		.build();
	    }
	    
	    public ICategory getSoftware() {
	        return Category.get()
	        		.setName("Software")
	        		.setTitle("Software")
	        		.setParent("Software")
	        		.build();
	    }
	    
	    public ICategory getSmartphones() {
	        return Category.get()
	        		.setName("Smartphones")
	        		.setTitle("Smartphones")
	        		.setParent("Phones & PDAs")
	        		.build();
	    }
	    
	    public ICategory getCameras() {
	        return Category.get()
	        		.setName("Cameras")
	        		.setTitle("Cameras")
	        		.setParent("Cameras")
	        		.build();
	    }
	    
	    public ICategory getMP3Players() {
	        return Category.get()
	        		.setName("MP3 Players")
	        		.setTitle("MP3 Players")
	        		.setParent("MP3 Players")
	        		.build();
	    }
	    
}
