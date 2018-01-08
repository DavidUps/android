package com.example.arribasd.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int num=0;
    String texto="";
    Boolean campo = false;
    private Intent chosser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void masBtn(View view)
    {
        num++;
        TextView cantidades =(TextView) findViewById(R.id.cantidadesCambiar);
        cantidades.setText("" + num);
    }

    public void menosBtn(View view)
    {
        num--;
        TextView cantidades =(TextView) findViewById(R.id.cantidadesCambiar);
        cantidades.setText("" + num);
    }

    /*public void cambiarCantidades()
    {
        TextView cantidades =(TextView) findViewById(R.id.cantidadesCambiar);
        cantidades.setText(num);
    }*/

    public void ordenPedido(View view)
    {
        campo = false;
        clear();
        EditText nombre = (EditText) findViewById(R.id.nombre);
        CheckBox checkAzucar = (CheckBox) findViewById(R.id.checkAzucar);
        CheckBox checkLeche = (CheckBox) findViewById(R.id.checkLeche);
        TextView precioTotal = (TextView) findViewById(R.id.precioTotal);

        if(!nombre.getText().toString().isEmpty())
        {
            texto = "Nombre: " + nombre.getText().toString();
            campo = true;
        }

        if(checkAzucar.isChecked() || checkLeche.isChecked())
        {
            texto += "\n" + getString(R.string.toppings);
            campo = true;
        }

        if(checkAzucar.isChecked())
        {
            texto += "\n \t" + checkAzucar.getText().toString();
        }

        if(checkLeche.isChecked())
        {
            texto += "\n \t" + checkLeche.getText().toString();
        }

        if(campo)
        {
            texto += "\n"+ "Quantity: " + num + "\n"    + "$" + (num * 2.5) + "\n" + getString(R.string.thank_you);
        }

        precioTotal.setText(texto);

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String to[]={"cafeteriapepe@gmail.com"};
        intent.putExtra(intent.EXTRA_EMAIL,to);
        intent.putExtra(intent.EXTRA_SUBJECT, "Pedido café: " + nombre.getText().toString());
        intent.putExtra(Intent.EXTRA_TEXT, texto);
        intent.setType("message/rfc822");
        chosser = Intent.createChooser(intent, "Enviar Email");
        startActivity(chosser);
    }

    public void clear()
    {
        texto ="$0";
        TextView precioTotal = (TextView) findViewById(R.id.precioTotal);
        precioTotal.setText(texto);
    }

    public void ventana(View view)
    {
        Intent intent = null, choser = null;

        Button madrid = (Button) findViewById(R.id.madrid);
        if(view.getId() == R.id.madrid)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:40.4167,-3.70325 "));
            chosser = Intent.createChooser(intent,"Launch maps");
            startActivity(chosser);
        }

        if(view.getId()== R.id.youTube)
        {
            intent = new Intent(intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.youtube.com/?gl=ES&hl=es.com"));
            chosser = Intent.createChooser(intent, "Launch YouTube");
            startActivity(chosser);


        }
    }

}


