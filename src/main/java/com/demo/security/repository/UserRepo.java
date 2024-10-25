package com.demo.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.security.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
