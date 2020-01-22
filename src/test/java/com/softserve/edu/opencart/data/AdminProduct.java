package com.softserve.edu.opencart.data;

interface IProductName {
	IProductTitle setName(String name);
}

interface IProductTitle {
	IModel setTitle(String title);
}

interface IModel {
	IBuildAdminProduct setModel(String model);
}

interface IBuildAdminProduct {
	IAdminProduct build();
}

public final class AdminProduct 
		implements IAdminProduct, IProductName, IProductTitle, IModel, IBuildAdminProduct{

	String name;
	String title;
	String model;

    public static IProductName get() {
        return new AdminProduct();
    }

		public IProductTitle setName(String name) {
			this.name = name;
			return this;
		}

		public String getName() {
			return name;
		}

		public IModel setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public String getTitle() {
			return title;
		}

		public IBuildAdminProduct setModel(String model) {
			this.model = model;
			return this;
		}
		
		public String getModel() {
			return model;
		}

		public IAdminProduct build() {
			return this;
		}

}
