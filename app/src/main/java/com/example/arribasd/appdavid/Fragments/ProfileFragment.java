package com.example.arribasd.appdavid.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.arribasd.appdavid.Adapter.Lista;
import com.example.arribasd.appdavid.Main;
import com.example.arribasd.appdavid.R;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {



    public ProfileFragment() {
        // Required empty public constructor
    }


    ImageView imagen;
    Uri path;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Coger la imagen
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        imagen = (ImageView) view.findViewById(R.id.profileImageView);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                intent.setType("image/");
                startActivityForResult(intent, 0);
            }
        });

        //Coger los datos y mandarlos al ArrayList

        final EditText email = (EditText) view.findViewById(R.id.emailText);
        final EditText telephone = (EditText) view.findViewById(R.id.telephoneText);

        Button save = (Button) view.findViewById(R.id.saveBtn);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Main.lista.add(new Lista(email.getText().toString(),telephone.getText().toString(),path));
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            path=data.getData();
            imagen.setImageURI(path);
        }
    }
}
