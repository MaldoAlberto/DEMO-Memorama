package com.example.alberto.smallb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.alberto.smallb.Cartas.Adaptador;
import com.example.alberto.smallb.Cartas.Carta;

import java.util.ArrayList;

import xyz.hanks.library.bang.SmallBangView;


public class Game2 extends AppCompatActivity {
    SmallBangView sbv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_game2);
            ArrayList<Carta> category = new ArrayList<>();
            int games[] = {5, 6};

            for (int i = 0; i < 4; i++) {
                category.add(new Carta(R.drawable.carta, sbv));
            }

            GridView lv = (GridView) findViewById(R.id.gridview);

            int game = (int) (Math.random() * 2);


            Adaptador adapter = new Adaptador(this, category, getApplicationContext(), games[game]);

            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    final int pos = position;

                    //CODIGO AQUI


                }
            });
    }
}
