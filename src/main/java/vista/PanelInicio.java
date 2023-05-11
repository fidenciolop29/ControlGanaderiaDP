package vista;

import controlador.ControladorDailyDairy;
import modelo.ModeloDailyDairy;

import java.awt.*;

public class PanelInicio extends javax.swing.JPanel {

    public ControladorDailyDairy controlador;

    public PanelInicio() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnGanado = new JButtonRounded(new java.awt.Color(255, 255, 255, 255), new java.awt.Color(255, 255, 255, 215));
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();


        setMinimumSize(new java.awt.Dimension(720, 480));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(720, 480));
        setLayout(new java.awt.GridLayout(1, 2));

        jPanel1.setLayout(new java.awt.GridLayout(3, 0));

        jPanel3.setBackground(ModeloDailyDairy.Color.COLOR_VERDE);
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(50, 30, 10, 30));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setFont(new java.awt.Font("Corbel", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BIENVENIDO A");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Corbel", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DAILYDIARY");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel3.add(jLabel4);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(ModeloDailyDairy.Color.COLOR_VERDE);
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 50, 30, 50));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html><body>Sistema de gestión de ganadería de doble propósito </body></html>");
        jLabel1.setToolTipText("");
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel4);

        jPanel5.setBackground(ModeloDailyDairy.Color.COLOR_VERDE);
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(30, 30, 30, 30));

        btnGanado.setBackground(ModeloDailyDairy.Color.COLOR_VERDE);
        btnGanado.setText("Ganado");
        btnGanado.setPreferredSize(new Dimension(100,25));
        jPanel5.add(btnGanado);

        jPanel1.add(jPanel5);

        add(jPanel1);

        jPanel2.setBackground(ModeloDailyDairy.Color.COLOR_VERDE);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        System.out.println(getClass());
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tanqueleche.png"))); // NOI18N

        jPanel2.add(jLabel2, java.awt.BorderLayout.CENTER);

        add(jPanel2);
    }// </editor-fold>//GEN-END:initComponents

    public void addActionListenersPanelInicioComponents(){
        btnGanado.addActionListener(this.controlador);
    }

    public void setControlador(ControladorDailyDairy controlador) {
        this.controlador = controlador;
        System.out.println("Me ejecuto 'set controlador' ");
    }

    public JButtonRounded getBtnGanado() {
        return btnGanado;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButtonRounded btnGanado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}

