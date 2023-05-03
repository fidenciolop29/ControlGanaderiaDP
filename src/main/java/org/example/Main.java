package org.example;

import javax.swing.*;
import vista.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        PanelInicio panel = new PanelInicio();
        //PanelGanado panel2 = new PanelGanado();
        //PanelAgregar panel3 = new PanelAgregar();
        //PanelEliminar panel4 = new PanelEliminar();
        //PanelModificar panel5 = new PanelModificar();

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,600);
        f.add(panel);
        //f.add(panel2);
        //f.add(panel3);
        //f.add(panel4);
        //f.add(panel5);

        f.setVisible(true);

    }
}