package com.example.manydialogoptions;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DropdownMenuActivity extends AppCompatActivity {

    Button bClose;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dropdown_menu);

        bClose=findViewById(R.id.bClose);
        bClose.setOnClickListener(v -> finish());

        String[] items = {"Be\'er Sheva", "Tel Aviv", "Jerusalem", "Haifa", "Rishon Lezion"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, items);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        autoCompleteTextView.setAdapter(adapter);
    }
}
