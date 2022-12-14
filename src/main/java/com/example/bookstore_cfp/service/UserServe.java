package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.UserDto;
import com.example.bookstore_cfp.exception.BookStoreException;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServe implements IUserServe{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserM save(UserDto userDto) {
        UserM userM = new UserM(userDto);
        userRepo.save(userM);
        return userM;
    }

    @Override
    public List<UserM> userList() {
        return userRepo.findAll();
    }

    @Override
    public UserM getById(Integer Id) {
        UserM userM = userRepo.findById(Id).orElseThrow(()->new BookStoreException("user not found"));
        return userM;
    }

    @Override
    public UserM update(Integer Id, UserM userM) {
        UserM userM1 =  userRepo.findById(Id).orElseThrow(()->new BookStoreException("User does not exsit"));
        if(userM1 != null){
            userM1.setFirstName(userM1.getFirstName());
            userM1.setLastName(userM.getLastName());
            userM1.setAddress(userM.getAddress());
            userM1.setPassword(userM.getPassword());
            userM1.setEmail(userM.getEmail());
            return userRepo.save(userM1);
        }
        return userM1;
    }

    @Override
    public void delete(Integer Id) {
        if (userRepo.existsById(Id)){
            userRepo.deleteById(Id);
        }
        else {
            log.info("opps!! Id not found");
            throw new BookStoreException("user not found");
        }
    }

    @Override
    public UserM byName(String name) {
        return userRepo.getUserMSByFirstName(name);
    }

    @Override
    public UserM byLogin(String email, String password) {
        return userRepo.getUserMBynameAndPassword(email, password);

    }
}
