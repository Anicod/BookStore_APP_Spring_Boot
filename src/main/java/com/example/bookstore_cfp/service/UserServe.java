package com.example.bookstore_cfp.service;

import com.example.bookstore_cfp.dto.UserDto;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.repository.BookStoreRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServe implements IUserServe{
    @Autowired
    BookStoreRepo bookStoreRepo;

    @Override
    public UserM save(UserDto userDto) {
        UserM userM = new UserM(userDto);
        bookStoreRepo.save(userM);
        return userM;
    }

    @Override
    public List<UserM> userList() {
        return bookStoreRepo.findAll();
    }

    @Override
    public UserM getById(Integer Id) {
        UserM userM = bookStoreRepo.findById(Id).get();
        return userM;
    }

    @Override
    public UserM update(Integer Id, UserM userM) {
        UserM userM1 =  bookStoreRepo.findById(Id).get();
        if(userM1 != null){
            userM1.setFirstName(userM1.getFirstName());
            userM1.setLastName(userM.getLastName());
            userM1.setAddress(userM.getAddress());
            userM1.setPassword(userM.getPassword());
            userM1.setEmail(userM.getEmail());
            return bookStoreRepo.save(userM1);
        }
        return null;
    }

    @Override
    public void delete(Integer Id) {
        if (bookStoreRepo.existsById(Id)){
            bookStoreRepo.deleteById(Id);
        }
        else {
            log.info("opps!! Id not found");
        }
    }
}
