package com.example.arribasd.appdavid.Adapter;

import android.net.Uri;

/**
 * Created by ArribasD on 12/21/17.
 */

public class Lista {
    private String email;
    private String telephone;
    private Uri image;

    public Lista(String email, String telephone, Uri image){
        this.email = email;
        this.telephone = telephone;
        this.image = image;
    }

    public Lista(){
        email = "";
        telephone = "";
        image = Uri.EMPTY;
    }

    public String getEmail(){
        return email;
    }

    public String getTelephone(){
        return telephone;
    }

    public Uri getImage(){
        return  image;
    }
}
