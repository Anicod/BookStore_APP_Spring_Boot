package com.example.bookstore_cfp.controller;

import com.example.bookstore_cfp.dto.ResponseUserDto;
import com.example.bookstore_cfp.dto.UserDto;
import com.example.bookstore_cfp.model.UserM;
import com.example.bookstore_cfp.service.IUserServe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    IUserServe iUserServe;

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> userRegistration(@Valid @RequestBody UserDto userDto){
        UserM userM = iUserServe.save(userDto);
        ResponseUserDto responseUserDto = new ResponseUserDto(userM, "user register successfully");
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }
    @GetMapping("/getalluser")
    public ResponseEntity<ResponseUserDto> getAll(){
        List<UserM> userMS = iUserServe.userList();
        ResponseUserDto responseUserDto = new ResponseUserDto(userMS, "list of all user");
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }
    @GetMapping("/getbyid")
    public ResponseEntity<ResponseUserDto> getById(@RequestParam Integer id){
        UserM userM = iUserServe.getById(id);
        if(userM.UserId.equals(id)){
            log.info("user exsit");
        }
        else {
            log.info("user not found");
        }
        ResponseUserDto responseUserDto = new ResponseUserDto(userM, "user exsit by this id");
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }
    @PutMapping("/updatebyid/{Id}")
    public ResponseEntity<ResponseUserDto> updateById(@PathVariable Integer Id, @RequestBody UserDto userDto){
        UserM userM = new UserM(userDto);
        UserM updateUser = iUserServe.update(Id, userM);
        ResponseUserDto responseUserDto = new ResponseUserDto(updateUser, "details updated successfully");
        if(updateUser.UserId.equals(Id)){
            log.info("userId  updated successfully");
        }
        else {
            log.info("user not found");
        }
        return new ResponseEntity<>(responseUserDto, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{Id}")
    public String deleteData(@PathVariable Integer Id){
        iUserServe.delete(Id);
        return "Id deleted successfully";
    }

}
