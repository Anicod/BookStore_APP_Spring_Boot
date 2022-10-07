package com.example.bookstore_cfp.dto;

public class UserDto {
    public String firstName;
    public String lastName;
    public String address;
    public String password;
    public String email;

    public UserDto(String firstName, String lastName, String address, String password, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.password = password;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
