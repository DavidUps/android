package com.example.arribasd.appdavid.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arribasd.appdavid.R;

import java.util.ArrayList;

/**
 * Created by ArribasD on 12/21/17.
 */

public class ListaAdapter extends ArrayAdapter<Lista> {


    private ArrayList<Lista> lista;

    public ListaAdapter(Activity context, ArrayList<Lista> listas) {
        super(context,0,listas);
        lista = listas;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);
        }

        Lista user = lista.get(position);

        TextView email = (TextView) listItemView.findViewById(R.id.emailAdapter);
        email.setText(user.getEmail());

        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        image.setImageURI(user.getImage());

        TextView telephone = (TextView) listItemView.findViewById(R.id.telephoneAdapter);
        telephone.setText(user.getTelephone());



        return listItemView;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
