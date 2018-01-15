package com.example.arribasd.a15_flavors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.activity_main);
        //modificamos el texto del textview
        TextView textView;
        textView = (TextView)findViewById(R.id.texto);
        textView.setText(FlavorClass.get());
    }
}
