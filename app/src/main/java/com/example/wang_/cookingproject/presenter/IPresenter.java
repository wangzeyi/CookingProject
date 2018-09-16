package com.example.wang_.cookingproject.presenter;

import android.view.View;

import java.util.ArrayList;

public interface IPresenter {

    void onClick(View view);
    void saveMenu(String menu, String step1, String step2, String step3);
    ArrayList<String> getMenu();

}
