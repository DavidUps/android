package com.example.arribasd.a10_permisosenruntime;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Permission;

public class MainActivity extends AppCompatActivity {

    Button concedio = null;
    Button cancelado = null;
    private final int REQUEST_LOCATION_CODE = 1;
    private final int REQUEST_RECORDINGAUDIO_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        concedio = (Button) findViewById(R.id.okPermision);
        cancelado = (Button) findViewById(R.id.cancelPermision);

        concedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermision(Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_LOCATION_CODE);
            }
        });

        cancelado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askPermision(Manifest.permission.RECORD_AUDIO, REQUEST_RECORDINGAUDIO_CODE);
            }
        });
    }

    private void askPermision(String permission, int requestCode){
        if(ContextCompat.checkSelfPermission(this, new String(permission)) != PackageManager.PERMISSION_GRANTED){
            //No tenemos permisos
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }else {
            Toast.makeText(MainActivity.this, "Los permisos funciona", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_LOCATION_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permisos de localizacion activos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Permisos de localizacion inactivos", Toast.LENGTH_SHORT).show();
                }
                break;
            case  REQUEST_RECORDINGAUDIO_CODE:
                if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(MainActivity.this, "Permisos de audio activos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Permisos de audio inactivos", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
