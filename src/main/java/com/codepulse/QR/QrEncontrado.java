package com.codepulse.QR;

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

public class QrEncontrado extends JFrame{
    private JPanel backGround;
    private JPanel bottomJPanel;
    private JPanel centerJPanel;

    private JLabel lblEncontrado;

    private JButton btnRegresar;

    public QrEncontrado(String estado){
        setTitle("Usuario Encontrado");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        configureBackGround();
        configureCenterPanel(estado);
        configureBottomPanel();
    }
    public void configureBackGround(){
        backGround=new JPanel(new BorderLayout());
        setContentPane(backGround);
    }

    public void configureCenterPanel(String estado){
        centerJPanel=new JPanel(new GridBagLayout());
        if (estado.equals("Encontrado")) {
            centerJPanel.setBackground(Color.GREEN);
        }else{
            centerJPanel.setBackground(Color.RED);
        }
        GridBagConstraints gbc=new GridBagConstraints();
        gbc.insets=new Insets(10, 10, 10, 10);

        lblEncontrado=new JLabel();

        if (estado.equals("Encontrado")) {
            lblEncontrado.setText("Usuario Encontrado");
        }else{
            lblEncontrado.setText("Usuario No Encontrado");
        }
        lblEncontrado.setBackground(new Color(246, 245, 244));
		lblEncontrado.setFont(new Font("FreeSerif", Font.BOLD, 24));
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=0;
        centerJPanel.add(lblEncontrado,gbc);

        backGround.add(centerJPanel,BorderLayout.CENTER);

    }

    public void configureBottomPanel(){
        bottomJPanel=new JPanel(new BorderLayout());
        bottomJPanel.setBackground(Color.gray);


        btnRegresar=new JButton("Regresar");
        btnRegresar.setBackground(new Color(255, 255, 255));
        btnRegresar.setFont(new Font("DejaVu Sans", Font.BOLD, 25));
        bottomJPanel.add(btnRegresar,BorderLayout.WEST);

        backGround.add(bottomJPanel,BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        QrEncontrado qrEncontrado=new QrEncontrado("Encontrado");
        qrEncontrado.setVisible(true);
    }
}
