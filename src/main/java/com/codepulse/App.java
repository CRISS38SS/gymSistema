package com.codepulse;

public class App {
    public static void main(String[] args) {
        // Crear instancia de la clase sqlite
        sqlite db = new sqlite();

        // SQL para crear la tabla de productos
        String createProductoTable = "CREATE TABLE IF NOT EXISTS producto ("
                + "idProd INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "barraCode TEXT NOT NULL,"
                + "cantidad INTEGER NOT NULL"
                + ");";
        db.crearTablas(createProductoTable);
        System.out.println("Tabla 'producto' creada.");

        // SQL para crear la tabla de usuarios
        String createUsuarioTable = "CREATE TABLE IF NOT EXISTS usuario ("
                + "idUsua INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "nombre TEXT NOT NULL,"
                + "lastName TEXT NOT NULL,"
                + "email TEXT NOT NULL,"
                + "fprint TEXT NOT NULL,"
                + "subscription TEXT NOT NULL"
                + ");";
        db.crearTablas(createUsuarioTable);
        System.out.println("Tabla 'usuario' creada.");

        String createCajeroTable = "CREATE TABLE IF NOT EXISTS cajero ("
        + "idCajero INTEGER PRIMARY KEY AUTOINCREMENT, "
        + "usuario TEXT NOT NULL, "
        + "contrasena TEXT NOT NULL, "
        + "email TEXT NOT NULL"
        + ");";
        db.crearTablas(createCajeroTable);
        System.out.println("se creo la tabla cajero");

        // Iniciar la ventana de inicio de sesión
        InicioSesion is = new InicioSesion();
        is.setVisible(true);
    }
}
