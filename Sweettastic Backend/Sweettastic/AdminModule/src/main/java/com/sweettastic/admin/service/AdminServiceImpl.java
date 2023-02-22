package com.sweettastic.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.admin.repository.AdminRepo;

@Service
public class AdminServiceImpl {

	@Autowired
	private AdminRepo adminDao;
	
}
