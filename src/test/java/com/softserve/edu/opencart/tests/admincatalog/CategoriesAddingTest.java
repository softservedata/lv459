package com.softserve.edu.opencart.tests.admincatalog;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.tests.LocalAdminTestRunner;

public class CategoriesAddingTest extends LocalAdminTestRunner {
	
	@DataProvider // (parallel = true)
    public Object[][] correctUsers() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin()},
            };
    }
        
    @Test(dataProvider = "correctUsers")
	public void addNewCategory(IAdmin validAdmin) {
		
		loadAdminPage()
    	.successfulLogin(validAdmin)
    	.gotoCategoriesPage()
    	.gotoAddCategoryPage()
		.typeName("test")
		.typeTitle("test")
		.clickDataButton()
		.typeParent("test")
		.gotoModifiedCatalogPage()
		.getSuccessText();
	}
    
}
