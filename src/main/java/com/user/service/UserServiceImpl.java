package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.model.User;
import com.user.repository.UserRepo;

/**
 * @author sekhar
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepo userRepo;

	@Override
	public User createUser(User user) {
		User user1=userRepo.save(user);
		return user1;
	}

	@Override
	public User updateuser(String email,int id) {

		User result=userRepo.update(email, id);
		
		return null;
	}

	@Override
	public User find(String email) {
		
		
		User result=userRepo.getByEmail(email);
		return result;
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);
		
		
	}

	@Override
	public Iterable<User> findAll() {
		
		return  userRepo.findAll();
	}


}
