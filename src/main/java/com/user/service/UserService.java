package com.user.service;

import java.util.List;

import com.user.model.User;

/**
 * @author sekhar
 *
 */
public interface UserService {
	
	
	/**
	 * @return
	 */
	public User createUser(User user);
	
	/**
	 * @return
	 */
	public User updateuser(String email,int id);
	/**
	 * @return
	 */
	public void delete(User user);
	/**
	 * @return
	 */
	public User find(String email);
	
	public Iterable<User> findAll();
	
	
	
	

}
