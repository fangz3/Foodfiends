package com.example.fangz.food_fiends;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

public class UserTable extends SQLiteOpenHelper {

    private static final String TAG = "UserTable";
    public static final String TABLE_NAME = "users";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";

    public UserTable(Context context) {
        super(context, TABLE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //Add a new row to the database
    public Boolean addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        ContentValues values2 = new ContentValues();
        values.put(COLUMN_USERNAME, user.getUsername());
        values.put(COLUMN_PASSWORD, user.getPassword());

        Log.d(TAG, "addData: Adding " + user.getUsername() + " to " + TABLE_NAME);
        long result = db.insert(TABLE_NAME, null, values);

        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    //Delete a user from the database
    public void deleteUser(String userName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE " + COLUMN_USERNAME + "=\"" + userName + "\";" );
    }

    public void clearDatabase() {
        SQLiteDatabase db = this.getWritableDatabase();
        String clearDBQuery = "DELETE FROM "+ TABLE_NAME;
        db.execSQL(clearDBQuery);
    }

    public String databaseToString() {
        String dbString = "";
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        c.moveToFirst();

        while(!c.isAfterLast()) {
            if(c.getString(c.getColumnIndex("username")) != null) {
                dbString += c.getString(c.getColumnIndex("username"));
                dbString += "\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
