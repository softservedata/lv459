package com.softserve.edu.rest.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getAdmin();
    }

    public static User getAdmin() {
        return new User("admin", "qwerty", true).addItem(ItemRepository.getDefaultItemIndex0());
    }

    public static User notExistingUser() {
        return new User("Anna", "ksjddlfkjddqwerty", false).addItem(ItemRepository.getDefaultItemIndex0());
    }

    public static User someNotAdminUser() {
        return new User("user", "qwerty", false).addItem(ItemRepository.getDefaultItemIndex0());
    }

    public static User createVasya() {
        return new User("Vasya", "qwerty", false).addItem(ItemRepository.getDefaultItemIndex0());
    }

    public static User getDana() {
        return new User("Dana", "qwerty", false).addItem(ItemRepository.getDefaultItemIndex0());
    }

<<<<<<< HEAD
//    	public static User getDanaWithChangedPassword(){
=======

    public static User getNewAdmin() {
        return new User("adminNew", "qwerty", true).addItem(ItemRepository.getDefaultItemIndex0());
    }

    //	public static User getDanaWithChangedPassword(){
>>>>>>> 91a2e84c827da245f481b8ee9ff56d33bf7aee45
//		return new User("Dana", "qwerty5", false).addItem(ItemRepository.getDefaultItemIndex0());
//	}
	public static User getAdmin1() {
		return new User("admin", "qwerty", true)
				.addItem(ItemRepository.getBook())
				.addItem(ItemRepository.getCopybook());
	}
}
