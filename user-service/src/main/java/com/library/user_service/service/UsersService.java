package com.library.user_service.service;

import com.library.user_service.dao.UsersDao;
import com.library.user_service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    UsersDao usersDao;

    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(usersDao.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<String> createUser(User user) {

        //Check if same email address exists in db
        Optional<User> existingUser = usersDao.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return new ResponseEntity<>("User with this email address already exists", HttpStatus.CONFLICT);
        }

        usersDao.save(user);
        return ResponseEntity.ok("SUCCESS");
    }


    public ResponseEntity<User> getUserwithId(int id) {
        return new ResponseEntity<>(usersDao.findById(id).get(), HttpStatus.OK);
    }


    public ResponseEntity<String> updateUser(User user) {

        if(getUserwithId(user.getId()) == null){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        usersDao.save(user);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }


    public ResponseEntity<String> deleteUser(int id) {
        if(getUserwithId(id) == null){
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        try{
            usersDao.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        }catch(Exception e){
            return new ResponseEntity<>("Delete failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<List<User>> getUsersList(List<Integer> id) {
        List<User> temp = new ArrayList<>();
        for(int i : id){
            temp.add(getUserwithId(i).getBody());
        }
        return new ResponseEntity<>(temp, HttpStatus.OK);

    }
}
