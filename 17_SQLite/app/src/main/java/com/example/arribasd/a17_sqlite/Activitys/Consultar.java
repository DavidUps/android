package com.example.arribasd.a17_sqlite.Activitys;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arribasd.a17_sqlite.ConexionSQLHelper;
import com.example.arribasd.a17_sqlite.R;
import com.example.arribasd.a17_sqlite.Utilidades.Utilidades;

public class Consultar extends AppCompatActivity {

    ConexionSQLHelper conexion;

    EditText consultarID;
    TextView consultarNombre, consultarTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        consultarID = (EditText) findViewById(R.id.consultaID);
        consultarNombre = (TextView) findViewById(R.id.consultaNombre);
        consultarTelefono = (TextView) findViewById(R.id.consultaTelefono);

        conexion = new ConexionSQLHelper(getApplicationContext(),"db_usuarios", null, 1);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.buscarBTN:
                consultar();
                break;
            case  R.id.actualizarBTN:
                break;
            case R.id.eliminarBTN:
                break;
        }
    }

    private void consultar() {
        SQLiteDatabase db = conexion.getReadableDatabase();
        String[] parametros = {consultarID.getText().toString()};
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};

        try {
            Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            consultarNombre.setText(cursor.getString(0));
            consultarTelefono.setText(cursor.getString(1));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El id no está asignado", Toast.LENGTH_SHORT).show();
            limpiar();
        }


    }

    private void limpiar() {
        consultarID.setText("");
        consultarNombre.setText("");
        consultarTelefono.setText("");
    }

}
