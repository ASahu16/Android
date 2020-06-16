package com.hackodia.com.sqliteexp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbAdaptor extends SQLiteOpenHelper
{
    public MyDbAdaptor(Context context)
    {
        super(context, "app_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table student(name text , mobile text , password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void saveData(String Name , String Mobile , String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("name" , Name);
        cv.put("mobile" , Mobile);
        cv.put("password" , Password);

        db.insert("student" , null , cv);


    }

    public Cursor showData()
    {
        Cursor c=null;

        SQLiteDatabase db=this.getReadableDatabase();

        c=db.rawQuery("select * from student" , null);

        if (c!=null)
        {
            c.moveToFirst();
        }

        return  c;
    }

    public void deleteData(String Mobile)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("student" , "mobile"+"="+Mobile , null);
    }

    public void updateData(String Mobile , String Password)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put("password" , Password);

        db.update("student" , cv , "mobile"+"="+Mobile, null);
    }

}
