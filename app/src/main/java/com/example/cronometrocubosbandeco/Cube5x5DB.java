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

public class Cube5x5DB extends SQLiteOpenHelper {

    public static final String TAG = "sql";
    public static final  String NOME_BANCO = "BancoCube5x5.db";
    public static final int VERSÃO_BANCO = 1;
    public static final String TABLE_NAME = "cubo5x5";
    public static final String COLUNA0 = "_id";
    public static final String COLUNA1 = "tempo";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " +TABLE_NAME + " ("
                    + COLUNA0 +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUNA1 + " TEXT )";




    public Cube5x5DB(Context context) {
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
    public long salva5x5(Cube5x5 cube5x5){

        long id = cube5x5.get_id();

        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues valores5x5 = new ContentValues();

            valores5x5.put(COLUNA1, cube5x5.getTempo5x5());
            if (id !=0){
                int count = db.update(TABLE_NAME, valores5x5,"_id =?",new String[]{String.valueOf(id)});
                return count;
            }

            else {
                id = db.insert(TABLE_NAME, null, valores5x5);
                return id;
            }

        }finally {
            db.close();
        }

    }

    public int apagar5x5(String Apagartempo5x5){
        SQLiteDatabase db = getWritableDatabase();
        try {

            int count = db.delete(TABLE_NAME, "tempo=?", new String[]{Apagartempo5x5});
            Log.i(TAG,"deletou registro 5x5 =>" + count);
            return count;

        }finally {
            db.close();
        }
    }

    public ArrayList<Cube5x5> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Cube5x5> lista5x5 = new ArrayList<>();
        try{
            Cursor c5x5 = db.query(TABLE_NAME, null,null,null, null, null, "tempo asc");
            if(c5x5.moveToFirst()){
                do {
                    @SuppressLint("Range") long id = c5x5.getLong(c5x5.getColumnIndex("_id"));
                    @SuppressLint("Range") String tempo = c5x5.getString(c5x5.getColumnIndex("tempo"));

                    Cube5x5 currentContact5x5 = new Cube5x5(id, tempo);
                    lista5x5.add(currentContact5x5);

                }while(c5x5.moveToNext());
            }
            return  lista5x5;
        }finally {
            db.close();
        }


    }



}