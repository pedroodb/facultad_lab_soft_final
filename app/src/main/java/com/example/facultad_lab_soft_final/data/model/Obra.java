package com.example.facultad_lab_soft_final.data.model;

public class Obra extends Actividad{

    String elenco;
    String autor;
    String direccion;
    String sinopsis;
    String tematica;
    FechaHora[] fechas;

    public Obra(int id, String nombre, String descripcion, UbicacionObra ubicacion, String elenco, String autor, String direccion, String sinopsis, String tematica, FechaHora[] fechas) {
        super(id, nombre, descripcion, ubicacion);
        this.elenco = elenco;
        this.autor = autor;
        this.direccion = direccion;
        this.sinopsis = sinopsis;
        this.tematica = tematica;
        this.fechas = fechas;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public FechaHora[] getFechas() {
        return fechas;
    }

    public void setFechas(FechaHora[] fechas) {
        this.fechas = fechas;
    }
}
