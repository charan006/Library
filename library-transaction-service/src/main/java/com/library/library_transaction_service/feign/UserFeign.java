package com.library.library_transaction_service.feign;

import com.library.library_transaction_service.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("USER-SERVICE")
public interface UserFeign {

    @GetMapping("user/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers();

    @GetMapping("user/getUsers")
    public ResponseEntity<List<User>> getUsersList(@RequestBody List<Integer> id);

    @GetMapping("user/getUser/{id}")
    public ResponseEntity<User> getUserWithId(@PathVariable int id);

}
