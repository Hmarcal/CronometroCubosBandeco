package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cronometro5x5 extends AppCompatActivity {

    private TextView timer5x5;
    private Button btnStart5x5;
    private Button btnStop5x5;
    private Button btnSave5x5;
    private Button btnTempos5x5;
    private Button btnApagartemp5x5;

    private Context cContext;
    private Contagem5x5 cContagem5x5;
    private Thread cThreadCrono5x5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro5x5);

        cContext = this;

        timer5x5 = findViewById(R.id.timer5x5XML);
        btnStart5x5 = findViewById(R.id.start5x5XML);
        btnStop5x5 = findViewById(R.id.stop5x5XML);
        btnSave5x5 = findViewById(R.id.save5x5XML);
        btnTempos5x5 = findViewById(R.id.visutempos5x5XML);
        btnApagartemp5x5 = findViewById(R.id.apaga5x5XML);


        btnStart5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cContagem5x5 == null){
                    cContagem5x5 = new Contagem5x5(cContext);
                    cThreadCrono5x5 = new Thread(cContagem5x5);
                    cThreadCrono5x5.start();
                    cContagem5x5.start();
                }

            }
        });

        btnStop5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cContagem5x5 !=null){
                    cContagem5x5.stop();
                    cThreadCrono5x5.interrupt();
                    cThreadCrono5x5 = null;

                    cContagem5x5 = null;
                }
            }
        });

        btnSave5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent save5x5Intent = new Intent(Cronometro5x5.this, Cadastrar5x5.class);
                startActivity(save5x5Intent);
            }
        });

        btnTempos5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visuTemp5x5 = new Intent(Cronometro5x5.this,ExibirTemp5x5.class);
                startActivity(visuTemp5x5);
            }
        });

        btnApagartemp5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent apagar5x5Intent = new Intent(Cronometro5x5.this,Apaga5x5.class);
                startActivity(apagar5x5Intent);
            }
        });

    }

    public void updateTimerText(final String time){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                timer5x5.setText(time);
            }
        });

    }



}
