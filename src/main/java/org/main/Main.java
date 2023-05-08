package org.main;

import controlador.ControladorDailyDairy;
import modelo.ModeloDailyDairy;
import vista.*;


public class Main {
    public static void main(String[] args) {
        JFrameDailyDairy vista = new JFrameDailyDairy();
        ModeloDailyDairy modelo = new ModeloDailyDairy();
        ControladorDailyDairy controlador = new ControladorDailyDairy(modelo,vista);

    }
}