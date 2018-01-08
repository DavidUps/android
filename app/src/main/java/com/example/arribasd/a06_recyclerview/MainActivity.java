package com.example.arribasd.a06_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Crear la misma lista
    ArrayList<String> listDatos;

    //Generar referencia al recycler
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler_id);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        listDatos = new ArrayList<String>();
        for(int i=0; i<50; i++){
            listDatos.add("Dato numero: " + i);
        }

        //le enviamos la lista
        RecyclerAdapter adapter = new RecyclerAdapter(listDatos);
        recycler.setAdapter(adapter);
    }
}
