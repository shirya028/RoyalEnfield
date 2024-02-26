package com.example.royalenfield;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {

    TextView t1,t2,t3,t4,t5;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Bundle b =getIntent().getExtras();
        t1=findViewById(R.id.name);
        t2=findViewById(R.id.email);
        t3=findViewById(R.id.phone);
        t4=findViewById(R.id.user);
        t5=findViewById(R.id.product);


        t1.setText("Name: "+b.get("name")+"");
        t2.setText("Email: "+b.get("email")+"");
        t3.setText("Phone: "+b.get("phone")+"");
        t4.setText("Username: "+b.get("user")+"");
        if(b.get("product").equals(""))
        {
            t5.setText("Nothing Purchased Yet!");
        }
        else
        {
            t5.setText(b.get("product")+"");
        }

    }
}