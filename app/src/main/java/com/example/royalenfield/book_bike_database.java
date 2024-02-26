package com.example.royalenfield;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class book_bike_database extends SQLiteOpenHelper {
    Context c1;
    public book_bike_database(Context c) {
        super(c, "book_bike_db", null, 1);
        this.c1=c;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String q="create table booked_bikes(user text,phone text,bike text,color text);";
        sqLiteDatabase.execSQL(q);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insert_bike_info(String nm,String ph,String bike,String color)
    {
        String s="INSERT INTO booked_bikes";
        SQLiteDatabase db12=getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("user",nm);
        c.put("phone",ph);
        c.put("bike",bike);
        c.put("color",color);
        db12.insert("booked_bikes",null,c);
        Toast.makeText(c1, "request received ,thanks you!!", Toast.LENGTH_LONG).show();
    }
    public Cursor showData()
    {
        SQLiteDatabase s1 = getWritableDatabase(); //one  minn
        Cursor c2 = s1.rawQuery("select * from booked_bikes", null);
        return c2;

    }
}
