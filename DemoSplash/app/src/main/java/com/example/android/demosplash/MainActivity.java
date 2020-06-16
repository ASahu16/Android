package com.example.android.demosplash;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView logo;
    ImageView h;
    ImageView o;
    ImageView n;
    ImageView d;
    ImageView a;
    ObjectAnimator animate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        h = findViewById(R.id.h);
        o = findViewById(R.id.o);
        n = findViewById(R.id.n);
        d = findViewById(R.id.d);
        a = findViewById(R.id.a);


    }
}
