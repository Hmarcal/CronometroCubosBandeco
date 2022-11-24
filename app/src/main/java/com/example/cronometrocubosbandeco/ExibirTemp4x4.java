package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ExibirTemp4x4 extends AppCompatActivity {

    private ListView minhaLista4x4;

    private ArrayAdapter adapter;

    private static ArrayList<Cube4x4> exibeLista4x4;

    private Cube4x4DB db;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exibir_temp4x4);

        db = new Cube4x4DB(this);

        minhaLista4x4 = (ListView)  findViewById(R.id.listView4x4XML);

        exibeLista4x4 = db.findAll();

        adapter = new ArrayAdapter<Cube4x4>(this, android.R.layout.simple_list_item_1,exibeLista4x4);

        minhaLista4x4.setAdapter(adapter);


    }
}