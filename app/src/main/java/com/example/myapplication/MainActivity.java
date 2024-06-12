package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonResult;
    EditText editTextN1, editTextN2, editTextN3, editTextN4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonResult = findViewById(R.id.btn_result);

        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        editTextN3 = findViewById(R.id.number3);
        editTextN4 = findViewById(R.id.number4);


        buttonResult.setOnClickListener(this);


        editTextN1.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextN2.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextN3.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        editTextN4.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    }

    public double getDoubleFromEditText(EditText editText) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(this, "Wpisz liczbę", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Double.parseDouble(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        double num1 = getDoubleFromEditText(editTextN1);
        double num2 = getDoubleFromEditText(editTextN2);
        double num3 = getDoubleFromEditText(editTextN3);
        double num4 = getDoubleFromEditText(editTextN4);

        if (view.getId() == R.id.btn_result) {

            double totalCost = (num1 / 100) * num2 * num3;

            double costPerPerson = totalCost / num4;

            double costPer100km = (num2 * num3);


            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("totalCost", totalCost);
            intent.putExtra("costPerPerson", costPerPerson);
            intent.putExtra("costPer100km", costPer100km);


            startActivity(intent);
        }
    }
}


