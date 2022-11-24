package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Apaga5x5 extends AppCompatActivity {

    private EditText tempoApaga5x5;
    private Button btnApagar5x5;

    private Cube5x5DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apaga5x5);

        db = new Cube5x5DB(this);

        tempoApaga5x5 = findViewById(R.id.tempo5x5AXML);
        btnApagar5x5 = findViewById(R.id.apagar5x5AXML);

        btnApagar5x5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = db.apagar5x5(tempoApaga5x5.getText().toString());
                if (count == 0){
                    Toast.makeText(Apaga5x5.this, "Tempo Inexistente", Toast.LENGTH_SHORT).show();
                    tempoApaga5x5.setText("");
                }else {
                    Toast.makeText(Apaga5x5.this, "Tempo Apagado!", Toast.LENGTH_SHORT).show();
                    tempoApaga5x5.setText("");
                }
            }
        });

    }
}