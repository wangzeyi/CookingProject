package com.example.wang_.cookingproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.wang_.cookingproject.SecActivity;
import com.example.wang_.cookingproject.presenter.IPresenter;
import com.example.wang_.cookingproject.presenter.Presenter;
import com.example.wang_.cookingproject.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IView {

    Button button_Show, button_Back, button_Submit;
    Frag_menu f_menu;
    IPresenter presenter;
    EditText tv_dish, tv_step1, tv_step2, tv_step3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_Show = findViewById(R.id.button_show);
        button_Back = findViewById(R.id.button_back);
        button_Submit = findViewById(R.id.button_submit);
        tv_dish = findViewById(R.id.editText_dish);
        tv_step1 = findViewById(R.id.editText_step1);
        tv_step2 = findViewById(R.id.editText_step2);
        tv_step3 = findViewById(R.id.editText_step3);

        presenter = new Presenter(MainActivity.this);
        f_menu= new Frag_menu();

        getSupportFragmentManager().beginTransaction().add(R.id.main_layout,f_menu).commit();
        //f_menu.addElement("hi");
    }


    @Override
    public void showFragMenu() {
        //f_menu= new Frag_menu();
        //getSupportFragmentManager().beginTransaction().add(R.id.main_layout,f_menu).commit();

        ArrayList<String> dishList = presenter.getMenu();

        f_menu.clearElement();

        for(String s: dishList){
            f_menu.addElement(s);

        }
        //getSupportFragmentManager().beginTransaction().add(R.id.main_layout,f_menu).commit();

    }

    @Override
    public void destroyFragMenu() {
        getSupportFragmentManager().beginTransaction().remove(f_menu).commit();
    }

    @Override
    public void addtoFragMenu() {

        String dish_nm = tv_dish.getText().toString();
        String step1 = tv_step1.getText().toString();
        String step2 = tv_step2.getText().toString();
        String step3 = tv_step3.getText().toString();


        presenter.saveMenu(dish_nm, step1, step2, step3);

    }



    public void clickHandler(View view) {
        presenter.onClick(view);
    }

    public void goSecAcitvity(String dish_nm){
        Intent i = new Intent(MainActivity.this, SecActivity.class);
        i.putExtra("dish_name", dish_nm);
        startActivity(i);

    }


}
