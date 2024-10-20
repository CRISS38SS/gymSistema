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

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backGround;
	private JTextField txtUsuario;
	private JTextField textField;

	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 350);
		setLocationRelativeTo(null);
		backGround = new JPanel();
		backGround.setBackground(new Color(246, 245, 244));
		backGround.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(backGround);
		backGround.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 235, 350);
		panel.setBackground(new Color(154, 153, 150));
		backGround.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("New label");
		lblImagen.setBounds(12, 25, 211, 115);
		panel.add(lblImagen);
		
		JButton btnRegistro = new JButton("Registrarte");
        btnRegistro.addActionListener(e->{
            Registro registro=new Registro();
            registro.setVisible(true);
            this.dispose();
        });
		btnRegistro.setBackground(new Color(255, 255, 255));
		btnRegistro.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnRegistro.setBorder(null);
		btnRegistro.setBounds(12, 143, 211, 47);
		panel.add(btnRegistro);
		
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
		
		JLabel lblInicioSesin = new JLabel("Inicio Sesión");
		lblInicioSesin.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblInicioSesin.setFont(new Font("C059", Font.BOLD, 44));
		lblInicioSesin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInicioSesin.setBounds(266, 12, 509, 57);
		backGround.add(lblInicioSesin);
		
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
		
		textField = new JTextField();
		textField.setFont(new Font("FreeSerif", Font.ITALIC, 24));
		textField.setColumns(10);
		textField.setBorder(null);
		textField.setBackground(new Color(246, 245, 244));
		textField.setBounds(411, 146, 364, 29);
		backGround.add(textField);
		
		JButton btnInicioSesion = new JButton("Inicio Sesión");
		btnInicioSesion.addActionListener(e->{
			Principal principal=new Principal();
			principal.setVisible(true);
			this.dispose();
		});
		btnInicioSesion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnInicioSesion.setBorder(null);
		btnInicioSesion.setBackground(new Color(255, 255, 255));
		btnInicioSesion.setBounds(406, 245, 211, 47);
		backGround.add(btnInicioSesion);
	}
}
