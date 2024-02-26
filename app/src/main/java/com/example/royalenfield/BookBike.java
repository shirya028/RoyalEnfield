package com.example.royalenfield;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BookBike extends AppCompatActivity {

    Spinner model;
    String models[]={"Scram411","Classic 350","Meteor","Himalayan","Intercepter","Continental GT","Bullet"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_bike);
        model=findViewById(R.id.model);

        Spinner spinner1=findViewById(R.id.model);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this, R.array.bikes, android.R.layout.simple_spinner_item);

        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);
    }
}