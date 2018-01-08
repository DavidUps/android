package com.example.arribasd.a06_recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ArribasD on 08-Jan-18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderRecycler> {
    //Creamos la refencia a lo que se va a mostrar, en este caso como es una String un ArrayList.

    ArrayList<String> listDatos;

    //Creamos el constructor
    public RecyclerAdapter(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    //Se va a encargar de enlazar el adaptador con el archivo XML
    @Override
    public ViewHolderRecycler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        return new ViewHolderRecycler(view);
    }

    //Enlaza el adaptador y nuestra clase viewHolderRecyler
    @Override
    public void onBindViewHolder(ViewHolderRecycler holder, int position) {

        holder.asignarDatos(listDatos.get(position));
    }
    //Devuelve el tamaño de la lista
    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    //1º Creamos la clase ViewHolderDatos
    public class ViewHolderRecycler extends RecyclerView.ViewHolder {
        //Le damos la referencia del dato del xml
        TextView dato;
        //Creamos el constructor
        public ViewHolderRecycler(View itemView) {
            super(itemView);
            //Se coge desde aquí
            dato = itemView.findViewById(R.id.datoID);
        }

        //Le decimos que coja el dato y lo asigne
        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
}
