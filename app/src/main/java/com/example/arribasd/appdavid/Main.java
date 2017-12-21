package com.example.arribasd.appdavid;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.arribasd.appdavid.Adapter.Lista;
import com.example.arribasd.appdavid.Fragments.ListFragment;
import com.example.arribasd.appdavid.Fragments.ProfileFragment;

import java.util.ArrayList;

public class Main extends AppCompatActivity {

    public static ArrayList<Lista> lista = new ArrayList<>();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    //Code of fragment

                    setTitle("Profile");
                    ProfileFragment fragment = new ProfileFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.add(R.id.fragmentMain, fragment, "Fragment name");
                    fragmentTransaction.commit();
                    return true;

                case R.id.navigation_dashboard:

                    //Code of fragment

                    ListFragment fragmentList = new ListFragment();
                    android.support.v4.app.FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.add(R.id.fragmentMain, fragmentList, "Fragment Name");
                    fragmentTransaction2.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getSupportActionBar().hide();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ProfileFragment fragment = new ProfileFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentMain, fragment, "Fragment name");
        fragmentTransaction.commit();

        lista.add(new Lista("david","dadad", Uri.EMPTY));

    }

}
