package com.example.arribasd.a17_sqlite.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.arribasd.a17_sqlite.ConexionSQLHelper;
import com.example.arribasd.a17_sqlite.Entidades.Usuario;
import com.example.arribasd.a17_sqlite.R;
import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultarList extends AppCompatActivity {

    ListView listView;

    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuario;

    ConexionSQLHelper conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_list);

        listView = (ListView) findViewById(R.id.listView);

        conexion = new ConexionSQLHelper(getApplicationContext(), "db_usuarios", null,1);

        consularListaPersonas();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion);
        listView.setAdapter(adapter);
    }

    private void consularListaPersonas() {
        SQLiteDatabase db = conexion.getReadableDatabase();

        Usuario usuario = null;

        listaUsuario = new ArrayList<Usuario>();

        //SELECT * FROM usuarios

        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);

        while(cursor.moveToNext()){

            usuario = new Usuario();

            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuario.add(usuario);

            obtenerLista();
        }
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for(int i=0; i<listaUsuario.size(); i++){
            listaInformacion.add(listaUsuario.get(i).getId().toString() +"\n" +
                                listaUsuario.get(i).getNombre() + "\n" +
                                listaUsuario.get(i).getTelefono());
        }

    }
}
