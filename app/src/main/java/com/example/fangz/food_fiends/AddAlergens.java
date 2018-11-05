package com.example.fangz.food_fiends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddAlergens extends AppCompatActivity {
    private static EditText edAddAlergens;
    private static Button btnOk, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alergens);

        edAddAlergens = (EditText) findViewById(R.id.addAlergens);
        btnOk = (Button) findViewById(R.id.ok);
        btnBack = (Button) findViewById(R.id.back);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alergen = edAddAlergens.getText().toString();
                Toast toast = Toast.makeText(getApplicationContext(), alergen + " added", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 150);
                toast.show();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserInfo.class);
                startActivity(intent);
            }
        });
    }
}
