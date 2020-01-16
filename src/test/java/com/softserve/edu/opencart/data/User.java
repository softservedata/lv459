package com.softserve.edu.opencart.data;

import java.util.ArrayList;
import java.util.List;

//5. Add Builder
interface IFirstName {
	ILastName setFirstName(String firstName);
}

interface ILastName {
	IEmail setLastName(String lastName);
}

interface IEmail {
	ITelephone setEmail(String email);
}

interface ITelephone {
	IAddress setTelephone(String telephone);
}

interface IAddress {
	ICity setAddress1(String address1);
}

interface ICity {
	IPostCode setCity(String city);
}

interface IPostCode {
	ICountry setPostCode(String postCode);
}

interface ICountry {
	IRegionState setCountry(String country);
}

interface IRegionState {
	IPassword setRegionState(String regionState);
}

interface IPassword {
	ISubscribe setPassword(String password);
}

interface ISubscribe {
	IFaxOptional setSubscribe(boolean subscribe);
}

//5. Add Builder
//interface IBuildUser {
//	IBuildUser setFax(String fax);
//	IBuildUser setCompany(String company);
//	IBuildUser setAddress2(String address2);
	// 5. Add Builder
	//User build();
	// 6. Add Dependency Inversion
//	IUser build();
//}

// 8. Add Optional Parameters
interface IBuildUser {
	IUser build();
}

interface IFaxOptional extends IBuildUser {
	ICompanyOptional setFax(String fax);
}

interface ICompanyOptional extends IBuildUser {
	IAddressOptional setCompany(String company);
}

interface IAddressOptional extends IBuildUser {
	IBuildUser setAddress2(String address2);
}


