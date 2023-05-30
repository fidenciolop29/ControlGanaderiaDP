package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import controlador.*;

public class JButtonRounded extends JButton {

    public JButtonRounded(int magnitud_redondez) {
        this();
        this.setMagnitud_redondez(magnitud_redondez);
    }
    public JButtonRounded(Color colorRelleno,Color colorBotonPresionado){
        this();
        this.setColorBoton(colorRelleno);
        this.setColorBotonPresionado(colorBotonPresionado);
    }
    public JButtonRounded() {
        setOpaque(false);
        //setPreferredSize(new Dimension(150, 100));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
//        setFocusable(false);
        setBorder(null);
        //this.setBackground(new Color(0, 168, 198, 135));
}

    protected void paintComponent(Graphics g) {
        //Necesitamos pintar primero un rectangulo del mismo color que el fondo para eliminar efectos no deseados
        g.setColor(getBackground());
        g.fillRect(0, 0, getSize().width , getSize().height );

        if (getModel().isRollover()){
            g.setColor(getColorBotonPresionado());
        }

        if (getModel().isPressed()) {
            g.setColor(getColorBoton());
        }

        if(!getModel().isPressed()&&!getModel().isRollover()){
            g.setColor(getColorBoton());
        }

        g.fillRoundRect(0, 0, getSize().width, getSize().height, magnitud_redondez, magnitud_redondez);
        super.paintComponent(g);
    }

    //    protected void paintBorder(Graphics g) {
//        g.setColor(getForeground());
//        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, magnitud_redondez, magnitud_redondez);
//    }
    protected void paintBorder(Graphics g) {
        // No dibujar borde
    }

    public boolean contains(int x, int y) {
        if (forma == null || !forma.getBounds().equals(getBounds())) {
            forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), magnitud_redondez, magnitud_redondez);
        }
        return forma.contains(x, y);
    }

    public Color getColorBotonPresionado() {
        return colorBotonPresionado;
    }

    public Color getColorBoton() {
        return colorBoton;
    }

    public void setColorBotonPresionado(Color colorBotonPresionado) {
        this.colorBotonPresionado = colorBotonPresionado;
    }

    public void setColorBoton(Color colorBoton) {
        this.colorBoton = colorBoton;
    }

    public void setMagnitud_redondez(int magnitud_redondez) {
        this.magnitud_redondez = magnitud_redondez;
    }
    Shape forma;
    private int magnitud_redondez = 15;
    private Color colorBoton = new Color(82,186,142);
    private Color colorBotonPresionado = new Color(82,186,142).brighter();
}


