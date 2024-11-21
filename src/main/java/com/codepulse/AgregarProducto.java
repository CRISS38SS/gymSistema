package com.codepulse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;


public class AgregarProducto extends JFrame {

    //dueño del gym jaim gomez ibarra
    // Variables del panel
    private JPanel backGround;
    private JPanel costadoBackGround;
    private JPanel mainPanel;
    private JLabel lblImagenCostado;
    private JLabel lblAgregarProducto;
    private JTextField txtNombre;
    private JLabel lblNombre;
    private JLabel lblPrecio;
    private JTextField txtPrecio;
    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JButton btnClean;

    //costado
    private JButton exit;


    public AgregarProducto() {
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
        lblAgregarProducto = new JLabel("Agrega Producto");
        lblAgregarProducto.setFont(new Font("FreeSans", Font.BOLD, 35));
        gbc = new GridBagConstraints();
        gbc.gridwidth=2;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblAgregarProducto, gbc);

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
        borraTextRestaura(txtNombre, "Nombre");
        txtNombre.setBackground(new Color(246, 245, 244));
		txtNombre.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtNombre.setBorder(null);
		txtNombre.setColumns(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtNombre, gbc);

        //configuracion de lblLastName
        lblPrecio=new JLabel("Precio");
        lblPrecio.setBackground(new Color(246, 245, 244));
		lblPrecio.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblPrecio,gbc);

        //configuracion de txtPrecio
        txtPrecio=new JTextField("Precio");
        borraTextRestaura(txtPrecio, "Precio");
        txtPrecio.setBackground(new Color(246, 245, 244));
		txtPrecio.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtPrecio.setBorder(null);
		txtPrecio.setColumns(10);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtPrecio,gbc);

        //configuracion de lblCantidad
        lblCantidad=new JLabel("Numero");
        lblCantidad.setBackground(new Color(246, 245, 244));
		lblCantidad.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblCantidad,gbc);

        //configuracion de txtCantidad
        txtCantidad=new JTextField("Cantidad",15);
        borraTextRestaura(txtCantidad, "Cantidad");
        txtCantidad.setBackground(new Color(246, 245, 244));
		txtCantidad.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtCantidad.setBorder(null);
		txtCantidad.setColumns(10);
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(txtCantidad,gbc);

        // Configuración final de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //configuracion btnRegistration
        btnClean=new JButton("Borrar");
        btnClean.addActionListener(e->{
            txtNombre.setText("Nombre");
            txtPrecio.setText("Precio");
            txtCantidad.setText("Cantidad");
        });
        btnClean.setBackground(new Color(255, 255, 255));
        btnClean.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnClean,gbc);

        //configuracion btnAgregar
        btnAgregar=new JButton("Agregar");
        btnAgregar.addActionListener(e->{
            Producto producto=new Producto();
            producto.setName(txtNombre.getText());
            producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
            producto.setCantidad(Integer.parseInt(txtCantidad.getText()));

            String nombre="";
            int precio,cantidad;
            nombre=producto.getName();
            precio=producto.getPrecio();
            cantidad=producto.getCantidad();
            JOptionPane.showMessageDialog(null, "Se agrego producto al stock");

            sqlite.insertarProducto(nombre,precio, cantidad);
        });
        btnAgregar.setBackground(new Color(255, 255, 255));
        btnAgregar.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=5;
        gbc.insets=new Insets(10, 10, 10, 10);
        gbc.fill=GridBagConstraints.BOTH;
        mainPanel.add(btnAgregar,gbc);
    }

    public static void main(String[] args) {
        AgregarProducto r = new AgregarProducto();
        r.setVisible(true);
    }

    private void borraTextRestaura(JTextField field,String texto){
    
        field.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e){
                if (field.getText().equals(texto)) {
                    field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e){
                if (field.getText().isEmpty()) {
                    field.setText(texto);
                }
            }
        });
    }
}
