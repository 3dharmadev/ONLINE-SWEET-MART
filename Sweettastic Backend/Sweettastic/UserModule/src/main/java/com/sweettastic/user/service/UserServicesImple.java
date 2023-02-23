package com.sweettastic.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sweettastic.user.exceptions.UserException;
import com.sweettastic.user.model.user;
import com.sweettastic.user.repository.userRepository;
@Service
public class UserServicesImple implements UserServices{

	@Autowired
	private userRepository userRepo;
	
	@Override
	public user saveuser(user u1) {
		user u2= userRepo.save(u1);
		return u2;
	}

	@Override
	public user UpdateUser(user users) {
		
		 Optional<user> opt= userRepo.findById(users.getUserId());
		 
		 if(opt.isPresent())
		 {
			return userRepo.save(users);
		 }
		 else
		 {
			 throw new UserException("user not exist");
		 }
	}

	@Override
	public String CancelUser(Integer userId) {
		Optional<user> opt=userRepo.findById(userId);
		if(opt.isPresent())
		{
			userRepo.deleteById(userId);
			return "User Deleted";
		}
		else
		{
			throw new UserException("user not Exist");
		}
		
		
	}

	@Override
	public List<user> ShowAllUser() {
		List<user> allUser=userRepo.findAll();
		if(!allUser.isEmpty())
		{
			return allUser;
		}
		else
		{
			throw new UserException("user Not Found");
		}
		
	}

	

}
