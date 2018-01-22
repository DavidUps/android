package com.example.arribasd.a17_sqlite.Utilidades;

/**
 * Created by ArribasD on 1/15/2018.
 */

public class Utilidades {

    public static final String TABLA_USUARIO = "Usuario";
    public static final String CAMPO_ID = "id";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";
    //CREATE TABLE usuario (id INTEGER PRIMARY KEY, nombre TEXT NOT NULL, telefono TEXT NOT NULL);
    public static final String CREATE_TABLA_USUARIO = "CREATE TABLE " + TABLA_USUARIO + " (" + CAMPO_ID +" INTEGER PRIMARY KEY, "+CAMPO_NOMBRE+" TEXT NOT NULL, "+CAMPO_TELEFONO+" TEXT NOT NULL)";
}
