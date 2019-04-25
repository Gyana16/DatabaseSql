package com.example.gyana.demoofsql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by GYANA on 2017-11-28.
 */

public class MyDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="student.db";
    private static final String TABLE_NAME="student";
    private  static final String COL_1="ID";
    private  static final String COL_2="NAME";
    private  static final String COL_3="SURNAME";
    private  static final String COL_4="ROLL";
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table "+TABLE_NAME +" "+
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,ROLL TEXT)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

   /* public void update(String name)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("UPDATE student SET NAME ='Rajesh' WHERE NAME='Subham'");
    }*/

    void update()
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,"Nikhil");
       // contentValues.put("upass","909090");
        sqLiteDatabase.update("student",contentValues,"COL_2=?",new String[]{"Java"});
    }

    public boolean isInserted(String name,String surname,String roll)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_2,name);
        cv.put(COL_3,surname);
        cv.put(COL_4,roll);

        long res=db.insert(TABLE_NAME,null,cv);

        if (res==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getReadableDatabase();

        Cursor result=db.rawQuery("select * from "+TABLE_NAME,null);
        return  result;
    }

}
