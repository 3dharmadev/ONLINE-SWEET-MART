package com.sweettastic.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.user.model.User;

public interface userRepository extends JpaRepository<User, Integer>{

}
