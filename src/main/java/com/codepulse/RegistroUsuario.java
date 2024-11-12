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
    private JLabel lblNumero;
    private JTextField txtNumero;
    private JLabel lblsubscription;
    private JTextField txtsubscription;
    private JButton btnRegistration;
    private JButton btnClean;

    //costado
    private JButton exit;


    public RegistroUsuario() {
        // Configurar la ventana
        setBounds(100, 100, 550, 500);
        setLocationRelativeTo(null);
        setResizable(false);

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
        ImageIcon icon = new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        lblImagenCostado = new JLabel(icon);
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        lblImagenCostado.setIcon(new ImageIcon(image));
        lblImagenCostado.setFont(new Font("FreeSans", Font.BOLD, 30));
        gbc = new GridBagConstraints(); // Reset de restricciones
        gbc.gridx = 0;
        gbc.gridy = 0; // Fila 0 para lblImagenCostado
        gbc.anchor=GridBagConstraints.PAGE_START;
        gbc.weighty=1;
        costadoBackGround.add(lblImagenCostado, gbc);


        exit=new JButton("Salir");
        exit.setBackground(new Color(255, 255, 255));
        exit.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        exit.addActionListener(e->{
            dispose();
        });
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets = new Insets(10, 0, 40, 0);
        gbc.fill=GridBagConstraints.BOTH;
        gbc.anchor=GridBagConstraints.PAGE_END;
        costadoBackGround.add(exit,gbc);


        //--------------------------componentes para mainPrincipal------------------------------
        // Configuración de lblRegistro en el panel principal
        lblRegistro = new JLabel("Registro De Cliente");
        lblRegistro.setFont(new Font("FreeSans", Font.BOLD, 35));
        gbc = new GridBagConstraints();
        gbc.gridwidth=2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblRegistro, gbc);

        //configuracion de lblNombre
        lblNombre=new JLabel("Nombre");
        lblNombre.setBackground(new Color(246, 245, 244));
		lblNombre.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblNombre,gbc);

        // Configuración de txtNombre debajo de lblImagenCostado
        txtNombre = new JTextField("Nombre"); // Agrega un tamaño preferido
        txtNombre.setBackground(new Color(246, 245, 244));
		txtNombre.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtNombre, gbc);

        //configuracion de lblLastName
        lblLastName=new JLabel("Apellido");
        lblLastName.setBackground(new Color(246, 245, 244));
		lblLastName.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblLastName,gbc);

        //configuracion de txtLastName
        txtLastName=new JTextField("Apellido");
        txtLastName.setBackground(new Color(246, 245, 244));
		txtLastName.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtLastName.setBorder(null);
		txtLastName.setColumns(10);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtLastName,gbc);

        //configuracion de lblEmail
        lblNumero=new JLabel("Numero");
        lblNumero.setBackground(new Color(246, 245, 244));
		lblNumero.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblNumero,gbc);

        //configuracion de txtEmail
        txtNumero=new JTextField("Numero",15);
        txtNumero.setBackground(new Color(246, 245, 244));
		txtNumero.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtNumero.setBorder(null);
		txtNumero.setColumns(10);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtNumero,gbc);

        //configuracion de lblsubscription
        lblsubscription=new JLabel("Suscripcion");
        lblsubscription.setBackground(new Color(246, 245, 244));
		lblsubscription.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblsubscription,gbc);

        //configuracion de txtsubscription
        txtsubscription=new JTextField("suscripcion",15);
        txtsubscription.setBackground(new Color(246, 245, 244));
		txtsubscription.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtsubscription.setBorder(null);
		txtsubscription.setColumns(10);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=4;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtsubscription,gbc);

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //configuracion btnRegistration
        btnClean=new JButton("Borrar");
        btnClean.setBackground(new Color(255, 255, 255));
        btnClean.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnClean,gbc);

        //configuracion btnClean
        btnRegistration=new JButton("Registrar");
        btnRegistration.addActionListener(e->{
            Usuario usuario=new Usuario();
            usuario.setName(txtNombre.getText());
            usuario.setLastName(txtLastName.getText());
            usuario.setNumero(txtNumero.getText());
            usuario.setSubscription(txtsubscription.getText());
            usuario.setFprint("hola");

            String nombre="",lastname="",numero="",subscription="",fprint="";
            nombre=usuario.getName();
            lastname=usuario.getLastName();
            numero=usuario.getNumero();
            subscription=usuario.getSubscription();
            fprint=usuario.getFprint();

            JOptionPane.showMessageDialog(null, nombre+lastname+numero+subscription+"k");

            sqlite.insertarUsuario(nombre,lastname,numero,"fprint",subscription);
        });
        btnRegistration.setBackground(new Color(255, 255, 255));
        btnRegistration.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnRegistration,gbc);
    }

    public static void main(String[] args) {
        RegistroUsuario r = new RegistroUsuario();
        r.setVisible(true);
    }
}
