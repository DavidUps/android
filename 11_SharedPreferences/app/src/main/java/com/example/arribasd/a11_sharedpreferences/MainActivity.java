package com.example.arribasd.a11_sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Context context = this;

    EditText editText = null;
    Button guardarBtn = null;
    Button mostrarBtn = null;
    TextView mostrarText = null;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.eDato);
        guardarBtn = (Button) findViewById(R.id.guardarBtn);
        mostrarBtn = (Button) findViewById(R.id.mostrarBtn);
        mostrarText = (TextView) findViewById(R.id.mostrarTextView);

        //Guardar
        guardarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getPreferences(context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Serie", editText.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this, "Se ha guardado", Toast.LENGTH_SHORT).show();
            }
        });

        //Mostrar
        mostrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getPreferences(context.MODE_PRIVATE);
                String valor = sharedPreferences.getString("Serie", "No hay dato");
                mostrarText.setText(valor);
            }
        });
    }
}
