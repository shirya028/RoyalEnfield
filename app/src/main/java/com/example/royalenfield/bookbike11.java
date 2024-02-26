package com.example.royalenfield;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class bookbike11 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner model,bike_color;
    String models[]={"Scram411","Classic 350","Meteor","Himalayan","Intercepter","Continental GT","Bullet"};
    int imgs[]={R.drawable.scram_img,R.drawable.classic_img,R.drawable.meteor_img,R.drawable.himalayan,R.drawable.interceptor_img,R.drawable.continental,R.drawable.bullet_img};
    ImageView iv;
    EditText nm,ph;
    String bike_selected;
    Context c1;
    book_bike_database db;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        db=new book_bike_database(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookbike11);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        iv=findViewById(R.id.bike_color_img);
        model=findViewById(R.id.model);
        nm=findViewById(R.id.full_nm);
        ph=findViewById(R.id.mob);
        model.setOnItemSelectedListener(this);
        bike_color=findViewById(R.id.bike_color);
        item_adapter ad=new item_adapter(this,models,imgs);
        bike_color.setOnItemSelectedListener(this);
        model.setAdapter(ad);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String bike=models[i];
        if(bike.equals("Scram411"))
        {
            bike_selected="Scram411";
            String[] colors={"Graphite Blue","Graphite Red","Graphite Yellow","Blazing black","Skyline Blue","White Flame","Silver Sprit"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);

            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Graphite Blue"))
                    {
                        iv.setImageResource(R.drawable.graphite_blue);
                    }
                    if(s.equals("Graphite Red"))
                    {
                        iv.setImageResource(R.drawable.graphite_red);
                    }
                    if(s.equals("Graphite Yellow"))
                    {
                        iv.setImageResource(R.drawable.graphite_yellow);
                    }
                    if(s.equals("Blazing black"))
                    {
                        iv.setImageResource(R.drawable.blazing_black);
                    }
                    if(s.equals("Skyline Blue"))
                    {
                        iv.setImageResource(R.drawable.sykline_blue);
                    }
                    if(s.equals("White Flame"))
                    {
                        iv.setImageResource(R.drawable.white_flame);
                    }
                    if(s.equals("Silver Sprit"))
                    {
                        iv.setImageResource(R.drawable.silver_spirit);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        if(bike.equals("Classic 350"))
        {
            bike_selected="Classic 350";
            String[] colors={"Redditch Red","Halycon Black","Halycon Green","Halycon Grey","Chrome Red","Chrome Bronze","Gunmetal Grey","Dark Stealth Black"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Redditch Red"))
                    {
                        iv.setImageResource(R.drawable.redditch_red);
                    }
                    if(s.equals("Halycon Black"))
                    {
                        iv.setImageResource(R.drawable.halcyon_black);
                    }
                    if(s.equals("Halycon Green"))
                    {
                        iv.setImageResource(R.drawable.halcyon_green);
                    }
                    if(s.equals("Halycon Grey"))
                    {
                        iv.setImageResource(R.drawable.halcyon_grey);
                    }
                    if(s.equals("Chrome Red"))
                    {
                        iv.setImageResource(R.drawable.chrome_red);
                    }
                    if(s.equals("Chrome Bronze"))
                    {
                        iv.setImageResource(R.drawable.chrome_bronze);
                    }
                    if(s.equals("Gunmetal Grey"))
                    {
                        iv.setImageResource(R.drawable.gun_metal_frey);
                    }
                    if(s.equals("Dark Stealth Black"))
                    {
                        iv.setImageResource(R.drawable.dark_stealth);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }
        if(bike.equals("Meteor"))
        {
            bike_selected="Meteor";
            String[] colors={"Fireball Red","Supernova Red","Fireball Blue","Stellar Red","Firball Matt Green","Stellar Black","Supernova Blue","Fireball Yellow","Supernova Brown"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Fireball Red"))
                    {
                        iv.setImageResource(R.drawable.fireball_red);
                    }
                    if(s.equals("Supernova Red"))
                    {
                        iv.setImageResource(R.drawable.super_nova_red);
                    }
                    if(s.equals("Fireball Blue"))
                    {
                        iv.setImageResource(R.drawable.fireball_blue);
                    }
                    if(s.equals("Stellar Red"))
                    {
                        iv.setImageResource(R.drawable.stellar_red);
                    }
                    if(s.equals("Firball Matt Green"))
                    {
                        iv.setImageResource(R.drawable.fireball_matt_green);
                    }
                    if(s.equals("Supernova Blue"))
                    {
                        iv.setImageResource(R.drawable.super_nova_blue);
                    }
                    if(s.equals("Stellar Black"))
                    {
                        iv.setImageResource(R.drawable.stellar_black);
                    }
                    if(s.equals("Fireball Yellow"))
                    {
                        iv.setImageResource(R.drawable.fireball_yellow);
                    }
                    if(s.equals("Supernova Brown"))
                    {
                        iv.setImageResource(R.drawable.super_nova_brown);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }
        if(bike.equals("Himalayan"))
        {
            bike_selected="Himalayan";
            String[] colors={"Granite Black","Rock Red","Gravel Grey","Lake Blue","Mirage Silver","Pine Green"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Granite Black"))
                    {
                        iv.setImageResource(R.drawable.granite_black);
                    }
                    if(s.equals("Rock Red"))
                    {
                        iv.setImageResource(R.drawable.rock_red);
                    }
                    if(s.equals("Gravel Grey"))
                    {
                        iv.setImageResource(R.drawable.gravel_grey);
                    }
                    if(s.equals("Lake Blue"))
                    {
                        iv.setImageResource(R.drawable.lake_blue);
                    }
                    if(s.equals("Mirage Silver"))
                    {
                        iv.setImageResource(R.drawable.mirage_silver);
                    }
                    if(s.equals("Pine Green"))
                    {
                        iv.setImageResource(R.drawable.pine_green);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        if(bike.equals("Intercepter"))
        {
            bike_selected="Interceptor";
            String[] colors={"Baker Express","Downtown Drag","Ventura Blue","Canyon Red","Mark 2","Orange Crush","Sunset Strip"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Baker Express"))
                    {
                        iv.setImageResource(R.drawable.bakers_express);
                    }
                    if(s.equals("Downtown Drag"))
                    {
                        iv.setImageResource(R.drawable.downtown_drag);
                    }
                    if(s.equals("Canyon Red"))
                    {
                        iv.setImageResource(R.drawable.canyon_red);
                    }
                    if(s.equals("Mark 2"))
                    {
                        iv.setImageResource(R.drawable.mark2);
                    }
                    if(s.equals("Orange Crush"))
                    {
                        iv.setImageResource(R.drawable.orange_crush);
                    }
                    if(s.equals("Sunset Strip"))
                    {
                        iv.setImageResource(R.drawable.sunset_strip);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        if(bike.equals("Continental GT"))
        {
            bike_selected="Continental GT";
            String[] colors={"Rocker Red","Dux Deluxe","Ventura Storm","Mr Clean","British Racing Green"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Rocker Red"))
                    {
                        iv.setImageResource(R.drawable.rockeer_red);
                    }
                    if(s.equals("Dux Deluxe"))
                    {
                        iv.setImageResource(R.drawable.dux_deluxe);
                    }
                    if(s.equals("Ventura Storm"))
                    {
                        iv.setImageResource(R.drawable.ventura_strom);
                    }
                    if(s.equals("Mr Clean"))
                    {
                        iv.setImageResource(R.drawable.mr_clean);
                    }
                    if(s.equals("British Racing Green"))
                    {
                        iv.setImageResource(R.drawable.british_racing_green);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }
        if(bike.equals("Bullet"))
        {
            bike_selected="Bullet";
            String[] colors={"Black","Onxy Black","Bullet Silver"};
            ArrayAdapter<String> ad=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,colors);
            bike_color.setAdapter(ad);
            bike_color.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String s=colors[i];
                    if(s.equals("Onxy Black"))
                    {
                        iv.setImageResource(R.drawable.onxy_black);
                    }
                    if(s.equals("Black"))
                    {
                        iv.setImageResource(R.drawable.black_bullet);
                    }
                    if(s.equals("Bullet Silver"))
                    {
                        iv.setImageResource(R.drawable.bullet_silver);
                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void book(View view) {

        String name=nm.getText().toString();
        String phone=ph.getText().toString();
        if(name.equals(""))
        {
                 Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show();
        }
        else
        {
                if(phone.length()!=10)
                {
                    Toast.makeText(this, "Please Enter valid phone", Toast.LENGTH_SHORT).show();
                }
                else {

                    new AlertDialog.Builder(bookbike11.this)
                            .setTitle("Book this Bike?")
                            .setMessage("Are you sure to book this Bike? \n You will receive Calls from the 'NAND Enterprises' for booking related details")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    String color_selected=bike_color.getSelectedItem().toString();
                                    db.insert_bike_info(name,phone,bike_selected,color_selected);
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();

                     }
        }

    }
}