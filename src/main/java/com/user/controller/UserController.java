package com.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.repository.UserRepo;
import com.user.service.UserService;

/**
 * @author sekhar
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	UserService userService;
	
	
 /**
 * @param userData
 * @return
 */
@RequestMapping(value="/adduser",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
   public User addUser(@RequestBody  User userData)
   {

	if(null!=userData){
		User result=userService.createUser(userData);
		
	   
		return result;
	}
	else 
	{
     return null;
	}
	
   }
	
}
	
	
	
