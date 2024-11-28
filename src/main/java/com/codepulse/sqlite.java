package com.codepulse;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
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

    public static void insertarProducto(String name, int cantidad, int precio ){
        String sql="INSERT INTO producto (nombre, cantidad, precio) VALUES (?,?,?)";
        try (Connection conn=DriverManager.getConnection(URL);
            PreparedStatement ps=conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setInt(2, cantidad);
            ps.setInt(3, precio);
        
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

    public static void registroAdmin(String nombre, String contrasena, String correo) {
        String sqlCheck = "SELECT COUNT(*) AS total FROM cajero";
        String sqlInsert = "INSERT INTO cajero (usuario, contrasena, email) VALUES (?, ?, ?)";
    
        try (Connection con = DriverManager.getConnection(URL);
             PreparedStatement psCheck = con.prepareStatement(sqlCheck)) {
    
            ResultSet rs = psCheck.executeQuery();
            if (rs.next() && rs.getInt("total") > 0) {
                JOptionPane.showMessageDialog(null, "Ya existe un administrador registrado.");
            } else {
                try (PreparedStatement psInsert = con.prepareStatement(sqlInsert)) {
                    psInsert.setString(1, nombre);
                    psInsert.setString(2, contrasena);
                    psInsert.setString(3, correo);
    
                    int row = psInsert.executeUpdate();
                    if (row > 0) {
                        JOptionPane.showMessageDialog(null, "Administrador registrado exitosamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el administrador.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al intentar registrar el administrador.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.");
        }
    }
    
    public static void cargaDatosDeSql(JComboBox<String> comboBox){
        List<String> allItems=loadItemsFromDatabase();
                allItems.forEach(comboBox::addItem);
        
                JTextField textField=(JTextField) comboBox.getEditor().getEditorComponent();
                textField.addKeyListener(new KeyAdapter(){
                    @Override
                    public void keyReleased(KeyEvent e){
                        String input =textField.getText();
                        comboBox.hidePopup();
        
                        comboBox.removeAllItems();
                        for (String item : allItems) {
                            if (item.toLowerCase().contains(input.toLowerCase())) {
                                comboBox.addItem(item);
                            }
                        }
                        comboBox.showPopup();
                        textField.setText(input);
                    }
                });
            }

    private static List<String> loadItemsFromDatabase(){
        List<String> items=new ArrayList<>();
        String query="SELECT nombre FROM producto";
        try (Connection con=DriverManager.getConnection(URL);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query)) {
            
            while (rs.next()) {
                items.add(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar los datos: "+e.getMessage());
        }
        return items;
    }

    public static void buscarProductoDinamico(JComboBox<String> comboBox, JTable tableProductos, JSpinner cantidadS) {
        String nombreProducto = ((JTextField) comboBox.getEditor().getEditorComponent()).getText().trim();
        //int cantidad = (int) cantidadS.getValue();
        int cantidad=0;

        if (nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de producto para buscar.");
            return;
        }
    
        String sql = "SELECT id, nombre, precio, cantidad FROM producto WHERE nombre LIKE ?";
        try (Connection con = DriverManager.getConnection(URL);
             PreparedStatement statement = con.prepareStatement(sql)) {
    
            statement.setString(1, nombreProducto);
            ResultSet resultSet = statement.executeQuery();
    
            DefaultTableModel tableModel = (DefaultTableModel) tableProductos.getModel();
    
            comboBox.removeAllItems();
    
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                double precio = resultSet.getDouble("precio");
                int stock = resultSet.getInt("cantidad");
                cantidad =(int)cantidadS.getValue();
                boolean productoEncontrado=false;
    
                // Agregar al comboBox las coincidencias encontradas
                comboBox.addItem(nombre);
    
                // Si no hay stock, mostrar mensaje
                if (stock <= 0) {
                    JOptionPane.showMessageDialog(null, "El producto '" + nombre + "' no tiene stock disponible.");
                    continue;
                }
                if (stock<cantidad) {
                    JOptionPane.showMessageDialog(null, "no se puede agregar la cantidad seleccionada es mayor al stock: "+stock);
                    continue;
                }
                // Verificar si el producto ya está en la tabla
                //boolean existeEnTabla = false;
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    int idExistente = (int) tableModel.getValueAt(i, 0);
                    if (idExistente == id) {
                        int cantidadExistente = (int) tableModel.getValueAt(i, 2);
                        int nuevaCantidad = cantidadExistente + cantidad;
    
                        // Verificar que la nueva cantidad no exceda el stock
                        if (nuevaCantidad > stock) {
                            JOptionPane.showMessageDialog(null, "No se puede agregar más cantidad. Stock disponible: " + stock);
                            return;
                        }
    
                        // Actualizar la cantidad y el total en la tabla
                        tableModel.setValueAt(nuevaCantidad, i, 2);
                        double totalExistente = (double) tableModel.getValueAt(i, 4);
                        tableModel.setValueAt(totalExistente + (cantidad * precio), i, 4);
                        productoEncontrado = true;
                        cantidadS.setValue(1);;
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
                comboBox.addItem("none");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al buscar el producto: " + e.getMessage());
        }
    }

    public static void inicializarComboBox(JComboBox<String> comboBox, String valorPredefinido) {
        String sql = "SELECT DISTINCT nombre FROM producto"; // Consulta para obtener todos los nombres de productos
        try (Connection con = DriverManager.getConnection(URL);
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
    
            comboBox.removeAllItems(); // Limpia los elementos existentes
            comboBox.addItem(valorPredefinido); // Agrega el valor predefinido
    
            while (resultSet.next()) {
                String nombreProducto = resultSet.getString("nombre");
                if (!nombreProducto.equals(valorPredefinido)) {
                    comboBox.addItem(nombreProducto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al inicializar el comboBox: " + e.getMessage());
        }
    }

    

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public static String generarResumen(JTable tableProductos) {
        StringBuilder resumen = new StringBuilder();
        
        // Recorremos todas las filas de la tabla
        for (int i = 0; i < tableProductos.getRowCount(); i++) {
            String nombre = tableProductos.getValueAt(i, 1).toString(); // Columna del nombre
            int cantidad = Integer.parseInt(tableProductos.getValueAt(i, 2).toString()); // Columna de la cantidad
            double total = Double.parseDouble(tableProductos.getValueAt(i, 4).toString()); // Columna del total
            
            // Agregamos los datos de la fila al resumen
            resumen.append("Nombre: ").append(nombre)
                   .append(", Cantidad: ").append(cantidad)
                   .append(", Total: ").append(total)
                   .append("\n");
        }
        
        return resumen.toString();
    }
    

    public static void rebajarCantidadBd(JTable tableProductos){
        DefaultTableModel tableModel=(DefaultTableModel)tableProductos.getModel();
        
        // Recorremos todas las filas de la tabla
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            int id=Integer.parseInt(tableProductos.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tableProductos.getValueAt(i, 2).toString()); // Columna de la cantidad

            String sql = "UPDATE producto " +
                   "SET cantidad = CASE " +
                   "WHEN cantidad - ? < 0 THEN 0 " +
                   "ELSE cantidad - ? " +
                   "END " +
                   "WHERE id = ?";    
                       
            try (Connection con=DriverManager.getConnection(URL);
            PreparedStatement ps =con.prepareStatement(sql)) {
            ps.setInt(1,cantidad);
            ps.setInt(2, cantidad);
            ps.setInt(3, id);

            int rowA=ps.executeUpdate();
            if (rowA>0) {
                System.out.println("Cantidad actualizada para el producto con ID: " + id);
            }else{
                System.out.println("No se encontró el producto con ID: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error al actualizar la cantidad del producto: " + e.getMessage());
        }

        tableModel.removeRow(i);
        }
    }
}
