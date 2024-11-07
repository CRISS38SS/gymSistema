package com.codepulse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlite {
    Producto pr=new Producto();
    private static final String URL="jdbc:sqlite:gymsistema.db";

    public void crearTablas(String sql){
        try (Connection conn=DriverManager.getConnection(URL);
             Statement st=conn.createStatement()){
                st.execute(sql);
        }catch (SQLException e) {
            System.out.println( e.getMessage());
        }
    }

    public void insertarProducto(String name, String barraCode, int cantidad){
        String sql="INSERT INTO producto (nombre, barraCode, cantidad) VALUES (?,?,?)";
        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, barraCode);
            ps.setInt(3, cantidad);
        
            ps.executeUpdate();
            System.out.println("se insertaron los productos");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertarUsuario(String name,String lastName, String email, String fprint, String subscription){
        String sql="INSERT INTO usuario (nombre,lastName,email,fprint,subscription) VALUES (?,?,?,?,?)";

        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, fprint);
            ps.setString(5, subscription);

            ps.executeUpdate();
            System.out.println("se insertaron los usuarios");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void AddCajero(String usuario, String contrasena, String email){
        String sql="INSERT INTO cajero (usuario, contrasena, email) VALUES (?,?,?)";
        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, contrasena);
            ps.setString(3, email);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
