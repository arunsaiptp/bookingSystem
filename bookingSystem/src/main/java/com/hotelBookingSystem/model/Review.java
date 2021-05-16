package com.hotelBookingSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Review")
public class Review {
	
	@Id
	@GenericGenerator(name = "Review_id_increment", strategy = "increment")
	@GeneratedValue(generator = "Review_id_increment")
	private Integer id;
	
	@Column(name="userId", nullable=false)
	private Integer userId;
	
	@Column(name="hotelId", nullable=false)
	private Integer hotelId;
	
	@Column(name="comments", nullable=false)
	private String comments;

	@Column(name="rating", nullable=false)
	private String rating;
	
	@Column(name = "status", columnDefinition = "bpchar(1)", length = 1)
	private String status;
	
	public Review() {
		
	}

	public Review(Integer userId, Integer hotelId, String comments, String rating) {
		super();
		this.userId = userId;
		this.hotelId = hotelId;
		this.comments = comments;
		this.rating = rating;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
