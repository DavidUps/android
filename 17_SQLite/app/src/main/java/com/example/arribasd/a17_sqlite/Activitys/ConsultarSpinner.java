package com.example.arribasd.a17_sqlite.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.arribasd.a17_sqlite.ConexionSQLHelper;
import com.example.arribasd.a17_sqlite.Entidades.Usuario;
import com.example.arribasd.a17_sqlite.R;
import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarSpinner extends AppCompatActivity {

    Spinner comboPersonas;
    TextView id,nombre,telefono;
    ArrayList<String> listaPersonas;
    ArrayList<Usuario> listaUsuarios;
    ConexionSQLHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_spinner);

        comboPersonas = (Spinner) findViewById(R.id.comboPersonas);
        id = (TextView) findViewById(R.id.spinnerID);
        nombre = (TextView) findViewById(R.id.spinnerNombre);
        telefono = (TextView) findViewById(R.id.spinnerTelefono);

        conexion = new ConexionSQLHelper(getApplicationContext(), "db_usuarios", null, 1);

        consultarListaPersonas();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, listaPersonas);
        comboPersonas.setAdapter(adapter);

        comboPersonas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id1) {

                if(position != 0) {
                    id.setText("ID " + listaUsuarios.get(position -1).getId().toString());
                    nombre.setText("Nombre " + listaUsuarios.get(position -1).getNombre());
                    telefono.setText("Telefono " + listaUsuarios.get(position -1).getTelefono());
                }else {
                    id.setText("ID");
                    nombre.setText("Nombre");
                    telefono.setText("Telefono");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void consultarListaPersonas() {
        //Tener acceso a nuestra tabla
        SQLiteDatabase db = conexion.getReadableDatabase();

        Usuario persona;

        persona = null;

        listaUsuarios = new ArrayList<Usuario>();
        //SELECT * FROM usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()){
            persona = new Usuario();
            persona.setId(cursor.getInt(0));
            persona.setNombre(cursor.getString(1));
            persona.setTelefono(cursor.getString(2));

            listaUsuarios.add(persona);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaPersonas = new ArrayList<String>();
        listaPersonas.add("Seleccione");

        for(int i=0;i<listaUsuarios.size(); i++){
            listaPersonas.add(listaUsuarios.get(i).getId() + " - " + listaUsuarios.get(i).getNombre());
        }
    }
}
