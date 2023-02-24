package com.sweettastic.user.service;

import java.util.List;

import com.sweettastic.user.model.User;

public interface UserServices {

	
	public User saveuser(User u1);
	
	public User UpdateUser(User users);
	public String  CancelUser(Integer userId);
	public List<User> ShowAllUser();
}
