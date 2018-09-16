package com.example.wang_.cookingproject.view;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wang_.cookingproject.Menu_Adapter;
import com.example.wang_.cookingproject.R;
import com.example.wang_.cookingproject.view.IView_Menu;

import java.util.ArrayList;

public class Frag_menu extends android.support.v4.app.Fragment implements IView_Menu {

    ListView listview_Menu;
    ArrayList<String> dish_list;
    Menu_Adapter ma;
    MainActivity mainActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.frag_menu, container, false);

        dish_list = new ArrayList<>();
        listview_Menu = v.findViewById(R.id.listview_menu);

        ma = new Menu_Adapter(dish_list, getActivity());
        mainActivity = (MainActivity) getActivity();

        listview_Menu.setAdapter(ma);

        listview_Menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String dish = dish_list.get(position);
            //Toast.makeText(getActivity(), dish, Toast.LENGTH_SHORT).show();
            DisplayMenu dpm = new DisplayMenu(dish);
            dpm.execute();

            String[] dish_split = dish.split(" ");
            String dish_nm = dish_split[0];
            mainActivity.goSecAcitvity(dish_nm);

            }
        });



        return v;
    }
    @Override
    public void addElement(String dish_nm){
        dish_list.add(dish_nm);
        ma.notifyDataSetChanged();
        //Toast.makeText(getActivity(), dish_nm, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void clearElement(){
        dish_list.clear();
        ma.notifyDataSetChanged();
    }

    class DisplayMenu extends AsyncTask<Void, Integer, Void>{

        String[] menu;

        public DisplayMenu(String menu) {
            //this.menu = menu;
            this.menu = menu.split(" ");

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(getActivity(), menu[0], Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            for(int i=0; i<4; i++) {
                publishProgress(i);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values[0]);
            Toast.makeText(getActivity(), menu[values[0]], Toast.LENGTH_SHORT).show();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }


    }

}
