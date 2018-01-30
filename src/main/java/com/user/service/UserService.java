package com.user.service;

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
	public User updateuser();
	/**
	 * @return
	 */
	public User delete();
	/**
	 * @return
	 */
	public User find();

}
