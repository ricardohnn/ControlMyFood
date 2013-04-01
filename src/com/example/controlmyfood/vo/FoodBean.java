package com.example.controlmyfood.vo;

import android.os.Parcel;
import android.os.Parcelable;

public class FoodBean implements Parcelable {

	private Long id;
	private String foodName;
	private String phoneNumber;
	private String foodExpirationDate;
	private String foodInsertedDate;
	private String foodLocation;

	public FoodBean() {
	}

	public FoodBean(Parcel in) {
		readFromParcel(in);
	}

	public FoodBean(long id, String foodName, String phoneNumber,
			String foodExpirationDate, String foodInsertedDate,
			String foodLocation) {
		this.id = id;
		this.foodName = foodName;
		this.phoneNumber = phoneNumber;
		this.foodExpirationDate = foodExpirationDate;
		this.foodInsertedDate = foodInsertedDate;
		this.foodLocation = foodLocation;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	private void readFromParcel(Parcel in) {

		id = in.readLong();
		foodName = in.readString();
		phoneNumber = in.readString();
		foodExpirationDate = in.readString();
		foodInsertedDate = in.readString();
		foodLocation = in.readString();
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeLong(id);
		dest.writeString(foodName);
		dest.writeString(phoneNumber);
		dest.writeString(foodExpirationDate);
		dest.writeString(foodInsertedDate);
		dest.writeString(foodLocation);
	}

	public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
		public FoodBean createFromParcel(Parcel in) {
			return new FoodBean(in);
		}

		public FoodBean[] newArray(int size) {
			return new FoodBean[size];
		}
	};

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
