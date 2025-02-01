package com.library.user_service.dao;

import com.library.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
