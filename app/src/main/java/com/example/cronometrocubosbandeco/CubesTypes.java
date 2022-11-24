package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CubesTypes extends AppCompatActivity {


    private Button btn2x2;
    private Button btn3x3;
    private Button btn4x4;
    private Button btn5x5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolhas_cube);

        btn2x2 = (Button) findViewById(R.id.c2x2XML);
        btn3x3 = (Button) findViewById(R.id.c3x3XML);
        btn4x4 = (Button) findViewById(R.id.c4x4XML);
        btn5x5 = (Button) findViewById(R.id.c5x5XML);


        btn2x2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt2x2Intent = new Intent(CubesTypes.this, Cronometro2x2.class);
                startActivity(bt2x2Intent);
            }
        });

        btn3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt3x3Intent = new Intent(CubesTypes.this, Cronometro3x3.class);
                startActivity(bt3x3Intent);
            }
        });

        btn4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt4x4Intent = new Intent(CubesTypes.this, Cronometro4x4.class);
                startActivity(bt4x4Intent);
            }
        });

        btn5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bt5x5Intent = new Intent(CubesTypes.this, Cronometro5x5.class);
                startActivity(bt5x5Intent);
            }
        });




    }
}