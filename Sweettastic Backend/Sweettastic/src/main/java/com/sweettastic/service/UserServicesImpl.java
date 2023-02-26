package com.sweettastic.service;

import java.util.List;
import java.util.Optional;

import com.sweettastic.exceptions.UserException;
import com.sweettastic.models.User;
import com.sweettastic.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServicesImpl implements UserService {

	@Autowired
	private UserRepo userRepo;


	
	@Override
	public User saveuser(User u1) {
		User u2= userRepo.save(u1);
		return u2;
	}

	@Override
	public User UpdateUser(User users) {
		
		 Optional<User> opt= userRepo.findById(users.getUserId());
		 
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
		Optional<User> opt=userRepo.findById(userId);
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
	public List<User> ShowAllUser() {
		List<User> allUser=userRepo.findAll();
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
