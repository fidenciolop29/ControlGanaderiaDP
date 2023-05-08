package vista;

import java.awt.*;
import controlador.*;
public class PanelAgregar extends javax.swing.JPanel {

    private ControladorDailyDairy controlador;

    public PanelAgregar() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanelBotonEliminar = new javax.swing.JPanel();
        jButtonEliminar = new JButtonRounded();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButtonAgregar = new JButtonRounded();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new Color(174,206,79));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 40, 40, 40));
        jPanel1.setLayout(new java.awt.GridLayout(3, 0, 0, 40));
        Color fondo = jPanel2.getBackground();

        /*jPanel3.setBackground(new Color(0, 168, 198, 135));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel3.setLayout(new java.awt.GridLayout(2, 0));

        jLabel3.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("<html><body>Seleccionar imagen</body></html>");
        jLabel3.setToolTipText("");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 20));
        jPanel3.add(jLabel3);

        jLabel1.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("<html><body>Seleccione la imagen del ganado</body></html>");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setPreferredSize(new java.awt.Dimension(100, 18));
        jPanel3.add(jLabel1);*/

        jPanel1.add(jPanel3);

        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2);
        jPanelBotonEliminar.setOpaque(false);

        //Boton eliminar

        jButtonEliminar.setBackground(new Color(174,206,79));
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("Eliminar imagen");
        jButtonEliminar.setPreferredSize(new Dimension(100,25));
        jPanelBotonEliminar.add(jButtonEliminar);

        jPanel1.add(jPanelBotonEliminar);

        jPanel1.setPreferredSize(new Dimension(240,180));

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new Color(143,190,0,25));
        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 40, 5));

        //jButtonAgregar.setBackground(fondo);
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("Agregar");
        jButtonAgregar.setPreferredSize(new Dimension(100,25));
        jPanel6.add(jButtonAgregar);

        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBackground(new Color(143,190,0,25));
        jPanel7.setBorder(javax.swing.BorderFactory.createEmptyBorder(40, 20, 20, 20));

        jLabel9.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jLabel9.setText("REGISTRO DE VACAS");
        jPanel7.add(jLabel9);

        jPanel2.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new Color(143,190,0,25));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 110, 10, 110));
        jPanel5.setLayout(new java.awt.GridLayout(8, 0, 0, 10));

        jLabel4.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel4.setText("Numero");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel4);

        jTextField1.setPreferredSize(new java.awt.Dimension(64, 18));
        jPanel5.add(jTextField1);

        jLabel5.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel5.setText("Fierro");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel5);

        jTextField2.setPreferredSize(new java.awt.Dimension(64, 18));
        jPanel5.add(jTextField2);

        jLabel6.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel6.setText("Color");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel6);

        jTextField3.setPreferredSize(new java.awt.Dimension(64, 18));
        jPanel5.add(jTextField3);

        jLabel7.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        jLabel7.setText("Raza");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel7);

        jTextField4.setPreferredSize(new java.awt.Dimension(64, 18));
        jPanel5.add(jTextField4);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);
        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButtonRounded jButtonEliminar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
private javax.swing.JPanel jPanelBotonEliminar;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;

    public void setControlador(ControladorDailyDairy controladorDailyDairy) {
        this.controlador = controladorDailyDairy;
    }
    // End of variables declaration//GEN-END:variables
}

