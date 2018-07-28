package com.inti.student.honeypottouristguide;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "HoneyPotDatabase.db";
    public static final String TABLE_NAME = "HoneyPotData";
    public static final String COL1 = "ID";
    public static final String COL2 = "NAME";
    public static final String COL3 = "CONVERSION_RATE";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "ITEM1 TEXT ," + "ITEM2 TEXT)";
        db.execSQL(createTable);
        db.execSQL("INSERT INTO " + TABLE_NAME + "(NAME, CONVERSION_RATE) VALUES (USD, 0.25)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP IF TABLE EXISTS " + TABLE_NAME);
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME,null);
        return data;
    }
}
