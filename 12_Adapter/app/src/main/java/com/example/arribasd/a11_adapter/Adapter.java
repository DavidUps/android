package com.example.arribasd.a11_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArribasD on 1/11/2018.
 */

public class Adapter extends ArrayAdapter<PersonaClase> {

    public Adapter(@NonNull Context context, @NonNull ArrayList<PersonaClase> objects) {
        super(context,0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        //Si la visto no esta cargada, carga la vista con el Layout de adapter
        if(view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.adapter,parent, false);
        }
        //Se cojen la lista
        PersonaClase persona = getItem(position);
        //Se va cargando cada item con la clase
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        nombre.setText(persona.getNombre());

        TextView apellido = (TextView) view.findViewById(R.id.apellido);
        apellido.setText(persona.getApellido());

        return view;
    }
}
