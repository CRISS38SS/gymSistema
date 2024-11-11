package com.codepulse;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame {

	private JPanel backGround;
	private JPanel panelDerecho;
	private JPanel panelIzquierdo;

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


		backGround = new JPanel(new GridBagLayout());
		setContentPane(backGround);
		
		GridBagConstraints gbc=new GridBagConstraints();

		//panel izquierdo
		panelIzquierdo = new JPanel(new GridBagLayout());
		panelIzquierdo.setBackground(new Color(154, 153, 150));
		gbc=new GridBagConstraints();
		gbc.weightx=0.2;
		gbc.weighty=1;
		gbc.gridx=0;
		gbc.fill=GridBagConstraints.BOTH;
		backGround.add(panelIzquierdo,gbc);

		//panel Derecho
		panelDerecho=new JPanel(new GridBagLayout());
		panelDerecho.setBackground(new Color(246, 245, 244));
		gbc=new GridBagConstraints();
		gbc.weightx=0.8;
		gbc.weighty=1;
		gbc.gridx=1;
		gbc.fill=GridBagConstraints.BOTH;
		backGround.add(panelDerecho,gbc);

		JLabel lblGymGorillaz = new JLabel("Gym Gorillaz");
		lblGymGorillaz.setFont(new Font("FreeSans", Font.BOLD, 60));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.weightx=2;
		gbc.anchor=GridBagConstraints.PAGE_START;
		gbc.weighty=1;
		panelDerecho.add(lblGymGorillaz,gbc);

		//------botones--------------------------------------------------
		JButton btnRegistro = new JButton("Registrar Cliente");
		btnRegistro.addActionListener(e->{
			RegistroUsuario registroUsuario=new RegistroUsuario();
			registroUsuario.setVisible(true);
		});
		btnRegistro.setBackground(new Color(154, 153, 150));
		btnRegistro.setFont(new Font("FreeSans", Font.BOLD, 26));
		btnRegistro.setPreferredSize(new Dimension(10,30));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(0,30,25,30);
		gbc.anchor=GridBagConstraints.CENTER;
		panelDerecho.add(btnRegistro,gbc);


		JButton btnPuntoVenta = new JButton("Punto de venta");
		btnPuntoVenta.addActionListener(e->{
			PuntoDeVentaUI puntoVenta=new PuntoDeVentaUI();
			puntoVenta.setVisible(true);
			dispose();
		});
		btnPuntoVenta.setBackground(new Color(192, 191, 188));
		btnPuntoVenta.setFont(new Font("FreeSans", Font.BOLD, 26));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.weightx=1;
		gbc.weighty=1;
		gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(0,30,25,30);
		gbc.anchor=GridBagConstraints.CENTER;
		panelDerecho.add(btnPuntoVenta,gbc);


		JButton btnVerUsuario = new JButton("Ver Usuario");
		btnVerUsuario.addActionListener(e->{
			JOptionPane.showMessageDialog(null, "se abre ver usuario");
		});
		btnVerUsuario.setBackground(new Color(154, 153, 150));
		btnVerUsuario.setFont(new Font("FreeSans", Font.BOLD, 26));
		//btnVerUsuario.setBounds(248, 337, 590, 100);
		gbc=new GridBagConstraints();
		gbc.weightx=1;
		gbc.gridx=0;
		gbc.gridy=3;
		gbc.fill=GridBagConstraints.BOTH;
		gbc.anchor=GridBagConstraints.CENTER;
		gbc.weighty=1;
		gbc.insets=new Insets(0,30,0,30);
		panelDerecho.add(btnVerUsuario,gbc);

		JLabel h = new JLabel("");
		h.setFont(new Font("FreeSans", Font.BOLD, 60));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=4;
		gbc.weightx=2;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.weighty=1;
		panelDerecho.add(h,gbc);
		
		//---------------------------------------------------------------
		
		ImageIcon icon=new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
		JLabel lblImagen = new JLabel(icon);
		Image image=icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		lblImagen.setIcon(new ImageIcon(image));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		panelIzquierdo.add(lblImagen,gbc);
		
		JLabel lblAdmin = new JLabel("administrador");
		lblAdmin.setFont(new Font("FreeSans", Font.BOLD, 30));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.CENTER;
		panelIzquierdo.add(lblAdmin,gbc);
		
		//--------botones costado-------------------------------------------
		JButton btnCerrarSesin = new JButton("Cerrar Sesión");
        btnCerrarSesin.addActionListener(e->{
            InicioSesion inicioSesion=new InicioSesion();
            inicioSesion.setVisible(true);
            this.dispose();
        });
		btnCerrarSesin.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnCerrarSesin.setBackground(new Color(119, 118, 123));
		btnCerrarSesin.setForeground(new Color(255, 255, 255));
		btnCerrarSesin.setPreferredSize(new Dimension(200,80));
		gbc=new GridBagConstraints();
		gbc.weighty=1;
		gbc.weightx=1;
		gbc.gridy=2;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.insets=new Insets(0, 10, 5, 10);
		panelIzquierdo.add(btnCerrarSesin,gbc);
		
		//--------------------------------------------------------------------
	}
}
