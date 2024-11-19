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
    private JTextField txtBuscarProducto;
    private JLabel lblTotal;
    private JTable tableProductos;
    private JSpinner spinnerCantidad;

    public PuntoDeVentaUI(int id, String nombre) {
        setTitle("Sistema de Punto de Venta");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        configurarBackGround();
        configurarSidePanel(id);
        configurarMainPanel();
        configurarBottomPanel(id);

        JOptionPane.showMessageDialog(null,nombre);
    }

    private void configurarBackGround() {
        backGround = new JPanel(new BorderLayout());
        setContentPane(backGround);
    }

    private void configurarSidePanel(int id) {
        sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        btnQuitarProducto = new JButton("Quitar Producto");
        gbc.gridy = 1;
        sidePanel.add(btnQuitarProducto, gbc);

        if (id==1) {
            btnAgregarStock=new JButton("Agregar Stock");
            btnAgregarStock.addActionListener(e->{

            });
            gbc=new GridBagConstraints();
            gbc.gridy=0;
            sidePanel.add(btnAgregarStock,gbc);
        }

        btnHistorial=new JButton("historial");
        btnHistorial.addActionListener(e->{
            mostrarHistorial();
        });
        gbc.gridy=2;
        sidePanel.add(btnHistorial,gbc);

        backGround.add(sidePanel, BorderLayout.WEST);
    }

    private void configurarMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(250, 250, 250));

        String[] columnNames = {"ID", "Producto", "Cantidad", "Precio", "Total"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        tableProductos = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableProductos);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        productOptionsPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        txtBuscarProducto = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        productOptionsPanel.add(new JLabel("Buscar Producto:"), gbc);

        gbc.gridx = 1;
        productOptionsPanel.add(txtBuscarProducto, gbc);

        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        productOptionsPanel.add(new JLabel("Cantidad:"), gbc);

        gbc.gridx = 1;
        productOptionsPanel.add(spinnerCantidad, gbc);

        btnAgregarProducto = new JButton("Agregar Producto");
        btnAgregarProducto.addActionListener(e->{
            String prod=txtBuscarProducto.getText();
            sqlite.buscarProducto(prod,tableProductos,spinnerCantidad);
        });
        gbc.gridx = 2;
        productOptionsPanel.add(btnAgregarProducto, gbc);

        mainPanel.add(productOptionsPanel, BorderLayout.NORTH);
        backGround.add(mainPanel, BorderLayout.CENTER);
    }

    private void configurarBottomPanel(int id) {
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(180, 180, 180));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 50));

        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
        bottomPanel.add(lblTotal, BorderLayout.CENTER);

        btnFinalizarVenta = new JButton("Finalizar Venta");
        btnFinalizarVenta.addActionListener(e->{
            VtnConfirmaVta vta=new VtnConfirmaVta();
            vta.setVisible(true);
        });
        bottomPanel.add(btnFinalizarVenta, BorderLayout.EAST);

        btnRegresar=new JButton("Regresar");
        btnRegresar.addActionListener(e->{
            Principal principal=new Principal(id);
            principal.setVisible(true);
            this.dispose();
        });
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PuntoDeVentaUI ui = new PuntoDeVentaUI(2,"Fin");
            ui.setVisible(true);
        });
    }
}
