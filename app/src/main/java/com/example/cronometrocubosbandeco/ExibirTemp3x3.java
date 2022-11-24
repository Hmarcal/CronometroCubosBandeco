package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibirTemp3x3 extends AppCompatActivity {

    private ListView minhaLista3x3;

    private ArrayAdapter adapter;

    private static ArrayList<Cube3x3> exibeLista3x3;

    private Cube3x3DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_temp3x3);

        db = new Cube3x3DB(this);

        minhaLista3x3 = (ListView)  findViewById(R.id.listView3x3XML);

        exibeLista3x3 = db.findAll();

        adapter = new ArrayAdapter<Cube3x3>(this, android.R.layout.simple_list_item_1,exibeLista3x3);

        minhaLista3x3.setAdapter(adapter);

    }
}