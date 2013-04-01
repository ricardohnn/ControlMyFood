package com.example.controlmyfood.bo;

import java.util.List;

import android.content.Context;
import android.util.Log;

import com.example.controlmyfood.dao.DBAdapter;
import com.example.controlmyfood.vo.FoodBean;

public class DBBo {

	private final String TAG = "ControlMyFood";
	private DBAdapter dbAdapter;
	private FoodBean food;

	public DBBo(Context context) {
		dbAdapter = new DBAdapter(context);
	}

	public Boolean writeFood(FoodBean food) {
		Boolean result = false;

		Log.d(TAG, "Reading values to write in SQLite");

		dbAdapter.open();

		if (dbAdapter.insertOrUpdateFood(food.getFoodName(),
				food.getPhoneNumber(), food.getFoodExpirationDate(),
				food.getFoodInsertedDate(), food.getFoodLocation()) != null) {
			result = true;
			Log.d(TAG, "Food written in SQLite with success");
		} else {
			Log.w(TAG, "Problem when writting food in SQLite");
		}

		dbAdapter.close();

		return result;
	}

	public FoodBean readFoodById(Long foodId) {
		Log.d(TAG, "Reading food information");

		dbAdapter.open();
		food = dbAdapter.getFoodById(foodId);
		dbAdapter.close();

		return food;
	}

	public Void removeFood(Long foodId) {
		Log.d(TAG, "Removing food information");

		dbAdapter.open();
		dbAdapter.RemoveFood(foodId);
		dbAdapter.close();

		return null;
	}

	public List<FoodBean> getFoodList(String foodLocal) {
		Log.d(TAG, "Getting all foods information");

		List<FoodBean> foodBeanList = null;
		dbAdapter.open();
		foodBeanList = dbAdapter.getFoods(foodLocal);
		dbAdapter.close();

		return foodBeanList;
	}
}
