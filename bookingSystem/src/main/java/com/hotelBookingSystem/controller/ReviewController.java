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

import com.hotelBookingSystem.model.Review;
import com.hotelBookingSystem.repository.ReviewRepository;

/**
 * @author DevangamS
 *
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
	@Autowired
	ReviewRepository reviewRepository;
	
	@PostMapping
	  public ResponseEntity<Review> createReview(@RequestBody Review review) {
	    try {
	    	Review _review = reviewRepository
	          .save(review);
	      return new ResponseEntity<>(_review, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	
	  @PutMapping("/{id}")
	  public ResponseEntity<Review> updateReview(@PathVariable("id") Integer id, @RequestBody Review review) {
	    Optional<Review> reviewData = reviewRepository.findById(id);
	    if (reviewData.isPresent()) {
	    	Review _review = reviewData.get();
	    	_review.setUserId(review.getUserId());
	    	_review.setHotelId(review.getHotelId());
	    	_review.setComments(review.getComments());
	    	_review.setRating(review.getRating());
	      return new ResponseEntity<>(reviewRepository.save(_review), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	
	
	@DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteHotel(@PathVariable("id") Integer id) {
	    try {
	    	reviewRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

}
