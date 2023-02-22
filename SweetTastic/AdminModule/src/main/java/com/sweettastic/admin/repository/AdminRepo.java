package com.sweettastic.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.admin.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
