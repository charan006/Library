package com.library.library_transaction_service.feign;

import com.library.library_transaction_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="USER-SERVICE")
public interface UserFeign {

    @GetMapping("getAllUsers")
    public ResponseEntity<List<User>> getAllUsers();

    @PostMapping("createUser")
    public ResponseEntity<String> createUser(@RequestBody User user);

    @GetMapping("getUsers")
    public ResponseEntity<List<User>> getUsersList(@RequestBody List<Integer> id);

    @GetMapping("getUser/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable int id);

    @PutMapping("updateUser")
    public ResponseEntity<String> updateUser(@RequestBody User user);

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id);


}
