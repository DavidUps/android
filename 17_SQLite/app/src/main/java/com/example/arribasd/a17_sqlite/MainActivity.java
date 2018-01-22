package com.example.arribasd.a17_sqlite;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arribasd.a17_sqlite.Activitys.Consultar;
import com.example.arribasd.a17_sqlite.Activitys.ConsultarList;
import com.example.arribasd.a17_sqlite.Activitys.ConsultarSpinner;
import com.example.arribasd.a17_sqlite.Activitys.Registro;
import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    ConexionSQLHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creamos la base de datos
        conexion = new ConexionSQLHelper(this, "db_usuarios", null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.registrarBtn:
                Intent registrar = new Intent(MainActivity.this, Registro.class);
                startActivity(registrar);
                break;
            case R.id.consultarBtn:
                Intent consultar = new Intent(MainActivity.this, Consultar.class);
                startActivity(consultar);
                break;
            case R.id.consultarSpinnerBtn:
                Intent consultarSpinner = new Intent(MainActivity.this, ConsultarSpinner.class);
                startActivity(consultarSpinner);
                break;
            case R.id.consultarListViewBtn:
                Intent consultarListView = new Intent(MainActivity.this, ConsultarList.class);
                startActivity(consultarListView);
                break;
        }
    }
}
