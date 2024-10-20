package com.codepulse;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backGround;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
	private JTextField txtEmail;

	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 380);
		setLocationRelativeTo(null);
		backGround = new JPanel();
		backGround.setBackground(new Color(246, 245, 244));
		backGround.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(backGround);
		backGround.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 235, 380);
		panel.setBackground(new Color(154, 153, 150));
		backGround.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setBounds(12, 25, 211, 115);
		panel.add(lblImagen);
		
		JButton btnIniciarSesion = new JButton("Inicio Sesión");
        btnIniciarSesion.addActionListener(e->{
            InicioSesion is=new InicioSesion();
            is.setVisible(true);
            this.dispose();
        });
		btnIniciarSesion.setBackground(new Color(255, 255, 255));
		btnIniciarSesion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setBounds(12, 143, 211, 47);
		panel.add(btnIniciarSesion);
		
		JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e->{
            this.dispose();
        });
		btnSalir.setBackground(new Color(61, 56, 70));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnSalir.setBorder(null);
		btnSalir.setBounds(12, 237, 211, 47);
		panel.add(btnSalir);
		
		JLabel lblRegistro = new JLabel("Registro");
		lblRegistro.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblRegistro.setFont(new Font("C059", Font.BOLD, 44));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(266, 12, 509, 57);
		backGround.add(lblRegistro);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("FreeSerif", Font.BOLD, 24));
		lblUsuario.setBounds(253, 81, 140, 35);
		backGround.add(lblUsuario);
		
		JSeparator separatorUsuario = new JSeparator();
		separatorUsuario.setForeground(new Color(0, 0, 0));
		separatorUsuario.setBounds(411, 114, 364, 2);
		backGround.add(separatorUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(new Color(246, 245, 244));
		txtUsuario.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(411, 81, 364, 29);
		backGround.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setFont(new Font("FreeSerif", Font.BOLD, 24));
		lblContrasena.setBounds(253, 146, 150, 35);
		backGround.add(lblContrasena);
		
		JSeparator separatorUsuario_1 = new JSeparator();
		separatorUsuario_1.setForeground(Color.BLACK);
		separatorUsuario_1.setBounds(411, 179, 364, 2);
		backGround.add(separatorUsuario_1);
		
		txtContrasena = new JTextField();
		txtContrasena.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtContrasena.setColumns(10);
		txtContrasena.setBorder(null);
		txtContrasena.setBackground(new Color(246, 245, 244));
		txtContrasena.setBounds(411, 146, 364, 29);
		backGround.add(txtContrasena);
		
		JButton btnRegistro = new JButton("Registrarte");
		btnRegistro.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnRegistro.setBorder(null);
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setBounds(407, 291, 211, 47);
		backGround.add(btnRegistro);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("FreeSerif", Font.BOLD, 24));
		lblEmail.setBounds(253, 210, 140, 35);
		backGround.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		txtEmail.setColumns(10);
		txtEmail.setBorder(null);
		txtEmail.setBackground(new Color(246, 245, 244));
		txtEmail.setBounds(411, 210, 364, 29);
		backGround.add(txtEmail);
		
		JSeparator separatorEmail = new JSeparator();
		separatorEmail.setForeground(Color.BLACK);
		separatorEmail.setBounds(411, 243, 364, 2);
		backGround.add(separatorEmail);
	}
}
