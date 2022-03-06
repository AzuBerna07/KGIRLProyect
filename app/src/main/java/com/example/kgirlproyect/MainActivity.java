package com.example.kgirlproyect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {
    //DURATION
    private static int SPLASH_SCREEN= 5000;

    //variables
    Animation topAnim,bottomAnim;
    ImageView logo;
    TextView eslogan;

    //button para cambiar de activity
    Button btnInciar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //linea para hacer full la pantalla
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        //direccionamos
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim  = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
        logo = findViewById(R.id.imgLogo);
        eslogan=findViewById(R.id.txtEslogan);

        //button
        btnInciar = (Button) findViewById(R.id.btnIniciar);


        //Poner animación
        logo.setAnimation(topAnim);
        eslogan.setAnimation(bottomAnim);

        //CAMBIAR A OTRA ACTIVITY por medio de SPLASH
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

        //METODO PARA CAMBIAR DE ACTIVITY POR BUTTON status pendiente por que no me carga
        btnInciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Menu.class);
                startActivity(in);
                finish();

            }
        });
    }

}