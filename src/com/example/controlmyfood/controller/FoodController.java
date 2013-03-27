package com.example.controlmyfood.controller;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.controlmyfood.bo.DBBo;
import com.example.controlmyfood.vo.FoodBean;

public class FoodController {

	public Boolean saveFood(Context context, ArrayList<String> datas) {
		DBBo dbBo = new DBBo(context);
		dbBo.writeFood(toFoodBean(datas));
		return true;
	}

	public Boolean loadFood(Context context, Long foodId) {
		DBBo dbBo = new DBBo(context);
		FoodBean food = dbBo.readFoodById(foodId);
		Log.i("ControlMyFood",
				"Expiration Date: " + food.getFoodExpirationDate()
						+ "\nInsertion Date: " + food.getFoodInsertedDate()
						+ "\nLocation: " + food.getFoodLocation()
						+ "\nFood Name: " + food.getFoodName()
						+ "\nPhone Number: " + food.getPhoneNumber());
		return true;
	}
	
	public List<FoodBean> loadAllFoods(Context context) {
		DBBo dbBo = new DBBo(context);
		List<FoodBean> foods = dbBo.getFoodList();

		return foods;
	}

	public Void removeFood(Context context, Long foodId) {
		DBBo dbBo = new DBBo(context);
		dbBo.removeFood(foodId);
		return null;
	}

	private FoodBean toFoodBean(ArrayList<String> datas) {
		FoodBean food = new FoodBean();

		try {
			food.setFoodName(datas.get(0));
			food.setPhoneNumber(datas.get(1));
			food.setFoodInsertedDate(datas.get(2));
			food.setFoodExpirationDate(datas.get(3));
			food.setFoodLocation(datas.get(4));
		} catch (NullPointerException e) {
			Log.w("ControlMyFood", "Food data not created");
		}
		Log.d("ControlMyFood", "Food data created");
		Log.i("ControlMyFood",
				"Expiration Date: " + food.getFoodExpirationDate()
						+ "\nInsertion Date: " + food.getFoodInsertedDate()
						+ "\nLocation: " + food.getFoodLocation()
						+ "\nFood Name: " + food.getFoodName()
						+ "\nPhone Number: " + food.getPhoneNumber());
		return food;
	}
}
