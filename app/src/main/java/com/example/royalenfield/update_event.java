package com.example.royalenfield;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class update_event extends AppCompatActivity {
ListView lv;
TextView tv,tv1;
String str;
WebView wv;
Button b1,b2;
EditText e1;

event_registeration_details ev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_event);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        tv=findViewById(R.id.t1);
        tv1=findViewById(R.id.t0);
         ev=new event_registeration_details(this);
         wv=findViewById(R.id.wv);
         b1=findViewById(R.id.change_event_btn);
         b2=findViewById(R.id.set_btn);
         e1=findViewById(R.id.e1);
         str=getIntent().getStringExtra("pressed");
         if(str.equals("details"))
         {
             show_event_details();
         }
         if(str.equals("update"))
         {
             update_details_now();
         }
    }

public  void show_event_details()
{
    tv.setVisibility(View.VISIBLE);
    tv1.setVisibility(View.VISIBLE);
    wv.setVisibility(View.INVISIBLE);
    b1.setVisibility(View.INVISIBLE);
    b2.setVisibility(View.INVISIBLE);
    e1.setVisibility(View.INVISIBLE);
    Cursor c=ev.showDetails();
    StringBuilder s=new StringBuilder();
    while(c.moveToNext())
    {
        s.append("Name :-"+c.getString(0)+"                           Phone:- "+c.getString(1)+"\n");
    }
    tv.setText(s);
}
public void  update_details_now()
{
    tv.setVisibility(View.INVISIBLE);
    tv1.setVisibility(View.INVISIBLE);
    wv.setVisibility(View.VISIBLE);
    b1.setVisibility(View.VISIBLE);
    b2.setVisibility(View.VISIBLE);
    e1.setVisibility(View.VISIBLE);
    wv.setWebViewClient(new WebViewClient());
    wv.getSettings().setSupportZoom(true);
    wv.getSettings().setJavaScriptEnabled(true);
    wv.loadUrl("https://docs.google.com/presentation/d/11BZbf1B3Gt9xOLdg-A1NJ3ihdaNPM-s_2cyfX_LV9Vo/edit?usp=sharing");
    Toast.makeText(this, "Please wait for few seconds....", Toast.LENGTH_SHORT).show();

}


    public void change_event(View view)
    {
        new AlertDialog.Builder(update_event.this)
                .setTitle("Notice !!")
                .setMessage("To update event,you must loging into Google drive with the specified email ")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Uri u=Uri.parse("https://docs.google.com/presentation/d/11BZbf1B3Gt9xOLdg-A1NJ3ihdaNPM-s_2cyfX_LV9Vo/edit?usp=sharing");
                        Intent my_int=new Intent(Intent.ACTION_VIEW,u);
                        startActivity(my_int);
                    }
                })
                .show();

    }

    public void setAmount(View view) {
        String amount=e1.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("uname",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();
        myEdit.putString("amount", amount);
        myEdit.commit();
        Toast.makeText(this, "Amount Successfully Set", Toast.LENGTH_SHORT).show();

    }
}