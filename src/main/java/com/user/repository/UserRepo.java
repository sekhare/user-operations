package com.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.user.model.User;

/**
 * @author sekhar
 *
 */
@Repository
public interface UserRepo extends CrudRepository<User ,Long> {
	
	

}
