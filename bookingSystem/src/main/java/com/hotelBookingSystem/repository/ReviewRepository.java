package com.hotelBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelBookingSystem.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
