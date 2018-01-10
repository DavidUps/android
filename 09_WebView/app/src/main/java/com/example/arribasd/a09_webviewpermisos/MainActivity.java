package com.example.arribasd.a09_webviewpermisos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getActionBar().hide();
        getSupportActionBar().hide();
        WebView view = (WebView) findViewById(R.id.webView);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setBuiltInZoomControls(true);
        //view.setWebViewClient(new WebViewClient());



        view.loadUrl("http://videojuegosdosa.esy.es/");
    }
}
