package com.sweettastic.service;

import com.sweettastic.models.User;

import java.util.List;


public interface UserService{

	
	public User saveuser(User u1);
	
	public User UpdateUser(User users);
	public String  CancelUser(Integer userId);
	public List<User> ShowAllUser();
}
