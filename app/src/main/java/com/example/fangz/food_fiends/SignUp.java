package com.example.fangz.food_fiends;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {

    public static Button btnSignUp, btnBack, btnDelete;
    public static EditText edUsername, edPassword;
    public static TextView test;

    //UserTable userTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Global global = (Global)getApplicationContext();

        btnSignUp = (Button)findViewById(R.id.signUp);
        btnBack = (Button)findViewById(R.id.back);
        edUsername = (EditText)findViewById(R.id.username2);
        edPassword = (EditText)findViewById(R.id.password2);
        test = (TextView)findViewById(R.id.test);
        btnDelete = (Button)findViewById(R.id.delete);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                User user = new User(username, password);
                global.userTable.addUser(user);
                test.setText(global.userTable.databaseToString());
                edUsername.setText("");
                edPassword.setText("");
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                global.userTable.clearDatabase();
            }
        });
    }




}
