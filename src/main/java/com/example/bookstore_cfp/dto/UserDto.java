package com.example.bookstore_cfp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class UserDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "enter a valid name")
    public String firstName;
    @Pattern(regexp = "[a-zA-Z]{2,}$", message = "enter a valid last name")
    public String lastName;
    @NotEmpty(message = "address not be empty")
    @Pattern(regexp = "[a-zA-Z]{2,}$", message = "enter a valid address")
    public String address;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}[1-9]{1,}[0]{1,}[@#$%&]{1,}$", message = "password must be strong")
    public String password;
    @Email(message = "your email is not valid")
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
