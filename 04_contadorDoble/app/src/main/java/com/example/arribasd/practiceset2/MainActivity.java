package com.example.arribasd.practiceset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int numA=0,
        numB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tresPuntosA(View view)
    {
        numA+=3;
        TextView contadorA = (TextView) findViewById(R.id.countTeamA);
        String textoContadorA = String.valueOf(numA);
        contadorA.setText(textoContadorA);
    }

    public void dosPuntosA(View view)
    {
        numA+=2;
        TextView contadorA = (TextView) findViewById(R.id.countTeamA);
        String textoContadorA = String.valueOf(numA);
        contadorA.setText(textoContadorA);
    }

    public void freeA(View view)
    {
        numA+=1;
        TextView contadorA = (TextView) findViewById(R.id.countTeamA);
        String textoContadorA = String.valueOf(numA);
        contadorA.setText(textoContadorA);
    }

    public void tresPuntosB(View view)
    {
        numB+=3;
        TextView contadorA = (TextView) findViewById(R.id.countTeamB);
        String textoContador = String.valueOf(numB);
        contadorA.setText(textoContador);
    }

    public void dosPuntosB(View view)
    {
        numB+=2;
        TextView contadorA = (TextView) findViewById(R.id.countTeamB);
        String textoContador = String.valueOf(numB);
        contadorA.setText(textoContador);
    }

    public void freeB(View view)
    {
        numB+=1;
        TextView contadorA = (TextView) findViewById(R.id.countTeamB);
        String textoContadorA = String.valueOf(numB);
        contadorA.setText(textoContadorA);
    }

    public void reset(View view)
    {
        numA=0;
        numB=0;
        TextView contadorA = (TextView) findViewById(R.id.countTeamA);
        TextView contadorB = (TextView) findViewById(R.id.countTeamB);
        contadorA.setText("0");
        contadorB.setText("0");
    }
}
