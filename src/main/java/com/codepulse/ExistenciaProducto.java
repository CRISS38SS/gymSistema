package com.codepulse;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExistenciaProducto extends JFrame{
    private JPanel backGround;
    private JButton btnCancelar;
    private JButton btnProdExistente;
    private JButton btnProdNuevo;
    private JLabel lblTitulo;
    private JPanel fondo;
    private JPanel bottomPanel;

    public ExistenciaProducto(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 200);
		setVisible(true);
        setLocationRelativeTo(null);

        configurarFondo();
        centerPanelSide();
        bottomPanelside();


       
    }

    private void configurarFondo() {
        fondo = new JPanel(new BorderLayout());
        setContentPane(fondo);
    }

    public void centerPanelSide(){
		backGround = new JPanel(new GridBagLayout());
        backGround.setBackground(new Color(200, 200, 200));

		fondo.add(backGround,BorderLayout.CENTER);
		
		GridBagConstraints gbc=new GridBagConstraints();

        lblTitulo=new JLabel("Agregar Producto");
        lblTitulo.setFont(new Font("FreeSans", Font.BOLD, 35));
        gbc=new GridBagConstraints();
        gbc.gridy=0;
        gbc.gridwidth=2;
        backGround.add(lblTitulo,gbc);

        btnProdExistente=new JButton("Producto Existente");
        btnProdExistente.setBackground(new Color(255, 255, 255));
        btnProdExistente.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.insets=new Insets(0, 0, 0, 5);
        backGround.add(btnProdExistente,gbc);

        btnProdNuevo=new JButton("Producto Nuevo");
        btnProdNuevo.addActionListener(e->{
            AgregarProducto producto=new AgregarProducto();
            producto.setVisible(true);
            this.dispose();
        });
        btnProdNuevo.setBackground(new Color(255, 255, 255));
        btnProdNuevo.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=1;
        gbc.insets=new Insets(0, 5, 0, 0);
        backGround.add(btnProdNuevo,gbc);

    }

    public void bottomPanelside(){

        bottomPanel=new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(180, 180, 180));

        btnCancelar=new JButton("Cancelar");
        btnCancelar.addActionListener(e->{
            this.dispose();
        });
        btnCancelar.setBackground(new Color(255, 255, 255));
        btnCancelar.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        bottomPanel.add(btnCancelar,BorderLayout.WEST);
        fondo.add(bottomPanel,BorderLayout.SOUTH); 

    }

    public static void main(String[] args) {
        ExistenciaProducto producto=new ExistenciaProducto();
        producto.setVisible(true);
    }
}