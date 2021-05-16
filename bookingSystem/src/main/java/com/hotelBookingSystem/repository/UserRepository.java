package com.hotelBookingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelBookingSystem.model.Users;


public interface UserRepository extends JpaRepository<Users, Integer>  {

}
