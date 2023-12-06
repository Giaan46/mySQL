package com.tarea;

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private double peso;

    public Producto() {
    }

    public Producto(String producto, double precio, double peso) {
        this.id = id;
        this.nombre = producto;
        this.precio = precio;
        this.peso = peso;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }


}
