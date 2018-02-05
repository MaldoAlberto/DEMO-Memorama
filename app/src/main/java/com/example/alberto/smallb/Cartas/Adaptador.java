package com.example.alberto.smallb.Cartas;

/**
 * Created by alberto on 4/02/18.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.alberto.smallb.R;

import java.util.ArrayList;

import xyz.hanks.library.bang.SmallBangView;


public class Adaptador extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<Carta> items;
    private Context c;
    private int aux1=0,aux2=0,aux3=0,aux4=0,n=3;
    private boolean estadoJuego = true;
    private int tipoGame = 0;
    int pos = 0, numcarta = 0;

    public Adaptador (Activity activity, ArrayList<Carta> items, Context c, int tipoGame) {
        this.activity = activity;
        this.items = items;
        this.c = c;
        this.tipoGame = tipoGame;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    public void addAll(ArrayList<Carta> category) {
        for (int i = 0; i < category.size(); i++) {
            items.add(category.get(i));
        }
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

         View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.celda_carta, null);
        }

        final Carta dir = items.get(position);


        final SmallBangView sv = (SmallBangView) v.findViewById(R.id.efecto);
        final String nameCarts1 [] ={"triangulo", "cuadrado", "espiral", "circulo","triangulo", "cuadrado", "espiral", "circulo"};
        final String nameCarts2 [] ={"cruz", "sol", "tache", "sol","rombo", "tache", "rombo", "cruz"};


        final String nameCarts3 [] ={"triangulo", "cuadrado", "espiral", "circulo","triangulo", "cuadrado", "espiral", "circulo",
                "cruz", "sol", "tache", "sol","rombo", "tache", "rombo", "cruz"};
        final String nameCarts4 [] ={"cruz", "sol", "tache","triangulo", "cuadrado", "espiral", "circulo","triangulo", "circulo",
                 "sol","rombo", "tache", "rombo", "cruz", "cuadrado", "espiral"};


        final String nameCarts5 [] ={"triangulo",  "espiral", "espiral", "triangulo"};
        final String nameCarts6 [] ={"cruz",  "tache", "cruz", "tache"};

        final ImageView imagen = (ImageView) v.findViewById(R.id.card);
        imagen.setImageResource(dir.getImagen());
        ViewGroup.LayoutParams params = (ViewGroup.LayoutParams) imagen.getLayoutParams();
        params.width = 90;
        params.height = 120;
        // existing height is ok as is, no need to edit it
        imagen.setLayoutParams(params);

        String selectname = new String();

        switch(tipoGame){
            case 1:
                selectname = nameCarts1[position];
                break;
            case 2:
                selectname = nameCarts2[position];
                break;
            case 3:
                selectname = nameCarts3[position];
                break;
            case 4:
                selectname = nameCarts4[position];
                break;
            case 5:
                selectname = nameCarts5[position];
                break;
            case 6:
                selectname = nameCarts6[position];
                break;
        };
        numcarta++;

        if(numcarta >= 8 && (tipoGame == 1 || tipoGame == 2))
            numcarta = 7;

        if(numcarta >= 16 && (tipoGame == 3 || tipoGame == 4))
            numcarta = 15;

        if(numcarta >= 4 && (tipoGame == 5 || tipoGame == 6))
            numcarta = 3;

        final int resID = c.getResources().getIdentifier(selectname, "drawable", c.getPackageName());
        imagen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(imagen.isSelected()){
                    imagen.setSelected(false);
                    imagen.setImageResource(R.drawable.carta);

                }
                else{
                    imagen.setSelected(true);

                    imagen.setImageResource(resID);
                }
            }
        });


        return v;
    }

}
