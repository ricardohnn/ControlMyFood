package com.example.controlmyfood.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.example.controlmyfood.R;
import com.example.controlmyfood.adapters.MainFragmentAdapter;

public class MainActivity extends FragmentActivity {
	private MainFragmentAdapter mAdapter;
	private ViewPager mPager;
	private Context context;
	private Button addFood;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		context = this;
		mAdapter = new MainFragmentAdapter(getSupportFragmentManager());

		mPager = (ViewPager) findViewById(R.id.pager);
		mPager.setAdapter(mAdapter);
		mPager.setCurrentItem(1);
		addFood = (Button) findViewById(R.id.header_add_food);

		addFood.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(context,InsertFoodActivity.class);
				startActivity(intent);
			}
		});
	}

}
