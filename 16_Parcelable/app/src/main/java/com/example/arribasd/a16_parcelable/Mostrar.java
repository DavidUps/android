package com.example.arribasd.a16_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.arribasd.a16_parcelable.ClasePersona.Persona;

public class Mostrar extends AppCompatActivity {

    TextView nombreMostrar;
    TextView apellidoMostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar);

        nombreMostrar = (TextView) findViewById(R.id.nombreMostrar);
        apellidoMostrar = (TextView) findViewById(R.id.apellidoMostrar);

        Intent intent = this.getIntent();

        Persona persona = intent.getParcelableExtra("empleado");

        nombreMostrar.setText("Nombre: " + persona.getNombre());
        apellidoMostrar.setText("Apellido: " + persona.getApellido());
    }
}
