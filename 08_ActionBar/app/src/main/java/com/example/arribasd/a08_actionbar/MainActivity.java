package com.example.arribasd.a08_actionbar;

import android.app.Fragment;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.arribasd.a08_actionbar.Fragments.DeleteFragment;
import com.example.arribasd.a08_actionbar.Fragments.ShareFragment;

public class MainActivity extends AppCompatActivity implements ShareFragment.OnFragmentInteractionListener, DeleteFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        android.support.v4.app.Fragment fragment = null;
        boolean fragmentSelected = false;
        switch (item.getItemId()){
            case R.id.item1:
                fragment = new ShareFragment();
                fragmentSelected = true;
                Toast.makeText(MainActivity.this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                fragment = new DeleteFragment();
                fragmentSelected = true;
                Toast.makeText(MainActivity.this, "Delete", Toast.LENGTH_SHORT).show();
        }
        if (fragmentSelected){
            getSupportFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
