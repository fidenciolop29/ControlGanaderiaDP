/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ControladorDailyDairy;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Uriel Méndez Romero
 */
public class PanelEliminar extends javax.swing.JPanel {

  /**
   * Creates new form PanelGanado
   */
  public PanelEliminar() {
    initComponents();
  }

  private ControladorDailyDairy controladorDailyDairy;

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelIzquierda = new javax.swing.JPanel();
    lblArriba = new javax.swing.JLabel();
    panelEliminar = new javax.swing.JPanel();
    lblNumero = new javax.swing.JLabel();
    txtNumero = new javax.swing.JTextField();
    panelBtnEliminar = new javax.swing.JPanel();
    btnEliminar = new javax.swing.JButton();
    lblAbajo = new javax.swing.JLabel();
    panelDerecha = new javax.swing.JPanel();
    panelNorte = new javax.swing.JPanel();
    lblTituloBaja = new javax.swing.JLabel();
    panelCentro = new javax.swing.JPanel();
    panelTablaGanado = new javax.swing.JScrollPane();
    tablaGanado = new javax.swing.JTable();
    panelSur = new javax.swing.JPanel();
    btnRegresar = new javax.swing.JButton();

    setBackground(new Color(254, 254, 254));
    setBorder(new javax.swing.border.LineBorder(new Color(255, 255, 255), 10, true));
    setPreferredSize(new java.awt.Dimension(250, 340));
    setLayout(new java.awt.BorderLayout(5, 0));

    panelIzquierda.setPreferredSize(new Dimension(240,573));
    panelIzquierda.setBackground(new Color(143,190,0,170));
    panelIzquierda.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 40, 40));
    panelIzquierda.setLayout(new java.awt.GridLayout(3, 1, 20, 10));
    panelIzquierda.add(lblArriba);

    panelEliminar.setOpaque(false);
    panelEliminar.setLayout(new java.awt.GridLayout(3, 0, 5, 20));

    lblNumero.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    lblNumero.setText("Numero");
    panelEliminar.add(lblNumero);

    txtNumero.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    panelEliminar.add(txtNumero);

    panelBtnEliminar.setOpaque(false);

    btnEliminar.setBackground(new Color(0, 168, 198, 135));
    btnEliminar.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
    btnEliminar.setForeground(new Color(255, 255, 255));
    btnEliminar.setText("Eliminar ganado");
    panelBtnEliminar.add(btnEliminar);

    panelEliminar.add(panelBtnEliminar);

    panelIzquierda.add(panelEliminar);
    panelIzquierda.add(lblAbajo);

    add(panelIzquierda, java.awt.BorderLayout.LINE_START);

    panelDerecha.setLayout(new java.awt.BorderLayout());

    panelNorte.setBackground(new Color(143,190,0,25));
    panelNorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 20, 20, 20));

    lblTituloBaja.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
    lblTituloBaja.setText("BAJA DE GANADO");
    panelNorte.add(lblTituloBaja);

    panelDerecha.add(panelNorte, java.awt.BorderLayout.PAGE_START);

    panelCentro.setBackground(new Color(143,190,0,25));
    panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 40, 40, 40));
    panelCentro.setLayout(new java.awt.BorderLayout());

    tablaGanado.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "NUMERO", "FIERRO", "COLOR", "RAZA", "IMAGEN"
      }
    ) {
      Class[] types = new Class [] {
        String.class, String.class, String.class, String.class, Object.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    panelTablaGanado.setViewportView(tablaGanado);

    panelCentro.add(panelTablaGanado, java.awt.BorderLayout.CENTER);

    panelDerecha.add(panelCentro, java.awt.BorderLayout.CENTER);

    panelSur.setBackground(new Color(143,190,0,25));
    panelSur.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 40, 5));

    btnRegresar.setBackground(new Color(0, 168, 198, 135));
    btnRegresar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    btnRegresar.setForeground(new Color(255, 255, 255));
    btnRegresar.setText("Regresar");
    panelSur.add(btnRegresar);

    panelDerecha.add(panelSur, java.awt.BorderLayout.PAGE_END);

    add(panelDerecha, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnEliminar;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JLabel lblAbajo;
  private javax.swing.JLabel lblArriba;
  private javax.swing.JLabel lblNumero;
  private javax.swing.JLabel lblTituloBaja;
  private javax.swing.JPanel panelBtnEliminar;
  private javax.swing.JPanel panelCentro;
  private javax.swing.JPanel panelDerecha;
  private javax.swing.JPanel panelEliminar;
  private javax.swing.JPanel panelIzquierda;
  private javax.swing.JPanel panelNorte;
  private javax.swing.JPanel panelSur;
  private javax.swing.JScrollPane panelTablaGanado;
  private javax.swing.JTable tablaGanado;
  private javax.swing.JTextField txtNumero;

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
