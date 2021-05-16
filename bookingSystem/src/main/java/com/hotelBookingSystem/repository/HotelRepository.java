package com.hotelBookingSystem.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.hotelBookingSystem.model.Hotel_Info;

/**
 * @author DevangamS
 *
 */

public interface HotelRepository extends JpaRepository<Hotel_Info, Integer>, CrudRepository<Hotel_Info, Integer>,
		QueryByExampleExecutor<Hotel_Info> {
	Hotel_Info findByCityAndDate(String city, String date);

	List<Hotel_Info> findByCityAndDateOrNoOfRoomsOrStarsOrWifiOrRestaurantOrAcOrMeals(String city, Date date,
			Integer noOfRooms, Integer stars, boolean wifi, boolean restaurant, boolean ac, boolean meals);

	List<Hotel_Info> findByCity(String city);

	List<Hotel_Info> findByCityAndDateOrNoOfRoomsOrWifiOrRestaurantOrAcOrMeals(String city, Date date,
			Integer noOfRooms, boolean wifi, boolean restaurant, boolean ac, boolean meals);

	List<Hotel_Info> findByCityAndDateOrStarsOrWifiOrRestaurantOrAcOrMeals(String city, Date date,
			 Integer stars, boolean wifi, boolean restaurant, boolean ac, boolean meals);

	List<Hotel_Info> findByCityAndDateOrWifiOrRestaurantOrAcOrMeals(String city, Date date,
			 boolean wifi, boolean restaurant, boolean ac, boolean meals);
}
