package com.example.fangz.food_fiends;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OutputAlternatives extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static Spinner spnAlternatives;
    private TextView tvOutput;
    private String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output_alternatives);

        spnAlternatives = findViewById(R.id.alternatives);
        tvOutput = findViewById(R.id.output);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(OutputAlternatives.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.ingredients));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAlternatives.setAdapter(myAdapter);

        spnAlternatives.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        selected = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(this,selected,Toast.LENGTH_SHORT).show();
        if(selected.equals("Milk")) {
            tvOutput.setText("Almond milk, Soy milk, Coconut milk, Flax milk, Hemp milk, Oat milk, Commercial lactose-free milk");
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
