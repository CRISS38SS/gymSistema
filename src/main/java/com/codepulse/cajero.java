package com.codepulse;

public class cajero {
    private String usuario;
    private String contrasena;
    private String email;
    
    public cajero(String usuario, String contrasena, String email) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }

    public cajero() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
