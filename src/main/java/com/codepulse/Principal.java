package com.codepulse;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.codepulse.QR.QRCodeScannerWithOpenCV;

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

public class Principal extends JFrame {

	private JPanel backGround;
	private JPanel panelDerecho;
	private JPanel panelIzquierdo;
	private JButton btnRegistroCajero;

	public Principal(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 490);
		setVisible(true);
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
			String nombre=sqlite.obtenerNombre(id);
			PuntoDeVentaUI puntoVenta=new PuntoDeVentaUI(id,nombre);
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
			verUsuarios verUsuarios = new verUsuarios(id);
			verUsuarios.setVisible(true);
			this.dispose();
		});
		btnVerUsuario.setBackground(new Color(154, 153, 150));
		btnVerUsuario.setFont(new Font("FreeSans", Font.BOLD, 26));
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
		
		String nombre=sqlite.obtenerNombre(id);
		JLabel lblAdmin = new JLabel(nombre);
		lblAdmin.setFont(new Font("FreeSans", Font.BOLD, 30));
		gbc=new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.anchor=GridBagConstraints.CENTER;
		panelIzquierdo.add(lblAdmin,gbc);
		
		//--------botones costado-------------------------------------------

		if (id==1) {
			btnRegistroCajero=new JButton("Registrar Cajero");
			btnRegistroCajero.addActionListener(e->{
				RegistroCajero registroCajero=new RegistroCajero();
				registroCajero.setVisible(true);
			});
			btnRegistroCajero.setFont(new Font("FreeSans", Font.BOLD, 20));
			btnRegistroCajero.setBackground(new Color(119, 118, 123));
			btnRegistroCajero.setForeground(new Color(255, 255, 255));
			btnRegistroCajero.setPreferredSize(new Dimension(200,80));
			gbc=new GridBagConstraints();
			gbc.gridx=0;
			gbc.gridy=2;
			gbc.insets=new Insets(0, 10, 0, 10);
			gbc.fill=GridBagConstraints.HORIZONTAL;
			panelIzquierdo.add(btnRegistroCajero,gbc);
		}


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
		gbc.gridy=4;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.insets=new Insets(0, 10, 5, 10);
		panelIzquierdo.add(btnCerrarSesin,gbc);


		JButton btnScannear = new JButton("Scannear QR");
        btnScannear.addActionListener(e->{
            QRCodeScannerWithOpenCV inicioSesion=new QRCodeScannerWithOpenCV(id);
        });
		btnScannear.setFont(new Font("FreeSans", Font.BOLD, 20));
		btnScannear.setBackground(new Color(119, 118, 123));
		btnScannear.setForeground(new Color(255, 255, 255));
		btnScannear.setPreferredSize(new Dimension(200,80));
		gbc=new GridBagConstraints();
		gbc.weighty=1;
		gbc.weightx=1;
		gbc.gridy=3;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.anchor=GridBagConstraints.PAGE_END;
		gbc.insets=new Insets(0, 10, 5, 10);
		panelIzquierdo.add(btnScannear,gbc);
		
		//--------------------------------------------------------------------
	}
}
