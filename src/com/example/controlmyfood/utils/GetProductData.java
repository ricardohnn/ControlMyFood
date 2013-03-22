package com.example.controlmyfood.utils;

import java.util.ArrayList;

import com.example.controlmyfood.vo.FoodBean;

import android.widget.EditText;

public class GetProductData {

	public void SetFoodBean(ArrayList<EditText> datas) {
		FoodBean foodbean = new FoodBean();
		ArrayList<String> tofoodbeansdatas = new ArrayList<String>();
		for (int i = 0; i<datas.size(); i++) {
			tofoodbeansdatas.add(datas.get(i).getText().toString());
			System.out.println(tofoodbeansdatas.get(i));
		}
		foodbean.setFoodName(tofoodbeansdatas.get(0));
		foodbean.setPhoneNumber(tofoodbeansdatas.get(1));
		foodbean.setFoodInsertedDate(tofoodbeansdatas.get(2));
		foodbean.setFoodExpirationDate(tofoodbeansdatas.get(3));
		foodbean.setFoodLocation(tofoodbeansdatas.get(4));
	}
}

