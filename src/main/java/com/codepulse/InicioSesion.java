package com.codepulse;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

import com.codepulse.FitroJtextField.AlphabeticFilter;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backGround;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JPanel panelDerecho;

	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 350);
		setLocationRelativeTo(null);

		backGround = new JPanel(new GridBagLayout());
		setContentPane(backGround);

		GridBagConstraints gbc=new GridBagConstraints();

		JPanel panelIzquierdo = new JPanel(new GridBagLayout());
		gbc.gridx=0;
		gbc.weightx = 0.2;
        gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		panelIzquierdo.setBackground(new Color(154, 153, 150));
		backGround.add(panelIzquierdo,gbc);

		panelDerecho=new JPanel(new GridBagLayout());
		gbc.gridx=1;
		gbc.weightx = 0.8;
		gbc.fill = GridBagConstraints.BOTH;
		panelDerecho.setBackground(new Color(246, 245, 244));
		backGround.add(panelDerecho,gbc);
		
		ImageIcon icono = new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        JLabel lblImagen = new JLabel(icono);
        Image image = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(image));
		gbc=new GridBagConstraints();
		gbc.gridy=0;
		gbc.weighty=1;
		gbc.insets=new Insets(10, 15, 20, 15);
		gbc.anchor=GridBagConstraints.PAGE_START;
		panelIzquierdo.add(lblImagen,gbc);
		
		JButton btnRegistro = new JButton("Registrarte");
        btnRegistro.addActionListener(e->{
            Registro registro=new Registro();
            registro.setVisible(true);
            this.dispose();
        });
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnRegistro.setPreferredSize(new Dimension(120,120));
		gbc.gridy=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=1;
		gbc.insets=new Insets(0, 15, 20, 15);
		gbc.weighty=1;
		gbc.anchor=GridBagConstraints.CENTER;
		panelIzquierdo.add(btnRegistro,gbc);
		
		JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e->{
            this.dispose();
        });
		btnSalir.setBackground(new Color(61, 56, 70));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnSalir.setPreferredSize(new Dimension(120,120));
		gbc.gridy=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.anchor=GridBagConstraints.PAGE_END;
		panelIzquierdo.add(btnSalir,gbc);


		JLabel lblInicioSesin = new JLabel("Inicio Sesión");
		gbc=new GridBagConstraints();
		lblInicioSesin.setFont(new Font("C059", Font.BOLD, 44));
		gbc.insets=new Insets(0, 0, 35, 0);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		panelDerecho.add(lblInicioSesin,gbc);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		gbc=new GridBagConstraints();
		lblUsuario.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc.gridx=0;
		gbc.gridy=1;
		panelDerecho.add(lblUsuario,gbc);
		
		
		txtUsuario = new JTextField();
		((AbstractDocument) txtUsuario.getDocument()).setDocumentFilter(new AlphabeticFilter());
		txtUsuario.setBackground(new Color(246, 245, 244));
		txtUsuario.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtUsuario.setBorder(null);
		txtUsuario.setColumns(10);
		gbc.gridx=1;
		gbc.gridy=1;
		panelDerecho.add(txtUsuario,gbc);

		JSeparator separatorUsuario = new JSeparator();
		gbc=new GridBagConstraints();
		separatorUsuario.setForeground(new Color(0, 0, 0));
		separatorUsuario.setPreferredSize(new java.awt.Dimension(180, 2)); 
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorUsuario,gbc);
		
		JLabel lblContrasena = new JLabel("Contraseña:  ");
		gbc=new GridBagConstraints();
		lblContrasena.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc.gridx=0;
		gbc.gridy=3;
		panelDerecho.add(lblContrasena,gbc);
		
		JSeparator separatorContrasena = new JSeparator();
		gbc=new GridBagConstraints();
		separatorContrasena.setForeground(Color.BLACK);
		separatorContrasena.setPreferredSize(new java.awt.Dimension(180, 2));
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorContrasena,gbc);
		
		txtContrasena = new JPasswordField();
		gbc=new GridBagConstraints();
		txtContrasena.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtContrasena.setColumns(10);
		txtContrasena.setBorder(null);
		txtContrasena.setBackground(new Color(246, 245, 244));
		gbc.gridx=1;
		gbc.gridy=3;
		panelDerecho.add(txtContrasena,gbc);
		
		JButton btnInicioSesion = new JButton("Inicio Sesión");
		gbc=new GridBagConstraints();
		btnInicioSesion.addActionListener(e->{

		cajero cajer=new cajero();
		String nombre,contrasena;
		cajer.setUsuario(txtUsuario.getText());
		cajer.setContraseña(String.valueOf(txtContrasena.getPassword()));
		nombre=cajer.getUsuario();
		contrasena=cajer.getContraseña();

		if (nombre.isEmpty()||contrasena.isEmpty()) {
			JOptionPane.showMessageDialog(null,"llena los campos");
		}else{

		verificar(nombre,contrasena);
		}
		});
		btnInicioSesion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnInicioSesion.setForeground(new Color(255, 255, 255));
		btnInicioSesion.setBackground(new Color(61, 56, 70));
		btnInicioSesion.setPreferredSize(new Dimension(60,60));
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.insets=new Insets(15, 0, 0, 0);
		panelDerecho.add(btnInicioSesion,gbc);
	}
	public static void main(String[] args) {
		InicioSesion inicioSesion=new InicioSesion();
		inicioSesion.setVisible(true);
	}

	private void verificar(String nombre,String contrasena){
		String URL="jdbc:sqlite:gymsistema.db";
		String sql="SELECT * FROM cajero WHERE usuario=? AND contrasena=?";
		try (Connection conn=DriverManager.getConnection(URL); PreparedStatement ps=conn.prepareStatement(sql)) {
			ps.setString(1, nombre);
			ps.setString(2, contrasena);

			ResultSet s=ps.executeQuery();
			if (s.next()) {
				int id=s.getInt("idCajero");
				Principal principal=new Principal(id);
				principal.setVisible(true);
				dispose();
			}else{
				JOptionPane.showMessageDialog(null, "no hay ningun usuario");
			}
		} catch (Exception e) {

		}
	}
}
