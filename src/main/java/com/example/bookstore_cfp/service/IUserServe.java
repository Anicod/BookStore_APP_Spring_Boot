package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.UserDto;
import com.example.bookstore_cfp.model.UserM;

import java.util.List;

public interface IUserServe {
UserM save(UserDto userDto);
List<UserM> userList();
UserM getById(Integer Id);
UserM update(Integer Id, UserM userM);
void delete(Integer Id);
UserM byName(String name);
UserM byLogin(String email, String password);
}
