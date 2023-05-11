package org.main;

import controlador.ControladorDailyDairy;
import modelo.ModeloDailyDairy;
import vista.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //Modelo
        ModeloDailyDairy modelo = new ModeloDailyDairy();

        //Vistas
        ArrayList<Object> vistas = new ArrayList<>();
        vistas.add(0,new JFrameDailyDairy());
        vistas.add(1,new PanelInicio());
        vistas.add(2,new PanelAgregar());
        vistas.add(3,new PanelModificar());
        vistas.add(4,new PanelGanado());
        vistas.add(5,new PanelEliminar());

        //Controlador
        ControladorDailyDairy controlador = new ControladorDailyDairy(modelo,vistas);

    }
}