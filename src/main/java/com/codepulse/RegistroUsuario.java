package com.codepulse;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.*;
import java.awt.*;
public class RegistroUsuario extends JFrame{

    //variables del panel
    private JPanel backGround;
    private JPanel costadoBackGround;
    
    public RegistroUsuario(){
        setBounds(100,100,500,500);
        setLocationRelativeTo(null);

        backGround=new JPanel(new BorderLayout());
        backGround.setBackground(new Color(100,100,100,100));
        setContentPane(backGround);
        backGround.setLayout(null);

        costadoBackGround=new JPanel();
        costadoBackGround.setBackground(new Color(200,200,200,200));
        costadoBackGround.setBounds(0, 0, 100, 500);

        backGround.add(costadoBackGround,BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        RegistroUsuario r=new RegistroUsuario();
        r.setVisible(true);
    }
}