public final class User
		// 5. Add Builder
		implements IFirstName, ILastName, IEmail,
			ITelephone, IAddress, ICity, IPostCode, ICountry, IRegionState,
			IPassword, ISubscribe, IFaxOptional, ICompanyOptional, IAddressOptional, IBuildUser,
			// 6. Add Dependency Inversion
			IUser {

	public static enum UserColumns {
        FIRST_NAME(0),
        LAST_NAME(1),
        EMAIL(2),
        TELEPHONE(3),
        ADDRESS1(4),
        CITY(5),
        POST_CODE(6),
        COUNTRY(7),
        REGION_STATE(8),
        PASSWORD(9),
        SUBSCRIBE(10),
        FAX(11),
        COMPANY(12),
        ADDRESS2(13);
        //
        private int index;

        private UserColumns(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }
    
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	
	private final static String EMAIL_SEPARATOR = "@";
	public final static String EMPTY_STRING = new String();
	//private final static Logger logger = LoggerFactory.getLogger(User.class);
	//
	// 1. Classic Constructor
	private String firstName;
	private String lastName;
	private String email;
	private String telephone;
	private String fax; // optional
	private String company; // optional
	private String address1;
	private String address2; // optional
	private String city;
	private String postCode;
	private String country;
	private String regionState;
	private String password;
	private boolean subscribe;

	// 1. Classic Constructor
//	public User(String firstName, String lastName, String email, String telephone, String fax, String company,
//			String address1, String address2, String city, String postCode, String country, String regionState,
//			String password, boolean subscribe) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.email = email;
//		this.telephone = telephone;
//		this.fax = fax;
//		this.company = company;
//		this.address1 = address1;
//		this.address2 = address2;
//		this.city = city;
//		this.postCode = postCode;
//		this.country = country;
//		this.regionState = regionState;
//		this.password = password;
//		this.subscribe = subscribe;
//	}

	// 2. Use Default Constructor, Setters
	// public User() {
	// 4. Add Static Factory
	private User() {
		//this.firstName = "";
		//this.lastName = "";
		//this.email = "";
		//this.telephone = "";
		// 5. Add Builder
		this.fax = EMPTY_STRING; 		// optional
		// 5. Add Builder
		this.company = EMPTY_STRING; 	// optional
		//this.address1 = "";
		// 5. Add Builder
		this.address2 = EMPTY_STRING;	// optional
		//this.city = "";
		//this.postCode = "";
		//this.country = "";
		//this.regionState = "";
		//this.password = "";
		//this.subscribe = true;
	}

	// 4. Add Static Factory
	// public static User get() {
	// 5. Add Builder
	public static IFirstName get() {
		return new User();
	}

	// setters

	// 2. Use Default Constructor, Setters
	// public void setFirstName(String firstName) {
	// 3. Use Fluent Interface
	//public User setFirstName(String firstName) {
	// 5. Add Builder
	public ILastName setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public IEmail setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public ITelephone setEmail(String email) {
		this.email = email;
		return this;
	}

	public IAddress setTelephone(String telephone) {
		this.telephone = telephone;
		return this;
	}

	public ICompanyOptional setFax(String fax) {
		this.fax = fax;
		return this;
	}

	public IAddressOptional setCompany(String company) {
		this.company = company;
		return this;
	}

	public ICity setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public IBuildUser setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public IPostCode setCity(String city) {
		this.city = city;
		return this;
	}

	public ICountry setPostCode(String postCode) {
		this.postCode = postCode;
		return this;
	}

	public IRegionState setCountry(String country) {
		this.country = country;
		return this;
	}

	public IPassword setRegionState(String regionState) {
		this.regionState = regionState;
		return this;
	}

	public ISubscribe setPassword(String password) {
		this.password = password;
		return this;
	}

	public IFaxOptional setSubscribe(boolean subscribe) {
		this.subscribe = subscribe;
		return this;
	}

	// 5. Add Builder
	//public User build() {
	// 6. Add Dependency Inversion
	public IUser build() {
		return this;
	}
	
	// getters

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getTelephone() {
		return telephone;
	}

	public String getFax() {
		return fax;
	}

	public String getCompany() {
		return company;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCountry() {
		return country;
	}

	public String getRegionState() {
		return regionState;
	}

	public String getPassword() {
		return password;
	}

	public boolean isSubscribe() {
		return subscribe;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName 
				+ ", lastName=" + lastName 
				+ ", email=" + email 
				+ ", telephone=" + telephone 
				+ ", fax=" + fax 
				+ ", company=" + company 
				+ ", address1=" + address1 
				+ ", address2=" + address2 
				+ ", city=" + city 
				+ ", postCode=" + postCode 
				+ ", country=" + country 
				+ ", regionState=" + regionState 
				+ ", password=" + password 
				+ ", subscribe=" + subscribe + "]";
	}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public static IUser getByList(List<String> row) {
        //logger.trace("row.size() = " + row.size() + " UserColumns.values().length = " + UserColumns.values().length);
        List<String> userData = new ArrayList<>(row);
        for (int i = userData.size(); i < UserColumns.values().length; i++) {
            userData.add(EMPTY_STRING);
        }
        return User.get()
                .setFirstName(userData.get(UserColumns.FIRST_NAME.getIndex()))
                .setLastName(userData.get(UserColumns.LAST_NAME.getIndex()))
                .setEmail(userData.get(UserColumns.EMAIL.getIndex()))
                .setTelephone(userData.get(UserColumns.TELEPHONE.getIndex()))
                .setAddress1(userData.get(UserColumns.ADDRESS1.getIndex()))
                .setCity(userData.get(UserColumns.CITY.getIndex()))
                .setPostCode(userData.get(UserColumns.POST_CODE.getIndex()))
                .setCountry(userData.get(UserColumns.COUNTRY.getIndex()))
                .setRegionState(userData.get(UserColumns.REGION_STATE.getIndex()))
                .setPassword(System.getenv().get(userData.get(UserColumns.PASSWORD.getIndex())))
                .setSubscribe(Boolean.parseBoolean(userData
                		.get(UserColumns.SUBSCRIBE.getIndex()).toLowerCase()))
                .setFax(userData.get(UserColumns.FAX.getIndex()) != null ? userData.get(UserColumns.FAX.getIndex()) : EMPTY_STRING)
                //.setFax( userData.get(UserColumns.FAX.getIndex()) == null
                //            || userData.get(UserColumns.FAX.getIndex()).isEmpty()
                //        ? EMPTY_STRING : userData.get(UserColumns.FAX.getIndex()))
                .setCompany(userData.get(UserColumns.COMPANY.getIndex()) != null ? userData.get(UserColumns.COMPANY.getIndex()) : EMPTY_STRING)
                .setAddress2(userData.get(UserColumns.ADDRESS2.getIndex()) != null ? userData.get(UserColumns.ADDRESS2.getIndex()) : EMPTY_STRING)
                .build();
    }

    public static List<IUser> getByLists(List<List<String>> rows) {
        List<IUser> result = new ArrayList<>();
        // TODO Verify Test Data as Valid
        if (!rows.get(0).get(UserColumns.EMAIL.getIndex())
                .contains(EMAIL_SEPARATOR)) {
            rows.remove(0);
        }
        for (List<String> currentRow : rows) {
            result.add(getByList(currentRow));
        }
        return result;
    }

}
