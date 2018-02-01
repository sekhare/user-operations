package com.user.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.StringUtils;

import com.user.model.Login;
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
	final static Logger logger = Logger.getLogger(UserController.class);

	/**
	 * @param userData
	 * @return
	 */
	@RequestMapping(value = "/adduser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> addUser(@RequestBody User userData) {

		userService.createUser(userData);
		logger.debug("Added:: User " + userData);
		return new ResponseEntity<User>(userData, HttpStatus.CREATED);

	}

	/**
	 * @param email
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/update/{email}", method = RequestMethod.PATCH)
	public ResponseEntity<Void> updateUser(@RequestBody User user,
			@PathVariable("email") String email)

	{
		User oldUser = userService.find(email);

		if (oldUser == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.createUser(user);
			return new ResponseEntity<Void>(HttpStatus.OK);

		}

	}

	@RequestMapping(value = "/getuser/{email}", method = RequestMethod.GET)
	public ResponseEntity<User> getUsermail(@PathVariable("email") String email) {
		User result = userService.find(email);
		if (result == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<User>(HttpStatus.OK);

		}
	}

	@RequestMapping(value = "/finaAll", method = RequestMethod.GET)
	public Iterable<User> getAll() {

		return userService.findAll();
	}

	@RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("email") String email) {

		User user = userService.find(email);
		if (user == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(user);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> userLogin(@RequestBody Login loginUser)

	{

		String email = loginUser.getEmail();
		String password = loginUser.getPassword();
		User user = userService.find(email);
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {

			String actualPassword = user.getPassword();
			if (password.equals(actualPassword)) {
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sdf.format(date);
				user.setLastLoginDate(date);
				userService.createUser(user);
				return new ResponseEntity<User>(HttpStatus.OK);

			}
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);

		}

	}

}
