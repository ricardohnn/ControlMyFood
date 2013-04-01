package com.example.controlmyfood.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.controlmyfood.R;
import com.example.controlmyfood.controller.FoodController;
import com.example.controlmyfood.vo.FoodBean;

public class InsertFoodActivity extends Activity {

	// private Button botaoTeste;
	private EditText nameField;
	private EditText phoneField;
	private EditText insertedDataField;
	private EditText expirationDataField;
	private EditText locationField;
	private Context context;
	private Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert_activity);
		bundle = getIntent().getExtras();
		context = this;

		nameField = (EditText) findViewById(R.id.nameField);
		phoneField = (EditText) findViewById(R.id.phoneField);
		insertedDataField = (EditText) findViewById(R.id.insertedDateField);
		expirationDataField = (EditText) findViewById(R.id.expirationDateField);
		locationField = (EditText) findViewById(R.id.locationField);

		if (bundle != null) {
			FoodBean foodBean = bundle.getParcelable("showFood");
			nameField.setText(foodBean.getFoodName());
			phoneField.setText(foodBean.getPhoneNumber());
			insertedDataField.setText(foodBean.getFoodInsertedDate());
			expirationDataField.setText(foodBean.getFoodExpirationDate());
			locationField.setText(foodBean.getFoodLocation());
		}

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	public void onSubmitButtonClick(View v) {
		FoodController foodController = new FoodController();
		ArrayList<String> datas = new ArrayList<String>();
		datas.add(nameField.getText().toString());
		datas.add(phoneField.getText().toString());
		datas.add(insertedDataField.getText().toString());
		datas.add(expirationDataField.getText().toString());
		datas.add(locationField.getText().toString());
		foodController.saveFood(context, datas);

		// TODO JUST FOR TESTING
		Log.d("ControlMyFood", "Sending Broadcast");
		Intent data = new Intent("fragmentupdater");
		this.sendBroadcast(data);

		this.finish();
	}

	// Exemplo
	public void onRemoveButtonClick(View v) {
		bundle = getIntent().getExtras();
		if (bundle != null) {
			FoodBean foodBean = bundle.getParcelable("showFood");
			FoodController foodController = new FoodController();
			foodController.removeFood(context, foodBean.getId());
			Intent data = new Intent("fragmentupdater");
			this.sendBroadcast(data);

			this.finish();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
