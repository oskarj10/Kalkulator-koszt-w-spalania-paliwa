package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView textViewTotalCost, textViewCostPerPerson, textViewCostPer100km;
    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCost = findViewById(R.id.total_cost);
        textViewCostPerPerson = findViewById(R.id.cost_per_person);
        textViewCostPer100km = findViewById(R.id.cost_per_100km);
        buttonBack = findViewById(R.id.btn_back);


        Intent intent = getIntent();
        double totalCost = intent.getDoubleExtra("totalCost", 0);
        double costPerPerson = intent.getDoubleExtra("costPerPerson", 0);
        double costPer100km = intent.getDoubleExtra("costPer100km", 0);


        String totalCostStr = String.format("%.2f", totalCost);
        String costPerPersonStr = String.format("%.2f", costPerPerson);
        String costPer100kmStr = String.format("%.2f", costPer100km);


        textViewTotalCost.setText(totalCostStr + " zł");
        textViewCostPerPerson.setText(costPerPersonStr + " zł");
        textViewCostPer100km.setText(costPer100kmStr + " zł");


        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
}
