package com.hotelBookingSystem.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelBookingSystem.model.Hotel_Info;
import com.hotelBookingSystem.repository.HotelRepository;
import com.hotelBookingSystem.util.DateUtil;

/**
 * @author DevangamS
 *
 */
@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	HotelRepository hotelRepository;

	/**
	 * @param hotelInfo
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Hotel_Info> createHotel(@RequestBody Hotel_Info hotelInfo) {
		try {
			Hotel_Info hotel_Info = hotelRepository.save(hotelInfo);
			return new ResponseEntity<>(hotel_Info, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param id
	 * @param hotelInfo
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Hotel_Info> updateHotel(@PathVariable("id") Integer id, @RequestBody Hotel_Info hotelInfo) {
		Optional<Hotel_Info> hotelInfoData = hotelRepository.findById(id);
		if (hotelInfoData.isPresent()) {
			Hotel_Info hotel_Info = hotelInfoData.get();
			hotel_Info.setName(hotelInfo.getName());
			hotel_Info.setAddress(hotelInfo.getAddress());
			hotel_Info.setCity(hotelInfo.getCity());
			hotel_Info.setCost(hotelInfo.getCost());
			hotel_Info.setStars(hotelInfo.getStars());
			hotel_Info.setAc(hotelInfo.isAc());
			hotel_Info.setWifi(hotelInfo.isWifi());
			hotel_Info.setMeals(hotelInfo.isMeals());
			hotel_Info.setRestaurant(hotelInfo.isRestaurant());
			hotel_Info.setDate(hotelInfo.getDate());
			hotel_Info.setNoOfRooms(hotelInfo.getNoOfRooms());
			return new ResponseEntity<>(hotelRepository.save(hotel_Info), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteHotel(@PathVariable("id") Integer id) {
		try {
			hotelRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * @param city
	 * @param date
	 * @param numberOfRooms
	 * @param stars
	 * @param wifi
	 * @param restaurant
	 * @param ac
	 * @param meals
	 * @return
	 */
	@GetMapping("/{city}/{date}")
	public List<Hotel_Info> getHotelInfo(@PathVariable("city") String city, @PathVariable("date") String date,
			@RequestParam("number-of-rooms") String noOfRooms, @RequestParam("stars") String stars,
			@RequestParam("wifi") boolean wifi, @RequestParam("restaurant") boolean restaurant,
			@RequestParam("ac") boolean ac, @RequestParam("meals") boolean meals) {
		List<Hotel_Info> data = null;
		Timestamp timestamp = null;
		try {
			if (!date.isEmpty()) {
				timestamp = DateUtil.getInstance().convertStringToTimestamp(date);
			}
			if(!noOfRooms.isEmpty() && !stars.isEmpty()) {
				data = hotelRepository
						.findByCityAndDateOrNoOfRoomsOrStarsOrWifiOrRestaurantOrAcOrMeals(city, timestamp, Integer.parseInt(noOfRooms), Integer.parseInt(stars),
								wifi, restaurant, ac, meals);
			}else {
				if(!noOfRooms.isEmpty() && stars.isEmpty()) {
					data = hotelRepository
							.findByCityAndDateOrNoOfRoomsOrWifiOrRestaurantOrAcOrMeals(city, timestamp, Integer.parseInt(noOfRooms),
									wifi, restaurant, ac, meals);
				}else if(noOfRooms.isEmpty() && !stars.isEmpty()){
					data = hotelRepository
							.findByCityAndDateOrStarsOrWifiOrRestaurantOrAcOrMeals(city, timestamp,Integer.parseInt(stars),
									wifi, restaurant, ac, meals);
				}else {
					data = hotelRepository
							.findByCityAndDateOrWifiOrRestaurantOrAcOrMeals(city, timestamp,
									wifi, restaurant, ac, meals);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
