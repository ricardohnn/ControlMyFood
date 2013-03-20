package com.example.controlmyfood;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	// private Button botaoTeste;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		/*
		 * botaoTeste = (Button) findViewById(R.id.button1);
		 * 
		 * botaoTeste.setOnClickListener(new View.OnClickListener() {
		 * 
		 * @Override public void onClick(View v) {
		 * Toast.makeText(BasicButtonActivity.this, "Button clicked!",
		 * Toast.LENGTH_SHORT).show(); } });
		 */

		Log.d("debug", "Fim");
		Log.d("debug", "tripinhaaa");
		Log.d("debug", "Teste");
	}

	public void Button1Bt1(View v) {
		System.out.println("VAMO VAMO VAMO");
		Toast.makeText(this, "Produto Cadastrado", Toast.LENGTH_SHORT).show();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
