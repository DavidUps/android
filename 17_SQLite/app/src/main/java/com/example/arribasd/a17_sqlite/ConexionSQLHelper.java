package com.example.arribasd.a17_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

import java.sql.SQLClientInfoException;

/**
 * Created by ArribasD on 1/15/2018.
 */

public class ConexionSQLHelper extends SQLiteOpenHelper {



    public ConexionSQLHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Creamos los Scipts
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creamos la tabla usuario
        db.execSQL(Utilidades.CREATE_TABLA_USUARIO);
    }

    //Refrescamos los Scripts
    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {
        //Si hay una tabla Usuarios, nos la borre y luego le pasemos la base de datos al onCreate
        db.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIO);
        onCreate(db);
    }
}
