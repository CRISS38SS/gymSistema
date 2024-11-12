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

import java.awt.Dimension;

import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Registro extends JFrame {

	private JPanel backGround;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JTextField txtEmail;

	JPanel panelIzquierdo;
	JPanel panelDerecho;

	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 380);
		setLocationRelativeTo(null);


		backGround = new JPanel(new GridBagLayout());
		setContentPane(backGround);


		GridBagConstraints gbc=new GridBagConstraints();
		//
		//sqlite sql=new sqlite();
		
		panelIzquierdo = new JPanel(new GridBagLayout());
		panelIzquierdo.setBackground(new Color(154, 153, 150));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.weightx=0.2;
		gbc.weighty=1;
		gbc.fill=GridBagConstraints.BOTH;
		backGround.add(panelIzquierdo,gbc);

		panelDerecho=new JPanel(new GridBagLayout());
		panelDerecho.setBackground(new Color(246, 245, 244));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.weightx=0.8;
		gbc.fill=GridBagConstraints.BOTH;
		backGround.add(panelDerecho,gbc);
		
		ImageIcon icon=new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
		JLabel lblImagen = new JLabel(icon);
		Image image=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblImagen.setIcon(new ImageIcon(image));
		gbc=new GridBagConstraints();
		gbc.gridy=0;
		gbc.weighty=1;
		gbc.anchor=GridBagConstraints.PAGE_START;
		gbc.insets=new Insets(10, 15, 5, 15);
		panelIzquierdo.add(lblImagen,gbc);
		
		JButton btnIniciarSesion = new JButton("Inicio Sesión");
        btnIniciarSesion.addActionListener(e->{
            InicioSesion is=new InicioSesion();
            is.setVisible(true);
            this.dispose();
        });
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setPreferredSize(new Dimension(120,120));
		gbc=new GridBagConstraints();
		gbc.gridy=1;
		gbc.weighty=1;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		panelIzquierdo.add(btnIniciarSesion,gbc);
		
		JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e->{
            this.dispose();
        });
		btnSalir.setBackground(new Color(61, 56, 70));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnSalir.setBorder(null);
		btnSalir.setPreferredSize(new Dimension(120,120));
		gbc=new GridBagConstraints();
		gbc.gridy=2;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		panelIzquierdo.add(btnSalir,gbc);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setFont(new Font("C059", Font.BOLD, 44));
		lblRegistro.setBounds(266, 12, 509, 57);
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		panelDerecho.add(lblRegistro,gbc);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		panelDerecho.add(lblUsuario,gbc);
		
		JSeparator separatorUsuario = new JSeparator();
		separatorUsuario.setForeground(new Color(0, 0, 0));
		separatorUsuario.setPreferredSize(new java.awt.Dimension(180,2));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=2;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorUsuario,gbc);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(246, 245, 244));
		txtUsuario.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(null);
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=1;
		panelDerecho.add(txtUsuario,gbc);
		
		JLabel lblContrasena = new JLabel("Contraseña:  ");
		lblContrasena.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=3;
		panelDerecho.add(lblContrasena,gbc);
		
		JSeparator separatorContrasena = new JSeparator();
		separatorContrasena.setForeground(Color.BLACK);
		separatorContrasena.setPreferredSize(new Dimension(180,2));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorContrasena,gbc);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtContrasena.setColumns(10);
		txtContrasena.setBorder(null);
		txtContrasena.setBackground(new Color(246, 245, 244));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=3;
		panelDerecho.add(txtContrasena,gbc);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=5;
		panelDerecho.add(lblEmail,gbc);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(246, 245, 244));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=5;
		panelDerecho.add(txtEmail,gbc);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setForeground(Color.BLACK);
		separatorEmail.setPreferredSize(new Dimension(180,2));
		gbc=new GridBagConstraints();
		gbc.gridx=1;
		gbc.gridy=6;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorEmail,gbc);

		JButton btnRegistro = new JButton("Registrarte");
		btnRegistro.addActionListener(e->{
			String nomCajero="";
			String contrasena="";
			String email="";
			cajero cajero=new cajero();
			cajero.setUsuario(txtUsuario.getText());
			cajero.setContraseña(String.valueOf(txtContrasena.getPassword()));
			cajero.setEmail(txtEmail.getText());
			 
			nomCajero=cajero.getUsuario();
			contrasena=cajero.getContraseña();
			email=cajero.getEmail();
			if (nomCajero.isEmpty()||contrasena.isEmpty()||email.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Debes de llenar los recuadros");
			} else {
				sqlite.AddCajero(nomCajero,contrasena,email);
				JOptionPane.showMessageDialog(null, "Se agrego el cajero");
			}
		});
		btnRegistro.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnRegistro.setBorder(null);
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setPreferredSize(new Dimension(70,70));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=7;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2;
		panelDerecho.add(btnRegistro,gbc);
		
	}
	public static void main(String[] args) {
		Registro registro=new Registro();
		registro.setVisible(true);
	}
}
