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
    Button button = null;
    private Intent chosser;
    private final int REQUEST_CODE_IMAGE = 1;
    private final int REQUEST_CODE_EMAIL = 2;
    Uri uri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la AcctionBar
        getSupportActionBar().hide();

        imageView = (ImageView) findViewById(R.id.selectImg);
        button = (Button) findViewById(R.id.saveBtn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/jpg");
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(intent.EXTRA_EMAIL,"Gabriel.ArroyoPajares@unisys.com");
                intent.putExtra(intent.EXTRA_SUBJECT, "Hola Gabi XDDD: ");
                intent.putExtra(Intent.EXTRA_TEXT, "Te envio esta imagen desde mi app del movil, como ola la mola");
                intent.setType("message/rfc822");
                chosser = Intent.createChooser(intent, "Enviar Email");
                intent.putExtra(intent.EXTRA_STREAM, uri);
                startActivity(chosser);

            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_IMAGE){
                uri = data.getData();
                imageView.setImageURI(uri);
            }else{
                Toast.makeText(MainActivity.this,"Compruebe la imagen", Toast.LENGTH_LONG).show();
            }
            if(requestCode == REQUEST_CODE_EMAIL){
                Toast.makeText(MainActivity.this, "YEII mensage enviado", Toast.LENGTH_LONG).show();
            }
        }
    }


}
