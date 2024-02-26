package com.example.royalenfield;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;
//its the database for the people who wants to register for event


public class event_registeration_details extends SQLiteOpenHelper {
    public event_registeration_details(Context c) {
        super(c, "event_registeration", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table event_details(Name text,PhoneNumber text);";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public  void insertDetails(String nm,String ph)
    {
        SQLiteDatabase s = getWritableDatabase();
        String query = "insert into event_details values('" + nm + "','"+ph+"');";
        s.execSQL(query);
    }
    public Cursor showDetails() {

        SQLiteDatabase s1 = getWritableDatabase();
        String query1 = "select * from event_details";
        Cursor c1 = s1.rawQuery(query1, null);
        return c1;

    }
}
