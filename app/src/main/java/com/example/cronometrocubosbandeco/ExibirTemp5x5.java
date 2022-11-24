package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibirTemp5x5 extends AppCompatActivity {

    private ListView minhaLista5x5;

    private ArrayAdapter adapter;

    private static ArrayList<Cube5x5> exibeLista5x5;

    private Cube5x5DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_temp5x5);

        db = new Cube5x5DB(this);

        minhaLista5x5 = (ListView)  findViewById(R.id.listView5x5XML);

        exibeLista5x5 = db.findAll();

        adapter = new ArrayAdapter<Cube5x5>(this, android.R.layout.simple_list_item_1,exibeLista5x5);

        minhaLista5x5.setAdapter(adapter);

    }
}