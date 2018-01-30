package com.user.service;

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
	public User updateuser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User find() {
		// TODO Auto-generated method stub
		return null;
	}

}
