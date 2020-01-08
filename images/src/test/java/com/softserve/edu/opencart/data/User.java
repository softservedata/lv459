package com.softserve.edu.opencart.data;

public class User {

    private String email;
    private String firstName;
    private String password;

    public User(String email, String firstName, String password) {
        this.email = email;
        this.firstName = firstName;
        this.password = password;
    }

    // setters

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // getters

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

}