package com.example.arribasd.a13_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArribasD on 1/11/2018.
 */

public class AdapterPersonas extends RecyclerView.Adapter<AdapterPersonas.ViewHolderDatos> {

    private ArrayList<Person> people;

    public AdapterPersonas(ArrayList<Person> people) {
        this.people = people;
    }

    //Enlaza el adaptador con el layout Item_list
    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderDatos holder, int position) {
        Person person = people.get(position);
        holder.nombre.setText(person.getNombre());
        holder.apellido.setText(person.getApellido());
    }

    @Override
    public int getItemCount() {

        return people.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView nombre;
        TextView apellido;

        public ViewHolderDatos(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.nombreAdapter);
            apellido = (TextView) itemView.findViewById(R.id.apellidoAdapter);
        }
    }
}
