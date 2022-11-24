package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar5x5 extends AppCompatActivity {

    private Button btnCadastra5x5;
    private EditText tempoCb5x5;


    private Cube5x5DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar5x5);

        db = new Cube5x5DB(this);
        btnCadastra5x5 = findViewById(R.id.cadastra5x5XML);
        tempoCb5x5 = findViewById(R.id.tempo5x5XML);


        btnCadastra5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempoCb5x5.getText().length() == 0){
                    Toast.makeText(Cadastrar5x5.this, "Por favor preencha o tempo!",Toast.LENGTH_SHORT).show();
                }else {

                    String temp5x5 = tempoCb5x5.getText().toString();


                    Cube5x5 cadastro5x5 = new Cube5x5(0,temp5x5);

                    long id = db.salva5x5(cadastro5x5);
                    if (id != -1)
                        Toast.makeText(Cadastrar5x5.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Cadastrar5x5.this,"Ops! Não foi possível salvar o tempo.", Toast.LENGTH_LONG).show();

                    tempoCb5x5.setText("");
                }
            }
        });





    }
}