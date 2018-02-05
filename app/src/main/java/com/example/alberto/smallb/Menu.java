package com.example.alberto.smallb;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class Menu extends AppCompatActivity {

    ImageView game1,game2,game3,game4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        game1 = findViewById(R.id.menu1);
        game2 = findViewById(R.id.menu2);
        game3 = findViewById(R.id.menu3);
        game4 = findViewById(R.id.menu4);

        game1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Game1.class);
                startActivity(intent);
            }
        });


        game2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Game2.class);
                startActivity(intent);
            }
        });


        game3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Game3.class);
                startActivity(intent);
            }
        });


        game4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, Game4.class);
                startActivity(intent);
            }
        });

    }
}
