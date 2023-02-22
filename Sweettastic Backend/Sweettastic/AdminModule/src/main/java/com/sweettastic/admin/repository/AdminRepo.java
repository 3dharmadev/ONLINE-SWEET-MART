package com.sweettastic.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweettastic.admin.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{

}
