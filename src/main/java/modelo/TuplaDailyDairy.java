package modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class TuplaDailyDairy {
    String bajaMuerteExtravio;
    String statusordeña;
    String sexoGanado;
    String descripcionGanado;
    String fierroGanado;
    String razaGanado;
    String colorGanado;
    String numeroGanado;
    String fotografiaGanado;

    public TuplaDailyDairy(String numeroGanado,String fierroGanado,String colorGanado,String razaGanado,String descripcionGanado,String sexoGanado,String statusordeña,String fotografiaGanado,String bajaMuerteExtravio) {
        this.bajaMuerteExtravio = bajaMuerteExtravio;
        this.statusordeña = statusordeña;
        this.sexoGanado = sexoGanado;
        this.descripcionGanado = descripcionGanado;
        this.fierroGanado = fierroGanado;
        this.razaGanado = razaGanado;
        this.colorGanado = colorGanado;
        this.numeroGanado = numeroGanado;
        this.fotografiaGanado = fotografiaGanado;
    }

    public String getBajaMuerteExtravio() {
        return bajaMuerteExtravio;
    }

    public void setBajaMuerteExtravio(String bajaMuerteExtravio) {
        this.bajaMuerteExtravio = bajaMuerteExtravio;
    }

    public String getStatusordeña() {
        return statusordeña;
    }

    public void setStatusordeña(String statusordeña) {
        this.statusordeña = statusordeña;
    }

    public String getSexoGanado() {
        return sexoGanado;
    }

    public void setSexoGanado(String sexoGanado) {
        this.sexoGanado = sexoGanado;
    }

    public String getDescripcionGanado() {
        return descripcionGanado;
    }

    public void setDescripcionGanado(String descripcionGanado) {
        this.descripcionGanado = descripcionGanado;
    }

    public String getFierroGanado() {
        return fierroGanado;
    }

    public void setFierroGanado(String fierroGanado) {
        this.fierroGanado = fierroGanado;
    }

    public String getRazaGanado() {
        return razaGanado;
    }

    public void setRazaGanado(String razaGanado) {
        this.razaGanado = razaGanado;
    }

    public String getColorGanado() {
        return colorGanado;
    }

    public void setColorGanado(String colorGanado) {
        this.colorGanado = colorGanado;
    }

    public String getNumeroGanado() {
        return numeroGanado;
    }

    public void setNumeroGanado(String numeroGanado) {
        this.numeroGanado = numeroGanado;
    }

    public String getFotografiaGanado() {
        return fotografiaGanado;
    }

    public void setFotografiaGanado(String fotografiaGanado) {
        this.fotografiaGanado = fotografiaGanado;
    }

    public static JTable updateJTableGanado(ArrayList<TuplaDailyDairy> tuplas, DefaultTableModel modelo) {
        modelo.setRowCount(0);
        for (TuplaDailyDairy tupla : tuplas) {
            System.out.println("x");
            Object[] fila = {
                    tupla.numeroGanado,
                    tupla.fierroGanado,
                    tupla.colorGanado,
                    tupla.razaGanado,
                    tupla.descripcionGanado,
                    tupla.sexoGanado,
                    tupla.statusordeña,
                    tupla.fotografiaGanado,
                    tupla.bajaMuerteExtravio
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        return tabla;
    }
    public static JTable updateJTableEliminar(ArrayList<TuplaDailyDairy> tuplas, DefaultTableModel modelo) {
        modelo.setRowCount(0);
        for (TuplaDailyDairy tupla : tuplas) {
            System.out.println("x");
            Object[] fila = {
                    tupla.numeroGanado,
                    tupla.fierroGanado,
                    tupla.colorGanado,
                    tupla.razaGanado,
                    tupla.descripcionGanado,
                    tupla.sexoGanado,
                    tupla.statusordeña,
                    tupla.fotografiaGanado,
                    tupla.bajaMuerteExtravio
            };
            modelo.addRow(fila);
        }

        JTable tabla = new JTable(modelo);

        return tabla;
    }
}
