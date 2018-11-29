package com.example.fangz.food_fiends;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;

public class AllergenTable extends SQLiteOpenHelper {
    private static final String TAG = "UserTable";
    public static final String TABLE_NAME = "allergens";
    public static final String COLUMN_ALLERGEN = "allergen";
    //public Global global;


    public AllergenTable(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ALLERGEN + " TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add a new row to the database
    public void addAllergen(String allergen) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();
        values.put(COLUMN_ALLERGEN, allergen);

        db.insert(TABLE_NAME, null, values);

    }

    //Delete a user from the database
    public void deleteAllergen(String allergen) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_ALLERGEN + "=\"" + allergen + "\";" );
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+ TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

    public ArrayList<String> databaseToList() {
        ArrayList<String> allergenList;
        allergenList = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_ALLERGEN)) != null) {
                allergenList.add(c.getString(c.getColumnIndex(COLUMN_ALLERGEN)));
            }
            c.moveToNext();
        }
        db.close();
        return allergenList;

    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex(COLUMN_ALLERGEN)) != null) {
                dbString += c.getString(c.getColumnIndex(COLUMN_ALLERGEN));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
