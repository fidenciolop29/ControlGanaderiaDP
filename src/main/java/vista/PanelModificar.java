/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ControladorDailyDairy;

import javax.swing.*;
import java.awt.Color;

/**
 *
 * @author Uriel Méndez Romero
 */
public class PanelModificar extends javax.swing.JPanel {

  /**
   * Creates new form PanelGanado
   */
  public PanelModificar() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelDerecha = new javax.swing.JPanel();
    panelSur = new javax.swing.JPanel();
    btnGuardar = new javax.swing.JButton();
    btnRegresar = new javax.swing.JButton();
    panelNorte = new javax.swing.JPanel();
    lblTituloModificacion = new javax.swing.JLabel();
    panelCentro = new javax.swing.JPanel();
    lblFierro = new javax.swing.JLabel();
    txtFierro = new javax.swing.JTextField();
    lblColor = new javax.swing.JLabel();
    txtColor = new javax.swing.JTextField();
    lblRaza = new javax.swing.JLabel();
    txtRaza = new javax.swing.JTextField();
    lblDescripcion = new javax.swing.JLabel();
    cboxDescripcion = new javax.swing.JComboBox<>();
    lblSexo = new javax.swing.JLabel();
    cboxSexo = new javax.swing.JComboBox<>();
    panelIzquierda = new javax.swing.JPanel();
    panelBuscar = new javax.swing.JPanel();
    lblNumero = new javax.swing.JLabel();
    txtNumero = new javax.swing.JTextField();
    panelBtnBuscar = new javax.swing.JPanel();
    btnBuscar = new javax.swing.JButton();
    lblImagenGanado = new javax.swing.JLabel();
    panelEditarImagen = new javax.swing.JPanel();
    btnEditarImagen = new javax.swing.JButton();

    setBackground(new Color(254, 254, 254));
    setBorder(new javax.swing.border.LineBorder(new Color(255, 255, 255), 10, true));
    setPreferredSize(new java.awt.Dimension(250, 340));
    setLayout(new java.awt.BorderLayout(5, 0));

    panelDerecha.setLayout(new java.awt.BorderLayout());

