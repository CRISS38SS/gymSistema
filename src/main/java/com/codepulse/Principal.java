package com.codepulse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel backGround;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 490);
        setLocationRelativeTo(null);
		backGround = new JPanel();
		backGround.setBackground(new Color(246, 245, 244));
		backGround.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(backGround);
		backGround.setLayout(null);
		
		JButton btnRegistro = new JButton("Registrar");
		btnRegistro.setBackground(new Color(154, 153, 150));
		btnRegistro.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnRegistro.setBorder(null);
		btnRegistro.setBounds(248, 75, 280, 100);
		backGround.add(btnRegistro);
		
		JButton btnVerUsuarios = new JButton("Ver Usuarios");
		btnVerUsuarios.setBackground(new Color(154, 153, 150));
		btnVerUsuarios.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnVerUsuarios.setBorder(null);
		btnVerUsuarios.setBounds(558, 75, 280, 100);
		backGround.add(btnVerUsuarios);
		
		JButton btnAsistencias = new JButton("Asistencias");
		btnAsistencias.setBackground(new Color(154, 153, 150));
		btnAsistencias.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnAsistencias.setBorder(null);
		btnAsistencias.setBounds(248, 337, 280, 100);
		backGround.add(btnAsistencias);
		
		JButton btnSeguimientoDePagos = new JButton("Seguimiento De pagos");
		btnSeguimientoDePagos.setBackground(new Color(192, 191, 188));
		btnSeguimientoDePagos.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnSeguimientoDePagos.setBorder(null);
		btnSeguimientoDePagos.setBounds(248, 206, 590, 100);
		backGround.add(btnSeguimientoDePagos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(154, 153, 150));
		panel.setBounds(0, 0, 214, 490);
		backGround.add(panel);
		panel.setLayout(null);
		
		JLabel lblImagen = new JLabel("Imagen");
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagen.setBounds(12, 12, 190, 168);
		panel.add(lblImagen);
		
		JLabel lblAdmin = new JLabel("admin");
		lblAdmin.setFont(new Font("FreeSans", Font.BOLD, 18));
		lblAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdmin.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAdmin.setBounds(12, 192, 190, 32);
		panel.add(lblAdmin);
		
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
        btnCerrarSesin.addActionListener(e->{
            InicioSesion inicioSesion=new InicioSesion();
            inicioSesion.setVisible(true);
            this.dispose();
        });
		btnCerrarSesin.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnCerrarSesin.setBackground(new Color(119, 118, 123));
		btnCerrarSesin.setForeground(new Color(255, 255, 255));
		btnCerrarSesin.setBounds(12, 395, 190, 54);
		panel.add(btnCerrarSesin);
		
		JButton btnCambiarImagen = new JButton("cambiar Imagen");
        btnCambiarImagen.addActionListener(e->{
            JOptionPane.showMessageDialog(null, "cambio la imagen");
        });
		btnCambiarImagen.setFont(new Font("FreeSans", Font.BOLD, 18));
		btnCambiarImagen.setBackground(new Color(246, 245, 244));
		btnCambiarImagen.setBounds(12, 235, 190, 54);
		panel.add(btnCambiarImagen);
		
		JButton btnAsistencias_1 = new JButton("Asistencias");
		btnAsistencias_1.setBackground(new Color(154, 153, 150));
		btnAsistencias_1.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnAsistencias_1.setBorder(null);
		btnAsistencias_1.setBounds(558, 337, 280, 100);
		backGround.add(btnAsistencias_1);
		
		JLabel lblPrincipalGymLuffy = new JLabel("Principal Gym Luffy");
		lblPrincipalGymLuffy.setFont(new Font("FreeSans", Font.BOLD, 30));
		lblPrincipalGymLuffy.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrincipalGymLuffy.setBounds(308, 12, 478, 39);
		backGround.add(lblPrincipalGymLuffy);
	}
}
