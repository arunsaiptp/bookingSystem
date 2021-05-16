package com.hotelBookingSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBookingSystem.model.Users;
import com.hotelBookingSystem.repository.UserRepository;

/**
 * @author DevangamS
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	/**
	 * @param user
	 * @return
	 */
	@PostMapping
	  public ResponseEntity<Users> createUser(@RequestBody Users user) {
	    try {
	    	Users _user = userRepository
	          .save(user);
	      return new ResponseEntity<>(_user, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	
	
	/**
	 * @param id
	 * @param users
	 * @return
	 */
	@PutMapping("/{id}")
	  public ResponseEntity<Users> updateUser(@PathVariable("id") Integer id, @RequestBody Users users) {
	    Optional<Users> userslData = userRepository.findById(id);
	    if (userslData.isPresent()) {
	    	Users _user = userslData.get();
	    	_user.setFirstName(users.getFirstName());
	    	_user.setMiddleName(users.getMiddleName());
	    	_user.setMiddleName(users.getLastName());
	    	_user.setGender(users.getGender());
	    	_user.setDob(users.getDob());
	    	_user.setEmailId(users.getEmailId());
	    	_user.setPhoneNumber(users.getPhoneNumber());
	    	_user.setAddress(users.getAddress());
	      return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
	    try {
	    	userRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
}
