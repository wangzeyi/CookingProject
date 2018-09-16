package com.example.wang_.cookingproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Menu_Adapter extends BaseAdapter{

    ArrayList<String> dish;
    //ArrayList<Integer> dish_image;
    LayoutInflater layoutInflater;
    Context ctx;

    public Menu_Adapter(ArrayList<String> dish, Context ctx) {
        this.dish = dish;
        //this.dish_image = dish_image;
        this.ctx = ctx;

        this.layoutInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return dish.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = layoutInflater.inflate(R.layout.menu_item_layout, null);
        TextView tv = v.findViewById(R.id.textView_mydish);

        tv.setText(dish.get(position));

        return v;
    }
}
