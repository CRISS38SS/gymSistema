package com.codepulse;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PuntoDeVentaUI extends JFrame {

    private JPanel backGround;
    private JPanel sidePanel;
    private JPanel mainPanel;
    private JPanel productOptionsPanel;
    private JPanel bottomPanel;

    private JButton btnAgregarProducto, btnQuitarProducto, btnFinalizarVenta,btnHistorial,btnRegresar,btnAgregarStock;
    private JLabel lblTotal, lblNombre;
    private JTable tableProductos;
    private JSpinner spinnerCantidad;
    private JComboBox<String> jcbBuscaProducto;
    private int suma;

    private CustomTableModel tableModel;

    public PuntoDeVentaUI(int id, String nombre) {
        setTitle("Sistema de Punto de Venta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        configurarBackGround();
        configurarSidePanel(id,nombre,tableModel);
        configurarMainPanel();
        configurarBottomPanel(id,suma);
    }

    private void configurarBackGround() {
        backGround = new JPanel(new BorderLayout());
        setContentPane(backGround);
    }

    private void configurarSidePanel(int id, String nombre, CustomTableModel tableModel) {
        sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);


        lblNombre=new JLabel(nombre);
        lblNombre.setFont(new Font("FreeSans", Font.BOLD, 30));
        gbc=new GridBagConstraints();
        gbc.gridy=0;
        sidePanel.add(lblNombre,gbc);

        btnQuitarProducto = new JButton("Quitar Producto");
        btnQuitarProducto.addActionListener(e->{
            restarCantidad(tableProductos,(CustomTableModel) tableProductos.getModel(),mainPanel);
        });
        btnQuitarProducto.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnQuitarProducto.setBackground(new Color(119, 118, 123));
		btnQuitarProducto.setForeground(new Color(255, 255, 255));
        gbc.gridy = 2;
        gbc.insets=new Insets(5, 0, 0, 0);
        sidePanel.add(btnQuitarProducto, gbc);

        if (id==1) {
            btnAgregarStock=new JButton("Agregar Stock");
            btnAgregarStock.addActionListener(e->{
                ExistenciaProducto producto=new ExistenciaProducto();
                producto.setVisible(true);
            });
            btnAgregarStock.setFont(new Font("FreeSans", Font.BOLD, 20));
            btnAgregarStock.setBackground(new Color(119, 118, 123));
            btnAgregarStock.setForeground(new Color(255, 255, 255));
            gbc=new GridBagConstraints();
            gbc.gridy=1;
            sidePanel.add(btnAgregarStock,gbc);
        }

        btnHistorial=new JButton("historial");
        btnHistorial.addActionListener(e->{
            mostrarHistorial();
        });
        btnHistorial.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnHistorial.setBackground(new Color(119, 118, 123));
		btnHistorial.setForeground(new Color(255, 255, 255));
        gbc.gridy=3;
        gbc.insets=new Insets(5, 0, 0, 0);
        sidePanel.add(btnHistorial,gbc);

        backGround.add(sidePanel, BorderLayout.WEST);
    }

    private void configurarMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(250, 250, 250));

        String[] columnNames = {"ID", "Producto", "Cantidad", "Precio", "Total"};
        Object[][] data={};
        tableModel = new CustomTableModel(data,columnNames);
        tableProductos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProductos);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        productOptionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        jcbBuscaProducto = new JComboBox<>();
        sqlite.inicializarComboBox(jcbBuscaProducto, "none");
        jcbBuscaProducto.setEditable(true);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        productOptionsPanel.add(new JLabel("Buscar Producto:"), gbc);
        gbc.gridx = 1;
        productOptionsPanel.add(jcbBuscaProducto, gbc);

        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        productOptionsPanel.add(new JLabel("Cantidad:"), gbc);

        gbc.gridx = 1;
        productOptionsPanel.add(spinnerCantidad, gbc);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(e->{
            //String prod=txtBuscarProducto.getText();
            sqlite.cargaDatosDeSql(jcbBuscaProducto);
            sqlite.buscarProductoDinamico(jcbBuscaProducto,tableProductos,spinnerCantidad);
            recalcularTotal();
        });
        btnAgregarProducto.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnAgregarProducto.setBackground(new Color(119, 118, 123));
		btnAgregarProducto.setForeground(new Color(255, 255, 255));
        gbc.gridx = 2;
        productOptionsPanel.add(btnAgregarProducto, gbc);

        mainPanel.add(productOptionsPanel, BorderLayout.NORTH);
        backGround.add(mainPanel, BorderLayout.CENTER);
    }

    private void configurarBottomPanel(int id,int suma) {
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(180, 180, 180));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 50));

        lblTotal = new JLabel("Total: "+suma);
        lblTotal.setFont(new Font("FreeSans", Font.BOLD, 30));
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(lblTotal, BorderLayout.CENTER);

        btnFinalizarVenta = new JButton("Finalizar Venta");
        btnFinalizarVenta.addActionListener(e->{
           String ven= sqlite.generarResumen(tableProductos);
            VtnConfirmaVta vta=new VtnConfirmaVta(ven,tableProductos);
            vta.setVisible(true);
        });
        btnFinalizarVenta.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnFinalizarVenta.setBackground(new Color(119, 118, 123));
		btnFinalizarVenta.setForeground(new Color(255, 255, 255));
        bottomPanel.add(btnFinalizarVenta, BorderLayout.EAST);

        btnRegresar=new JButton("Regresar");
        btnRegresar.addActionListener(e->{
            Principal principal=new Principal(id);
            principal.setVisible(true);
            this.dispose();
        });
        btnRegresar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnRegresar.setBackground(new Color(119, 118, 123));
		btnRegresar.setForeground(new Color(255, 255, 255));
        bottomPanel.add(btnRegresar,BorderLayout.WEST);
        backGround.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void mostrarHistorial() {
        JDialog historialDialog = new JDialog(this, "Historial de Ventas", true);
        historialDialog.setSize(600, 400);
        historialDialog.setLocationRelativeTo(this);

        String[] columnNames = {"ID Venta", "Fecha", "Total"};
        Object[][] data = {
                {"1", "2024-11-15", "$150.00"},
                {"2", "2024-11-14", "$220.00"},
                {"3", "2024-11-13", "$340.00"}
        };

        JTable tableHistorial = new JTable(new DefaultTableModel(data, columnNames));
        JScrollPane scrollPane = new JScrollPane(tableHistorial);

        historialDialog.add(scrollPane, BorderLayout.CENTER);
        historialDialog.setVisible(true);
    }

    private void recalcularTotal(){
        int columnIndice=4;
        suma=0;

        for (int fila = 0; fila < tableProductos.getRowCount(); fila++) {
            Object valor=tableProductos.getValueAt(fila, columnIndice);

            if (valor instanceof Number) {
                suma+=((Number) valor).intValue();
            }else{
                try {
                    suma+=Integer.parseInt(valor.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir el valor: "+valor);
                }
            }
        }
        lblTotal.setText("Total: "+suma);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PuntoDeVentaUI ui = new PuntoDeVentaUI(1,"Fin");
            ui.setVisible(true);
        });
    }

    public void restarCantidad(JTable table, CustomTableModel model, JComponent parent) {
        // Obtener fila seleccionada
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(parent, "Por favor, selecciona una fila primero.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Pedir la cantidad a restar
        String input = JOptionPane.showInputDialog(parent, "Ingresa la cantidad a restar:");
        if (input == null || input.trim().isEmpty()) {
            return; // Cancelar si no se ingresa nada
        }

        try {
            int cantidadARestar = Integer.parseInt(input);

            // Validar que no sea negativa
            if (cantidadARestar < 0) {
                JOptionPane.showMessageDialog(parent, "La cantidad a restar no puede ser negativa.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la cantidad actual
            int cantidadActual = (int) model.getValueAt(selectedRow, 2); // Columna 2 es "Cantidad"

            // Validar que no reste más de lo disponible
            if (cantidadARestar > cantidadActual) {
                JOptionPane.showMessageDialog(parent, "No puedes restar más de la cantidad disponible.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Actualizar la cantidad en el modelo
            int nuevaCantidad = cantidadActual-cantidadARestar;
            if (nuevaCantidad==0) {
                model.eliminarFila(selectedRow);
            }else{
                model.setValueAt(cantidadActual - cantidadARestar, selectedRow, 2);
                double precio =(double)model.getValueAt(selectedRow, 3);
                double nuevoTotal=nuevaCantidad * precio;
                model.setValueAt(nuevoTotal, selectedRow, 4);
            }

            recalcularTotal();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(parent, "Por favor, ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

// Clase personalizada para el modelo de la tabla
class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Deshabilitar la edición para todas las celdas
        return false;
    }

    public void eliminarFila(int fila) {
        if (fila >= 0 && fila < getRowCount()) {
            // Eliminar la fila del modelo
            removeRow(fila);
            fireTableRowsDeleted(fila, fila);
        }
    }
}