    panelSur.setBackground(new Color(143,190,0,25));
    panelSur.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 40, 5));
    panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

    btnGuardar.setBackground(new Color(0, 168, 198, 135));
    btnGuardar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    btnGuardar.setForeground(new Color(255, 255, 255));
    btnGuardar.setText("Guardar");
    btnGuardar.setFocusable(false);
    panelSur.add(btnGuardar);

    btnRegresar.setBackground(new Color(0, 168, 198, 135));
    btnRegresar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    btnRegresar.setForeground(new Color(255, 255, 255));
    btnRegresar.setText("Regresar");
    panelSur.add(btnRegresar);

    panelDerecha.add(panelSur, java.awt.BorderLayout.PAGE_END);

    panelNorte.setBackground(new Color(143,190,0,25));
    panelNorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 20, 20, 20));

    lblTituloModificacion.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
    lblTituloModificacion.setText("MODIFICACION DE GANADO");
    panelNorte.add(lblTituloModificacion);

    panelDerecha.add(panelNorte, java.awt.BorderLayout.NORTH);

    panelCentro.setBackground(new Color(143,190,0,25));
    panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 110, 10, 110));
    panelCentro.setFocusable(false);
    panelCentro.setLayout(new java.awt.GridLayout(11, 0, 0, 5));

    lblFierro.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblFierro.setText("Fierro");
    lblFierro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    panelCentro.add(lblFierro);

    txtFierro.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    txtFierro.setPreferredSize(new java.awt.Dimension(64, 18));
    panelCentro.add(txtFierro);

    lblColor.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblColor.setText("Color");
    lblColor.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    panelCentro.add(lblColor);

    txtColor.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    txtColor.setPreferredSize(new java.awt.Dimension(64, 18));
    panelCentro.add(txtColor);

    lblRaza.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblRaza.setText("Raza");
    lblRaza.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    panelCentro.add(lblRaza);

    txtRaza.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    txtRaza.setPreferredSize(new java.awt.Dimension(64, 18));
    panelCentro.add(txtRaza);

    lblDescripcion.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblDescripcion.setText("Descripción");
    panelCentro.add(lblDescripcion);

    cboxDescripcion.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    cboxDescripcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vaca", "Toro", "Novillo", "Novilla", "Vaquillla", "Cria" }));
    panelCentro.add(cboxDescripcion);

    lblSexo.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblSexo.setText("Sexo");
    lblSexo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    panelCentro.add(lblSexo);

    cboxSexo.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    cboxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Macho", "Hembra" }));
    cboxSexo.setSelectedItem("");
    cboxSexo.setToolTipText("");
    panelCentro.add(cboxSexo);

    panelDerecha.add(panelCentro, java.awt.BorderLayout.CENTER);

    add(panelDerecha, java.awt.BorderLayout.CENTER);

    panelIzquierda.setBackground(new Color(143,190,0,170));
    panelIzquierda.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 20, 20, 20));
    panelIzquierda.setLayout(new java.awt.GridLayout(3, 1, 20, 20));

    panelBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
    panelBuscar.setOpaque(false);
    panelBuscar.setLayout(new java.awt.GridLayout(3, 0, 0, 15));

    lblNumero.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    lblNumero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    lblNumero.setText("Numero");
    lblNumero.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
    panelBuscar.add(lblNumero);

    txtNumero.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    panelBuscar.add(txtNumero);

    panelBtnBuscar.setOpaque(false);

    btnBuscar.setBackground(new Color(0, 168, 198, 135));
    btnBuscar.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    btnBuscar.setForeground(new Color(255, 255, 255));
    btnBuscar.setText("Buscar");
    panelBtnBuscar.add(btnBuscar);

    panelBuscar.add(panelBtnBuscar);

    panelIzquierda.add(panelBuscar);

    lblImagenGanado.setMaximumSize(new java.awt.Dimension(200, 150));
    lblImagenGanado.setMinimumSize(new java.awt.Dimension(200, 150));
    lblImagenGanado.setOpaque(true);
    lblImagenGanado.setPreferredSize(new java.awt.Dimension(200, 150));
    panelIzquierda.add(lblImagenGanado);

    panelEditarImagen.setOpaque(false);

    btnEditarImagen.setBackground(new Color(0, 168, 198, 135));
    btnEditarImagen.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
    btnEditarImagen.setForeground(new Color(255, 255, 255));
    btnEditarImagen.setText("Editar imagen");
    panelEditarImagen.add(btnEditarImagen);

    panelIzquierda.add(panelEditarImagen);

    add(panelIzquierda, java.awt.BorderLayout.LINE_START);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnBuscar;
  private javax.swing.JButton btnEditarImagen;
  private javax.swing.JButton btnGuardar;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JComboBox<String> cboxDescripcion;
  private javax.swing.JComboBox<String> cboxSexo;
  private javax.swing.JLabel lblColor;
  private javax.swing.JLabel lblDescripcion;
  private javax.swing.JLabel lblFierro;
  private javax.swing.JLabel lblImagenGanado;
  private javax.swing.JLabel lblNumero;
  private javax.swing.JLabel lblRaza;
  private javax.swing.JLabel lblSexo;
  private javax.swing.JLabel lblTituloModificacion;
  private javax.swing.JPanel panelBtnBuscar;
  private javax.swing.JPanel panelBuscar;
  private javax.swing.JPanel panelCentro;
  private javax.swing.JPanel panelDerecha;
  private javax.swing.JPanel panelEditarImagen;
  private javax.swing.JPanel panelIzquierda;
  private javax.swing.JPanel panelNorte;
  private javax.swing.JPanel panelSur;
  private javax.swing.JTextField txtColor;
  private javax.swing.JTextField txtFierro;
  private javax.swing.JTextField txtNumero;
  private javax.swing.JTextField txtRaza;

  private ControladorDailyDairy controladorDailyDairy;
  public ControladorDailyDairy getControladorDailyDairy() {
    return controladorDailyDairy;
  }

  public void setControlador(ControladorDailyDairy controladorDailyDairy) {
    this.controladorDailyDairy = controladorDailyDairy;
    this.btnRegresar.addActionListener(this.controladorDailyDairy);
  }

  public JButton getBtnRegresar() {
    return this.btnRegresar;
  }
  // End of variables declaration//GEN-END:variables
}
