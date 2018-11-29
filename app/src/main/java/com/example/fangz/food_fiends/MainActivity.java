package com.example.fangz.food_fiends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static Button btnLogin, btnSignUp;
    public static EditText edUsername, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Global Variable for the database
        Global global = (Global) getApplicationContext();
        global.createAllergenTable();
        global.createUserTable();

        //Edit Text view for login username
        edUsername = findViewById(R.id.username);
        //Edit Text view for login password
        edPassword = findViewById(R.id.password);

        //Login button
        btnLogin = (Button) findViewById(R.id.login);
        //Signup button
        btnSignUp = (Button) findViewById(R.id.signUp);

        //Redirection method for login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserInfo.class);
                if (edUsername.getText().toString().equals("admin") && edPassword.getText().toString().equals("12345")) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Redirection method for signup
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }
}
