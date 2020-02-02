package com.softserve.edu.rest.data;

public final class UserRepository {

	private UserRepository() {
	}

	public static User getDefault() {
		return getAdmin();
	}

	public static User getAdmin() {
		return new User("admin", "qwerty", true).addItem("My data");
	}

	public static User notExistingUser() {
		return new User("Anna", "ksjddlfkjddqwerty", false).addItem("My data");
	}

	public static User someNotAdminUser (){
		return new User("user", "qwerty", false).addItem("usersNewItem");
	}

	public static User createVasya(){
		return new User("Vasya", "qwerty", false).addItem("usersNewItem");
	}

}
