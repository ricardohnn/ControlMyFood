package com.example.controlmyfood.adapters;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.controlmyfood.R;
import com.example.controlmyfood.vo.FoodBean;

public class GridItemAdapter extends BaseAdapter {

	private Context context;
	private List<FoodBean> foods;
	
	public GridItemAdapter(Context context, List<FoodBean> foods) {
		this.context = context;
		this.foods = foods;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			gridView = inflater.inflate(R.layout.grid_item, null);
 
			ImageView foodImageItem = (ImageView) gridView.findViewById(R.id.foodImageItem);
			foodImageItem.setBackgroundResource(R.drawable.item_milk);
			
			TextView foodNameItem = (TextView) gridView
					.findViewById(R.id.foodNameItem);
			foodNameItem.setText(foods.get(position).getFoodName());

			TextView expirationDateItem = (TextView) gridView
					.findViewById(R.id.expirationDateItem);
			expirationDateItem.setText(foods.get(position).getFoodExpirationDate());

			TextView phoneNumberItem = (TextView) gridView
					.findViewById(R.id.phoneNumberItem);
			phoneNumberItem.setText(foods.get(position).getPhoneNumber());
	
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return foods.size();
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	
}
