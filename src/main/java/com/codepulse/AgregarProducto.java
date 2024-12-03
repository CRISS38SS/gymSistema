package com.codepulse;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

import com.codepulse.FitroJtextField.AlphabeticFilter;
import com.codepulse.FitroJtextField.NumericFilter;

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


    public AgregarProducto(JComboBox<String> jcbBuscaProducto) {
        setBounds(100, 100, 550, 500);
        setLocationRelativeTo(null);
        setResizable(false);

        backGround = new JPanel();
        backGround.setLayout(new GridBagLayout());
        setContentPane(backGround);

        costadoBackGround = new JPanel(new GridBagLayout());
        costadoBackGround.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        backGround.add(costadoBackGround, gbc);

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(150, 150, 150));
        gbc.gridx = 1;
        gbc.weightx = 0.8;
        backGround.add(mainPanel, gbc);



        //-------------componentes de costadoBackGraound--------------------------------------
        // Configuración de lblImagenCostado
        ImageIcon icon = new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        lblImagenCostado = new JLabel(icon);
        Image image = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        lblImagenCostado.setIcon(new ImageIcon(image));
        lblImagenCostado.setFont(new Font("FreeSans", Font.BOLD, 30));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor=GridBagConstraints.PAGE_START;
        gbc.weighty=1;
        costadoBackGround.add(lblImagenCostado, gbc);


        exit=new JButton("Salir");
        exit.setBackground(new Color(255, 255, 255));
        exit.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        exit.addActionListener(e->{
            jcbBuscaProducto.removeAllItems();
            sqlite.cargaDatosDeSql(jcbBuscaProducto);
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
        txtNombre = new JTextField("Nombre");
        ((AbstractDocument) txtNombre.getDocument()).setDocumentFilter(new AlphabeticFilter());
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
        ((AbstractDocument) txtPrecio.getDocument()).setDocumentFilter(new NumericFilter());
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
        lblCantidad=new JLabel("Cantidad");
        lblCantidad.setBackground(new Color(246, 245, 244));
		lblCantidad.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.insets=new Insets(10, 10, 20, 10);
        mainPanel.add(lblCantidad,gbc);

        //configuracion de txtCantidad
        txtCantidad=new JTextField("Cantidad",15);
        ((AbstractDocument) txtCantidad.getDocument()).setDocumentFilter(new NumericFilter());
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

            sqlite.insertarProducto(nombre,cantidad, precio);
            jcbBuscaProducto.removeAllItems();
            sqlite.cargaDatosDeSql(jcbBuscaProducto);

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
