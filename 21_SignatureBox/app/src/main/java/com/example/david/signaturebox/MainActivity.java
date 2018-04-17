package com.example.david.signaturebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kyanogen.signatureview.SignatureView;

public class MainActivity extends AppCompatActivity {

    Button send,btnClear;
    SignatureView signatureView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signatureView   = findViewById(R.id.signature_view);
        btnClear        = findViewById(R.id.btnClear);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signatureView.clearCanvas();
            }
        });
    }
}
