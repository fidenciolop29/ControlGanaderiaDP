package controlador;

import modelo.*;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorDailyDairy implements ActionListener {
    private JFrameDailyDairy frame;
    private ModeloDailyDairy modelo;
    private PanelInicio panelInicio;
    private PanelGanado panelGanado;
    private PanelAgregar panelAgregar;
    private PanelEliminar panelEliminar;
    private PanelModificar panelModificar;

    public ControladorDailyDairy() {

    }

    public ControladorDailyDairy(ModeloDailyDairy modelo, ArrayList<Object> vistas) {
        this.modelo = modelo;
        this.frame = (JFrameDailyDairy) vistas.get(0);
        this.panelInicio = (PanelInicio) vistas.get(1);
        this.panelAgregar = (PanelAgregar) vistas.get(2);
        this.panelModificar = (PanelModificar) vistas.get(3);
        this.panelGanado = (PanelGanado) vistas.get(4);
        this.panelEliminar = (PanelEliminar) vistas.get(5);

        frame.setControlador(this);
        this.getPanelInicio().setControlador(this);
        this.getPanelAgregar().setControlador(this);
        this.getPanelGanado().setControlador(this);
        this.getPanelEliminar().setControlador(this);
        this.getPanelModificar().setControlador(this);


        this.getPanelInicio().addActionListenersPanelInicioComponents();


//        this.getPanelAgregar().setControlador(this);
//        this.getPanelGanado().setControlador(this);
//        this.getPanelEliminar().setControlador(this);
//        this.getPanelModificar().setControlador(this);
        this.frame.add(this.getPanelInicio());






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==panelInicio.getBtnGanado()){

            frame.remove(panelInicio);
            frame.add(panelAgregar);
            frame.revalidate();
            frame.repaint();
        }

    }

    public PanelInicio getPanelInicio() {
        return panelInicio;
    }
    public void setPanelInicio(PanelInicio panelInicio) {
        this.panelInicio = panelInicio;
    }
    public PanelGanado getPanelGanado() {
        return panelGanado;
    }
    public void setPanelGanado(PanelGanado panelGanado) {
        this.panelGanado = panelGanado;
    }
    public PanelAgregar getPanelAgregar() {
        return panelAgregar;
    }
    public void setPanelAgregar(PanelAgregar panelAgregar) {
        this.panelAgregar = panelAgregar;
    }
    public PanelEliminar getPanelEliminar() {
        return panelEliminar;
    }
    public void setPanelEliminar(PanelEliminar panelEliminar) {
        this.panelEliminar = panelEliminar;
    }
    public PanelModificar getPanelModificar() {
        return panelModificar;
    }
    public void setPanelModificar(PanelModificar panelModificar) {
        this.panelModificar = panelModificar;
    }

}
