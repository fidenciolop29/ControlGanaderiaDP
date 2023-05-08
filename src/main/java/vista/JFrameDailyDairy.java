package vista;

import controlador.*;

import javax.swing.*;
import java.awt.*;

public class JFrameDailyDairy extends javax.swing.JFrame{
    private ControladorDailyDairy controlador;

    public JFrameDailyDairy() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
        this.setVisible(true);
    }

    public ControladorDailyDairy getControlador() {
        return controlador;
    }
    public void setControlador(ControladorDailyDairy controlador) {
        this.controlador = controlador;
    }
}
