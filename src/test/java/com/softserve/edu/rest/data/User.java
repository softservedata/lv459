package com.softserve.edu.rest.data;

import java.util.ArrayList;
import java.util.List;

public class User {

	// private final String ERROR_USER_LOCKED = "ERROR, user locked";
	// private final String ERROR_USER_NOT_FOUND = "ERROR, user not found";
	//
	private String name;
	private String password;
	private boolean isAdmin;
	private List<String> items;

	// TODO Develop Builder
	public User(String name, String password, boolean isAdmin) {
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;
		items = new ArrayList<>();
	}

	// setters
	
	public User setName(String name) {
		this.name = name;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
		return this;
	}

	public User addItem(String item) {
		items.add(item);
		return this;
	}
	
	// getters
	
	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public List<String> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return "User [name=" + name
				//+ ", password=" + password
				+ ", isAdmin=" + isAdmin
				+ ", items=" + items + "]";
	}

	
}
