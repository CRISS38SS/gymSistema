package com.codepulse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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

    public static void buscarProducto(String Producto,JTable tableProductos,JSpinner cantidadS) {
        String nombreProducto = Producto.trim();
        int cantidad=0;
        if (nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de producto para buscar.");
            return;
        }
        String sql="SELECT id, nombre, precio, cantidad FROM producto WHERE nombre LIKE ?";
        try (Connection con = DriverManager.getConnection(URL);
            PreparedStatement statement=con.prepareStatement(sql)) {

            statement.setString(1, "%" + nombreProducto + "%");
            ResultSet resultSet = statement.executeQuery();

            DefaultTableModel tableModel = (DefaultTableModel) tableProductos.getModel();
            //tableModel.setRowCount(0); // Limpiar la tabla

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                cantidad =(int)cantidadS.getValue();
                boolean productoEncontrado=false;

                for(int i=0; i<tableModel.getRowCount(); i++){
                    int idExistente=(int) tableModel.getValueAt(i, 0);
                    if (idExistente==id) {
                        int cantidadExistente=(int) tableModel.getValueAt(i, 2);
                        tableModel.setValueAt(cantidadExistente + cantidad, i, 2);

                        double totalExistente = (double) tableModel.getValueAt(i, 4);
                        tableModel.setValueAt(totalExistente + (cantidad * precio), i, 4); // Actualizar el total
                        productoEncontrado = true;
                        productoEncontrado=true;
                        break;
                    }
                }

                if (!productoEncontrado) {
                    double total=cantidad*precio;
                    tableModel.addRow(new Object[]{id, nombre, cantidad,precio,total});

                }
            }

            if (tableModel.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No se encontraron productos con ese nombre.");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
        }
    }

}
