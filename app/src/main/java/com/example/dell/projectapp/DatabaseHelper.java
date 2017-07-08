package com.example.dell.projectapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper  extends SQLiteOpenHelper{

    //public static final String DATABASE_NAME = "employee.db";
    //public static final String TABLE_NAME = "employee_table"; originals
    public static final String DATABASE_NAME = "em.db";
    public static final String TABLE_NAME = "em_table";
    public static final String col_1 = "ID";
    public static final String col_2 = "NAME";
    public static final String col_3 = "DESIGNATION";
    public static final String col_4 = "LANDLINE";
    public static final String col_5 = "MOBILE";
    public static final String col_6 = "DEPARTMENT";
    public static final String col_7 = "LOCATION";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //query for creating the table "employee_table"
        // original String c_query = "CREATE TABLE "+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY,NAME TEXT,DESIGNATION TEXT,LANDLINE INTEGER,MOBILE INTEGER,DEPARTMENT TEXT,LOCATION TEXT);";
        String c_query = "CREATE TABLE "+ TABLE_NAME+ "(ID INTEGER PRIMARY KEY,NAME TEXT,DESIGNATION TEXT,LANDLINE TEXT,MOBILE TEXT,DEPARTMENT TEXT,LOCATION TEXT);";
        db.execSQL(c_query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME + ";");
        onCreate(db);
    }

    // old public boolean insertData(int id,String name,String design,int land,int mob,String dept,String loc) {
    public boolean insertData(int id,String name,String design,String land,String mob,String dept,String loc) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,design);
        contentValues.put(col_4,land);
        contentValues.put(col_5,mob);
        contentValues.put(col_6,dept);
        contentValues.put(col_7,loc);

        long result = db.insert(TABLE_NAME,null,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(int id,String name,String design,String land,String mob,String dept,String loc) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(col_1,id);
        contentValues.put(col_2,name);
        contentValues.put(col_3,design);
        contentValues.put(col_4,land);
        contentValues.put(col_5,mob);
        contentValues.put(col_6,dept);
        contentValues.put(col_7,loc);
        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {String.valueOf(id)});
        return true;
    }

    /*
    public Cursor queryData(String custom_query){
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res1 = db1.rawQuery(custom_query,null);
        //debugging
        System.out.println("custom_query:" + custom_query);
        //the_query received successfully as custom_query
        return res1;
    }*/
    public Cursor queryData(String custom_query) {
        SQLiteDatabase db1 = this.getWritableDatabase();
        Cursor res1 = db1.rawQuery(custom_query,null);
        //debugging
        // System.out.println(custom_query);received the_query as custom_query successfully
        return res1;
    }

    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] {id});
    }
}
