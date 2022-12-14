package com.example.bookstore_cfp.model;
import com.example.bookstore_cfp.dto.UserDto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class UserM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer UserId;
    public String firstName;
    public String lastName;
    public String address;
    public String password;
    public String email;

    public UserM(){

    }

    public UserM(UserDto userDto) {
        this.firstName = userDto.firstName;
        this.lastName = userDto.lastName;
        this.address = userDto.address;
        this.password = userDto.password;
        this.email = userDto.email;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
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
