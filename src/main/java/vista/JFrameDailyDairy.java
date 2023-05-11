package vista;

import controlador.*;

import javax.swing.*;
import java.awt.*;

public class JFrameDailyDairy extends javax.swing.JFrame{
    private ControladorDailyDairy controlador;
    private PanelInicio Defaultpanel;

    public JFrameDailyDairy() throws HeadlessException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900,600);
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
}
