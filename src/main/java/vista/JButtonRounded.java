package vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;

public class JButtonRounded extends JButton {
    public void setMagnitud_redondez(int magnitud_redondez) {
        this.magnitud_redondez = magnitud_redondez;
    }

    private int magnitud_redondez = 20;

    public JButtonRounded(int magnitud_redondez) {
        this();
        this.setMagnitud_redondez(magnitud_redondez);
    }

    public JButtonRounded() {
        setOpaque(false);
        //setPreferredSize(new Dimension(150, 100));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setBorder(null);
    }

    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(getBackground());
        } else {
            g.setColor(new Color(0, 168, 198, 135));
        }
        if (getModel().isRollover()){
            g.setColor(new Color(143,190,0,170));
        }
        g.fillRoundRect(0, 0, getSize().width - 1, getSize().height - 1, magnitud_redondez, magnitud_redondez);
        super.paintComponent(g);
    }

    //    protected void paintBorder(Graphics g) {
//        g.setColor(getForeground());
//        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, magnitud_redondez, magnitud_redondez);
//    }
    protected void paintBorder(Graphics g) {
        // No dibujar borde
    }

    Shape forma;

    public boolean contains(int x, int y) {
        if (forma == null || !forma.getBounds().equals(getBounds())) {
            forma = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), magnitud_redondez, magnitud_redondez);
        }
        return forma.contains(x, y);
    }
}


