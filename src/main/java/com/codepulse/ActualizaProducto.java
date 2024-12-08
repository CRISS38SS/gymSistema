package com.codepulse;

import java.awt.*;

import javax.swing.*;

public class ActualizaProducto extends JFrame{
    private JPanel backGround;
    private JPanel bottomJPanel;
    private JPanel centerJPanel;

    private JButton btnRegresar;
    private JButton btnActualizar;

    private JLabel lblActualizar;

    private JComboBox<String> jcVerProducto;
    
    public ActualizaProducto(int id){
        setTitle("Actualizar Productos");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        configureBackGround();
        configureBottomPanel();
        configureCenterPanel();
        
    }

    public void configureBackGround(){
        backGround=new JPanel(new BorderLayout());
        setContentPane(backGround);
    }

    public void configureBottomPanel(){
        bottomJPanel=new JPanel(new BorderLayout());
        bottomJPanel.setBackground(Color.BLUE);
        
        btnRegresar =new JButton("Cancelar");
        btnRegresar.addActionListener(e->{
            this.dispose();
        });
        btnRegresar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnRegresar.setBackground(new Color(119, 118, 123));
		btnRegresar.setForeground(new Color(255, 255, 255));
        bottomJPanel.add(btnRegresar, BorderLayout.WEST);

        backGround.add(bottomJPanel,BorderLayout.SOUTH);
    }

    public void configureCenterPanel(){
        centerJPanel=new JPanel(new GridBagLayout());
        centerJPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10, 10, 10, 10);


        lblActualizar=new JLabel("Actualizar Producto");
        lblActualizar.setFont(new Font("FreeSans", Font.BOLD, 30));
        lblActualizar.setHorizontalAlignment(SwingConstants.CENTER);
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=2;
        gbc.insets=new Insets(0, 0, 15, 0);
        centerJPanel.add(lblActualizar, gbc);

        jcVerProducto = new JComboBox<>();
        sqlite.inicializarComboBox(jcVerProducto, "");
        jcVerProducto.setEditable(true);
        gbc=new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        centerJPanel.add(new JLabel("Buscar Producto:"), gbc);
        gbc.gridx = 1;
        gbc.gridy=1;
        centerJPanel.add(jcVerProducto, gbc);

        JSpinner spinnerCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.insets=new Insets(15, 0, 0, 0);
        centerJPanel.add(new JLabel("Cantidad:"), gbc);
        gbc.gridx = 1;
        gbc.insets=new Insets(15, 0, 0, 0);
        centerJPanel.add(spinnerCantidad, gbc);


        btnActualizar =new JButton("Actualizar");
        btnActualizar.addActionListener(e->{
            String nombreProducto = ((JTextField) jcVerProducto.getEditor().getEditorComponent()).getText().trim();
            int cant=(int)spinnerCantidad.getValue();
            System.out.println(nombreProducto+" "+cant);
            sqlite.actualizarProductoExis(nombreProducto,cant);
            JOptionPane.showMessageDialog(null, "Se actualizo producto se agrego "+cant+" al stock");

        });
        btnActualizar.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnActualizar.setBackground(new Color(119, 118, 123));
		btnActualizar.setForeground(new Color(255, 255, 255));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth=2;
        gbc.insets=new Insets(15, 0, 0, 0);
        centerJPanel.add(btnActualizar,gbc);


        backGround.add(centerJPanel,BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        ActualizaProducto actualizaProducto=new ActualizaProducto(1);
        actualizaProducto.setVisible(true);
    }
}
