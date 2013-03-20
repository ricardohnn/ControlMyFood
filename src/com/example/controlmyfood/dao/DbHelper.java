package com.example.controlmyfood.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "foodRegister.db";
	public static final String TABLE_NAME = "food";

	public static String ID = "_id";
	public static String FOODNAME = "foodName";
	public static String PHONENUMBER = "phoneNumber";
	public static String FOODEXPIRATIONDATE = "foodExpirationDate";
	public static String FOODINSERTEDDATE = "foodInsertedDate";
	public static String FOODLOCATION = "foodLocation";

	private static final String DATABASE_CREATE = "create table " + TABLE_NAME
			+ "( " + ID + " integer primary key autoincrement, " + FOODNAME
			+ " text not null, " + PHONENUMBER + " text not null, "
			+ FOODEXPIRATIONDATE + " text not null, " + FOODINSERTEDDATE
			+ " text not null, " + FOODLOCATION + " text not null " + ");";

	public DbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DbHelper.class.getName(), "Upgrading database from version "
				+ oldVersion + "to " + newVersion
				+ ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
	}
}
