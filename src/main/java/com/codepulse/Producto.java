package com.codepulse;

public class Producto {
    private String name;
    private String barCode;
    private int cantidad;
    
    public Producto(String name, String barCode, int cantidad) {
        this.name = name;
        this.barCode = barCode;
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

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
}
