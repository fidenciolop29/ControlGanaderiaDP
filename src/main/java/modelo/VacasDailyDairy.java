package modelo;

import java.sql.Blob;

public class VacasDailyDairy {
    public VacasDailyDairy(){

    }
    public VacasDailyDairy(String numeroGanado, String fierroGanado, String colorGanado, String razaGanado, String descripcionGanado, String sexoGanado, String statusordeña, Blob fotografiaGanado, String bajaMuerteExtravio) {
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

    public String getStatusordeña() {
        return statusordeña;
    }

    public String getSexoGanado() {
        return sexoGanado;
    }

    public String getDescripcionGanado() {
        return descripcionGanado;
    }

    public String getFierroGanado() {
        return fierroGanado;
    }

    public String getRazaGanado() {
        return razaGanado;
    }

    public String getColorGanado() {
        return colorGanado;
    }

    public String getNumeroGanado() {
        return numeroGanado;
    }

    public Blob getFotografiaGanado() {
        return fotografiaGanado;
    }

    public void setBajaMuerteExtravio(String bajaMuerteExtravio) {
        this.bajaMuerteExtravio = bajaMuerteExtravio;
    }

    public void setStatusordeña(String statusordeña) {
        this.statusordeña = statusordeña;
    }

    public void setSexoGanado(String sexoGanado) {
        this.sexoGanado = sexoGanado;
    }

    public void setDescripcionGanado(String descripcionGanado) {
        this.descripcionGanado = descripcionGanado;
    }

    public void setFierroGanado(String fierroGanado) {
        this.fierroGanado = fierroGanado;
    }

    public void setRazaGanado(String razaGanado) {
        this.razaGanado = razaGanado;
    }

    public void setColorGanado(String colorGanado) {
        this.colorGanado = colorGanado;
    }

    public void setNumeroGanado(String numeroGanado) {
        this.numeroGanado = numeroGanado;
    }

    public void setFotografiaGanado(Blob fotografiaGanado) {
        this.fotografiaGanado = fotografiaGanado;
    }


    String bajaMuerteExtravio;
    String statusordeña;
    String sexoGanado;
    String descripcionGanado;
    String fierroGanado;
    String razaGanado;
    String colorGanado;
    String numeroGanado;
    Blob fotografiaGanado;

}
