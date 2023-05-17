package vista;

import controlador.*;
import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;

public class JFrameDailyDairy extends javax.swing.JFrame {
    private ControladorDailyDairy controlador;
    private PanelInicio Defaultpanel;
    private java.sql.Connection Connection;

    public JFrameDailyDairy() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080,640);
//        this.setDefaultpanel(new PanelInicio());
//        this.add(this.getDefaultpanel());
        this.setVisible(true);
    }

    public ControladorDailyDairy getControlador() {
        return controlador;
    }
    public void setControlador(ControladorDailyDairy controlador) {
        this.controlador = controlador;
    }
    public PanelInicio getDefaultpanel() {
        return Defaultpanel;
    }

    public void setDefaultpanel(PanelInicio defaultpanel) {
        Defaultpanel = defaultpanel;
    }

    public void resetDefaultpanel(){
        this.remove(this.getDefaultpanel());
    }

    private Connection getConnection() {
        return this.Connection;
    }

    public void setConnection(java.sql.Connection connection) {
        Connection = connection;
    }


}
