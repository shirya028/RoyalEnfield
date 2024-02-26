package com.example.royalenfield;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class adminActivity extends AppCompatActivity {


    ListView lv;
    ArrayList<String> ar;
    RegistrationLoginDatabase rdb;
    ArrayList<User> u;
    EditText et;
    WebView wv;
    Button b1;
    TextView tv1;
    ImageButton imb1,imb2;
    String s1;
    book_bike_database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        getSupportActionBar().hide();
        et=findViewById(R.id.et);
        lv=findViewById(R.id.lv);
        imb1=findViewById(R.id.imgbtn_1);
        imb2=findViewById(R.id.imgbtn_2);
        tv1=findViewById(R.id.txt_123);
        ar= new ArrayList<>();
        u= new ArrayList<>();
        db=new book_bike_database(this);

//        loadData();

        rdb= new RegistrationLoginDatabase(this);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String txt=charSequence+"";

                search(txt);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    private void search(String s) {
        ArrayList<String> al = new ArrayList<>();

        for(String t:ar)
        {
            if(t.contains(s))
            {
                al.add(t);
            }

        }
        lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,al));

    }


    public void userDetails(View view) {

        lv.setVisibility(View.VISIBLE);
        et.setVisibility(View.VISIBLE);
        imb1.setVisibility(View.INVISIBLE);
        imb2.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.GONE);
        rdb = new RegistrationLoginDatabase(this);
        loadData();
    }

    public void loadData()
    {
                u.clear();
                Cursor c1 =rdb.displayData();
                ar.clear();
                while(c1.moveToNext())
                {
                    ar.add(c1.getString(0));
                    u.add(new User(c1.getString(0),c1.getString(1),c1.getLong(2)+"",c1.getString(3)));
                }
                lv.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,ar));
                traverseCursor();
    }



    public void traverseCursor()
    {

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent in = new Intent(adminActivity.this,UserDetails.class);
                User a = u.get(i);
                Accessories_Db db = new Accessories_Db(adminActivity.this);
                in.putExtra("name",a.getName());
                in.putExtra("email",a.getEmail());
                in.putExtra("phone",a.getPhone());
                in.putExtra("user",a.getUser());
                Cursor c =db.displayData();
                StringBuilder sb = new StringBuilder();
                int sum=0;
                while(c.moveToNext())
                {
                    if(c.getString(0).equals(a.getUser()))
                    {
                        sum+=c.getInt(2);
                        sb.append("\n"+c.getString(1)+"\n");

                    }

                }
                sb.append("\nBill :"+sum);
                in.putExtra("product",sb.toString());
                startActivity(in);

            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                User a =u.get(i);
                 new AlertDialog.Builder(adminActivity.this)
                        .setTitle("Delete a User")
                        .setMessage("Are you sure to delete "+a.getName()+"?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                rdb.deleteUser(a.getUser());

                                Toast.makeText(adminActivity.this, "User deleted", Toast.LENGTH_SHORT).show();
                                loadData();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .show();

                return true;
            }
        });
    }

    public void event(View view) {
        lv.setVisibility(View.INVISIBLE);
        imb1.setVisibility(View.VISIBLE);
        imb2.setVisibility(View.VISIBLE);
        et.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.INVISIBLE);

    }




    public void go_to_details(View view) {
        Intent i2=new Intent(this,update_event.class);
        i2.putExtra("pressed","details");
        startActivity(i2);
    }

    public void go_to_update(View view) {
        Intent i2=new Intent(this,update_event.class);
        i2.putExtra("pressed","update");
        startActivity(i2);
    }

    public void show_bookings(View view) {
        et.setVisibility(View.INVISIBLE);
        lv.setVisibility(View.INVISIBLE);
        tv1.setVisibility(View.VISIBLE);
        imb1.setVisibility(View.INVISIBLE);
        imb2.setVisibility(View.INVISIBLE);
        Cursor c=db.showData();
        StringBuilder s=new StringBuilder();
        while(c.moveToNext())
        {
                s.append("Name :-"+c.getString(0)+"\nPhone :- "+c.getString(1)+"\nBike :- "+c.getString(2)+"\nColor :- "+c.getString(3)+"\n \n");
        }

       tv1.setText(s);

        }
}