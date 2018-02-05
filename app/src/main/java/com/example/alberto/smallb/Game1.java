package com.example.alberto.smallb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import xyz.hanks.library.bang.SmallBangView;

public class Game1 extends AppCompatActivity {

    ImageView card1, card2;
    String nameCarts [] ={"triangulo", "cuadrado", "espiral", "circulo"};
    boolean carta1Aux= false, carta2Aux= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        final SmallBangView carta1 = findViewById(R.id.carta1);
        final SmallBangView carta2 = findViewById(R.id.carta2);


        int position = (int) (Math.random() * 3);
        String selectname = nameCarts[position];
        final int resID = getResources().getIdentifier(selectname, "drawable", getPackageName());

        card1 = findViewById(R.id.card1);
        carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carta1.isSelected()) {
                    carta1.setSelected(false);
                    carta1Aux= false;
                    card1.setImageResource(R.drawable.carta);
                } else {
                    carta1.setSelected(true);
                    card1.setImageResource(resID);
                    carta1Aux= true;
                    if(carta1Aux == true && carta2Aux == true) {
                        carta1.setOnClickListener(null);
                        carta2.setOnClickListener(null);
                    }
                    carta1.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });


        card2 = findViewById(R.id.card2);
        carta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carta2.isSelected()) {
                    carta2.setSelected(false);
                    carta2Aux= false;
                    card2.setImageResource(R.drawable.carta);

                } else {
                    carta2.setSelected(true);
                    card2.setImageResource(resID);
                    carta2Aux= true;
                    if(carta1Aux == true && carta2Aux == true) {
                        carta1.setOnClickListener(null);
                        carta2.setOnClickListener(null);
                    }

                    carta2.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });


    }
}
