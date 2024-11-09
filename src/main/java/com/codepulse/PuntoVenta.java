package com.codepulse;

import javax.swing.*;
import java.awt.*;

public class PuntoVenta extends JFrame{

    private JPanel backGround;
    private JPanel costadoBackGround;
    private JPanel mainPanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JButton btnBack;
    private JButton btnScan;
    private JLabel lblImagenCostado;


    public PuntoVenta(){
        // Configuración de la ventana
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        
        // Configuración del panel de fondo
        backGround = new JPanel(new GridBagLayout());
        setContentPane(backGround);


        //---------------------parte costadoPanel-------------------------------------------------------------
        // Configuración del panel "costadoBackGround" en el lado izquierdo
        costadoBackGround = new JPanel(new GridBagLayout());
        costadoBackGround.setBackground(new Color(200, 200, 200));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        backGround.add(costadoBackGround, gbc);

        // Configuración de lblImagen en costadoBackGround
        ImageIcon icono = new ImageIcon("src/main/java/com/Imagenes/logoCodePulse.jpg");
        lblImagenCostado = new JLabel(icono);
        Image image = icono.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        lblImagenCostado.setIcon(new ImageIcon(image));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx=1;
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el icono
        costadoBackGround.add(lblImagenCostado, gbc);

        // Configuración de btnScan en costadoBackGround
        btnScan = new JButton("Escanear");
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        costadoBackGround.add(btnScan, gbc);

        // Configuración de btnBack en costadoBackGround
        btnBack = new JButton("Regresar");
        btnBack.addActionListener(e -> {
            Principal principal = new Principal();
            principal.setVisible(true);
            dispose();
        });
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0; // Deja que el botón ocupe el espacio restante hacia el fondo
        gbc.anchor = GridBagConstraints.PAGE_END;
        costadoBackGround.add(btnBack, gbc);

        //---------termina aqui la parte costadoPanel----------------------------------------------------------

        // Configuración del panel principal (mainPanel) a la derecha de costadoBackGround
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(150, 150, 150));
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        backGround.add(mainPanel, gbc);


        //---------------------parte superior de main panel-------------------------------------------------------------
        // Configuración de un panel superior (topPanel) que ocupa la parte superior del mainPanel
        topPanel = new JPanel();
        topPanel.setBackground(new Color(180, 180, 180));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.9; // Controla el espacio del topPanel
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(topPanel, gbc);

        //---------termina aqui la parte superior de mainPanel----------------------------------------------------------


        //---------------------parte inferior de main panel-------------------------------------------------------------
        // Configuración del bottomPanel en la parte inferior del mainPanel
        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(100, 200, 100, 200));
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1; // Ajusta el espacio para el bottomPanel
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(bottomPanel, gbc);

        //---------termina aqui la parte inferior de mainPanel----------------------------------------------------------

    }

    public static void main(String[] args) {
        PuntoVenta puntoVenta = new PuntoVenta();
        puntoVenta.setVisible(true);
    }
}
