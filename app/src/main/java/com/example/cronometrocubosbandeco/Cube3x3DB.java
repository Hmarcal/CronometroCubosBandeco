package com.example.cronometrocubosbandeco;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class Cube3x3DB extends SQLiteOpenHelper {

    public static final String TAG = "sql";
    public static final  String NOME_BANCO = "BancoCube3x3.db";
    public static final int VERSÃO_BANCO = 1;
    public static final String TABLE_NAME = "cubo3x3";
    public static final String COLUNA0 = "_id";
    public static final String COLUNA1 = "tempo";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " +TABLE_NAME + " ("
                    + COLUNA0 +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUNA1 + " TEXT )";




    public Cube3x3DB(Context context) {
        super(context, NOME_BANCO, null, VERSÃO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_TABLE);

        Log.d(TAG,"Tabela"+TABLE_NAME+" criada com sucesso" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    //metodos para salvar e apagar
    public long salva3x3(Cube3x3 cube3x3){

        long id = cube3x3.get_id();

        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues valores3x3 = new ContentValues();

            valores3x3.put(COLUNA1, cube3x3.getTempo3x3());
            if (id !=0){
                int count = db.update(TABLE_NAME, valores3x3,"_id =?",new String[]{String.valueOf(id)});
                return count;
            }

            else {
                id = db.insert(TABLE_NAME, null, valores3x3);
                return id;
            }

        }finally {
            db.close();
        }

    }

    public int apagar3x3(String Apagartempo3x3){
        SQLiteDatabase db = getWritableDatabase();
        try {

            int count = db.delete(TABLE_NAME, "tempo=?", new String[]{Apagartempo3x3});
            Log.i(TAG,"deletou registro 3x3 =>" + count);
            return count;

        }finally {
            db.close();
        }
    }

    public ArrayList<Cube3x3> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Cube3x3> lista3x3 = new ArrayList<>();
        try{
            Cursor c3x3 = db.query(TABLE_NAME, null,null,null, null, null, "tempo asc");
            if(c3x3.moveToFirst()){
                do {
                    @SuppressLint("Range") long id = c3x3.getLong(c3x3.getColumnIndex("_id"));
                    @SuppressLint("Range") String tempo = c3x3.getString(c3x3.getColumnIndex("tempo"));

                    Cube3x3 currentContact2x2 = new Cube3x3(id, tempo);
                    lista3x3.add(currentContact2x2);

                }while(c3x3.moveToNext());
            }
            return  lista3x3;
        }finally {
            db.close();
        }


    }


}