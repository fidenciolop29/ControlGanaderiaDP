package org.example;

import javax.swing.*;
import vista.*;


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //PanelInicio panel = new PanelInicio();
//        PanelGanado panel = new PanelGanado();
        PanelAgregar panel = new PanelAgregar();
        //PanelEliminar panel = new PanelEliminar();
        //PanelModificar panel = new PanelModificar();

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900,600);
        f.add(panel);

        f.setVisible(true);

    }
}