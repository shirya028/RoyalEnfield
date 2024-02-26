package com.example.royalenfield;

import android.app.DatePickerDialog;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.Toast;

public class testride extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
String s1[]={"Continental gt350","classic 550","Scram"};
String week[]={"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
ArrayAdapter<String> arr;
Spinner sp;
Button b1,b2;
CheckBox c1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testride);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        arr=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,s1);
        sp=findViewById(R.id.spinner1);
        b1=findViewById(R.id.date);
        b2=findViewById(R.id.sbt);
        c1=findViewById(R.id.checkbox1);
        sp.setAdapter(arr);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              if(c1.isChecked())
                                              {
                                                  b2.setVisibility(View.VISIBLE);
                                              }
                                              else
                                              {
                                                  b2.setVisibility(View.INVISIBLE);
                                              }

                                          }
                                      }
        );


    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void open_date(View view)
    {
        DatePickerDialog dp=new DatePickerDialog(this );
        dp.setOnDateSetListener(this);
        dp.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2)
    {
        int y=i;
        String m=week[i1];
        int d=i2;
        b1.setText(d+"/"+m+"/"+y);

    }
    public void submit(View view)
    {
        Toast.makeText(this, "btn pressed", Toast.LENGTH_SHORT).show();
    }
}