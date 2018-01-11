package com.example.arribasd.a13_recyclerview;

/**
 * Created by ArribasD on 1/11/2018.
 */

public class Person {
    private String nombre;
    private String apellido;

    public Person(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
