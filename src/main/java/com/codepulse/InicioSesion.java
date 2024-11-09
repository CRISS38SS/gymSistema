package com.codepulse;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backGround;
	private JTextField txtUsuario;
	private JTextField txtContrasena;
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
		gbc.fill = GridBagConstraints.BOTH; // Expande para llenar el espacio
		panelIzquierdo.setBackground(new Color(154, 153, 150));
		backGround.add(panelIzquierdo,gbc);

		panelDerecho=new JPanel(new GridBagLayout());
		gbc.gridx=1;
		gbc.weightx = 0.8;
		gbc.fill = GridBagConstraints.BOTH; // Expande para llenar el espacio
		panelDerecho.setBackground(new Color(246, 245, 244));
		backGround.add(panelDerecho,gbc);
		
		ImageIcon icono = new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        JLabel lblImagen = new JLabel(icono);
        Image image = icono.getImage().getScaledInstance(190, 190, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(image));
		gbc=new GridBagConstraints();
		//gbc.gridx=0;
		gbc.gridy=0;
		gbc.weighty=1;
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
		btnRegistro.setBorder(null);
		//gbc.gridx=0;
		gbc.gridy=1;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weightx=1;
		gbc.insets=new Insets(0, 15, 0, 15);
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
		btnSalir.setBorder(null);
		//gbc.gridx=0;
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
		panelDerecho.add(lblInicioSesin,gbc);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		gbc=new GridBagConstraints();
		lblUsuario.setFont(new Font("FreeSerif", Font.BOLD, 24));
		gbc.gridx=0;
		gbc.gridy=1;
		panelDerecho.add(lblUsuario,gbc);
		
		
		txtUsuario = new JTextField();
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
		separatorUsuario.setPreferredSize(new java.awt.Dimension(180, 2)); // Ajusta el tamaño si es necesario
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
		separatorContrasena.setPreferredSize(new java.awt.Dimension(180, 2)); // Ajusta el tamaño si es necesario
		gbc.gridx=1;
		gbc.gridy=4;
		gbc.insets=new Insets(0, 0, 35, 0);
		panelDerecho.add(separatorContrasena,gbc);
		
		txtContrasena = new JTextField();
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
			Principal principal=new Principal();
			principal.setVisible(true);
			this.dispose();
		});
		btnInicioSesion.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
		btnInicioSesion.setBorder(null);
		btnInicioSesion.setBackground(new Color(255, 255, 255));
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.gridwidth=2;
		gbc.insets=new Insets(35, 0, 0, 0);
		panelDerecho.add(btnInicioSesion,gbc);
	}
	public static void main(String[] args) {
		InicioSesion inicioSesion=new InicioSesion();
		inicioSesion.setVisible(true);
	}
}
