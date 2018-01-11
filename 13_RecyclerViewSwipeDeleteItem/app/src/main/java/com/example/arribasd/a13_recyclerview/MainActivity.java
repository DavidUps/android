package com.example.arribasd.a13_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.ListAdapter;

import java.util.ArrayList;

import me.rishabhkhanna.recyclerswipedrag.OnDragListener;
import me.rishabhkhanna.recyclerswipedrag.OnSwipeListener;
import me.rishabhkhanna.recyclerswipedrag.RecyclerHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Person> personas = new ArrayList<>();

        personas.add(new Person("David", "Arribas"));
        personas.add(new Person("Paco", "Gonzalez"));
        personas.add(new Person("Andres", "Gomez"));
        personas.add(new Person("Geremias", "Bose"));
        personas.add(new Person("Matias", "Perez"));
        personas.add(new Person("Ana", "Canalejo"));
        personas.add(new Person("Esther", "Aguado"));
        personas.add(new Person("Carmen", "Gordon"));
        personas.add(new Person("Raquel", "Aguado"));
        personas.add(new Person("Angel", "Segovia"));
        personas.add(new Person("Raul", "Arribas"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        AdapterPersonas adapterPersonas = new AdapterPersonas(personas);
        recyclerView.setAdapter(adapterPersonas);

        RecyclerHelper touchHelper = new RecyclerHelper<Person>(personas, (RecyclerView.Adapter) adapterPersonas);
        touchHelper.setRecyclerItemDragEnabled(true);
        touchHelper.setRecyclerItemSwipeEnabled(true);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        //  callback for recyclerview item dragged from one position to other
        touchHelper.setOnDragItemListener(new OnDragListener() {
            @Override
            public void onDragItemListener(int fromPosition, int toPosition) {
                Log.d("hola", "onDragItemListener: callback after dragging recycler view item");
            }
        });

        // callback for recyclerview item swiped left or right
        touchHelper.setOnSwipeItemListener(new OnSwipeListener() {
            @Override
            public void onSwipeItemListener() {
                Log.d("hola", "onSwipeItemListener: callback after swiping recycler view item");
            }
        });

    }

}
