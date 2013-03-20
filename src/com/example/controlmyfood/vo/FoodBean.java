package com.example.controlmyfood.vo;

public class FoodBean {

	private Long id;
	private String foodName;
	private String phoneNumber;
	private String foodExpirationDate;
	private String foodInsertedDate;
	private String foodLocation;

	public FoodBean(long id, String foodName, String phoneNumber, String foodExpirationDate,
			String foodInsertedDate, String foodLocation) {
		this.id = id;
		this.foodName = foodName;
		this.phoneNumber = phoneNumber;
		this.foodExpirationDate = foodExpirationDate;
		this.foodInsertedDate = foodInsertedDate;
		this.foodLocation = foodLocation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFoodExpirationDate() {
		return foodExpirationDate;
	}

	public void setFoodExpirationDate(String foodExpirationDate) {
		this.foodExpirationDate = foodExpirationDate;
	}

	public String getFoodInsertedDate() {
		return foodInsertedDate;
	}

	public void setFoodInsertedDate(String foodInsertedDate) {
		this.foodInsertedDate = foodInsertedDate;
	}

	public String getFoodLocation() {
		return foodLocation;
	}

	public void setFoodLocation(String foodLocation) {
		this.foodLocation = foodLocation;
	}

}
