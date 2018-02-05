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

public class Game3 extends AppCompatActivity {

    SmallBangView sbv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
        ArrayList<Carta> category = new ArrayList<>();

        for(int i = 0; i  < 8; i++)
        {
            category.add(new Carta(R.drawable.carta, sbv));
        }

        GridView lv = (GridView) findViewById(R.id.gridview);
        int game = (int) (Math.random() * 2) + 1;

        Adaptador adapter = new Adaptador(this, category, getApplicationContext(),game);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final int pos = position;
                //CODIGO AQUI


            }
        });
/*
        GridView gridview = (GridView) findViewById(R.id.gridview);// crear el
        // gridview a partir del elemento del xml gridview

        gridview.setAdapter(new ImageAdapter(this,16));// con setAdapter se llena
        // el gridview con datos. en
        // este caso un nuevo objeto de la clase ImageAdapter,
        // que está definida en otro archivo
        // para que detecte la pulsación se le añade un listener de itemClick
        // que recibe un OniTemClickListener creado con new

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {


            }
        });*/
    }
}
