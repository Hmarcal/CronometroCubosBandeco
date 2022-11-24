package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apaga4x4 extends AppCompatActivity {

    private EditText tempoApaga4x4;
    private Button btnApagar4x4;

    private Cube4x4DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaga4x4);


        db = new Cube4x4DB(this);

        tempoApaga4x4 = findViewById(R.id.tempo4x4AXML);
        btnApagar4x4 = findViewById(R.id.apagar4x4AXML);

        btnApagar4x4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = db.apagar4x4(tempoApaga4x4.getText().toString());
                if (count == 0){
                    Toast.makeText(Apaga4x4.this, "Tempo Inexistente", Toast.LENGTH_SHORT).show();
                    tempoApaga4x4.setText("");
                }else {
                    Toast.makeText(Apaga4x4.this, "Tempo Apagado!", Toast.LENGTH_SHORT).show();
                    tempoApaga4x4.setText("");
                }
            }
        });



    }
}