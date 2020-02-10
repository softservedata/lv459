package com.softserve.edu.opencart.tests.admincatalog;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.opencart.data.AdminRepo;
import com.softserve.edu.opencart.data.IAdmin;
import com.softserve.edu.opencart.data.IProduct;
import com.softserve.edu.opencart.data.ProductRepository;
import com.softserve.edu.opencart.tests.LocalAdminSingleThreadRunner;

public class ProductsAddingTest extends LocalAdminSingleThreadRunner {
	
	@DataProvider // (parallel = true)
    public Object[][] correctUsers() {
        return new Object[][] { 
            { AdminRepo.get().validAdmin(), ProductRepository.get().getMacBook() },
            //{ ProductRepository.get().getMacBook() }
            };
    }
        
    @Test(dataProvider = "correctUsers")
    
	public void addNewProduct(IAdmin validAdmin, IProduct macBookProduct)  {
		//IProduct macBookProduct = ProductRepository.get().getMacBook();
    	String actual = 
		loadAdminPage()
    	.successfulLogin(validAdmin)
    	.gotoProductPage()
    	.gotoAddProductPage()
    	.typeName(macBookProduct.getName())
		.typeTitle("test")
		.clickDataButton()
		.typeModel("test")
		.gotoModifiedCategoriesPage()
		.getSuccessText();
    	System.out.println(actual);
    	//Assert
	}
    
}
