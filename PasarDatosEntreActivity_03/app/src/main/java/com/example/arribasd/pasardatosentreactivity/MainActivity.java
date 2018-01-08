package com.example.arribasd.pasardatosentreactivity;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.arribasd.pasardatosentreactivity.Adapter.PersonAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person>persons;
    ListAdapter adapter;
    ListView listView;
    private static int REQUEST_CODE_ADD_PERSON = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        persons = new ArrayList<>();

        adapter = new PersonAdapter(this, persons);

        listView = (ListView) findViewById(R.id.list_main);

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addPerson = new Intent(MainActivity.this, AddPersonActivity.class);
                startActivityForResult(addPerson, REQUEST_CODE_ADD_PERSON);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(REQUEST_CODE_ADD_PERSON == requestCode && resultCode == Activity.RESULT_OK){
            Toast.makeText(getApplicationContext(), "Se han añadido", Toast.LENGTH_LONG).show();
            persons.add(new Person(data.getStringExtra("name"),data.getStringExtra("surname"),data.getStringExtra("email"),data.getStringExtra("telephone")));
            persons.add(new Person("hola", "no", "quiero", "funcionar"));
        }else{
            Toast.makeText(getApplicationContext(),"No se ha añadido a tu lista", Toast.LENGTH_SHORT).show();
        }
    }
}
