package com.example.fangz.food_fiends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserInfo extends AppCompatActivity {

    private static Button btnaddAlergens, btnsearchAlternatives, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        btnaddAlergens = (Button) findViewById(R.id.addAlergens);
        btnsearchAlternatives = (Button) findViewById(R.id.searchAlternatives);
        btnBack = (Button) findViewById(R.id.back);

        btnaddAlergens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddAlergens.class);
                startActivity(intent);

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnsearchAlternatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), OutputAlternatives.class);
                startActivity(intent);
            }
        });


    }

}
