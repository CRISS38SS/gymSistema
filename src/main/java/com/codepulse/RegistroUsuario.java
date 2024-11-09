package com.codepulse;

import javax.swing.*;
import java.awt.*;

public class RegistroUsuario extends JFrame {

    //dueño del gym jaim gomez ibarra
    // Variables del panel
    private JPanel backGround;
    private JPanel costadoBackGround;
    private JPanel mainPanel;
    private JLabel lblImagenCostado;
    private JLabel lblRegistro;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblsubscription;
    private JTextField txtsubscription;
    private JButton btnRegistration;
    private JButton btnClean;

    //costado
    private JButton exit;


    public RegistroUsuario() {
        // Configurar la ventana
        setBounds(100, 100, 500, 500);
        setLocationRelativeTo(null);

        // Panel principal con GridBagLayout
        backGround = new JPanel();
        backGround.setLayout(new GridBagLayout());
        setContentPane(backGround);

        // Configuración del panel "costadoBackGround" en el lado izquierdo
        costadoBackGround = new JPanel(new GridBagLayout()); // Usar GridBagLayout aquí también
        costadoBackGround.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH; // Expande para llenar el espacio
        backGround.add(costadoBackGround, gbc);

        // Configuración del panel principal (mainPanel) a la derecha de costadoBackGround
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(150, 150, 150));
        gbc.gridx = 1;
        gbc.weightx = 0.8;       // Más espacio en el eje X para mainPanel
        backGround.add(mainPanel, gbc);



        //-------------componentes de costadoBackGraound--------------------------------------
        // Configuración de lblImagenCostado
        lblImagenCostado = new JLabel("Imagen");
        lblImagenCostado.setFont(new Font("FreeSans", Font.BOLD, 30));
        gbc = new GridBagConstraints(); // Reset de restricciones
        gbc.gridx = 0;
        gbc.gridy = 0; // Fila 0 para lblImagenCostado
        gbc.insets = new Insets(10, 5, 350, 5);
        costadoBackGround.add(lblImagenCostado, gbc);


        exit=new JButton("Salir");
        exit.addActionListener(e->{
            dispose();
        });
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(10, 0, 40, 0);
        gbc.fill=GridBagConstraints.BOTH;
        costadoBackGround.add(exit,gbc);


        //--------------------------componentes para mainPrincipal------------------------------
        // Configuración de lblRegistro en el panel principal
        lblRegistro = new JLabel("Registro");
        lblRegistro.setFont(new Font("FreeSans", Font.BOLD, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblRegistro, gbc);

        //configuracion de lblNombre
        lblNombre=new JLabel("Nombre");
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblNombre,gbc);

        // Configuración de txtNombre debajo de lblImagenCostado
        txtNombre = new JTextField("Nombre",15); // Agrega un tamaño preferido
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtNombre, gbc);

        //configuracion de lblLastName
        lblLastName=new JLabel("Apellido");
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblLastName,gbc);

        //configuracion de txtLastName
        txtLastName=new JTextField("apellido",15);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtLastName,gbc);

        //configuracion de lblEmail
        lblEmail=new JLabel("Email");
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblEmail,gbc);

        //configuracion de txtEmail
        txtEmail=new JTextField("Email",15);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtEmail,gbc);
        //configuracion de lblsubscription
        lblsubscription=new JLabel("suscripcion");
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblsubscription,gbc);
        //configuracion de txtsubscription
        txtsubscription=new JTextField("suscripcion",15);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtsubscription,gbc);
        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //configuracion btnRegistration
        btnRegistration=new JButton("Registrar");
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnRegistration,gbc);

        //configuracion btnClean
        btnClean=new JButton("Borrar");
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnClean,gbc);
    }

    public static void main(String[] args) {
        RegistroUsuario r = new RegistroUsuario();
        r.setVisible(true);
    }
}
