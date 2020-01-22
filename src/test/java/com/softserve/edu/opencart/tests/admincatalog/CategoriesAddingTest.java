package com.softserve.edu.opencart.tests.admincatalog;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.CategoryRepository;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.ICategory;
import com.softserve.edu.opencart.tests.LocalAdminTestRunner;

/**
 * This {@code} class adds new categories from admin panel.
 */
public class CategoriesAddingTest extends LocalAdminTestRunner {
	
	@DataProvider
    public Object[][] correctUsers() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin(), CategoryRepository.get().getTablets()},
            { AdminRepo.get().validAdmin(), CategoryRepository.get().getSoftware()},
            { AdminRepo.get().validAdmin(), CategoryRepository.get().getSmartphones()},
            };
    }
        
    @Test(dataProvider = "correctUsers")
	public void addCategory(IAdmin validAdmin, ICategory tablets) {
    	
    	String actual = 
    	//login and go to Categories Page
		loadAdminPage()
    		.successfulLogin(validAdmin)
    		.gotoCategoriesPage()
    		.gotoAddCategoryPage()
    		.addCategory(tablets)
    		.getSuccessText();
		
		Assert.assertTrue(actual.contains(SUCCESS_MESSAGE));
	}
    
}
