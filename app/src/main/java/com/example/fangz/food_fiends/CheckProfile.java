package com.example.fangz.food_fiends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CheckProfile extends AppCompatActivity {

    Button btnshowAllergens, btndeleteAllergen, btnBack;
    EditText eddeleteAllergen;
    TextView tshow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_profile);

        final Global global = (Global) getApplicationContext();
        global.createAllergenList();


        btnshowAllergens = (Button)findViewById(R.id.showAllergens);
        btndeleteAllergen = (Button)findViewById(R.id.delete);
        eddeleteAllergen = (EditText)findViewById(R.id.deleteAllergen);
        btnBack = (Button)findViewById(R.id.back);

        tshow = (TextView)findViewById(R.id.show);

        btnshowAllergens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tshow.setText(global.allergenTable.databaseToString());
                String s = "";
                for (int i=0;i<global.allergenList.size();i++) {
                    s += global.allergenList.get(i);
                    s += " ";
                }
                tshow.setText(s);
            }
        });

        btndeleteAllergen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String allergen = eddeleteAllergen.getText().toString();
                global.allergenTable.deleteAllergen(allergen);
                global.createAllergenList();
                String s = "";
                for (int i=0;i<global.allergenList.size();i++) {
                    s += global.allergenList.get(i);
                }
                tshow.setText(s);
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
