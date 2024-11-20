package com.codepulse;

public class Producto {
    private String name;
    private int precio;
    private int cantidad;
    
    public Producto(String name, int precio, int cantidad) {
        this.name = name;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Producto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }



    
}
