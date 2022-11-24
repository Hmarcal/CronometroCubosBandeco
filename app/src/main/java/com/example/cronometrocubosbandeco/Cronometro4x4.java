package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cronometro4x4 extends AppCompatActivity {

    private TextView timer4x4;
    private Button btnStart4x4;
    private Button btnStop4x4;
    private Button btnSave4x4;
    private Button btnTempos4x4;
    private Button btnApagartemp4x4;

    private Context cContext;
    private Contagem4x4 cContagem4x4;
    private Thread cThreadCrono2x2;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro4x4);

        cContext = this;

        timer4x4 = findViewById(R.id.timer4x4XML);
        btnStart4x4 = findViewById(R.id.start4x4XML);
        btnStop4x4 = findViewById(R.id.stop4x4XML);
        btnSave4x4 = findViewById(R.id.save4x4XML);
        btnTempos4x4 = findViewById(R.id.visutempos4x4XML);
        btnApagartemp4x4 = findViewById(R.id.apaga4x4XML);


        btnStart4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cContagem4x4 == null){
                    cContagem4x4 = new Contagem4x4(cContext);
                    cThreadCrono2x2 = new Thread(cContagem4x4);
                    cThreadCrono2x2.start();
                    cContagem4x4.start();
                }

            }
        });

        btnStop4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cContagem4x4 !=null){
                    cContagem4x4.stop();
                    cThreadCrono2x2.interrupt();
                    cThreadCrono2x2 = null;

                    cContagem4x4 = null;
                }
            }
        });

        btnSave4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save4x4Intent = new Intent(Cronometro4x4.this, Cadastrar4x4.class);
                startActivity(save4x4Intent);
            }
        });

        btnTempos4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visuTemp4x4 = new Intent(Cronometro4x4.this,ExibirTemp4x4.class);
                startActivity(visuTemp4x4);
            }
        });

        btnApagartemp4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apagar4x4Intent = new Intent(Cronometro4x4.this,Apaga4x4.class);
                startActivity(apagar4x4Intent);
            }
        });

    }

    public void updateTimerText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer4x4.setText(time);
            }
        });

    }
}