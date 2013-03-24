package com.example.controlmyfood.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.controlmyfood.vo.FoodBean;

public class DBAdapter {

	private SQLiteDatabase database;
	private DBHelper dbHelper;
	private String[] allColumns = { DBHelper.ID, DBHelper.FOODNAME,
			DBHelper.PHONENUMBER, DBHelper.FOODEXPIRATIONDATE,
			DBHelper.FOODINSERTEDDATE, DBHelper.FOODLOCATION };

	public DBAdapter(Context context) {
		dbHelper = new DBHelper(context);
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}
	
	public FoodBean insertFood(String foodName, String phoneNumber,
			String foodExpirationDate, String foodInsertedDate,
			String foodLocation) {

		ContentValues values = new ContentValues();
		values.put(dbHelper.FOODNAME, foodName);
		values.put(dbHelper.PHONENUMBER, phoneNumber);
		values.put(dbHelper.FOODEXPIRATIONDATE, foodExpirationDate);
		values.put(dbHelper.FOODINSERTEDDATE, foodInsertedDate);
		values.put(dbHelper.FOODLOCATION, foodLocation);

		long insertId = database.insert(dbHelper.TABLE_NAME, null, values);

		// To show how to query
		Cursor cursor = database.query(dbHelper.TABLE_NAME, allColumns,
				dbHelper.ID + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();
		return cursorToFood(cursor);
	}

	public FoodBean insertOrUpdateFood(String foodName,
			String phoneNumber, String foodExpirationDate, String foodInsertedDate,
			String foodLocation) {

		Cursor cursor = database.query(dbHelper.TABLE_NAME, allColumns,
				dbHelper.FOODNAME + " = '" + foodName + "' and " + dbHelper.PHONENUMBER + " = '" + phoneNumber + "' and " + dbHelper.FOODEXPIRATIONDATE + " = '" + foodExpirationDate + "' and " + dbHelper.FOODINSERTEDDATE + " = '" + foodInsertedDate + "' and " + dbHelper.FOODLOCATION + " = '" + foodLocation + "'", null, null, null, null);
		
		if (cursor.getCount() <= 0) {
			return insertFood(foodName, phoneNumber, foodExpirationDate, foodInsertedDate, foodLocation);
		} else {

			ContentValues values = new ContentValues();
			values.put(dbHelper.FOODNAME, foodName);
			values.put(dbHelper.PHONENUMBER, phoneNumber);
			values.put(dbHelper.FOODEXPIRATIONDATE, foodExpirationDate);
			values.put(dbHelper.FOODINSERTEDDATE, foodInsertedDate);
			values.put(dbHelper.FOODLOCATION, foodLocation);
			
			long updateId = database.update(dbHelper.TABLE_NAME, values, dbHelper.FOODNAME + " = '" + foodName + "' and " + dbHelper.PHONENUMBER + " = '" + phoneNumber + "' and " + dbHelper.FOODEXPIRATIONDATE + " = '" + foodExpirationDate + "' and " + dbHelper.FOODINSERTEDDATE + " = '" + foodInsertedDate + "' and " + dbHelper.FOODLOCATION + " = '" + foodLocation + "'",null);

			cursor = database.query(dbHelper.TABLE_NAME, allColumns,
					dbHelper.ID + " = " + updateId, null, null, null, null);
			cursor.moveToFirst();
			return cursorToFood(cursor);
		}
	}
	
	private FoodBean cursorToFood(Cursor cursor) {
		FoodBean food = new FoodBean(cursor.getLong(0), cursor.getString(1),
				cursor.getString(2), cursor.getString(3), cursor.getString(4),
				cursor.getString(5));
		return food;
	}

	public void RemoveFood(int idFood) {
		database.delete(dbHelper.TABLE_NAME, dbHelper.ID + " = " + idFood, null);
	}

	public List<FoodBean> getFoods() {
		Cursor cursor = database
				.rawQuery(
						"select _id,foodName,phoneNumber,foodExpirationDate,foodInsertedDate,foodLocation from food",
						null);

		List<FoodBean> foodBeanList = new ArrayList<FoodBean>();
		
		cursor.moveToFirst();
		while (cursor.isAfterLast() == false) 
		{
			foodBeanList.add(cursorToFood(cursor));
		    cursor.moveToNext();
		}
		
		return foodBeanList;
	}
	
	public FoodBean getFood(int idFood) {
		Cursor cursor = database.query(dbHelper.TABLE_NAME, allColumns,
				dbHelper.ID + " = " + idFood, null, null, null, null);
		cursor.moveToFirst();
		return cursorToFood(cursor);
	}
	
}
