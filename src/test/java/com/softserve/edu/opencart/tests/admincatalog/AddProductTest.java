package com.softserve.edu.opencart.tests.admincatalog;

import org.testng.Assert;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminProductRepository;
import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.IAdminProduct;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.tests.LocalAdminTestRunner;

/**
 * This {@code} class adds products from admin panel.
 */
public class AddProductTest extends LocalAdminTestRunner  {
	
	@DataProvider
    public Object[][] correctUsers() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin(), AdminProductRepository.get().getIPhone() },
            };
    }
        
    @Test(dataProvider = "correctUsers")
    
	public void addNewProduct(IAdmin validAdmin, IAdminProduct product)  {
	
    	String actual = 
		loadAdminPage()
			.successfulLogin(validAdmin)
			.gotoProductPage()
			.gotoAddProductPage()
    		.addProduct(product)
    		.getSuccessText();

    	//Assert.assertEquals(actual, "Success: You have modified categories!");
    	Assert.assertTrue(actual.contains(SUCCESS_MESSAGE));
	}
    
}
