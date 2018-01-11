package com.example.arribasd.a11_adapter;

/**
 * Created by ArribasD on 1/11/2018.
 */

public class PersonaClase {
    private String Nombre;
    private String Apellido;

    public PersonaClase(String nombre, String apellido) {
        Nombre = nombre;
        Apellido = apellido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }
}
