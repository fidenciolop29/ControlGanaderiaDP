/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import controlador.ControladorDailyDairy;

import java.awt.Color;
/**
 *
 * @author Uriel Méndez Romero
 */
public class PanelAgregarOrdena extends javax.swing.JPanel {

  private ControladorDailyDairy controladorDailyDairy;

  /**
   * Creates new form PanelAgregarOrdena
   */
  public PanelAgregarOrdena() {

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

    panelNorte = new javax.swing.JPanel();
    lblTituloOrdena = new javax.swing.JLabel();
    panelSur = new javax.swing.JPanel();
    btnAgregar = new javax.swing.JButton();
    btnRegresar = new javax.swing.JButton();
    panelCentro = new javax.swing.JPanel();
    panelInputs = new javax.swing.JPanel();
    lblNumero = new javax.swing.JLabel();
    txtNumero = new javax.swing.JTextField();
    lblCria = new javax.swing.JLabel();
    txtCria = new javax.swing.JTextField();
    panelTablaOrdena = new javax.swing.JScrollPane();
    tablaOrdena = new javax.swing.JTable();

    setBorder(new javax.swing.border.LineBorder(new Color(255, 255, 255), 10, true));
    setLayout(new java.awt.BorderLayout());

    panelNorte.setBackground(new Color(143,190,0,25));
    panelNorte.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 10, 1));

    lblTituloOrdena.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
    lblTituloOrdena.setText("AGREGAR A ORDEÑA");
    panelNorte.add(lblTituloOrdena);

    add(panelNorte, java.awt.BorderLayout.PAGE_START);

    panelSur.setBackground(new Color(143,190,0,25));
    panelSur.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 40, 5));
    panelSur.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 5));

    btnAgregar.setBackground(new Color(0, 168, 198, 135));
    btnAgregar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    btnAgregar.setForeground(new Color(255, 255, 255));
    btnAgregar.setText("Agregar");
    btnAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnAgregarActionPerformed(evt);
      }
    });
    panelSur.add(btnAgregar);

    btnRegresar.setBackground(new Color(0, 168, 198, 135));
    btnRegresar.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
    btnRegresar.setForeground(new Color(255, 255, 255));
    btnRegresar.setText("Regresar");
    panelSur.add(btnRegresar);

    add(panelSur, java.awt.BorderLayout.PAGE_END);

    panelCentro.setBackground(new Color(143,190,0,25));
    panelCentro.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 40, 20, 40));
    panelCentro.setLayout(new java.awt.BorderLayout());

    panelInputs.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 1));
    panelInputs.setOpaque(false);
    panelInputs.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

    lblNumero.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblNumero.setText("Numero:");
    panelInputs.add(lblNumero);

    txtNumero.setColumns(8);
    txtNumero.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    panelInputs.add(txtNumero);

    lblCria.setFont(new java.awt.Font("Corbel", 1, 16)); // NOI18N
    lblCria.setText("Cria:");
    panelInputs.add(lblCria);

    txtCria.setColumns(8);
    txtCria.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
    panelInputs.add(txtCria);

    panelCentro.add(panelInputs, java.awt.BorderLayout.PAGE_END);

    tablaOrdena.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null},
        {null, null, null, null, null, null}
      },
      new String [] {
        "NUMERO", "FIERRO", "COLOR", "RAZA", "DESCRIPCIÓN", "SEXO"
      }
    ));
    panelTablaOrdena.setViewportView(tablaOrdena);

    panelCentro.add(panelTablaOrdena, java.awt.BorderLayout.CENTER);

    add(panelCentro, java.awt.BorderLayout.CENTER);
  }// </editor-fold>//GEN-END:initComponents

  private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnAgregarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnAgregar;
  private javax.swing.JButton btnRegresar;
  private javax.swing.JLabel lblCria;
  private javax.swing.JLabel lblNumero;
  private javax.swing.JLabel lblTituloOrdena;
  private javax.swing.JPanel panelCentro;
  private javax.swing.JPanel panelInputs;
  private javax.swing.JPanel panelNorte;
  private javax.swing.JPanel panelSur;
  private javax.swing.JScrollPane panelTablaOrdena;
  private javax.swing.JTable tablaOrdena;
  private javax.swing.JTextField txtCria;
  private javax.swing.JTextField txtNumero;
  // End of variables declaration//GEN-END:variables

  public ControladorDailyDairy getControladorDailyDairy() {
    return controladorDailyDairy;
  }

  public void setControlador(ControladorDailyDairy controladorDailyDairy) {
    this.controladorDailyDairy = controladorDailyDairy;
    this.btnRegresar.addActionListener(this.controladorDailyDairy);
  }

}
