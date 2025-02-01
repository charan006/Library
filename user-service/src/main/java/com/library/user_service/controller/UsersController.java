package com.library.user_service.controller;

import com.library.user_service.model.User;
import com.library.user_service.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return usersService.getAllUsers();
    }

    @PostMapping("createUser")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return usersService.createUser(user);
    }

    @GetMapping("getUsers")
    public ResponseEntity<List<User>> getUsersList(@RequestBody List<Integer> id){
        return usersService.getUsersList(id);
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable int id){
        return usersService.getUserwithId(id);
    }

    @PutMapping("updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user){
        return usersService.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        return usersService.deleteUser(id);
    }


}
