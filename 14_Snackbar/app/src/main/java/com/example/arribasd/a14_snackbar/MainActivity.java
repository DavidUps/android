package com.example.arribasd.a14_snackbar;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button menssage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menssage = (Button) findViewById(R.id.menssage);

        menssage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Mensaje que se pone", Snackbar.LENGTH_LONG)
                        .setActionTextColor(Color.CYAN)
                        .setAction("Nombre del Boton", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"Hola has pulsado",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }


        });
    }
}
