package org.example;

import javax.swing.*;
import vista.PanelInicio;
import vista.PanelGanado;
import vista.PanelAgregar;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        PanelInicio panel = new PanelInicio();
        //PanelGanado panel2 = new PanelGanado();
        //PanelAgregar panel3 = new PanelAgregar();

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,600);
        f.add(panel);
        //f.add(panel2);
        //f.add(panel3);

        f.setVisible(true);

    }
}