package org.main;

import controlador.*;
import modelo.ModeloDailyDairy;
import vista.*;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        //Modelo
        ModeloDailyDairy modelo = new ModeloDailyDairy();

        //Vistas
        ArrayList<Object> vistas = new ArrayList<>();
        vistas.add(0, new JFrameDailyDairy());
        vistas.add(1, new PanelInicio());
        vistas.add(2, new PanelAgregar());
        vistas.add(3, new PanelEditar());
        vistas.add(4, new PanelGanado());
        vistas.add(5, new PanelEliminar());
        vistas.add(6, new PanelOrdena());
        vistas.add(7, new PanelProduccion());
        vistas.add(8, new PanelAgregarOrdena());
        vistas.add(9, new PanelEliminarOrdena());

        //Controlador
        ControladorDailyDairy controlador = new ControladorDailyDairy(modelo, vistas);

    }
}