package com.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.user.model.User;

/**
 * @author sekhar
 *
 */
@Repository
public interface UserRepo extends CrudRepository<User ,Long> {
	
	
	@Modifying
	@Query("UPDATE userDetails u SET u.email =?1 WHERE u.id =?2")
	User update(@Param("email") String email, @Param("id") int id);
	
	@Query("Select u from userDetails u where u.email like ?1%")
	User getByEmail(@Param("email") String email);
  
	

}
