package com.softserve.edu.rest.data;

public class User {

	//private final String ERROR_USER_LOCKED = "ERROR, user locked";
	//private final String ERROR_USER_NOT_FOUND = "ERROR, user not found";
	//
	private String name;
	private String password;
	// TODO Remove
	private String token;
	private String time;
//    private List<Item> items;
	private boolean adminRights;

	// TODO Develop Builder
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		// items = new ArrayList<>();
		token = new String();
		adminRights = false;
	}

	// setters

	public User setAdminRights(boolean adminRights) {
		this.adminRights = adminRights;
		return this;
	}

	public User setToken(String token) {
		this.token = token;
		return this;
	}

	public User setTime(String time) {
		this.time = time;
		return this;
	}

//    public User addItem(Item item) {
//        items.add(item);
//        return this;
//    }

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	// getters

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getToken() {
		return token;
	}

	public String getTime() {
		return time;
	}

	public boolean isAdminRights() {
		return adminRights;
	}

//    public List<Item> getItems() {
//        return items;
//    }

	@Override
	public String toString() {
		return "User{" + "name='" + name + '\'' 
				+ ", password='" + password + '\'' 
				+ ", token='" + token + '\'' +
//                ", items=" + items +
				", adminRights=" + adminRights + '}';
	}
	
}
