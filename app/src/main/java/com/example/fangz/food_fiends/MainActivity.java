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

        edUsername = findViewById(R.id.username);
        edPassword = findViewById(R.id.password);

        btnLogin = (Button) findViewById(R.id.login);
        btnSignUp = (Button) findViewById(R.id.signUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserInfo.class);
                if (edUsername.getText().toString().equals("admin") && edPassword.getText().toString().equals("12345")) {
                    //Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SignUp.class);
                startActivity(intent);
            }
        });
    }
}
