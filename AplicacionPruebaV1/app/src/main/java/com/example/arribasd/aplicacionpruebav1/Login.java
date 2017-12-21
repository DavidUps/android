package com.example.arribasd.aplicacionpruebav1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //No mostrar la acction bar.

        getSupportActionBar().hide();
    }

    public void onClickEntrar(View view){

        EditText usuario = (EditText) findViewById(R.id.usuario);
        EditText contraseña = (EditText) findViewById(R.id.contraseña);
        //Toast.makeText(view.getContext(),"Usuario o Contraseña incorrectos", Toast.LENGTH_LONG).show();

        if (usuario.getText().toString().equals("david") && contraseña.getText().toString().equals("1234")){
            Intent usuarioIntent = new Intent(Login.this, Main.class);
            startActivity(usuarioIntent);
        }else
            Toast.makeText(view.getContext(),"Usuario o Contraseña incorrectos", Toast.LENGTH_LONG).show();

    }
}
