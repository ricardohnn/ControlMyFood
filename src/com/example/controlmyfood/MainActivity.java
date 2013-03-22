package com.example.controlmyfood;

import java.util.ArrayList;

import com.example.controlmyfood.utils.GetProductData;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	// private Button botaoTeste;
	private EditText nameField;
	private EditText phoneField;
	private EditText insertaeddataField;
	private EditText expirationdataField;
	private EditText locationField;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nameField = (EditText) findViewById(R.id.NameField);
		phoneField = (EditText) findViewById(R.id.PhoneField);
		insertaeddataField = (EditText) findViewById(R.id.InsertedDateField);
		expirationdataField = (EditText) findViewById(R.id.ExpirationDateField);
		locationField = (EditText) findViewById(R.id.LocationField);

		Log.d("debug", "Fim");
		Log.d("debug", "tripinhaaa");
		Log.d("debug", "Teste");
	}

	public void Button1Bt1(View v) {
		GetProductData getProductData = new GetProductData();
		ArrayList<EditText> datas = new ArrayList<EditText>();
		datas.add(nameField);
		datas.add(phoneField);
		datas.add(insertaeddataField);
		datas.add(expirationdataField);
		datas.add(locationField);
		getProductData.SetFoodBean(datas);
		Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
