package com.codepulse;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class VtnConfirmaVta extends JFrame {

    private JPanel backGround;
    private JButton btnCancelar;
    private JButton btnConfimar;
    private JLabel lblConfirmar;

    public  VtnConfirmaVta(String ventaR, JTable table,double total){
        setBounds(100, 100, 400, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        GridBagConstraints gbc=new GridBagConstraints();

        backGround = new JPanel();
        backGround.setLayout(new GridBagLayout());
        backGround.setBackground(new Color(255,255,255,255));
        setContentPane(backGround);

        lblConfirmar=new JLabel("Confimar Venta");
        lblConfirmar.setFont(new Font("FreeSans", Font.BOLD, 35));
        gbc=new GridBagConstraints();
        gbc.gridwidth=2;
        gbc.gridy=1;
        gbc.gridx=1;
        backGround.add(lblConfirmar,gbc);

        btnCancelar =new JButton("Cancelar");
        btnCancelar.addActionListener(e->{this.dispose();});
        btnCancelar.setBackground(new Color(150, 150, 150));
        btnCancelar.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
        gbc=new GridBagConstraints();
        gbc.gridx=1;
        gbc.gridy=2;
        gbc.insets=new Insets(0,0,0,5);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        backGround.add(btnCancelar,gbc);

        btnConfimar=new JButton("Confirmar");
        btnConfimar.addActionListener(e->{
            JOptionPane.showMessageDialog(null, ventaR);
            sqlite.registrarVenta(total);
            sqlite.rebajarCantidadBd(table);
            this.dispose();
        });
        btnConfimar.setBackground(new Color(150,150,150));
        btnConfimar.setFont(new Font("DejaVu Sans",Font.BOLD,20));
        gbc=new GridBagConstraints();
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.insets=new Insets(0,5,0,0);
        gbc.fill=GridBagConstraints.HORIZONTAL;
        backGround.add(btnConfimar,gbc);

    }
}
