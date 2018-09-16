package com.example.wang_.cookingproject.presenter;

import com.example.wang_.cookingproject.presenter.IPreseter_Menu;
import com.example.wang_.cookingproject.view.Frag_menu;
import com.example.wang_.cookingproject.view.IView_Menu;

public class Presenter_Menu implements IPreseter_Menu {

    IView_Menu view_menu;

    public Presenter_Menu(Frag_menu menu) {
        this.view_menu = menu;
    }

    @Override
    public void onClick(int position) {
        //view_menu.removeElement(position);
        //view_menu.displayElement(position);
    }
}
