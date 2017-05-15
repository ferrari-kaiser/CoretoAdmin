package com.example.ferra.coretoadmin.banco.domain;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ferra on 12/05/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "Gastos";
    private static int VERSAO = 1;


    public static class Gasto{
        public static final String TABELA = "GASTO";
        public static final String _ID = "_ID";
        public static final String GASTO_ID = "GASTO_ID";
        public static final String CATEGORIA = "CATEGORIA";
        public static final String DATA = "DATA";
        public static final String DESCRICAO = "DESCRICAO";
        public static final String VALOR = "VALOR";
        public static final String LATIDUDE = "LATITUDE";
        public static final String LONGITUDE = "LONGITUDE";
        public static final String LOCATION = "LOCATION";


        public static final String[] COLUNAS = new String[]{
                _ID, GASTO_ID, CATEGORIA, DATA, DESCRICAO, VALOR, LATIDUDE,LONGITUDE,LOCATION
        };
    }

    public static class users{
        public static final String TABELA = "USER";
        public static final String _ID = "_ID";
        public static final String GASTO_ID = "GASTO_ID";
        public static final String VALOR = "VALOR";
        public static final String NAME = "NAME";

        public static final String[] COLUNAS = new String[]{
                _ID, GASTO_ID, VALOR, NAME
        };
    }

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE GASTO (_ID INTEGER PRIMARY KEY," +
                " CATEGORIA TEXT, DATA TEXT, VALOR DOUBLE, DESCRICAO TEXT," +
                " LATITUDE TEXT,LONGITUDE TEXT,LOCATION TEXT, GASTO_ID INTEGER," +
                " FOREIGN KEY(GASTO_ID) REFERENCES GA(ID));");

        db.execSQL("CREATE TABLE USER (_ID INTEGER PRIMARY KEY," +
                " VALOR TEXT, NAME TEXT," +
                " GASTO_ID INTEGER," +
                " FOREIGN KEY(GASTO_ID) REFERENCES GA(ID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE gasto;");
        onCreate(db);
    }


}
