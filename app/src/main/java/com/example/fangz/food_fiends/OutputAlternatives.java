package com.example.fangz.food_fiends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OutputAlternatives extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Spinner spnAlternatives;
    private TextView tvOutput;
    private String selected;
    public HashMap<String,ArrayList<String>> alternative;
    public Global global;
    private Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_alternatives);

        //Global variable for the database
        global = (Global)getApplicationContext();
        global.createAllergenList();

        //Map for storing alternatives
        alternative = new HashMap<String, ArrayList<String>>();
        createAlternativeList();

        btnback = (Button)findViewById(R.id.back);

        spnAlternatives = findViewById(R.id.alternatives);
        tvOutput = findViewById(R.id.output);

        //ArrayAdapter for outputing alternatives
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(OutputAlternatives.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ingredients));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAlternatives.setAdapter(myAdapter);

        spnAlternatives.setOnItemSelectedListener(this);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), UserInfo.class);
                startActivity(intent);
            }
        });

    }

    public void createAlternativeList() {
        ArrayList<String> milk = new ArrayList<String>();
        milk.add("Almond milk");
        milk.add("Soy milk");
        alternative.put("milk",milk);

    }

    public String filter(String ingredient) {
        String result = " ";
        ArrayList<String> alt = new ArrayList<String>();
        alt = (ArrayList) alternative.get(ingredient).clone();
        for(int i=0; i<alt.size(); i++) {
            if (!global.allergenList.contains(alt.get(i)))
                result += alt.get(i);
                result += " ";
        }
        return result;
    }

    public String alternativeToString(ArrayList<String> alternatives) {
        String altString = "";
        for(int i=0; i<alternatives.size(); i++) {
            altString += altString + alternatives.get(i);
            altString += " ";
        }

        return altString;
    }

    //Method for showing replacements using the ArrayAdapter
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selected = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,selected,Toast.LENGTH_SHORT).show();
        if(selected.equals("Milk")) {
            tvOutput.setText(filter("milk"));
        }
        else if(selected.equals("Butter")) {
            tvOutput.setText("Coconut oil, Olive oil, Water, Commercial vegan butter");
        }
        else if(selected.equals("Egg")) {
            tvOutput.setText("Flax egg, Chia egg, Ripe banana, Applesauce, Aquafaba, Commercial egg replacement");
        }
        else if(selected.equals("Cream")) {
            tvOutput.setText("Coconut cream");
        }
        else if(selected.equals("Cheese")) {
            tvOutput.setText("Nutritional yeast, Commercial vegan cheese");
        }
        else if(selected.equals("Cream cheese/Sour Cream")) {
            tvOutput.setText("Commercial option");
        }
        else if(selected.equals("Flour, Milk, Chocolate")) {
            tvOutput.setText("Flour, Soymilk, Chocolate");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
