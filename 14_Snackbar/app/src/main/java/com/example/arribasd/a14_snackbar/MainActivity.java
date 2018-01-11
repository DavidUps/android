package com.example.arribasd.a14_snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Snackbar.make(view,"Hola soy tu mensage", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                //mySnackbar.setAction(R.string.undo_string, new MyUndoListener());
                //mySnackbar.show();
            }


        });
    }
}
