package com.example.arribasd.pasardatosentreactivity.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.arribasd.pasardatosentreactivity.Person;
import com.example.arribasd.pasardatosentreactivity.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ArribasD on 03-Jan-18.
 */

public class PersonAdapter extends ArrayAdapter<Person> {

    public PersonAdapter(Activity context, ArrayList<Person> person) {
        super(context,0, person);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListItemView = convertView;

        if (ListItemView == null){
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.person_list,parent,false);
        }

        Person person = getItem(position);

        TextView name = (TextView) ListItemView.findViewById(R.id.adapterName);
        name.setText(person.getName());

        TextView surname = (TextView) ListItemView.findViewById(R.id.adapterSurname);
        surname.setText(person.getSurname());

        TextView email = (TextView) ListItemView.findViewById(R.id.adapterEmail);
        email.setText(person.getEmail());

        TextView telephone = (TextView) ListItemView.findViewById(R.id.adapterTelephone);
        telephone.setText(person.getTelephone());

        return ListItemView;
    }
}
