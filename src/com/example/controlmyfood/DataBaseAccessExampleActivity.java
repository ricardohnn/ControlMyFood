package com.example.controlmyfood;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;

import com.example.controlmyfood.dao.DBAdapter;
import com.example.controlmyfood.vo.FoodBean;

public class DataBaseAccessExampleActivity extends Activity {

	//Contexto da activity
	private Context context;
	private DBAdapter dbAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		context = this;
		
		dbAdapter = new DBAdapter(context);
		
		//Necessita abrir conexao com o db
		dbAdapter.open();
		
		//Como inserir uma comida no sql parametros: nome da comida, telefone, data de validade, data de insercao, local 
		dbAdapter.insertFood("banana", "12345678", "11/02/2013", "11/02/1999", "despensa");
		
		//Como pegar informacao de uma comida
		FoodBean food = dbAdapter.getFood(1);
		String a = food.getFoodExpirationDate();
		String b = food.getFoodInsertedDate();
		String c = food.getFoodLocation();
		String d = food.getFoodName();
		String e = food.getPhoneNumber();
		
	
		//Como remover uma comida no sql
		//dbAdapter.RemoveFood(3);
		
		//Necessita fechar conexao com o bd
		dbAdapter.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
