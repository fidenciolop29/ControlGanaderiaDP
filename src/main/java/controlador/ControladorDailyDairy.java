package controlador;

import modelo.*;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDailyDairy implements ActionListener {
    private JFrameDailyDairy vista;
    private ModeloDailyDairy modelo;

    private PanelInicio panelInicio = new PanelInicio();
    private PanelGanado panelGanado = new PanelGanado();
    private PanelAgregar panelAgregar = new PanelAgregar();
    private PanelEliminar panelEliminar = new PanelEliminar();
    private PanelModificar panelModificar = new PanelModificar();

    public ControladorDailyDairy() {

    }

    public ControladorDailyDairy(ModeloDailyDairy modelo, JFrameDailyDairy vista) {
        this.modelo = modelo;
        this.vista = vista;
        vista.setControlador(this);
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

        this.vista.add(this.getPanelInicio());






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==panelInicio.getjButtonGanado()){
            System.out.println("Si me reconozco a mi mismo");
            vista.remove(panelInicio);
            vista.add(panelAgregar);
            vista.revalidate();
            vista.repaint();
        }

    }
    private void jButtonGanadoActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Hola");
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
