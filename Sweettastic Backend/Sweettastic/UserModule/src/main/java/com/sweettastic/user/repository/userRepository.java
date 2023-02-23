package com.sweettastic.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.user.model.user;

public interface userRepository extends JpaRepository<user, Integer>{

}
