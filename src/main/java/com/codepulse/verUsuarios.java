package com.codepulse;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class verUsuarios extends JFrame{
    private JPanel backGround;
    private JPanel leftJPanel;
    private JPanel bottomJPanel;
    private JPanel centerPanel;
    private JPanel usuarioOptionPanel;

    private JLabel lblLeft;
    private JButton btnBack;

    private JTextField txtBuscaUsuario;

    private JTable jttableUsuario;
    private CustomTableModel tableModel;


    public verUsuarios(){
        setTitle("Ver usuarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        configurarBackGround();
        leftSidePanel();
        bottomSidePanel();
        centerSidePanel();
        //agregarBotonEliminar();
    }

    private void configurarBackGround() {
        backGround = new JPanel(new BorderLayout());
        setContentPane(backGround);
    }

    private void leftSidePanel(){
        leftJPanel = new JPanel(new GridBagLayout());
        leftJPanel.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        ImageIcon icon=new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        lblLeft = new JLabel(icon);
		Image image=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblLeft.setIcon(new ImageIcon(image));
        gbc.gridy = 0;
        leftJPanel.add(lblLeft, gbc);

        backGround.add(leftJPanel, BorderLayout.WEST);
    }

    private void bottomSidePanel(){
        bottomJPanel = new JPanel(new BorderLayout());
        bottomJPanel.setBackground(new Color(223, 223, 223));

        btnBack = new JButton("Atras");
        btnBack.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnBack.setBackground(new Color(119, 118, 123));
		btnBack.setForeground(new Color(255, 255, 255));
        bottomJPanel.add(btnBack, BorderLayout.WEST);

        backGround.add(bottomJPanel, BorderLayout.SOUTH);
    }

    private void centerSidePanel(){
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(12, 12, 111));

        String[] columnNames = {"ID", "Nombre", "suscripción", "Inicia", "Termina"};
        Object[][] data = {{1,"cristian","Mensual","20 enero","20 febrero"},{2,"leonardo","semanal","20 enero","20 febrero"},{3,"eduardo","visita","20 enero","20 febrero"},{4,"Claudia","Mensual","20 enero","20 febrero"}};
        tableModel = new CustomTableModel(data, columnNames);
        jttableUsuario = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(jttableUsuario);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        usuarioOptionPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        txtBuscaUsuario = new JTextField();
        txtBuscaUsuario.setColumns(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        usuarioOptionPanel.add(new JLabel("Buscar Usuario:"), gbc);
        gbc.gridx = 1;
        usuarioOptionPanel.add(txtBuscaUsuario, gbc);

        JButton btnBuscar=new JButton("Buscar");
        btnBuscar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnBuscar.setBackground(new Color(119, 118, 123));
		btnBuscar.setForeground(new Color(255, 255, 255));
        gbc =new GridBagConstraints();
        gbc.gridx=2;
        gbc.gridy=0;
        usuarioOptionPanel.add(btnBuscar,gbc);

        centerPanel.add(usuarioOptionPanel,BorderLayout.NORTH);
        backGround.add(centerPanel, BorderLayout.CENTER);
    }

    private void agregarBotonEliminar() {
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> eliminarFilaSeleccionada());
        btnEliminar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnEliminar.setBackground(new Color(119, 118, 123));
		btnEliminar.setForeground(new Color(255, 255, 255));
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        leftJPanel.add(btnEliminar, gbc);
    }

    private void eliminarFilaSeleccionada() {
        int filaSeleccionada = jttableUsuario.getSelectedRow();
        if (filaSeleccionada != -1) {
            tableModel.eliminarFila(filaSeleccionada);
        }
    }

    public static void main(String[] args) {
        verUsuarios verUsuarios = new verUsuarios();
        verUsuarios.setVisible(true);
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
