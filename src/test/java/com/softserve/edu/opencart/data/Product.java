package com.softserve.edu.opencart.data;

	interface IName {
		IDescription setName(String name);
	}
	interface IDescription {
		PriceDollarExTax setDescription(String description);
	}

	interface PriceDollarExTax {
		IBuildProduct setPriceDollarExTax(String priceDollarExTax);
	}
	interface IBuildProduct {
		IProduct build();
	}

	public final class Product
			implements IName, IDescription, PriceDollarExTax,
			IBuildProduct,
			IProduct {

		private String name;
		private String description;
		private String priceDollarExTax;


		private Product() {
			//
		}

		public static IName get() {
			return new Product();
		}

		public IDescription setName(String name) {
			this.name = name;
			return this;
		}

		public PriceDollarExTax setDescription(String description) {
			this.description = description;
			return this;
		}

		public IBuildProduct setPriceDollarExTax(String priceDollarExTax) {
			this.priceDollarExTax = priceDollarExTax;
			return this;
		}

	public IProduct build() {
			return this;
		}

	public 	String getName(){return  name;}

	public String getDescription(){return description;}

	public 	String getPriceDollarExTax(){return priceDollarExTax;}

		@Override
		public String toString() {
			return "Product{" +
					"name='" + name + '\'' +
					", description='" + description + '\'' +
					", priceDollarExTax='" + priceDollarExTax + '\'' +
					'}';
		}

		//	public class Product {
//	private String name;
//	private String description;
//	private String priceDollarExTax;
//	// TODO
//	// private Map<Currencies, Decimal> prices;
//	private Map<Currencies, String> prices;
//
//	public Product(String name, String description, String priceDollarExTax) {
//		this.name = name;
//		this.description = description;
//		this.priceDollarExTax = priceDollarExTax;
//		prices = new HashMap<Currencies, String>();
//	}
//
//	// setters
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public void setPriceDollarExTax(String priceDollarExTax) {
//		this.priceDollarExTax = priceDollarExTax;
//	}
//
//	public Product addPrice(Currencies currency, String price) {
//		prices.put(currency, price);
//		return this;
//	}
//
//	// getters
//
//	public String getName() {
//		return name;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public String getPriceDollarExTax() {
//		return priceDollarExTax;
//	}
//
//	public String getPrice(Currencies currency) {
//		return prices.get(currency);
//	}





}
