package com.codepulse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

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

    public void insertarProducto(String name, int cantidad ){
        String sql="INSERT INTO producto (nombre, cantidad) VALUES (?,?)";
        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, cantidad);
        
            ps.executeUpdate();
            System.out.println("se insertaron los productos");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertarUsuario(String name,String lastName, String numero, String fprint, String subscription){
        String sql="INSERT INTO usuario (nombre,lastName,numero,fprint,subscription) VALUES (?,?,?,?,?)";

        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setString(3, numero);
            ps.setString(4, fprint);
            ps.setString(5, subscription);

            ps.executeUpdate();
            System.out.println("se insertaron los usuarios");
        } catch (SQLException e) {
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

    public static String obtenerNombre(int id){
        String sql="SELECT usuario FROM cajero WHERE idCajero=?";
        try (Connection con=DriverManager.getConnection(URL);
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                String nombre=rs.getString("usuario");
                return nombre;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return null;
    }
}
