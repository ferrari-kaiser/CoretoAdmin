package com.example.ferra.coretoadmin.banco.domain.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ferra.coretoadmin.banco.domain.DatabaseHelper;
import com.example.ferra.coretoadmin.banco.domain.Spent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferra on 12/05/2017.
 */

public class SpentDAO {

    private DatabaseHelper helper;

    private SQLiteDatabase db;


    public SpentDAO(Context context){
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDb() {
        if (db == null) {
            db = helper.getWritableDatabase();
        }
        return db;
    }

    public void close(){
        helper.close();
    }


    public List<Spent> listarGastos(){

        Cursor cursor = getDb().query(DatabaseHelper.Gasto.TABELA,
                DatabaseHelper.Gasto.COLUNAS,
                null, null, null, null, null);
        List<Spent> gastos = new ArrayList<Spent>();
        while(cursor.moveToNext()){
            Spent gasto = criarGasto(cursor);
            gastos.add(gasto);
        }

        cursor.close();
        return gastos;
    }

    public Spent buscarGastoPorId(Integer id){
        Cursor cursor = getDb().query(DatabaseHelper.Gasto.TABELA,
                DatabaseHelper.Gasto.COLUNAS,
                DatabaseHelper.Gasto._ID + " = ?",
                new String[]{ id.toString() },
                null, null, null);
        if(cursor.moveToNext()){
            Spent gasto = criarGasto(cursor);
            cursor.close();
            return gasto;
        }
        return null;
    }

    public long inserir(Spent gasto){
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.Gasto.CATEGORIA,
                gasto.getCategoria());

        values.put(DatabaseHelper.Gasto.DATA,
                gasto.getData());

        values.put(DatabaseHelper.Gasto.DESCRICAO,
                gasto.getDescricao());

        values.put(DatabaseHelper.Gasto.LATIDUDE,
                gasto.getLatitude());

        values.put(DatabaseHelper.Gasto.LONGITUDE,
                gasto.getLongitude());

        values.put(DatabaseHelper.Gasto.VALOR,
                gasto.getValor());

        values.put(DatabaseHelper.Gasto.LOCATION,
                gasto.getLocation());

        values.put(DatabaseHelper.Gasto.GASTO_ID,
                gasto.getGastoId());

        return getDb().insert(DatabaseHelper.Gasto.TABELA,
                null, values);
    }

    public boolean removerGasto(Long id){
        String whereClause = DatabaseHelper.Gasto._ID + " = ?";
        String[] whereArgs = new String[]{id.toString()};
        int removidos = getDb().delete(DatabaseHelper.Gasto.TABELA,
                whereClause, whereArgs);
        return removidos > 0;
    }

    public double calcularTotalGasto(Integer id){
        Cursor cursor = getDb().rawQuery(
                "SELECT SUM("+DatabaseHelper.Gasto.VALOR + ") FROM " +
                        DatabaseHelper.Gasto.TABELA + " WHERE " +
                        DatabaseHelper.Gasto.GASTO_ID + " = ?",
                new String[]{ id.toString() });
        cursor.moveToFirst();
        double total = cursor.getDouble(0);
        cursor.close();
        return total;
    }


    private Spent criarGasto(Cursor cursor) {
        Spent gasto = new Spent(
                cursor.getInt(cursor.getColumnIndex(
                        DatabaseHelper.Gasto._ID)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.DATA)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.CATEGORIA)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.DESCRICAO)),

                cursor.getFloat(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.VALOR)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.LATIDUDE)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.LONGITUDE)),

                cursor.getString(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.LOCATION)),

                cursor.getInt(cursor.getColumnIndex(
                        DatabaseHelper.Gasto.GASTO_ID))
        );

        return gasto;
    }
}
