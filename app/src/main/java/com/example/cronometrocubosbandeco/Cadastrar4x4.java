package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar4x4 extends AppCompatActivity {

    private Button btnCadastra4x4;
    private EditText tempoCb4x4;


    private Cube4x4DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar4x4);

        db = new Cube4x4DB(this);
        btnCadastra4x4 = findViewById(R.id.cadastra4x4XML);
        tempoCb4x4 = findViewById(R.id.tempo4x4XML);


        btnCadastra4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempoCb4x4.getText().length() == 0){
                    Toast.makeText(Cadastrar4x4.this, "Por favor preencha o tempo!",Toast.LENGTH_SHORT).show();
                }else {

                    String temp4x4 = tempoCb4x4.getText().toString();


                    Cube4x4 cadastro4x4 = new Cube4x4(0,temp4x4);

                    long id = db.salva4x4(cadastro4x4);
                    if (id != -1)
                        Toast.makeText(Cadastrar4x4.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Cadastrar4x4.this,"Ops! Não foi possível salvar o tempo.", Toast.LENGTH_LONG).show();

                    tempoCb4x4.setText("");
                }
            }
        });


    }
}