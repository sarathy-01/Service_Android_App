package com.example.service;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbhelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="products";
    private static final String TABLE_NAME="washingmechine";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_LOCATION="location";
    private static final String KEY_PHONE="phone";


    public Dbhelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_NAME+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +KEY_NAME+" TEXT,"
                +KEY_LOCATION+" TEXT,"
                +KEY_PHONE+" TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void addContact(String name,String location,String phone)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db=this.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_LOCATION,location);
        values.put(KEY_PHONE,phone);
        db.insert(TABLE_NAME,null,values);
    }

    Cursor readAllData()
    {
        String query="select * from "+TABLE_NAME;
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        cursor=db.rawQuery(query,null);
        return cursor;

    }

}