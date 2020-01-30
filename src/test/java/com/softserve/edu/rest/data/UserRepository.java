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

}
