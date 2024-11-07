package com.codepulse;

import javax.swing.*;
import java.awt.*;

public class puntoVenta extends JFrame{

    private JPanel backGround;
    private JPanel costadoBackGround;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JButton btnBack;

    public puntoVenta(){
        //configurar la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension screemSize=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screemSize);
        backGround=new JPanel();
        backGround.setLayout(new GridBagLayout());
        setContentPane(backGround);
        // Configuración del panel "costadoBackGround" en el lado izquierdo
        costadoBackGround = new JPanel(new GridBagLayout()); // Usar GridBagLayout aquí también
        costadoBackGround.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.2;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH; // Expande para llenar el espacio
        backGround.add(costadoBackGround, gbc);
        // Configuración del panel principal (mainPanel) a la derecha de costadoBackGround
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(150, 150, 150));
        gbc.gridx = 1;
        gbc.weightx = 0.8;       // Más espacio en el eje X para mainPanel
        backGround.add(mainPanel, gbc);

        //configuracion de buttomPanel
        bottomPanel=new JPanel();
        bottomPanel.setBackground(new Color(300,200,300,200));
        
        

        //configurar el btnRegresar
        btnBack=new JButton("Regresar");
        btnBack.addActionListener(e->{
            Principal principal=new Principal();
            principal.setVisible(true);
            dispose();
        });
        gbc=new GridBagConstraints();
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill=GridBagConstraints.BOTH;
        costadoBackGround.add(btnBack,gbc);
    }

    public static void main(String[] args) {
        puntoVenta puntoVenta=new puntoVenta();
        puntoVenta.setVisible(true);
    }
}
