package com.example.wang_.cookingproject.presenter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.example.wang_.cookingproject.model.MyDataBase;
import com.example.wang_.cookingproject.R;
import com.example.wang_.cookingproject.view.IView;
import com.example.wang_.cookingproject.view.MainActivity;

import java.util.ArrayList;

public class Presenter implements IPresenter {

    IView view;
    MyDataBase myDataBase;
    SQLiteDatabase sqLiteDatabase;

    public Presenter(MainActivity mainActivity) {
        this.view = mainActivity;
        myDataBase = new MyDataBase(mainActivity);
        sqLiteDatabase = myDataBase.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button_show:
                view.showFragMenu();
                break;
            case R.id.button_back:
                view.destroyFragMenu();
                break;
            case R.id.button_submit:
                view.addtoFragMenu();
                break;
            default:
                return;

        }
    }

    public void saveMenu(String menu, String step1, String step2, String step3){

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDataBase.MYDISH, menu);
        contentValues.put(MyDataBase.MYSTEP1, step1);
        contentValues.put(MyDataBase.MYSTEP2, step2);
        contentValues.put(MyDataBase.MYSTEP3, step3);

        sqLiteDatabase.insert(MyDataBase.MYTABLENAME, null, contentValues);
    }

    public ArrayList<String> getMenu(){

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + MyDataBase.MYTABLENAME, null);
        cursor.moveToFirst();

        ArrayList<String> dishList = new ArrayList<>();

        do {
            int id = cursor.getInt(cursor.getColumnIndex(MyDataBase.KEY_ID));
            String dish_nm = cursor.getString(cursor.getColumnIndex(MyDataBase.MYDISH));
            String step1 = cursor.getString(cursor.getColumnIndex(MyDataBase.MYSTEP1));
            String step2 = cursor.getString(cursor.getColumnIndex(MyDataBase.MYSTEP2));
            String step3 = cursor.getString(cursor.getColumnIndex(MyDataBase.MYSTEP3));

            String item =  dish_nm + " " + step1 + " " + step2 + " " + step3;

            dishList.add(item);

        } while (cursor.moveToNext());

        return dishList;
    }

}
