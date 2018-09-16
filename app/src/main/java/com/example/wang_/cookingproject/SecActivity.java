package com.example.wang_.cookingproject;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wang_.cookingproject.view.MainActivity;

public class SecActivity extends AppCompatActivity {

    Button button_Back;
    ImageView image_Dish;

    String[] dish = {"dish1", "dish2", "dish3"};
    int[] myPictures = {R.drawable.dish1, R.drawable.dish2, R.drawable.dish3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);

        button_Back = findViewById(R.id.button_back);
        image_Dish = findViewById(R.id.imageView_dish);

        //image_Dish.setImageResource(R.drawable.dish1);
        Intent i = getIntent();
        String dish_nm = i.getStringExtra("dish_name");

        int idx = 0;

        for(int j=0; j<dish.length; j++){
            if(dish[j].equals(dish_nm)){
                idx = j;
            }
        }

        image_Dish.setImageResource(myPictures[idx]);

        button_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SecActivity.this, MainActivity.class);
                startActivity(i);

            }
        });

        Intent myintent = new Intent(SecActivity.this, MyMusicService.class);
        startService(myintent);
    }
}
