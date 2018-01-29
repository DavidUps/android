package com.example.arribasd.a18_sqliteserver.Activitis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.arribasd.a18_sqliteserver.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.registry:
                Intent registry = new Intent(MainActivity.this, Registry.class);
                startActivity(registry);
                break;
            case R.id.showUser:
                Intent showUser = new Intent(MainActivity.this, ShowUser.class);
                startActivity(showUser);
                break;
        }
    }
}
