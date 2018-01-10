package com.example.arribasd.cambiofondo;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView = null;
    private final int REQUEST_CODE_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la AcctionBar
        getSupportActionBar().hide();

        imageView = (ImageView) findViewById(R.id.selectImg);
        Button button = (Button) findViewById(R.id.saveBtn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/jpg");
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_IMAGE){
                Uri uri = data.getData();
                imageView.setImageURI(uri);
            }else{
                Toast.makeText(MainActivity.this,"Compruebe la imagen", Toast.LENGTH_LONG).show();
            }
        }
    }


}
