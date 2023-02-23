package com.sweettastic.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sweettastic.user.model.user;
import com.sweettastic.user.service.UserServices;

@RestController
public class userContoller {

	@Autowired
	private UserServices userServices;

	@PostMapping("/users")
	public ResponseEntity<user> saveUser(@RequestBody user u1)
	{
		 user u4= userServices.saveuser(u1);
		 
		 return new ResponseEntity<>(u4,HttpStatus.OK);
	}
	@PutMapping("/users")
	public ResponseEntity<user> UpdateUser(@RequestBody user u){
		user updateduser =userServices.UpdateUser(u);
		
		return new ResponseEntity<>(updateduser,HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<String> DeleteUser(@PathVariable("user_id") Integer userId )
	{
		String deletedUser=userServices.CancelUser(userId);
		 
		 return new ResponseEntity<>(deletedUser,HttpStatus.OK);
	}
	@GetMapping("/allusers")
	public ResponseEntity<List<user>> alluser(){
		List<user> allUser=userServices.ShowAllUser();
		return new ResponseEntity<>(allUser,HttpStatus.ACCEPTED);
	}
}
