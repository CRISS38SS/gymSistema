package com.codepulse;

import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

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


    public verUsuarios(int id){
        setTitle("Ver usuarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);

        configurarBackGround();
        leftSidePanel();
        bottomSidePanel(id);
        centerSidePanel();
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

        ImageIcon icon=new ImageIcon(getClass().getResource("/com/Imagenes/logoCodePulse.jpg"));
        lblLeft = new JLabel(icon);
		Image image=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblLeft.setIcon(new ImageIcon(image));
        gbc.gridy = 0;
        leftJPanel.add(lblLeft, gbc);

        backGround.add(leftJPanel, BorderLayout.WEST);
    }

    private void bottomSidePanel(int id){
        bottomJPanel = new JPanel(new BorderLayout());
        bottomJPanel.setBackground(new Color(223, 223, 223));

        btnBack = new JButton("Atras");
        btnBack.addActionListener(e->{
            Principal principal=new Principal(id);
            principal.setVisible(true);
            this.dispose();
        });
        btnBack.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnBack.setBackground(new Color(119, 118, 123));
		btnBack.setForeground(new Color(255, 255, 255));
        bottomJPanel.add(btnBack, BorderLayout.WEST);

        backGround.add(bottomJPanel, BorderLayout.SOUTH);
    }

    private void centerSidePanel(){
        centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBackground(new Color(12, 12, 111));

        String[] columnNames = {"ID", "Nombre", "suscripción", "Inicia", "Termina","Activo"};
        tableModel = new CustomTableModel(new Object[0][0], columnNames);
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
        usuarioOptionPanel.add(new JLabel("Buscar Usuario por nombre:"), gbc);
        gbc.gridx = 1;
        usuarioOptionPanel.add(txtBuscaUsuario, gbc);

        JButton btnBuscar=new JButton("Buscar");
        btnBuscar.addActionListener(e -> {
            String textoBusqueda = txtBuscaUsuario.getText().trim().toLowerCase();
            TableRowSorter<CustomTableModel> sorter = new TableRowSorter<>(tableModel);
            jttableUsuario.setRowSorter(sorter);

            if (!textoBusqueda.isEmpty()) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda,1));
            } else {
                sorter.setRowFilter(null);
            }
        });

        btnBuscar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnBuscar.setBackground(new Color(119, 118, 123));
		btnBuscar.setForeground(new Color(255, 255, 255));
        gbc =new GridBagConstraints();
        gbc.gridx=2;
        gbc.gridy=0;
        usuarioOptionPanel.add(btnBuscar,gbc);

        centerPanel.add(usuarioOptionPanel,BorderLayout.NORTH);
        backGround.add(centerPanel, BorderLayout.CENTER);

        sqlite.cargarUsuariosDesdeBD(jttableUsuario);
    }

    public static void main(String[] args) {
        verUsuarios verUsuarios = new verUsuarios(1);
        verUsuarios.setVisible(true);
    }
}

class CustomTableModel extends DefaultTableModel {

    public CustomTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value = super.getValueAt(row, column);
    
        // Formatear las fechas para las columnas de fecha (por ejemplo, columnas 3 y 4)
        if ((column == 3 || column == 4) && value instanceof Date) {
            try {
                // Si es un objeto Date, formateamos la fecha
                SimpleDateFormat outputFormat = new SimpleDateFormat("d 'de' MMMM 'del' yyyy");
                return outputFormat.format((Date) value); // Formateamos la fecha
            } catch (Exception e) {
                // Si algo falla, retornamos el valor original
                return value;
            }
        }
    
        return value; // Retornamos el valor original si no es una fecha
    }
    
}
