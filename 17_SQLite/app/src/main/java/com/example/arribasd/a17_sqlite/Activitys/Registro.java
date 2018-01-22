package com.example.arribasd.a17_sqlite.Activitys;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arribasd.a17_sqlite.ConexionSQLHelper;
import com.example.arribasd.a17_sqlite.R;
import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

public class Registro extends AppCompatActivity {

    ConexionSQLHelper conexion;

    EditText nombre, telefono;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = (EditText) findViewById(R.id.nombreInsertar);
        telefono = (EditText) findViewById(R.id.telefonoInsertar);
        button = (Button) findViewById(R.id.registrar);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //registrarUsuarios();
                registrarUsuariosSql();
            }
        });
    }


    private void registrarUsuariosSql() {
        conexion = new ConexionSQLHelper(this,"db_usuarios", null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        //INSERT INTO Usuario(nombre, telefono) VALUES('Nombre','telefono');
        String insert = "INSERT INTO "
                + Utilidades.TABLA_USUARIO
                + " ("
                + Utilidades.CAMPO_NOMBRE
                + ","
                + Utilidades.CAMPO_TELEFONO
                + ")"
                + " VALUES('"
                + nombre.getText().toString()
                + "','"
                + telefono.getText().toString()
                +"')";

        db.execSQL(insert);

        db.close();

        Toast.makeText(Registro.this, "Se ha añadido ", Toast.LENGTH_SHORT).show();

    }

    private void registrarUsuarios() {
        ConexionSQLHelper conexion = new ConexionSQLHelper(this,"db_usuarios", null, 1);

        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, nombre.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, nombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, telefono.getText().toString());

        Long nombreResultado = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_NOMBRE, values);

        Toast.makeText(Registro.this, "Se ha añadido " + nombreResultado, Toast.LENGTH_SHORT).show();
    }
}
