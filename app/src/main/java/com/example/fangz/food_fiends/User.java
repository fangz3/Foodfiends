package com.example.fangz.food_fiends;

import java.util.ArrayList;

/**
 * Created by fangz on 11/23/2018.
 */

public class User {
    private int id;
    private String username;
    private String password;
    private ArrayList<String> allergens;

    public User(String userName, String passWord) {
        this.username = userName;
        this.password = passWord;
        this.allergens = new ArrayList<String>();
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getAllergens() {
        return allergens;
    }

    public void addAllergens(String allergen) {
        allergens.add(allergen);
    }
}
