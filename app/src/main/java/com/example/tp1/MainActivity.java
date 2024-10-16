package com.example.tp1;

import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAmount;
    private RadioButton radioDinarToEuro;
    private RadioButton radioEuroToDinar;
    private TextView textViewResult;

    // Exchange rates (example values, adjust as needed)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the views
        editTextAmount = findViewById(R.id.editTextAmount);
        radioDinarToEuro = findViewById(R.id.radioDinarToEuro);
        radioEuroToDinar = findViewById(R.id.radioEuroToDinar);
        textViewResult = findViewById(R.id.textViewResult);
        Button buttonConvert = findViewById(R.id.buttonConvert);

        // Set a click listener for the button
        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertCurrency();
            }
        });
    }

    private void convertCurrency() {
        String amountText = editTextAmount.getText().toString();

        if (!amountText.isEmpty()) {
            double amount = Double.parseDouble(amountText);
            double result;

            if (radioDinarToEuro.isChecked()) {
                // Convert Dinar to Euro
                result = amount /3.4;
                textViewResult.setText(String.format("Résultat: %.2f €", result));
            } else if (radioEuroToDinar.isChecked()) {
                // Convert Euro to Dinar
                result = amount * 3.4;
                textViewResult.setText(String.format("Résultat: %.2f Dinar", result));
            } else {
                textViewResult.setText("Veuillez choisir une option de conversion");
            }
        } else {
            textViewResult.setText("Veuillez entrer un montant");
        }
    }
}