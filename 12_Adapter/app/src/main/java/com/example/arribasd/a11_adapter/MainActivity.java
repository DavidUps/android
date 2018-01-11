package com.example.arribasd.a11_adapter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListAdapter adapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PersonaClase> personas = new ArrayList<>();

        personas.add(new PersonaClase("David", "Arribas"));
        personas.add(new PersonaClase("Paco", "Gonzalez"));
        personas.add(new PersonaClase("Andres", "Gomez"));
        personas.add(new PersonaClase("Geremias", "Bose"));
        personas.add(new PersonaClase("Matias", "Perez"));
        personas.add(new PersonaClase("Ana", "Canalejo"));
        personas.add(new PersonaClase("Esther", "Aguado"));
        personas.add(new PersonaClase("Carmen", "Gordon"));
        personas.add(new PersonaClase("Raquel", "Aguado"));
        personas.add(new PersonaClase("Angel", "Segovia"));
        personas.add(new PersonaClase("Raul", "Arribas"));

        adapter = new Adapter(this, personas);
        listView = (ListView) findViewById(R.id.list_main);
        listView.setAdapter(adapter);

    }
}
