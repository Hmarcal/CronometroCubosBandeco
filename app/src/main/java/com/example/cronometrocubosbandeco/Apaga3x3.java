package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apaga3x3 extends AppCompatActivity {

    private EditText tempoApaga3x3;
    private Button btnApagar3x3;

    private Cube3x3DB db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaga3x3);

        db = new Cube3x3DB(this);

        tempoApaga3x3 = findViewById(R.id.tempo3x3AXML);
        btnApagar3x3 = findViewById(R.id.apagar3x3AXML);

        btnApagar3x3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = db.apagar3x3(tempoApaga3x3.getText().toString());
                if (count == 0){
                    Toast.makeText(Apaga3x3.this, "Tempo Inexistente", Toast.LENGTH_SHORT).show();
                    tempoApaga3x3.setText("");
                }else {
                    Toast.makeText(Apaga3x3.this, "Tempo Apagado!", Toast.LENGTH_SHORT).show();
                    tempoApaga3x3.setText("");
                }
            }
        });

    }
}