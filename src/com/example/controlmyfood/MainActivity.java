package com.example.controlmyfood;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import com.example.controlmyfood.controller.FoodController;

public class MainActivity extends Activity {

	// private Button botaoTeste;
	private EditText nameField;
	private EditText phoneField;
	private EditText insertedDataField;
	private EditText expirationDataField;
	private EditText locationField;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		
		nameField = (EditText) findViewById(R.id.nameField);
		phoneField = (EditText) findViewById(R.id.phoneField);
		insertedDataField = (EditText) findViewById(R.id.insertedDateField);
		expirationDataField = (EditText) findViewById(R.id.expirationDateField);
		locationField = (EditText) findViewById(R.id.locationField);

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
		// Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();
	}
	
	//Exemplo
	public void onGetButtonClick(View v) {
		FoodController foodController = new FoodController();
		foodController.loadFood(context, (long) 1);
		// Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();
	}

	//Exemplo
	public void onRemoveButtonClick(View v) {
		FoodController foodController = new FoodController();
		foodController.removeFood(context, (long) 1);
		// Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
