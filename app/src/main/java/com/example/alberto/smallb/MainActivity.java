package com.example.alberto.smallb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import xyz.hanks.library.bang.SmallBangView;

public class MainActivity extends AppCompatActivity {

    LinearLayout background;
    ImageView title, play, card1, card2, card3, card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final SmallBangView carta1 = findViewById(R.id.carta1);
        final SmallBangView carta2 = findViewById(R.id.carta2);
        final SmallBangView carta3 = findViewById(R.id.carta3);
        final SmallBangView carta4 = findViewById(R.id.carta4);

        background = findViewById(R.id.background);
        title = findViewById(R.id.titleMemorama);
        play = findViewById(R.id.button2);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation(background);
                rotatingImage(title);
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
            }
        });

        carta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carta1.isSelected()) {
                    carta1.setSelected(false);
                } else {
                    carta1.setSelected(true);
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
                    card2.setImageResource(R.drawable.carta);
                } else {
                    carta2.setSelected(true);
                    card2.setImageResource(R.drawable.triangulo);
                    carta2.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });


        card3 = findViewById(R.id.card3);
        carta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carta3.isSelected()) {
                    carta3.setSelected(false);
                    card3.setImageResource(R.drawable.carta);
                } else {
                    carta3.setSelected(true);
                    card3.setImageResource(R.drawable.cuadrado);
                    carta3.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });


        card4 = findViewById(R.id.card4);
        carta4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carta4.isSelected()) {
                    carta4.setSelected(false);
                    card4.setImageResource(R.drawable.carta);
                } else {
                    carta4.setSelected(true);
                    card4.setImageResource(R.drawable.cuadrado);
                    carta4.likeAnimation(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);

                        }
                    });
                }
            }
        });

    }


    @SuppressLint("WrongConstant")
    private void startAnimation(View v){
        int colorStart = getResources().getColor(R.color.fondo);
        int colorEnd = getResources().getColor(R.color.fondoCambio);
        ValueAnimator colorAnimation = ObjectAnimator.ofInt(v,"backgroundColor",
                colorStart, colorEnd);
        colorAnimation.setDuration(2000);
        colorAnimation.setEvaluator(new ArgbEvaluator() );
        colorAnimation.setRepeatCount(1);
        colorAnimation.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimation.start();

    }

    public void rotatingImage(View view) {
        @SuppressLint("ResourceType") Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.layout.rotate_animation);
        view.startAnimation(startRotateAnimation);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

}
