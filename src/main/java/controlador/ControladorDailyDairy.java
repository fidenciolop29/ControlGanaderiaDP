package controlador;

import modelo.*;
import vista.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControladorDailyDairy implements ActionListener, MouseListener {
    private JFrameDailyDairy frame;
    private ModeloDailyDairy modelo;
    private PanelInicio panelInicio;
    private PanelGanado panelGanado;
    private PanelAgregar panelAgregar;
    private PanelEliminar panelEliminar;
    private PanelModificar panelModificar;

    private PanelOrdena panelOrdena;
    private PanelAgregarOrdena panelAgregarOrdena;
    private PanelEliminarOrdena panelEliminarOrdena;
    private PanelProduccion panelProduccion;

    private Connection connection;

    public ControladorDailyDairy(ModeloDailyDairy modelo, ArrayList<Object> vistas) {
        this.modelo = modelo;
        this.frame = (JFrameDailyDairy) vistas.get(0);

        this.connection = ModeloDailyDairy.getConnection();
        this.panelInicio = (PanelInicio) vistas.get(1);
        this.panelAgregar = (PanelAgregar) vistas.get(2);
        this.panelModificar = (PanelModificar) vistas.get(3);
        this.panelGanado = (PanelGanado) vistas.get(4);
        this.panelEliminar = (PanelEliminar) vistas.get(5);
        this.panelOrdena = (PanelOrdena) vistas.get(6);
        this.panelProduccion = (PanelProduccion) vistas.get(7);
        this.panelAgregarOrdena = (PanelAgregarOrdena) vistas.get(8);
        this.panelEliminarOrdena = (PanelEliminarOrdena) vistas.get(9);

        frame.setControlador(this);

        this.getPanelInicio().setControlador(this);
        this.getPanelAgregar().setControlador(this);
        this.getPanelGanado().setControlador(this);
        this.getPanelEliminar().setControlador(this);
        this.getPanelModificar().setControlador(this);
        this.getPanelAgregarOrdena().setControlador(this);
        this.getPanelEliminarOrdena().setControlador(this);
        this.getPanelOrdena().setControlador(this);
        this.getPanelProduccion().setControlador(this);


//        this.getPanelInicio().addActionListenersPanelInicioComponents();


//        this.getPanelAgregar().setControlador(this);
//        this.getPanelGanado().setControlador(this);
//        this.getPanelEliminar().setControlador(this);
//        this.getPanelModificar().setControlador(this);
        this.frame.add(this.getPanelInicio());



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==panelInicio.getBtnGanado()) {
            frame.remove(panelInicio);
            frame.add(panelGanado);
        }

        if (e.getSource()==panelGanado.getBtnRegresar()){
            frame.remove(panelGanado);
            frame.add(panelInicio);
        }



        if (e.getSource()==panelModificar.getBtnRegresar()){
            frame.remove(panelModificar);
            frame.add(panelGanado);
        }

        if (e.getSource()==panelAgregar.getBtnRegresar()){
            frame.remove(panelAgregar);
            frame.add(panelGanado);
        }

        if (e.getSource()==panelEliminar.getBtnRegresar()){
            frame.remove(panelEliminar);
            frame.add(panelGanado);
        }

        if (e.getSource() == panelOrdena.getBtnRegresar()){
            frame.remove(panelOrdena);
            frame.add(panelGanado);
        }

        //Agregar ganado
        if (e.getSource() == panelAgregar.getBtnAgregar()){
            //FALTA VALIDACION
            System.out.println("Agregar");
            String bajaMuerteExtravio = "0";
            String statusordeña = "0";
//            String sexoGanado = panelAgregar.getCboxSexo().getSelectedItem().toString();
            String sexoGanado = "h";
//            System.out.println(panelAgregar.getCboxDescripcion().getSelectedItem().toString());
            String descripcionGanado = panelAgregar.getCboxDescripcion().getSelectedItem().toString();
            String fierroGanado = panelAgregar.getTxtFierro().getText();
            String razaGanado = panelAgregar.getTxtRaza().getText();
            String colorGanado = panelAgregar.getTxtColor().getText();
            String numeroGanado = panelAgregar.getTxtNumero().getText();
            String fotografiaGanado = null;

            try{
                ModeloDailyDairy.insertTuplaBD(this.connection, new TuplaDailyDairy(numeroGanado,fierroGanado,colorGanado,razaGanado,descripcionGanado,sexoGanado,statusordeña,fotografiaGanado,bajaMuerteExtravio));
            }catch (Exception ex){
                System.out.println(ex.getMessage());
            }



        }



        refrescarPanelGanado();
        frame.revalidate();
        frame.repaint();

    }

    private void refrescarPanelGanado() {

        try {
            this.modelo.loadTuplas(this.connection);
            //System.out.println("El modelo tiene las tuplas");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        DefaultTableModel modelo = (DefaultTableModel) panelGanado.getTablaGanado().getModel();

        panelGanado.setTablaGanado(TuplaDailyDairy.updateJTableGanado(this.modelo.getTuplas(), modelo));


    }

    @Override
    public void mouseClicked(MouseEvent e) {

//        if (e.getSource()==panelGanado.getBtnAgregar() || e.getSource()==panelGanado.getLblSubAgregar() || e.getSource()==panelGanado.getLblTituloAgregar() ){
//            frame.remove(panelGanado);
//            frame.add(panelAgregar);
//        }
//        if (e.getSource()==panelGanado.getBtnEditar() || e.getSource()==panelGanado.getLblSubEditar() || e.getSource()==panelGanado.getLblTituloEditar()){
//            frame.remove(panelGanado);
//            frame.add(panelModificar);
//        }
//        if (e.getSource()==panelGanado.getBtnEliminar() || e.getSource()==panelGanado.getLblSubEliminar() || e.getSource()==panelGanado.getLblTituloEliminar()){
//            frame.remove(panelGanado);
//            frame.add(panelEliminar);
//        }
//        if (e.getSource()==panelGanado.getBtnMostrarOrdena() || e.getSource()==panelGanado.getLblSubMostrarOrdena() || e.getSource()==panelGanado.getLblTituloMostrarOrdena()){
//            frame.remove(panelGanado);
//            frame.add(panelOrdena);
//        }
//        if (e.getSource()==panelGanado.getBtnListaGanado() || e.getSource()==panelGanado.getLblSubListaGanado() || e.getSource()==panelGanado.getLblTituloListaGanado()){
//            frame.remove(panelGanado);
//            frame.add(panelGanado);
//        }
//
//
//
//        frame.revalidate();
//        frame.repaint();


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource()==panelGanado.getBtnAgregar() || e.getSource()==panelGanado.getLblSubAgregar() || e.getSource()==panelGanado.getLblTituloAgregar() ){
            frame.remove(panelGanado);
            frame.add(panelAgregar);
        }
        if (e.getSource()==panelGanado.getBtnEditar() || e.getSource()==panelGanado.getLblSubEditar() || e.getSource()==panelGanado.getLblTituloEditar()){
            frame.remove(panelGanado);
            frame.add(panelModificar);
        }
        if (e.getSource()==panelGanado.getBtnEliminar() || e.getSource()==panelGanado.getLblSubEliminar() || e.getSource()==panelGanado.getLblTituloEliminar()){
            frame.remove(panelGanado);
            frame.add(panelEliminar);
        }
        if (e.getSource()==panelGanado.getBtnMostrarOrdena() || e.getSource()==panelGanado.getLblSubMostrarOrdena() || e.getSource()==panelGanado.getLblTituloMostrarOrdena()){
            frame.remove(panelGanado);
            frame.add(panelOrdena);
        }
        /*if (e.getSource()==panelGanado.getBtnListaGanado() || e.getSource()==panelGanado.getLblSubListaGanado() || e.getSource()==panelGanado.getLblTituloListaGanado()){
            frame.remove(panelGanado);
            frame.add(panelGanado);
        }*/



        frame.revalidate();
        frame.repaint();
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
    public PanelOrdena getPanelOrdena() {
        return panelOrdena;
    }

    public void setPanelOrdena(PanelOrdena panelOrdena) {
        this.panelOrdena = panelOrdena;
    }

    public PanelAgregarOrdena getPanelAgregarOrdena() {
        return panelAgregarOrdena;
    }

    public void setPanelAgregarOrdena(PanelAgregarOrdena panelAgregarOrdena) {
        this.panelAgregarOrdena = panelAgregarOrdena;
    }

    public PanelEliminarOrdena getPanelEliminarOrdena() {
        return panelEliminarOrdena;
    }

    public void setPanelEliminarOrdena(PanelEliminarOrdena panelEliminarOrdena) {
        this.panelEliminarOrdena = panelEliminarOrdena;
    }

    public PanelProduccion getPanelProduccion() {
        return panelProduccion;
    }

    public void setPanelProduccion(PanelProduccion panelProduccion) {
        this.panelProduccion = panelProduccion;
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
