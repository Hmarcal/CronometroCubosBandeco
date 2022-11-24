package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cronometro3x3 extends AppCompatActivity {

    private TextView timer3x3;
    private Button btnStart3x3;
    private Button btnStop3x3;
    private Button btnSave3x3;
    private Button btnTempos3x3;
    private Button btnApagartemp3x3;

    private Context cContext;
    private Contagem3x3 cContagem3x3;
    private Thread cThreadCrono3x3;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro3x3);


        cContext = this;

        timer3x3 = findViewById(R.id.timer3x3XML);
        btnStart3x3 = findViewById(R.id.start3x3XML);
        btnStop3x3 = findViewById(R.id.stop3x3XML);
        btnSave3x3 = findViewById(R.id.save3x3XML);
        btnTempos3x3 = findViewById(R.id.visutempos3x3XML);
        btnApagartemp3x3 = findViewById(R.id.apaga3x3XML);


        btnStart3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cContagem3x3 == null){
                    cContagem3x3 = new Contagem3x3(cContext);
                    cThreadCrono3x3 = new Thread(cContagem3x3);
                    cThreadCrono3x3.start();
                    cContagem3x3.start();
                }

            }
        });

        btnStop3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cContagem3x3 !=null){
                    cContagem3x3.stop();
                    cThreadCrono3x3.interrupt();
                    cThreadCrono3x3 = null;

                    cContagem3x3 = null;
                }
            }
        });

        btnSave3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save3x3Intent = new Intent(Cronometro3x3.this, Cadastrar3x3.class);
                startActivity(save3x3Intent);
            }
        });

        btnTempos3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visuTemp3x3 = new Intent(Cronometro3x3.this,ExibirTemp3x3.class);
                startActivity(visuTemp3x3);
            }
        });

        btnApagartemp3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apagar3x3Intent = new Intent(Cronometro3x3.this,Apaga3x3.class);
                startActivity(apagar3x3Intent);
            }
        });

    }

    public void updateTimerText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer3x3.setText(time);
            }
        });

    }



}
