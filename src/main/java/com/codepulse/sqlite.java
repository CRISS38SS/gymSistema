package com.codepulse;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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

    public static void insertarUsuario(String name, String lastName, String numero, String fprint, String subscription) {
        String sql = "INSERT INTO usuario (nombre, lastName, numero, fprint, subscription, fechaT) VALUES (?, ?, ?, ?, ?, ?)";
        
        LocalDateTime fechaInicio = LocalDateTime.now();
        LocalDateTime fechaTermino = calcularFechaTermino(fechaInicio, subscription);

        try (Connection conn = DriverManager.getConnection(URL);
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setString(3, numero);
            ps.setString(4, fprint);
            ps.setString(5, subscription);

            if (fechaTermino != null) {
                ps.setString(6, fechaTermino.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            } else {
                ps.setNull(6, java.sql.Types.TIMESTAMP);
            }

            ps.executeUpdate();
            System.out.println("Se insertaron los usuarios");
        } catch (SQLException e) {
            System.out.println("Error al insertar usuario: " + e.getMessage());
        }
    }

    private static LocalDateTime calcularFechaTermino(LocalDateTime fechaInicio, String subscription) {
        switch (subscription.toLowerCase()) {
            case "anual":
                return fechaInicio.plusYears(1);
            case "mensual":
                return fechaInicio.plusMonths(1);
            case "semanal":
                return fechaInicio.plusWeeks(1);
            case "día":
            case "visita":
                return fechaInicio.plusDays(1);
            default:
                System.out.println("Tipo de suscripción desconocido: " + subscription);
                return null;
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
        int cantidad=0;

        if (nombreProducto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese un nombre de producto para buscar.");
            comboBox.removeAllItems();
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
    
                comboBox.addItem(nombre);
    
                if (stock <= 0) {
                    JOptionPane.showMessageDialog(null, "El producto '" + nombre + "' no tiene stock disponible.");
                    continue;
                }
                if (stock<cantidad) {
                    JOptionPane.showMessageDialog(null, "no se puede agregar la cantidad seleccionada es mayor al stock: "+stock);
                    continue;
                }
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    int idExistente = (int) tableModel.getValueAt(i, 0);
                    if (idExistente == id) {
                        int cantidadExistente = (int) tableModel.getValueAt(i, 2);
                        int nuevaCantidad = cantidadExistente + cantidad;
    
                        if (nuevaCantidad > stock) {
                            JOptionPane.showMessageDialog(null, "No se puede agregar más cantidad. Stock disponible: " + stock);
                            return;
                        }
    
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
        String sql = "SELECT DISTINCT nombre FROM producto";
        try (Connection con = DriverManager.getConnection(URL);
             Statement statement = con.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
    
            comboBox.removeAllItems();
            comboBox.addItem(valorPredefinido);
    
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
        
        for (int i = 0; i < tableProductos.getRowCount(); i++) {
            String nombre = tableProductos.getValueAt(i, 1).toString(); // Columna del nombre
            int cantidad = Integer.parseInt(tableProductos.getValueAt(i, 2).toString()); // Columna de la cantidad
            double total = Double.parseDouble(tableProductos.getValueAt(i, 4).toString()); // Columna del total
            
            resumen.append("Nombre: ").append(nombre)
                   .append(", Cantidad: ").append(cantidad)
                   .append(", Total: ").append(total)
                   .append("\n");
        }
        
        return resumen.toString();
    }
    

    public static void rebajarCantidadBd(JTable tableProductos){
        DefaultTableModel tableModel=(DefaultTableModel)tableProductos.getModel();
        
        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            int id=Integer.parseInt(tableProductos.getValueAt(i, 0).toString());
            int cantidad = Integer.parseInt(tableProductos.getValueAt(i, 2).toString());

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
        
    public static void cargarUsuariosDesdeBD(JTable jttableUsuario) {
        try (Connection conn = DriverManager.getConnection(URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM usuario")) {
            
            DefaultTableModel model = (DefaultTableModel) jttableUsuario.getModel();
            model.setRowCount(0);

            Date fechaActual =new Date();
            
            while (rs.next()) {
                Object[] row = new Object[6];

                row[0] = rs.getInt("idUsua");
                row[1] = rs.getString("nombre") + " " + rs.getString("lastName");
                row[2] = rs.getString("subscription");

                String fechaIString = rs.getString("fechaI");
                String fechaTString = rs.getString("fechaT");

                try {
                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.forLanguageTag("es-ES"));
                    Date fechaI = inputFormat.parse(fechaIString);
                    Date fechaT = null;
                    if (fechaTString != null) {
                        fechaT = inputFormat.parse(fechaTString);
                    }

                    SimpleDateFormat outputFormat = new SimpleDateFormat("d 'de' MMMM 'del' yyyy", Locale.forLanguageTag("es-ES"));
                    row[3] = outputFormat.format(fechaI);
                    row[4] = (fechaT != null) ? outputFormat.format(fechaT) : "";

                    if (fechaT == null || fechaT.after(fechaActual)) {
                        row[5] = "Sí"; 
                    } else {
                        row[5] = "No"; 
                    }
                } catch (ParseException e) {
                    row[3] = fechaIString;
                    row[4] = fechaTString;
                }
                model.addRow(row);
            }

            // Ajustar el tamaño de la columna "ID"
            TableColumn idColumn = jttableUsuario.getColumnModel().getColumn(0); // 0 es el índice de la columna "ID"
            idColumn.setPreferredWidth(1); // Ajusta el ancho de la columna "ID"

            // Ajustar otras columnas si es necesario
            TableColumn nombreColumn = jttableUsuario.getColumnModel().getColumn(1); // 1 es el índice de la columna "Nombre"
            nombreColumn.setPreferredWidth(50); // Ajusta el ancho de la columna de nombre

            TableColumn tipoColumn = jttableUsuario.getColumnModel().getColumn(2); // 1 es el índice de la columna "Nombre"
            tipoColumn.setPreferredWidth(30); 


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
