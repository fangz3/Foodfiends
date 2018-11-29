package com.example.fangz.food_fiends;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by fangz on 11/26/2018.
 */

public class Global extends Application {
    public UserTable userTable;
    public AllergenTable allergenTable;
    public ArrayList<String> allergenList;

    public void createUserTable() {
        userTable = new UserTable(this);
    }

    public void createAllergenTable() {
        allergenTable = new AllergenTable(this);
    }

    public void createAllergenList() {
        allergenList = new ArrayList<String>();
        allergenList = (ArrayList) allergenTable.databaseToList().clone();
    }

    public void printUserTable() {

    }
}
