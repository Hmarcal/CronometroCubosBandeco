package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar3x3 extends AppCompatActivity {

    private Button btnCadastra3x3;
    private EditText tempoCb3x3;

    private Cube3x3DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar3x3);

        db = new Cube3x3DB(this);
        btnCadastra3x3 = findViewById(R.id.cadastra3x3XML);
        tempoCb3x3 = findViewById(R.id.tempo3x3XML);


        btnCadastra3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tempoCb3x3.getText().length() == 0){
                    Toast.makeText(Cadastrar3x3.this, "Por favor preencha o tempo!",Toast.LENGTH_SHORT).show();
                }else {

                    String temp3x3 = tempoCb3x3.getText().toString();


                    Cube3x3 cadastro3x3 = new Cube3x3(0,temp3x3);

                    long id = db.salva3x3(cadastro3x3);
                    if (id != -1)
                        Toast.makeText(Cadastrar3x3.this, "Salvo com sucesso", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(Cadastrar3x3.this,"Ops! Não foi possível salvar o tempo.", Toast.LENGTH_LONG).show();

                    tempoCb3x3.setText("");
                }
            }
        });

    }
}