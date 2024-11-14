package com.codepulse;

import javax.swing.*;
import java.awt.*;

public class PuntoDeVentaUI extends JFrame {

    private JPanel backGround;
    private JPanel sidePanel;
    private JPanel mainPanel;
    private JPanel productOptionsPanel;
    private JPanel summaryPanel;
    private JPanel salesHistoryPanel;
    private JPanel bottomPanel;

    private JButton btnAgregarProducto, btnQuitarProducto, btnBuscarProducto, btnFinalizarVenta;
    private JButton btnVerHistorial,btnRegresar;
    private JTextField txtBuscarProducto;
    private JLabel lblTotal;
    private JTable tableProductos, tableHistorialVentas;
    private JSpinner spinnerCantidad;
    
    public PuntoDeVentaUI(int id) {
        setTitle("Sistema de Punto de Venta Avanzado");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width * 4 / 5, screenSize.height * 4 / 5);
        setLocationRelativeTo(null);

        backGround = new JPanel(new BorderLayout());
        setContentPane(backGround);

        // Configuración de paneles
        configurarSidePanel();
        configurarMainPanel();
        configurarProductOptionsPanel();
        configurarBottomPanel(id);
        configurarSummaryPanel();

    }

    private void configurarSidePanel() {
        sidePanel = new JPanel(new GridBagLayout());
        sidePanel.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        btnQuitarProducto = new JButton("Quitar Producto");
        gbc.gridy = 1;
        sidePanel.add(btnQuitarProducto, gbc);

        btnVerHistorial = new JButton("Ver Historial");
        btnVerHistorial.addActionListener(e->{
            configurarSalesHistoryPanel();
        });
        gbc.gridy = 3;
        sidePanel.add(btnVerHistorial, gbc);

        backGround.add(sidePanel, BorderLayout.WEST);
    }

    private void configurarMainPanel() {
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(250, 250, 250));

        String[] columnNames = {"ID", "Producto", "Cantidad", "Precio", "Total"};
        Object[][] data = {};
        tableProductos = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tableProductos);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        backGround.add(mainPanel, BorderLayout.CENTER);
    }

    private void configurarProductOptionsPanel() {
        productOptionsPanel = new JPanel(new GridBagLayout());
        productOptionsPanel.setBackground(new Color(220, 220, 220));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        txtBuscarProducto = new JTextField(15);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        productOptionsPanel.add(new JLabel("Buscar Producto:"), gbc);

        gbc.gridx = 1;
        productOptionsPanel.add(txtBuscarProducto, gbc);

        btnBuscarProducto = new JButton("Buscar");
        gbc.gridx = 2;
        productOptionsPanel.add(btnBuscarProducto, gbc);

        spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        productOptionsPanel.add(new JLabel("Cantidad:"), gbc);

        gbc.gridx = 1;
        productOptionsPanel.add(spinnerCantidad, gbc);

        btnAgregarProducto = new JButton("Agregar Producto");
        gbc.gridx = 2;
        gbc.gridy = 1;
        productOptionsPanel.add(btnAgregarProducto, gbc);

        backGround.add(productOptionsPanel, BorderLayout.NORTH);
    }

    private void configurarSummaryPanel() {
        summaryPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        summaryPanel.setBackground(new Color(240, 240, 240));
        summaryPanel.setBorder(BorderFactory.createTitledBorder("Resumen de Venta"));

        lblTotal = new JLabel("  Resumen de Venta  ");
        summaryPanel.add(lblTotal);

        lblTotal = new JLabel("Total: $0.00");
        summaryPanel.add(lblTotal);

        backGround.add(summaryPanel, BorderLayout.LINE_END);
    }

    private void configurarSalesHistoryPanel() {
        salesHistoryPanel = new JPanel(new BorderLayout());
        salesHistoryPanel.setBackground(new Color(245, 245, 245));
        salesHistoryPanel.setBorder(BorderFactory.createTitledBorder("Historial de Ventas"));

        String[] columns = {"ID Venta", "Fecha", "Total"};
        Object[][] data = {};
        tableHistorialVentas = new JTable(data, columns);
        JScrollPane scrollPane = new JScrollPane(tableHistorialVentas);
        salesHistoryPanel.add(scrollPane, BorderLayout.CENTER);

        backGround.add(salesHistoryPanel, BorderLayout.WEST);
    }

    private void configurarBottomPanel(int id) {
        bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(180, 180, 180));
        bottomPanel.setPreferredSize(new Dimension(getWidth(), 80));

        btnFinalizarVenta = new JButton("Finalizar Venta");
        btnFinalizarVenta.addActionListener(e->{
            configurarSummaryPanel();
        });
        bottomPanel.add(btnFinalizarVenta, BorderLayout.EAST);

        btnRegresar=new JButton("Regresar");
        btnRegresar.addActionListener(e->{
            Principal principal=new Principal(id);
            principal.setVisible(true);
            dispose();
        });
        bottomPanel.add(btnRegresar,BorderLayout.WEST);

        backGround.add(bottomPanel, BorderLayout.SOUTH);
    }
/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PuntoDeVentaUI ui = new PuntoDeVentaUI();
            ui.setVisible(true);
        });
    }
        */
}
