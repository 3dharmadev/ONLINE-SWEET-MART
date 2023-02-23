package com.sweettastic.user.service;

import java.util.List;

import com.sweettastic.user.model.user;

public interface UserServices {

	
	public user saveuser(user u1);
	
	public user UpdateUser(user users);
	public String  CancelUser(Integer userId);
	public List<user> ShowAllUser();
}
