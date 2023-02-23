package com.sweettastic.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sweettastic.customer.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{

	Customer findByUsername(String username);
}
