package com.softserve.edu.opencart.data;

public class AppUser {
	
	public static void main(String[] args) {
		//
		// 1. Classic Constructor
//		User user = new User("firstName_1", "lastName_1", "email_1",
//				"telephone_1", "fax_1", "company_1",
//				"address1_1", "address2_1", "city_1",
//				"postCode_1", "country_1", "regionState_1",
//				"password_1", true);
//		System.out.println("email = " + user.getEmail());
		//
		// 2. Use Default Constructor, Setters
//		User user = new User();
//		user.setFirstName("firstName_2");
//		user.setLastName("lastName_2");
//		user.setEmail("email_2");
//		user.setTelephone("telephone_2");
//		user.setFax("fax_2");
//		user.setCompany("company_2");
//		user.setAddress1("address1_2");
//		user.setAddress2("address2_2");
//		user.setCity("city_2");
//		user.setPostCode("postCode_2");
//		user.setCountry("country_2");
//		user.setRegionState("regionState_2");
//		user.setPassword("password_2");
//		user.setSubscribe(true);
//		System.out.println("email = " + user.getEmail());
		//
		// 3. Use Fluent Interface
//		User user = new User()
//			.setFirstName("firstName_3")
//			.setLastName("lastName_3")
//			//.setEmail("email_3") // Error
//			.setTelephone("telephone_3")
//			.setFax("fax_3")
//			.setCompany("company_3")
//			.setAddress1("address1_3")
//			.setAddress2("address2_3")
//			.setCity("city_3")
//			.setPostCode("postCode_3")
//			.setCountry("country_3")
//			.setRegionState("regionState_3")
//			.setPassword("password_3")
//			.setSubscribe(true);
//		System.out.println("email = " + user.getEmail());
		//
		// 4. Add Static Factory
//		User user = User.get()
//				.setFirstName("firstName_4")
//				.setLastName("lastName_4")
//				.setEmail("email_4")
//				.setTelephone("telephone_4")
//				.setFax("fax_4")
//				.setCompany("company_4")
//				.setAddress1("address1_4")
//				.setAddress2("address2_4")
//				.setCity("city_4")
//				.setPostCode("postCode_4")
//				.setCountry("country_4")
//				.setRegionState("regionState_4")
//				.setPassword("password_4")
//				.setSubscribe(true);
//			System.out.println("email = " + user.getEmail());
		//
		// 5. Add Builder
//		User user = User.get()
//				.setFirstName("firstName_5")
//				.setLastName("lastName_5")
//				.setEmail("email_5")
//				.setTelephone("telephone_5")
//				.setAddress1("address1_5")
//				.setCity("city_5")
//				.setPostCode("postCode_5")
//				.setCountry("country_5")
//				.setRegionState("regionState_5")
//				.setPassword("password_5")
//				.setSubscribe(true)
//				.setFax("fax_5")
//				.setCompany("company_5")
//				.setAddress2("address2_5")
//				.build();
//		System.out.println("email = " + user.getEmail());
//		// Code
//		System.out.println("email = " + user.setEmail("hahaha")); // Code Smell
//		// Code
//		System.out.println("email = " + user.getEmail());
		//
		// 6. Add Dependency Inversion
//		IUser user = User.get()
//				.setFirstName("firstName_5")
//				.setLastName("lastName_5")
//				.setEmail("email_5")
//				.setTelephone("telephone_5")
//				.setAddress1("address1_5")
//				.setCity("city_5")
//				.setPostCode("postCode_5")
//				.setCountry("country_5")
//				.setRegionState("regionState_5")
//				.setPassword("password_5")
//				.setSubscribe(true)
//				.setFax("fax_5")
//				.setCompany("company_5")
//				.setAddress2("address2_5")
//				.build();
//		System.out.println("email = " + user.getEmail());
		// Code
		//System.out.println("email = " + user.setEmail("hahaha")); // Compile Error
		//System.out.println("email = " + ((User) user).setEmail("hahaha")); // Code Smell
		// Code
		//System.out.println("email = " + user.getEmail());
		//
		// 7. Add Repository
		IUser user = UserRepository.get().getHahaha();
		System.out.println("email = " + user.getEmail());
	}
}
