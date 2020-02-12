package com.softserve.edu.rest.data;

public final class UserRepository {

    private UserRepository() {
    }

    public static User getDefault() {
        return getAdmin();
    }

    public static User getAdmin() {
        return new User("admin", "qwerty", true)
                .addItem(ItemRepository.getDefaultItemIndex1());
    }

    public static User notExistingUser() {
        return new User("Anna", "ksjddlfkjddqwerty", false)
                .addItem(ItemRepository.getDefaultItemIndex1());
    }

    public static User someNotAdminUser() {
        return new User("user", "qwerty", false)
                .addItem(ItemRepository.getDefaultItemIndex1());
    }

    public static User getVasya() {
        return new User("Vasya", "qwerty", true)
                .addItem(ItemRepository.getItemVasya());
    }

    public static User getDana() {
        return new User("Dana", "qwerty", false)
                .addItem(ItemRepository.getItemDana());
    }

    public static User getNewAdmin() {
        return new User("adminNew", "qwerty", true)
                .addItem(ItemRepository.getDefaultItemIndex1());
    }
}
