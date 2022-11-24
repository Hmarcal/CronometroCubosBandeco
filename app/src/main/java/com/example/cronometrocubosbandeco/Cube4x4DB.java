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

public class Cube4x4DB extends SQLiteOpenHelper {


    public static final String TAG = "sql";
    public static final  String NOME_BANCO = "BancoCube4x4.db";
    public static final int VERSÃO_BANCO = 1;
    public static final String TABLE_NAME = "cubo4x4";
    public static final String COLUNA0 = "_id";
    public static final String COLUNA1 = "tempo";

    private static final String SQL_CREATE_TABLE =
            "CREATE TABLE " +TABLE_NAME + " ("
                    + COLUNA0 +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUNA1 + " TEXT )";




    public Cube4x4DB(Context context) {
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
    public long salva4x4(Cube4x4 cube4x4){

        long id = cube4x4.get_id();

        SQLiteDatabase db = getWritableDatabase();
        try{
            ContentValues valores4x4 = new ContentValues();

            valores4x4.put(COLUNA1, cube4x4.getTempo4x4());
            if (id !=0){
                int count = db.update(TABLE_NAME, valores4x4,"_id =?",new String[]{String.valueOf(id)});
                return count;
            }

            else {
                id = db.insert(TABLE_NAME, null, valores4x4);
                return id;
            }

        }finally {
            db.close();
        }

    }

    public int apagar4x4(String Apagartempo4x4){
        SQLiteDatabase db = getWritableDatabase();
        try {

            int count = db.delete(TABLE_NAME, "tempo=?", new String[]{Apagartempo4x4});
            Log.i(TAG,"deletou registro 4x4 =>" + count);
            return count;

        }finally {
            db.close();
        }
    }

    public ArrayList<Cube4x4> findAll(){
        SQLiteDatabase db = getWritableDatabase();
        ArrayList<Cube4x4> lista4x4 = new ArrayList<>();
        try{
            Cursor c4x4 = db.query(TABLE_NAME, null,null,null, null, null, "tempo asc");
            if(c4x4.moveToFirst()){
                do {
                    @SuppressLint("Range") long id = c4x4.getLong(c4x4.getColumnIndex("_id"));
                    @SuppressLint("Range") String tempo = c4x4.getString(c4x4.getColumnIndex("tempo"));

                    Cube4x4 currentContact4x4 = new Cube4x4(id, tempo);
                    lista4x4.add(currentContact4x4);

                }while(c4x4.moveToNext());
            }
            return  lista4x4;
        }finally {
            db.close();
        }


    }


}