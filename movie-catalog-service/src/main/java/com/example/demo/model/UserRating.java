package com.example.demo.model;

import java.util.List;

public class UserRating {

	List<Rating> userRating;
	private String userId;
	
	public String getUserId() {
		return userId;
	}

	public UserRating() {
		
	}

	public List<Rating> getUserRating() {
		return userRating;
	}

	public void setUserRating(List<Rating> userRating) {
		this.userRating = userRating;
	}

	public void setUserId(String userId) {
		this.userId=userId;
		
	}
}
