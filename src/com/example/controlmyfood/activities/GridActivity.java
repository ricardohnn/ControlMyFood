package com.example.controlmyfood.activities;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.controlmyfood.R;
import com.example.controlmyfood.adapters.GridItemAdapter;
import com.example.controlmyfood.controller.FoodController;
import com.example.controlmyfood.vo.FoodBean;

public class GridActivity extends Activity {

	private Context context;
	private GridView gridView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_activity);

		context = this;

		FoodController foodController = new FoodController();
		List<FoodBean> foods = foodController.loadAllFoods(context);
		
		gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(new GridItemAdapter(context, foods));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
			}
		});

	}
}
