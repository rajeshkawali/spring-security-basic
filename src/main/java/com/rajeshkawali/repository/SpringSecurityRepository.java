package com.rajeshkawali.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajeshkawali.entity.User;

import java.util.Optional;

@Repository
public interface SpringSecurityRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    
}
