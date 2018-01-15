package com.example.arribasd.a16_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arribasd.a16_parcelable.ClasePersona.Persona;

public class MainActivity extends AppCompatActivity {

    EditText nombre;
    EditText apellido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        Button button = (Button) findViewById(R.id.mostrar);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Persona persona = new Persona(nombre.getText().toString(), apellido.getText().toString());

                Intent intent = new Intent(MainActivity.this, Mostrar.class);
                intent.putExtra("empleado",persona);
                startActivity(intent);
            }
        });

    }
}
