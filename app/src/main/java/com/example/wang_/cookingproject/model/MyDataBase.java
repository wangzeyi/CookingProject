package com.example.wang_.cookingproject.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDataBase extends SQLiteOpenHelper{

    public static final String MYDATABASE = "mydatabase";
    public static final String MYTABLENAME = "mytablename";
    public static final String KEY_ID = "mykeyid";
    public static final String MYDISH = "mydish";
    public static final String MYSTEP1 = "mystep1";
    public static final String MYSTEP2 = "mystep2";
    public static final String MYSTEP3 = "mystep3";
    public static final int MYVERSION = 1;

    //private static MyDataBase mydb = new MyDataBase();


    public MyDataBase(Context context) {
        super(context, MYDATABASE, null, MYVERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE = "CREATE TABLE " + MYTABLENAME + "(" +
                                KEY_ID + " INTEGER PRIMARY KEY," +
                                MYDISH + " DISH," +
                                MYSTEP1 + " STEP1," +
                                MYSTEP2 + " STEP2," +
                                MYSTEP3 + " STEP3" + ")";


        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MYTABLENAME);
        onCreate(db);
    }
}
