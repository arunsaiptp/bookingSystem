package com.hotelBookingSystem.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Hotel_Info")
public class Hotel_Info {
	
	@Id
	@GenericGenerator(name = "Hotel_Info_id_increment", strategy = "increment")
	@GeneratedValue(generator = "Hotel_Info_id_increment")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "stars")
	private String stars;
	
	@Column(name = "wifi")
	private boolean wifi;
	
	@Column(name = "ac")
	private boolean ac;
	
	@Column(name = "restaurant")
    private boolean restaurant;
	
	@Column(name = "meals")
	private boolean meals;
	
	@Column(name = "cost")
	private String cost;
	
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Column(name = "noOfRooms")
	private Integer noOfRooms;

	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Hotel_Info() {
		
	}
	
	public Hotel_Info(String name, String address, String city, String stars, boolean wifi, boolean ac,
			boolean restaurant, boolean meals, String cost, Date date, Integer noOfRooms) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.stars = stars;
		this.wifi = wifi;
		this.ac = ac;
		this.restaurant = restaurant;
		this.meals = meals;
		this.cost = cost;
		this.date = date;
		this.noOfRooms = noOfRooms;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
		this.stars = stars;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	
	public boolean isAc() {
		return ac;
	}


	public void setAc(boolean ac) {
		this.ac = ac;
	}


	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isMeals() {
		return meals;
	}

	public void setMeals(boolean meals) {
		this.meals = meals;
	}

	

	public String getCost() {
		return cost;
	}


	public void setCost(String cost) {
		this.cost = cost;
	}


	public Integer getNoOfRooms() {
		return noOfRooms;
	}


	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	
}
