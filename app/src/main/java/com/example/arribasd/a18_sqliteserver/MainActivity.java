package com.example.arribasd.a18_sqliteserver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.arribasd.a18_sqliteserver.Activitys.Registry;
import com.example.arribasd.a18_sqliteserver.Activitys.ShowUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.regisrty:
                Intent registry = new Intent(MainActivity.this, Registry.class);
                startActivity(registry);
                break;
            case R.id.show:
                Intent show = new Intent(MainActivity.this, ShowUser.class);
                startActivity(show);
                break;
        }
    }
}
